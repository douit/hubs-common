package com.bluecc.hubs.fund;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SqlMeta {
    ProtoMeta protoMeta;
    EntityMeta meta;
    public SqlMeta(ProtoMeta protoMeta, EntityMeta meta){
        this.protoMeta=protoMeta;
        this.meta=meta;
    }

    public List<String> getAliases(){
        return getAliases("*stamp");
    }

    public List<String> getAliases(String... exclude){
        String prefix=meta.getPrefix();
        return meta.getColNames(exclude).stream()
                .map(f -> String.format("%s.%s %s_%s", prefix, f, prefix, f))
                .collect(Collectors.toList());
    }

    public String getPrefix(){
        return meta.getPrefix();
    }

    public String addLinebreaks(String input, int maxLineLength) {
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (lineLen + word.length() > maxLineLength) {
                output.append("\n\t");
                lineLen = 0;
            }
            output.append(word);
            output.append(" ");
            lineLen += word.length();
        }
        return output.toString();
    }

    @Data
    @Builder
    public static class ViewDecl{
        String sql;
        String leftPrefix;
        String rightPrefix;
    }

    public ViewDecl leftJoin(String relation, String... exclude){
        if(exclude.length==0){
            exclude=new String[]{"*stamp"};
        }
        EntityMeta.RelationMeta rel=this.meta.findRelationByProtoName(relation).get();
        SqlMeta right= protoMeta.getSqlMeta(rel.relEntityName);
        List<String> allFields=getAliases(exclude);
        allFields.addAll(right.getAliases(exclude));
        String fieldDecl= String.join(", ", allFields);
        // "from contacts c left join phones p on c.id = p.contact_id"
        String joinClause=rel.getKeymaps().stream().map(km -> String.format("%s.%s = %s.%s",
                        meta.getPrefix(), km.getProtoField(),
                        right.meta.getPrefix(), km.getProtoRelField()))
                .collect(Collectors.joining(" and "));
        String joinDecl=String.format("from %s %s left join %s %s on %s",
                meta.getUnderscore(), meta.getPrefix(),
                right.meta.getUnderscore(), right.meta.getPrefix(), joinClause);
        String sql= addLinebreaks(String.format("select %s \n%s", fieldDecl, joinDecl), 80);
        return ViewDecl.builder()
                .sql(sql)
                .leftPrefix(meta.getPrefix())
                .rightPrefix(right.getPrefix())
                .build();
    }
}

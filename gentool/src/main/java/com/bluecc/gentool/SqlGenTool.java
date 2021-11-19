package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.bluecc.gentool.dummy.SeedReader;
import lombok.Builder;
import lombok.Data;

import java.io.*;
import java.util.*;

import static com.bluecc.gentool.EntityMetaManager.*;
import static com.bluecc.gentool.common.Util.*;
import static com.bluecc.gentool.dummy.SeedCollector.dataFile;
import static java.util.Objects.requireNonNull;

/**
 * $ just gen SqlGenTool
 */
public class SqlGenTool {
    @Data
    @Builder
    public static class MetaList{
        Set<String> entities;
    }

    public static void main(String[] args) throws IOException {
        SqlGenTool genTool=new SqlGenTool("mysql");
        genTool.build("asset/mysql/hubs.sql",
                "asset/mysql/hubs.json");

        genTool=new SqlGenTool("h2");
        genTool.build("domain/src/main/sql/hubs_h2.sql",null);
    }

    public SqlGenTool(){
        this("mysql");
    }

    String sqlMode;
    public SqlGenTool(String sqlMode){
        this.sqlMode=sqlMode;
    }

    public void build(String outputSqlFile, String outputJsonFile)  throws IOException{
        Writer writer=new FileWriter(outputSqlFile);

        Set<String> entityList=SeedReader.collectEntityNames(dataFile);
        if(sqlMode.equals("h2")){
            writer.write("SET MODE MYSQL; /* another h2 way to set mode */\n" +
                    "CREATE SCHEMA IF NOT EXISTS \"public\";\n\n");
        }
        for (String entityName : entityList) {
            File metaFile = getMetaFile(entityName);
            // System.out.println(metaFile.getName());
            String genCnt=genDDL(metaFile, writer);
            System.out.println(genCnt);
        }

        writer.write(String.format("-- total entities %d, from %s\n",
                entityList.size(), dataFile));
        writer.close();

        if(outputJsonFile!=null) {
            writeJsonFile(MetaList.builder()
                    .entities(entityList)
                    .build(), new File(outputJsonFile));
        }
    }

    private  void buildAll() throws IOException {
        File metaDir=new File("asset/meta");
        Writer writer=new FileWriter("asset/mysql/hubs.sql");
        for (File metaFile : requireNonNull(metaDir.listFiles((dir, name)
                -> name.toLowerCase().endsWith(".json")))) {
            // System.out.println(metaFile.getName());
            genDDL(metaFile, writer);
        }
        writer.close();
    }

    private  void genDDL(String entName) throws IOException {
        File file = getMetaFile(entName);
        genDDL(file, null);
    }

    public String genDDL(File file, Writer writer) throws IOException {
        EntityMeta meta = getEntityMeta(file);

        // System.out.println(meta.getName());
        // meta.getFields().forEach(f -> pretty(f));

        DummyTemplateProcs procs=new DummyTemplateProcs();
        String cnt=procs.procSql(sqlMode, meta);

        if(writer!=null){
            writer.write(cnt);
            writer.write('\n');
        }
        return cnt;
    }

}

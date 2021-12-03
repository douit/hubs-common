package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.bluecc.hubs.fund.DataSetUtil;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.MetaTypes;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

import static com.bluecc.gentool.dummy.SeedCollector.dataFile;
import static com.bluecc.hubs.fund.DataSetUtil.*;
import static com.bluecc.hubs.fund.DataSetUtil.collectEntitiesFromResources;
import static com.bluecc.hubs.fund.EntityMetaManager.*;
import static com.bluecc.hubs.fund.Util.writeJsonFile;
import static java.util.Objects.requireNonNull;

/**
 * $ just gen SqlGenTool -s
 */
@Slf4j
public class SqlGenTool {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class GenOpts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
    }

    public static void main(String[] args) throws IOException {
        GenOpts opts=new GenOpts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        startGen(opts);
    }

    public static void startGen(GenOpts opts) throws IOException {
        SqlGenTool genMysql = new SqlGenTool(opts,"mysql",
                ASSET_MYSQL_HUBS_SQL,
                ASSET_MYSQL_HUBS_JSON);
        SqlGenTool genH2 = new SqlGenTool(opts,"h2",
                DOMAIN_H2_FULL_SQL, null);


        System.out.println("opt-silent: " + opts.silent);
        genMysql.build();
        genH2.build();
    }

    // public static void start(SqlGenTool genTool) throws IOException {
    //     // List<String> entityNames= Lists.newArrayList("GeoPoint");
    //     // SqlGenTool genTool=new SqlGenTool("mysql");
    //     // genTool.addAdditions(entityNames);
    //     genTool.build("asset/mysql/hubs.sql",
    //             "asset/mysql/hubs.json");
    //
    //     genTool=new SqlGenTool("h2");
    //     // genTool.addAdditions(entityNames);
    //     genTool.build("domain/src/main/sql/hubs_h2.sql",null);
    // }

    String sqlMode;
    String outputSqlFile, outputJsonFile;
    Set<String> additions = Sets.newHashSet();
    GenOpts opts;
    public SqlGenTool(GenOpts opts, String sqlMode, String outputSqlFile, String outputJsonFile) {
        this.opts=opts;
        this.sqlMode = sqlMode;
        this.outputSqlFile = outputSqlFile;
        this.outputJsonFile = outputJsonFile;
    }

    public void addAdditions(List<String> entityNames) {
        additions.addAll(entityNames);
    }

    public void build() throws IOException {
        Writer writer = new FileWriter(outputSqlFile);

        // Set<String> entityList=SeedReader.collectEntityNames(dataFile);
        Set<String> entityList = collectEntitiesFromResources();
        entityList.addAll(this.additions);
        if (sqlMode.equals("h2")) {
            writer.write("SET MODE MYSQL; /* another h2 way to set mode */\n" +
                    "CREATE SCHEMA IF NOT EXISTS \"public\";\n\n");
        }
        Set<String> ignoreEnts=Sets.newHashSet();
        for (String entityName : entityList) {
            File metaFile = getMetaFile(entityName);
            // System.out.println(metaFile.getName());
            if(metaFile.exists()) {
                String genCnt = genDDL(sqlMode, metaFile, writer);
                if (!opts.silent) {
                    System.out.println(genCnt);
                }
            }else{
                log.warn("Cannot read entity {} meta file, ignore it", entityName);
                ignoreEnts.add(entityName);
            }
        }

        if(!ignoreEnts.isEmpty()) {
            System.out.println(".. ignore entities: " + ignoreEnts);
            entityList.removeAll(ignoreEnts);
        }
        String info=String.format("-- total entities %d, from seed dirs: %s\n",
                entityList.size(), Arrays.asList("order", "ecommerce"));
        System.out.println(info);
        writer.write(info);
        writer.close();

        if (outputJsonFile != null) {
            writeJsonFile(MetaTypes.MetaList.builder()
                    .entities(entityList)
                    .build(), new File(outputJsonFile));
        }
    }

    private void buildAll() throws IOException {
        File metaDir = new File("asset/meta");
        Writer writer = new FileWriter("asset/mysql/hubs.sql");
        for (File metaFile : requireNonNull(metaDir.listFiles((dir, name)
                -> name.toLowerCase().endsWith(".json")))) {
            // System.out.println(metaFile.getName());
            genDDL(sqlMode, metaFile, writer);
        }
        writer.close();
    }

    private void genDDL(String entName) throws IOException {
        File file = getMetaFile(entName);
        genDDL(sqlMode, file, null);
    }

    public static String genDDL(String sqlMode, File file, Writer writer) throws IOException {
        EntityMeta meta = getEntityMeta(file);

        // System.out.println(meta.getName());
        // meta.getFields().forEach(f -> pretty(f));

        DummyTemplateProcs procs = new DummyTemplateProcs();
        String cnt = procs.procSql(sqlMode, meta);

        if (writer != null) {
            writer.write(cnt);
            writer.write('\n');
        }
        return cnt;
    }

}

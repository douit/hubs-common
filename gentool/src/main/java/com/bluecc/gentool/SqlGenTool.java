package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.bluecc.gentool.dummy.FieldMappings;
import com.bluecc.gentool.dummy.SeedReader;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

import static com.bluecc.gentool.EntityMetaManager.*;
import static com.bluecc.gentool.common.Util.*;
import static com.bluecc.gentool.dummy.FieldMappings.getFieldTypes;
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
        SqlGenTool genTool=new SqlGenTool();
        genTool.build();
    }

    public void build()  throws IOException{
        Writer writer=new FileWriter("asset/mysql/hubs.sql");

        Set<String> entityList=SeedReader.collectEntityNames(dataFile);
        for (String entityName : entityList) {
            File metaFile = getMetaFile(entityName);
            // System.out.println(metaFile.getName());
            String genCnt=genDDL(metaFile, writer);
            System.out.println(genCnt);
        }

        writer.write(String.format("-- total entities %d, from %s\n",
                entityList.size(), dataFile));
        writer.close();

        writeJsonFile(MetaList.builder()
                .entities(entityList)
                .build(), new File("asset/mysql/hubs.json"));
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
        String cnt=procs.procMysql(meta);

        if(writer!=null){
            writer.write(cnt);
            writer.write('\n');
        }
        return cnt;
    }

}

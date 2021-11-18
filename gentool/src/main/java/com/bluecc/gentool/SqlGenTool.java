package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.bluecc.gentool.dummy.FieldMappings;
import com.bluecc.gentool.dummy.SeedReader;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static com.bluecc.gentool.common.Util.GSON;
import static com.bluecc.gentool.common.Util.pretty;
import static com.bluecc.gentool.dummy.FieldMappings.getFieldTypes;
import static com.bluecc.gentool.dummy.SeedCollector.dataFile;
import static java.util.Objects.requireNonNull;

/**
 * $ just gen SqlGenTool
 */
public class SqlGenTool {
    public static void main(String[] args) throws IOException {
        // String entName="Person";
        // genDDL("Person");
        // genDDL("PartyStatus");

        // buildAll();

        Writer writer=new FileWriter("asset/mysql/hubs.sql");
        Collection<String> entityList=SeedReader.collectEntityNames(dataFile);
        for (String entityName : entityList) {
            File metaFile = getMetaFile(entityName);
            System.out.println(metaFile.getName());
            genDDL(metaFile, writer);
        }
        writer.write(String.format("-- total entities %d, from %s\n",
                entityList.size(), dataFile));
        writer.close();
    }

    public static File getMetaFile(String entityName) {
        return new File("asset/meta/" + entityName + ".json");
    }

    private static void buildAll() throws IOException {
        File metaDir=new File("asset/meta");
        Writer writer=new FileWriter("asset/mysql/hubs.sql");
        for (File metaFile : requireNonNull(metaDir.listFiles((dir, name)
                -> name.toLowerCase().endsWith(".json")))) {
            System.out.println(metaFile.getName());
            genDDL(metaFile, writer);
        }
        writer.close();
    }

    static Map<String, FieldMappings.FieldTypeDef> types=getFieldTypes();
    private static void genDDL(String entName) throws IOException {
        File file = getMetaFile(entName);
        genDDL(file, null);
    }

    private static void genDDL(File file, Writer writer) throws IOException {
        EntityMeta meta = getEntityMeta(file);

        System.out.println(meta.getName());
        meta.getFields().forEach(f -> pretty(f));

        DummyTemplateProcs procs=new DummyTemplateProcs();
        String cnt=procs.procMysql(meta);
        if(writer!=null){
            writer.write(cnt);
            writer.write('\n');
        }
    }

    private static EntityMeta getEntityMeta(File file) throws FileNotFoundException {
        EntityMeta meta=GSON.fromJson(new FileReader(file),
                EntityMeta.class);
        meta.setupFieldMappings(types);
        return meta;
    }

    public static EntityMeta readEntityMeta(String entityName) throws IOException {
        return getEntityMeta(getMetaFile(entityName));
    }
}

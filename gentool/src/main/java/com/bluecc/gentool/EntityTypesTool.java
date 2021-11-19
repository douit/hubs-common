package com.bluecc.gentool;

import com.bluecc.gentool.dummy.SeedReader;
import com.google.common.collect.Sets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bluecc.gentool.EntityMetaManager.getMetaFile;
import static com.bluecc.gentool.SqlGenTool.genDDL;
import static com.bluecc.gentool.common.Util.readJsonFile;
import static com.bluecc.gentool.common.Util.writeJsonFile;
import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static java.util.Objects.requireNonNull;

public class EntityTypesTool {
    public static String seedDir = "dataset/seed";

    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(prependHubsHomeFile("asset/mysql/types.sql"));
        Set<String> entityList = collectFromFiles(prependHubsHomeFile(seedDir));
        int totalTypeEntities=entityList.size();
        SqlGenTool.MetaList hubsEntities = readJsonFile(SqlGenTool.MetaList.class,
                prependHubsHomeFile("asset/mysql/hubs.json"));

        Set<String> intersection = new HashSet<String>(hubsEntities.getEntities()); // use the copy constructor
        intersection.retainAll(entityList);
        // 在数据库中维护的实体类型
        writeJsonFile(SqlGenTool.MetaList.builder()
                .entities(intersection)
                .build(), prependHubsHomeFile("asset/mysql/retain_types.json"));

        entityList.removeAll(hubsEntities.getEntities());

        for (String entityName : entityList) {
            File metaFile = getMetaFile(entityName);
            System.out.println(metaFile.getName());
            genDDL(metaFile, writer);
        }

        writer.write(String.format("-- collect entities %d, from %s; total %d\n",
                entityList.size(), seedDir, totalTypeEntities));
        writer.close();

        writeJsonFile(SqlGenTool.MetaList.builder()
                .entities(entityList)
                .build(), prependHubsHomeFile("asset/mysql/types.json"));
    }

    static Set<String> collectFromFiles(File metaDir) {
        Set<String> rs = Sets.newHashSet();
        for (File metaFile : requireNonNull(metaDir.listFiles((dir, name)
                -> name.toLowerCase().endsWith(".xml")))) {
            Set<String> entityList = SeedReader.collectEntityNames(metaFile.toString());
            rs.addAll(entityList);
        }
        return rs;
    }

    public static SqlGenTool.MetaList types()  {
        try {
            return readJsonFile(SqlGenTool.MetaList.class,
                    prependHubsHomeFile("asset/mysql/types.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

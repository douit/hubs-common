package com.bluecc.gentool;

import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.SeedReader;
import com.google.common.collect.Sets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bluecc.hubs.fund.DataSetUtil.collectFromFiles;
import static com.bluecc.hubs.fund.DataSetUtil.getAvailableEntities;
import static com.bluecc.hubs.fund.EntityMetaManager.getMetaFile;
import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.*;
import static java.util.Objects.requireNonNull;

/**
 * $ just gen EntityTypesTool
 */
public class EntityTypesTool {
    public static String seedDir = "dataset/seed";
    public static String commonDir = "dataset/common";

    public static void main(String[] args) throws IOException {
        startGen();
    }

    public static void startGen() throws IOException {
        Writer writer = new FileWriter(prependHubsHomeFile("asset/mysql/types.sql"));
        Set<String> entityList = collectFromFiles(
                prependHubsHomeFile(seedDir),
                prependHubsHomeFile(commonDir));
        int totalTypeEntities=entityList.size();
        MetaTypes.MetaList hubsEntities = getAvailableEntities();

        Set<String> intersection = new HashSet<String>(hubsEntities.getEntities()); // use the copy constructor
        intersection.retainAll(entityList);
        // 在数据库中维护的实体类型
        writeJsonFile(MetaTypes.MetaList.builder()
                .entities(intersection)
                .build(), prependHubsHomeFile("asset/mysql/retain_types.json"));

        entityList.removeAll(hubsEntities.getEntities());

        for (String entityName : entityList) {
            File metaFile = getMetaFile(entityName);
            // System.out.println(metaFile.getName());
            SqlGenTool.genDDL("mysql", metaFile, writer);
        }

        writer.write(String.format("-- collect entities %d, from %s; total %d\n",
                entityList.size(), seedDir+", "+commonDir, totalTypeEntities));
        writer.close();

        writeJsonFile(MetaTypes.MetaList.builder()
                .entities(entityList)
                .build(), prependHubsHomeFile("asset/mysql/types.json"));
        System.out.println("ok.");
    }
}

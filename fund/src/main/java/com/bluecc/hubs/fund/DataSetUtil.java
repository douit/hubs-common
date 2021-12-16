package com.bluecc.hubs.fund;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.readJsonFile;
import static java.util.Objects.requireNonNull;

public class DataSetUtil {

    public static final String ASSET_MYSQL_HUBS_JSON = "asset/mysql/hubs.json";
    public static final String ASSET_MYSQL_HUBS_SQL = "asset/mysql/hubs.sql";
    public static final String DOMAIN_H2_FULL_SQL = "domain/src/main/sql/hubs_h2_full.sql";

    public static final String[] DATASET_DIR = {"order", "ecommerce", "livecases"};
    // public static final String[] DATA_SAMPLES={
    //         "dataset/OrderDemoData.xml",
    //         "dataset/PartyGeoPointData.xml",
    //         "dataset/AdminNewTenantData-MySQL.xml"
    // };

    public static Set<String> collectEntitiesFromResources() {
        // Set<String> entityList = SeedReader.collectEntityNames(DATA_SAMPLES);
        return collectFromFiles(seedDirs());
    }

    private static List<File> seedDirs() {
        return Stream.of(DATASET_DIR)
                .map(d -> SystemDefs.prependHubsHomeFile("dataset/" + d))
                .collect(Collectors.toList());
    }

    public static List<File> seedFiles() {
        List<File> files = Lists.newArrayList();
        seedDirs().forEach(d -> files.addAll(Util.listFiles(d, ".xml")));
        return files;
    }

    public static List<File> seedFiles(String... dirs) {
        List<File> files = Lists.newArrayList();
        Stream.of(dirs).forEach(d -> files.addAll(Util.listFiles(d, ".xml")));
        return files;
    }

    public static MetaTypes.MetaList getAvailableEntities() {
        MetaTypes.MetaList hubsEntities;
        try {
            hubsEntities = readJsonFile(MetaTypes.MetaList.class,
                    prependHubsHomeFile(ASSET_MYSQL_HUBS_JSON));

            return hubsEntities;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<String> collectFromFiles(File... metaDirs) {
        return collectFromFiles(Arrays.asList(metaDirs));
    }

    public static Set<String> collectFromFiles(List<File> metaDirs) {
        Set<String> rs = Sets.newHashSet();
        for (File metaDir : metaDirs) {
            for (File metaFile : requireNonNull(metaDir.listFiles((dir, name)
                    -> name.toLowerCase().endsWith(".xml")))) {
                Set<String> entityList = SeedReader.collectEntityNames(metaFile.toString());
                rs.addAll(entityList);
            }
        }
        return rs;
    }
}



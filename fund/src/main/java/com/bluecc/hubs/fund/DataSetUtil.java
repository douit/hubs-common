package com.bluecc.hubs.fund;

import java.io.IOException;
import java.util.Set;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.readJsonFile;

public class DataSetUtil {
    public static final String[] DATA_SAMPLES={
            "dataset/OrderDemoData.xml",
            "dataset/PartyGeoPointData.xml",
            "dataset/AdminNewTenantData-MySQL.xml"
    };
    public static Set<String> collectEntitiesFromResources() {
        Set<String> entityList = SeedReader.collectEntityNames(DATA_SAMPLES);
        return entityList;
    }

    public static MetaTypes.MetaList getAvailableEntities()  {
        MetaTypes.MetaList hubsEntities;
        try {
            hubsEntities = readJsonFile(MetaTypes.MetaList.class,
                    prependHubsHomeFile("asset/mysql/hubs.json"));

            return hubsEntities;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



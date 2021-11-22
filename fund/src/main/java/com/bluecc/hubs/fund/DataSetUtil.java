package com.bluecc.hubs.fund;

import java.io.IOException;
import java.util.Set;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.readJsonFile;

public class DataSetUtil {
    public static Set<String> collectEntitiesFromResources() {
        Set<String> entityList = SeedReader.collectEntityNames(
                "dataset/OrderDemoData.xml",
                "dataset/PartyGeoPointData.xml",
                "dataset/AdminNewTenantData-MySQL.xml");
        return entityList;
    }

    public static MetaTypes.MetaList getAvailableEntities()  {
        MetaTypes.MetaList hubsEntities = null;
        try {
            hubsEntities = readJsonFile(MetaTypes.MetaList.class,
                    prependHubsHomeFile("asset/mysql/hubs.json"));

            return hubsEntities;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


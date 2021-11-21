package com.bluecc.gentool;

import com.bluecc.gentool.dummy.SeedReader;

import java.io.IOException;
import java.util.Set;

import static com.bluecc.gentool.common.Util.readJsonFile;
import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;

public class DataSetUtil {
    public static Set<String> collectEntitiesFromResources() {
        Set<String> entityList = SeedReader.collectEntityNames(
                "dataset/OrderDemoData.xml",
                "dataset/PartyGeoPointData.xml",
                "dataset/AdminNewTenantData-MySQL.xml");
        return entityList;
    }

    public static SqlGenTool.MetaList getAvailableEntities()  {
        SqlGenTool.MetaList hubsEntities = null;
        try {
            hubsEntities = readJsonFile(SqlGenTool.MetaList.class,
                    prependHubsHomeFile("asset/mysql/hubs.json"));

            return hubsEntities;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


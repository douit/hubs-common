package com.bluecc.gentool;

import com.bluecc.gentool.dummy.SeedReader;

import java.util.Set;

public class DataSetUtil {
    public static Set<String> collectEntitiesFromResources() {
        Set<String> entityList = SeedReader.collectEntityNames(
                "dataset/OrderDemoData.xml",
                "dataset/PartyGeoPointData.xml",
                "dataset/AdminNewTenantData-MySQL.xml");
        return entityList;
    }

}

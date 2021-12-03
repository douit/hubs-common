package com.bluecc.hubs.fund;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static org.junit.Assert.*;

public class DataSetUtilTest {

    @Test
    public void collectEntitiesFromResources() {
        // Set<String> names= DataSetUtil.collectEntitiesFromResources();
        String[] samples={
                "dataset/order/OrderDemoData.xml",
                "dataset/order/PartyGeoPointData.xml",
                "dataset/order/AdminNewTenantData-MySQL.xml"
        };
        Set<String> entityList = SeedReader.collectEntityNames(
                Arrays.asList(samples), true);
        System.out.println(entityList.size());
        // 142

        Set<String> seedEnts =DataSetUtil.collectFromFiles(
                Collections.singletonList(prependHubsHomeFile("dataset/ecommerce")));
        System.out.println(seedEnts.size());
        System.out.println(seedEnts);
        // 67

        entityList.addAll(seedEnts);
        System.out.println(entityList.size());
    }

    @Test
    public void collectEntities(){
        Set<String> entityList = DataSetUtil.collectEntitiesFromResources();
        System.out.println(entityList.size());
    }
}
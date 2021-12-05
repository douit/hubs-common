package com.bluecc.hubs;

import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stereotypes.StereoSimpleDatSet;
import com.bluecc.hubs.stub.PersonFlatData;
import org.junit.Test;

import java.io.File;

public class StereotypesTest {
    public final PersonFlatData St_SamletWu = PersonFlatData.newBuilder()
            .setPartyId("SamletWu")
            .setFirstName("samlet")
            .setLastName("wu")
            .build();

    @Test
    public void testDateFileToClassName(){
        {
            String dataFile = "dataset/sample/sales_order.xml";
            System.out.println(getCapName(dataFile));
        }
        {
            String dataFile = "dataset/ecommerce/DemoProductCategoriesI18nData.xml";
            System.out.println(getCapName(dataFile));
        }
        {
            String dataFile = "dataset/order/AdminNewTenantData-MySQL.xml";
            System.out.println(getCapName(dataFile));
        }
    }

    private String getCapName(String  dataFile) {
        File file = new File(dataFile);
        String name=file.getName().replace(".xml", "");
        return name.contains("_")?Util.snakeToCamel(name)
                :name.replaceAll("[\\-]", "");
    }

    @Test
    public void testSimpleDataSet(){
        System.out.println(StereoSimpleDatSet.class.getName());
        System.out.println(StereoSimpleDatSet.PartyRole_DemoRepAll_SALES_REP);
        System.out.println(StereoSimpleDatSet.ProductPrice_GZ_DIG_LIST_PRICE_PURCHASE_USD__NA__);
    }
}


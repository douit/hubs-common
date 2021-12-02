package com.bluecc.income.dao;

import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.stub.Indicator;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static org.junit.Assert.*;

public class ProductDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ProductDelegator products;

    @Before
    public void setUp() throws Exception {
        setupEntities("Product");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            ProductFlatData flatData = ProductFlatData.newBuilder()
                    .setProductId(newId)
                    .setProductName(faker.commerce().productName())
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, products.create(ctx, flatData));
            assertEquals(1, products.update(ctx, flatData));
            assertEquals(1, products.find(ctx, flatData).size());
            assertEquals(1, products.findById(ctx, flatData).size());
            assertEquals(1, products.delete(ctx, flatData));
            assertEquals(0, products.find(ctx, flatData).size());
        });
    }

    @Test
    public void storeProtoData() {
        // String source = SystemDefs.prependHubsHome("dataset/sample/sales_order.xml");
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, sourceSalesOrder, false);

        DataFill dataFill = new DataFill();
        Multimap<String, Message> dataMap = dataFill.setupData(dataList);
        dataMap.get("Product").forEach(e -> {
            System.out.println(e);
            e.getAllFields().forEach((f, o) -> {
                System.out.println(f.getName());
                System.out.println(o);
            });

            Descriptors.FieldDescriptor fieldDescriptor=e.getDescriptorForType().findFieldByName("taxable");
            Object val=e.getField(fieldDescriptor);
            System.out.println(val.getClass().getName());
            Descriptors.EnumValueDescriptor enumVal=( Descriptors.EnumValueDescriptor)val;
            Indicator indicator=Indicator.valueOf(enumVal);
            System.out.println(indicator);
        });

    }

    @Test
    public void testGetRelatedMany() {
        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            genericProcs.storeDataFile(c, sourceSalesOrder);
            List<Map<String, Object>> rs= genericProcs.find(c, ProductFlatData.newBuilder()
                    .setProductId("GZ-1001")
                    .build());
            assertFalse(rs.isEmpty());
        });
    }
}
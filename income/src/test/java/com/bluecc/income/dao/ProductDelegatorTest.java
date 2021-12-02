package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.model.Product;
import com.bluecc.income.model.ProductPrice;
import com.github.javafaker.Faker;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.fund.Util.pretty;
import static java.lang.String.format;
import static org.junit.Assert.*;

public class ProductDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ProductDelegator products;

    @Before
    public void setUp() throws Exception {
        setupEntities("Product");
        // rowMapper(Product.class, ProductPrice.class);
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

            Descriptors.FieldDescriptor fieldDescriptor = e.getDescriptorForType().findFieldByName("taxable");
            Object val = e.getField(fieldDescriptor);
            System.out.println(val.getClass().getName());
            Descriptors.EnumValueDescriptor enumVal = (Descriptors.EnumValueDescriptor) val;
            Indicator indicator = Indicator.valueOf(enumVal);
            System.out.println(indicator);
        });

    }

    @Test
    public void testGetRelatedMany() {
        rowMapper(Product.class);
        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            genericProcs.storeDataFile(c, sourceSalesOrder);
            ProductFlatData productData = ProductFlatData.newBuilder()
                    .setProductId("GZ-1001")
                    .build();
            List<Product> rs = genericProcs.find(c, productData, Product.class);
            assertFalse(rs.isEmpty());
            assertEquals(1, rs.size());
            rs.forEach(e -> pretty(e));
            assertEquals("GZ-1001", rs.get(0).getProductId());
            assertEquals("FINISHED_GOOD", rs.get(0).getProductTypeId());
        });
    }

    @Test
    public void testGetRelationsWithMeta() {
        process(c -> genericProcs.storeDataFile(c, sourceSalesOrder));

        ProductData productData = ProductData.newBuilder()
                .setProductId("GZ-DIG")
                .build();
        // productData.getProductPriceList()
        // product_price, ProductPrice

        String relName = "product_price";
        EntityMeta p = protoMeta.getEntityMeta("Product");
        // p.getRelations().forEach(r -> System.out.println(r.getProtoName()));
        EntityMeta.RelationMeta relationMeta = p.findRelationByProtoName(relName).get();
        relationMeta.getRelFieldList().forEach(e -> System.out.println(e));

        INameSymbol symbol = EntityNames.ProductPrice;
        Map<String, Object> e = getRelations(productData, relName, symbol);
        System.out.println(e);

        // insert with transferred keys
        // insertWithRels(symbol, e);
        getRels(symbol, e);
        getTypedRels(symbol, e);
    }

    private Map<String, Object> getRelations(Message message,
                                             String relName, INameSymbol symbol) {
        Map<String, Object> e = genericProcs.transferRelations(message,
                relName, symbol.getEntityName());
        return e;
    }

    private void insertWithRels(INameSymbol symbol, Map<String, Object> e) {
        List<String> names = new ArrayList<>(e.keySet());
        List<String> placers = names.stream().map(name -> ":" + name)
                .collect(Collectors.toList());

        process(ctx -> {
            int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                    .define("table", symbol.getTable())
                    .defineList("columns", names)
                    .defineList("placers", placers)
                    .bindMap(e)
                    .execute();
            assertEquals(1, total);
        });
    }

    private void getRels(INameSymbol symbol, Map<String, Object> e) {
        List<String> names = new ArrayList<>(e.keySet());

        String fieldsCond = names.stream().map(name ->
                        format("%s=:%s", name, name))
                .collect(Collectors.joining(" and "));

        process(ctx -> {
            List<Map<String, Object>> rs = ctx.getHandle().createQuery(
                            "select * from <table> where <fieldsCond>")
                    .define("table", symbol.getTable())
                    .defineList("fieldsCond", fieldsCond)
                    .bindMap(e)
                    .mapToMap().list();
            assertFalse(rs.isEmpty());
        });
    }

    private void getTypedRels(INameSymbol symbol, Map<String, Object> e) {
        List<String> names = new ArrayList<>(e.keySet());

        String fieldsCond = names.stream().map(name ->
                        format("%s=:%s", name, name))
                .collect(Collectors.joining(" and "));

        process(ctx -> {
            List<ProductPrice> rs = ctx.getHandle().createQuery(
                            "select * from <table> where <fieldsCond>")
                    .define("table", symbol.getTable())
                    .defineList("fieldsCond", fieldsCond)
                    .bindMap(e)
                    .mapTo(ProductPrice.class).list();
            assertFalse(rs.isEmpty());
            rs.forEach(pp -> System.out.println(pp.getPrice()));
            // Integer::sum
            // int result = numbers.stream().reduce(0, Integer::sum);
            BigDecimal result = rs.stream()
                    .map(pp -> pp.getPrice())
                    .reduce(BigDecimal.ZERO, Calcs::sumDecimal);
            System.out.println(result);

            // sum with proto
            List<ProductPriceData> ds = rs.stream()
                    .map(p -> (ProductPriceData)p.toData())
                    .collect(Collectors.toList());
            BigDecimal result2 = ds.stream()
                    .map(p -> new BigDecimal(p.getPrice().getValue()))
                    .reduce(BigDecimal.ZERO, Calcs::sumDecimal);
            assertEquals(result, result2);
        });
    }

    public static class Calcs {
        public static int sum(int a, int b) {
            return a + b;
        }

        public static BigDecimal sumDecimal(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    }

    @Test
    public void testRelationValues() {
        process(c -> genericProcs.storeDataFile(c, sourceSalesOrder));

        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            ProductData productData = ProductData.newBuilder()
                    .setProductId("GZ-DIG")
                    .build();
            List<ProductPrice> rs = genericProcs.getRelationValues(c, productData,
                    "product_price",
                    ProductPrice.class);
            assertEquals(2, rs.size());
        });
    }


}
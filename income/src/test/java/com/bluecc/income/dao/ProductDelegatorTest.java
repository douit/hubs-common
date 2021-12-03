package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.ResultSubscriber;
import com.bluecc.income.helper.ModelWrapper;
import com.bluecc.income.model.*;
import com.bluecc.income.procs.AbstractProcs;
import com.github.javafaker.Faker;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.*;
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
        // setupEntities("Product");
        // rowMapper(Product.class, ProductPrice.class);
        setupEntities();
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
                    .map(p -> (ProductPriceData) p.toData())
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


    @Test
    public void testExtractedTableInfo() {
        ProductConfigData productConfigData = getProductConfigData();
        AbstractProcs.ExtractedTableInfo tableInfo = genericProcs.extract(productConfigData);
        pretty(tableInfo);
    }

    @Test
    public void testProductConfig() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            // <ProductConfig productId="PC001" configItemId="IT0003" sequenceNum="00"
            // fromDate="2004-08-20 12:59:26.209" configTypeId="STANDARD" isMandatory="Y"/>
            // ? Missing named parameter 'sequence_num'
            ProductConfigData productConfigData = getProductConfigData();
            System.out.println(productConfigData);
            genericProcs.create(c, productConfigData);
        });
    }

    private ProductConfigData getProductConfigData() {
        ProductConfigData productConfigData = ProductConfigData.newBuilder()
                .setProductId("pc001")
                .setConfigItemId("it0003")
                .setSequenceNum(0)
                .setFromDate(ProtoTypes.now())
                .setConfigTypeId("STANDARD")
                .setIsMandatory(Indicator.YES)
                .build();
        return productConfigData;
    }

    @Test
    public void testProductList() {
        final Set<String> relationsDemand= Sets.newHashSet(
                "product_price",
                "product_product_config",
                "primary_product_category");
        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            // genericProcs.all(c, EntityNames.Product, 0);
            ProductData p = ProductData.newBuilder()
                    .setProductId("PC001")
                    .build();
            List<ProductData> ds = genericProcs.find(c, p, Product.class).stream()
                    .map(e -> {
                        pretty(e);
                        ProductData.Builder pb = e.toHeadBuilder();

                        // add price to head entity
                        if(relationsDemand.contains("product_price")) {
                            genericProcs.getRelationValues(c, p, "product_price",
                                            ProductPrice.class)
                                    .forEach(pprice -> pb.addProductPrice(
                                            (ProductPriceData) pprice.toData()));
                        }

                        if(relationsDemand.contains("product_product_config")) {
                            genericProcs.getRelationValues(c, p, "product_product_config",
                                            ProductConfig.class)
                                    .forEach(pconfig -> pb.addProductProductConfig(
                                            (ProductConfigData) pconfig.toData()));
                        }

                        // single relation, with field setter: pb.set*
                        if(relationsDemand.contains("primary_product_category")) {
                            genericProcs.getRelationValues(c, p, "primary_product_category",
                                            ProductCategory.class)
                                    .forEach(pcat -> pb.setPrimaryProductCategory(
                                            (ProductCategoryData) pcat.toData()));
                        }

                        return pb.build();
                    }).collect(Collectors.toList());

            assertEquals(1, ds.size());
            assertFalse(ds.get(0).getProductPriceList().isEmpty());
            assertTrue(ds.get(0).getProductProductConfigCount()>0);
            assertFalse(ds.get(0).hasPrimaryProductCategory());

            ds.forEach(e -> {
                System.out.println("↪️  " + e);
                System.out.println("--------------");
            });

            Message p1 = genericProcs.findOne(c, p, Product.class).toData();
            System.out.println(p1);
            assertTrue(genericProcs.getRelationValues(c, p1,
                    "primary_product_category",
                    ProductCategory.class).isEmpty());
        });
    }

    @Test
    public void testFindRelation() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProductData p = ProductData.newBuilder()
                    .setProductId("FA-001")
                    .build();
            Message p1 = genericProcs.findOne(c, p, Product.class).toData();
            // System.out.println(p1);
            assertFalse(genericProcs.getRelationValues(c, p1,
                    "primary_product_category",
                    ProductCategory.class).isEmpty());

            List<ProductCategory> result= genericProcs.findRelation(c, p, "primary_product_category",
                    Product.class, ProductCategory.class);
            result.forEach(e -> System.out.println(e));
            assertTrue(result.size()>0);
        });
    }

    @Test
    public void testQueryDemands() {
        String key="FA-001";
        Set<String> relationsDemand= Sets.newHashSet("primary_product_category");
        process(c -> {
            ProductData p = ProductData.newBuilder()
                    .setProductId(key)
                    .build();
            List<ProductData.Builder> ds = genericProcs.find(c, p, Product.class).stream()
                    .map(e -> {
                        ProductData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                        // add/set primary_product_category to head entity
                        if(relationsDemand.contains("primary_product_category")) {
                            genericProcs.getRelationValues(c, p1, "primary_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setPrimaryProductCategory(
                                            (ProductCategoryData) el.toHeadBuilder().build()));
                        }

                        // add/set created_by_user_login to head entity
                        if(relationsDemand.contains("created_by_user_login")) {
                            genericProcs.getRelationValues(c, p1, "created_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setCreatedByUserLogin(
                                            el.toHeadBuilder().build()));
                        }

                        // add/set last_modified_by_user_login to head entity
                        if(relationsDemand.contains("last_modified_by_user_login")) {
                            genericProcs.getRelationValues(c, p1, "last_modified_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setLastModifiedByUserLogin(
                                            (UserLoginData) el.toHeadBuilder().build()));
                        }

                        // add/set default_shipment_box_type to head entity
                        if(relationsDemand.contains("default_shipment_box_type")) {
                            genericProcs.getRelationValues(c, p1, "default_shipment_box_type",
                                            ShipmentBoxType.class)
                                    .forEach(el -> pb.setDefaultShipmentBoxType(
                                            el.toDataBuilder().build()));
                        }

                        // add/set agreement to head entity
                        if(relationsDemand.contains("agreement")) {
                            genericProcs.getRelationValues(c, p1, "agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addAgreement(
                                            el.toDataBuilder().build()));
                        }

                        // add/set agreement_product_appl to head entity
                        if(relationsDemand.contains("agreement_product_appl")) {
                            genericProcs.getRelationValues(c, p1, "agreement_product_appl",
                                            AgreementProductAppl.class)
                                    .forEach(el -> pb.addAgreementProductAppl(
                                            el.toDataBuilder().build()));
                        }

                        // add/set cust_request_item to head entity
                        if(relationsDemand.contains("cust_request_item")) {
                            genericProcs.getRelationValues(c, p1, "cust_request_item",
                                            CustRequestItem.class)
                                    .forEach(el -> pb.addCustRequestItem(
                                            el.toDataBuilder().build()));
                        }

                        // add/set instance_of_fixed_asset to head entity
                        if(relationsDemand.contains("instance_of_fixed_asset")) {
                            genericProcs.getRelationValues(c, p1, "instance_of_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addInstanceOfFixedAsset(
                                            el.toDataBuilder().build()));
                        }

                        // add/set fixed_asset_product to head entity
                        if(relationsDemand.contains("fixed_asset_product")) {
                            genericProcs.getRelationValues(c, p1, "fixed_asset_product",
                                            FixedAssetProduct.class)
                                    .forEach(el -> pb.addFixedAssetProduct(
                                            el.toDataBuilder().build()));
                        }

                        // add/set inventory_item to head entity
                        if(relationsDemand.contains("inventory_item")) {
                            genericProcs.getRelationValues(c, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addInventoryItem(
                                            el.toDataBuilder().build()));
                        }

                        // add/set invoice_item to head entity
                        if(relationsDemand.contains("invoice_item")) {
                            genericProcs.getRelationValues(c, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addInvoiceItem(
                                            el.toDataBuilder().build()));
                        }

                        // add/set order_item to head entity
                        if(relationsDemand.contains("order_item")) {
                            genericProcs.getRelationValues(c, p1, "order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addOrderItem(
                                            (OrderItemData) el.toHeadBuilder().build()));
                        }

                        // add/set main_product_assoc to head entity
                        if(relationsDemand.contains("main_product_assoc")) {
                            genericProcs.getRelationValues(c, p1, "main_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addMainProductAssoc(
                                            el.toDataBuilder().build()));
                        }

                        // add/set assoc_product_assoc to head entity
                        if(relationsDemand.contains("assoc_product_assoc")) {
                            genericProcs.getRelationValues(c, p1, "assoc_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addAssocProductAssoc(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_category_member to head entity
                        if(relationsDemand.contains("product_category_member")) {
                            genericProcs.getRelationValues(c, p1, "product_category_member",
                                            ProductCategoryMember.class)
                                    .forEach(el -> pb.addProductCategoryMember(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_product_config to head entity
                        if(relationsDemand.contains("product_product_config")) {
                            genericProcs.getRelationValues(c, p1, "product_product_config",
                                            ProductConfig.class)
                                    .forEach(el -> pb.addProductProductConfig(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_product_config_product to head entity
                        if(relationsDemand.contains("product_product_config_product")) {
                            genericProcs.getRelationValues(c, p1, "product_product_config_product",
                                            ProductConfigProduct.class)
                                    .forEach(el -> pb.addProductProductConfigProduct(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_content to head entity
                        if(relationsDemand.contains("product_content")) {
                            genericProcs.getRelationValues(c, p1, "product_content",
                                            ProductContent.class)
                                    .forEach(el -> pb.addProductContent(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_facility to head entity
                        if(relationsDemand.contains("product_facility")) {
                            genericProcs.getRelationValues(c, p1, "product_facility",
                                            ProductFacility.class)
                                    .forEach(el -> pb.addProductFacility(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_facility_assoc to head entity
                        if(relationsDemand.contains("product_facility_assoc")) {
                            genericProcs.getRelationValues(c, p1, "product_facility_assoc",
                                            ProductFacilityAssoc.class)
                                    .forEach(el -> pb.addProductFacilityAssoc(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_facility_location to head entity
                        if(relationsDemand.contains("product_facility_location")) {
                            genericProcs.getRelationValues(c, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.addProductFacilityLocation(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_feature_appl to head entity
                        if(relationsDemand.contains("product_feature_appl")) {
                            genericProcs.getRelationValues(c, p1, "product_feature_appl",
                                            ProductFeatureAppl.class)
                                    .forEach(el -> pb.addProductFeatureAppl(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_keyword to head entity
                        if(relationsDemand.contains("product_keyword")) {
                            genericProcs.getRelationValues(c, p1, "product_keyword",
                                            ProductKeyword.class)
                                    .forEach(el -> pb.addProductKeyword(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_price to head entity
                        if(relationsDemand.contains("product_price")) {
                            genericProcs.getRelationValues(c, p1, "product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addProductPrice(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_promo_product to head entity
                        if(relationsDemand.contains("product_promo_product")) {
                            genericProcs.getRelationValues(c, p1, "product_promo_product",
                                            ProductPromoProduct.class)
                                    .forEach(el -> pb.addProductPromoProduct(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_review to head entity
                        if(relationsDemand.contains("product_review")) {
                            genericProcs.getRelationValues(c, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_store_survey_appl to head entity
                        if(relationsDemand.contains("product_store_survey_appl")) {
                            genericProcs.getRelationValues(c, p1, "product_store_survey_appl",
                                            ProductStoreSurveyAppl.class)
                                    .forEach(el -> pb.addProductStoreSurveyAppl(
                                            el.toDataBuilder().build()));
                        }

                        // add/set product_subscription_resource to head entity
                        if(relationsDemand.contains("product_subscription_resource")) {
                            genericProcs.getRelationValues(c, p1, "product_subscription_resource",
                                            ProductSubscriptionResource.class)
                                    .forEach(el -> pb.addProductSubscriptionResource(
                                            el.toDataBuilder().build()));
                        }

                        // add/set quote_item to head entity
                        if(relationsDemand.contains("quote_item")) {
                            genericProcs.getRelationValues(c, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.addQuoteItem(
                                            el.toDataBuilder().build()));
                        }

                        // add/set shipment_item to head entity
                        if(relationsDemand.contains("shipment_item")) {
                            genericProcs.getRelationValues(c, p1, "shipment_item",
                                            ShipmentItem.class)
                                    .forEach(el -> pb.addShipmentItem(
                                            el.toDataBuilder().build()));
                        }

                        // add/set sub_shipment_package_content to head entity
                        if(relationsDemand.contains("sub_shipment_package_content")) {
                            genericProcs.getRelationValues(c, p1, "sub_shipment_package_content",
                                            ShipmentPackageContent.class)
                                    .forEach(el -> pb.addSubShipmentPackageContent(
                                            el.toDataBuilder().build()));
                        }

                        // add/set shipment_receipt to head entity
                        if(relationsDemand.contains("shipment_receipt")) {
                            genericProcs.getRelationValues(c, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                            el.toDataBuilder().build()));
                        }

                        // add/set supplier_product to head entity
                        if(relationsDemand.contains("supplier_product")) {
                            genericProcs.getRelationValues(c, p1, "supplier_product",
                                            SupplierProduct.class)
                                    .forEach(el -> pb.addSupplierProduct(
                                            el.toDataBuilder().build()));
                        }

                        // add/set work_effort_good_standard to head entity
                        if(relationsDemand.contains("work_effort_good_standard")) {
                            genericProcs.getRelationValues(c, p1, "work_effort_good_standard",
                                            WorkEffortGoodStandard.class)
                                    .forEach(el -> pb.addWorkEffortGoodStandard(
                                            el.toDataBuilder().build()));
                        }


                        return pb;
                    }).collect(Collectors.toList());

            ResultSubscriber<IModel<?>> resultSubscriber=new ResultSubscriber<>();
            ds.forEach(e -> resultSubscriber.onNext(new ModelWrapper<>(e)));
            resultSubscriber.onComplete();

            resultSubscriber.getResult()
                    .forEach(e -> System.out.println(e.toData()));
        });

    }
}


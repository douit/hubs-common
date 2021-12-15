package com.bluecc.income.dao;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.stub.Identity;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.ProductStoreData;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.model.FixedAsset;
import com.bluecc.income.model.OrderHeader;
import com.bluecc.income.model.ProductStore;
import com.bluecc.income.model.ProductStorePaymentSetting;
import com.bluecc.income.procs.Orders;
import com.bluecc.income.procs.StatusTypes;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import com.google.protobuf.Descriptors;
import lombok.Data;
import org.assertj.core.api.Condition;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;

import javax.inject.Inject;
import javax.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.fund.Tuple2.of;
import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.stereotypes.OrderSeedData.StatusItem_ORDER_CANCELLED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ProductStoreDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ProductStoreDelegator productStores;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductStore");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            ProductStoreFlatData flatData = ProductStoreFlatData.newBuilder()
                    .setProductStoreId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productStores.create(ctx, flatData));
            assertEquals(1, productStores.update(ctx, flatData));
            assertEquals(1, productStores.find(ctx, flatData).size());
            assertEquals(1, productStores.findById(ctx, flatData).size());
            assertEquals(1, productStores.delete(ctx, flatData));
            assertEquals(0, productStores.find(ctx, flatData).size());
        });
    }

    @Test
    public void testQueryProductStore() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProductStore store = productStores.findOne(c,
                    Identity.newBuilder()
                            .setType("ProductStore")
                            .setValue("9000")
                            .build(), ProductStore.class);
            assertEquals("WebStoreWarehouse", store.getInventoryFacilityId());
            productStores.getRelationValues(c, store.toData(),
                            "product_store_payment_setting",
                            ProductStorePaymentSetting.class)
                    .forEach(e -> pretty(e));
        });
    }

    @Test
    public void testDelegator() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            productStores.queryProductStoreRelations("9000",
                            Sets.newHashSet(ProductStoreDelegator.PRODUCT_STORE_PAYMENT_SETTING))
                    .apply("")
                    .subscribe(e -> e.toData());
        });
    }

    @Test
    public void testAgent() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
            agent.getProductStorePaymentSetting().forEach(e -> pretty(e));

            Condition<ProductStorePaymentSetting> giftCard = new Condition<>(
                    m -> m.getPaymentMethodTypeId().equalsIgnoreCase("GIFT_CARD"),
                    "has GIFT_CARD"
            );
            assertThat(agent.getProductStorePaymentSetting())
                    .haveExactly(5, giftCard)
                    .hasAtLeastOneElementOfType(ProductStorePaymentSetting.class);
        });
    }

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @Test
    public void testAgentLiveObject() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
            agent.merge();
            agent.mergeProductStorePaymentSetting();
        });

        // find it
        ProductStore store = liveObjectsProvider.get().get(ProductStore.class, "9000");
        assertNotNull(store);
        pretty(store);
    }

    @Test
    public void testLiveObject() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
            ProductStore productStore = agent.merge();
            pretty(productStore);
            System.out.println("-> " + productStore.getRelProductStorePaymentSetting());

            // agent.mergeProductStorePaymentSetting()
            //         .forEach(e -> pretty(e));

            ProductStorePaymentSetting po = agent.getProductStorePaymentSetting().get(0);
            System.out.println("id: " + po.getId());
            productStores.liveObjectsProvider.get().merge(po);

            agent.mergeProductStorePaymentSetting();
        });

    }

    @Test
    public void testCompletionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<List<IModel<?>>> cf = CompletableFuture.supplyAsync(() -> {
            Flux<IModel<?>> flux = process(c -> {
                // Dao dao = c.getHandle().attach(// Dao.class);

                // ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
                // ProductStore productStore = agent.merge();
                // merge的对象无法传递

                // pretty(productStore);
                // System.out.println("-> " + productStore.getProductStorePaymentSetting());
                ProductStore store = productStores.findOne(c,
                        Identity.newBuilder()
                                .setType("ProductStore")
                                .setValue("9000")
                                .build(), ProductStore.class);
                c.getSubscriber().onNext(store);
                c.getSubscriber().onComplete();
            });
            return flux.collectList().block();
        });
        // cf.get().index().subscribe(e -> {
        //     System.out.println(e.getT1()+" -> "+e.getT2().toData());
        // });
        List<IModel<?>> rs = cf.get();
        rs.forEach(e -> System.out.println("-> " + e.toData()));
        // CompletableFuture<String> cf2 = cf.exceptionally(throwable -> "occurs a error: " + throwable);
    }

    @Test
    public void testCompletionStageWithAgent() throws ExecutionException, InterruptedException {
        CompletableFuture<Flux<IModel<?>>> cf = CompletableFuture.supplyAsync(() ->
                process(c -> {
                    ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
                    // ProductStore productStore = agent.merge(); // DON'T DO THIS

                    c.getSubscriber().onNext(agent.getRecord());
                    agent.getProductStorePaymentSetting().forEach(e -> {
                        c.getSubscriber().onNext(e);
                    });
                    c.getSubscriber().onComplete();
                }));
        cf.get().index().subscribe(e -> {
            System.out.println(e.getT1() + " -> " + e.getT2().toData());
        });
    }

    @Test
    public void testCompletionStageWithAgent2() throws ExecutionException, InterruptedException {
        CompletableFuture<List<IModel<?>>> cf =
                process(c -> {
                    ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
                    // ProductStore productStore = agent.merge(); // DON'T DO THIS

                    c.getSubscriber().onNext(agent.getRecord());
                    agent.getProductStorePaymentSetting().forEach(e -> {
                        c.getSubscriber().onNext(e);
                    });
                    c.getSubscriber().onComplete();
                }).collectList().toFuture();

        Set<String> allMethodTypes = cf.get().stream().peek(e -> System.out.println(e))
                .filter(e -> e instanceof ProductStorePaymentSetting)
                .map(e -> ((ProductStorePaymentSetting) e).getPaymentMethodTypeId())
                .collect(Collectors.toSet());
        System.out.println(allMethodTypes);
        assertThat(allMethodTypes).contains("EXT_OFFLINE",
                "EXT_PAYPAL", "EXT_WORLDPAY", "GIFT_CARD",
                "EXT_BILLACT", "FIN_ACCOUNT", "CREDIT_CARD",
                "EFT_ACCOUNT", "EXT_COD");
    }

    @Test
    public void testEntityAnnotation() {
        // Dao dao = c.getHandle().attach(Dao.class);
        // ProductStoreData.class;
        // Descriptors.Descriptor
        // ProductStoreData.getDefaultInstance();
        // ProductStoreData.getDescriptor()
        {
            Supplier<Descriptors.Descriptor> descriptorSupplier = ProductStoreData::getDescriptor;
            Descriptors.Descriptor descriptor = descriptorSupplier.get();
            // descriptor.getFields().forEach(f -> System.out.println(f.getName()));
            assertTrue(descriptor.getFields().size() > 1);
        }
        MessageObject messageObject = ProductStore.class.getAnnotation(MessageObject.class);
        try {
            Method method = messageObject.value().getMethod("getDescriptor");
            Descriptors.Descriptor descriptor = (Descriptors.Descriptor) method.invoke(null);
            descriptor.getFields().forEach(f -> System.out.println(f.getName()));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail(e.getMessage());
        }
    }


    @RegisterBeanMapper(value = ProductStore.class)
    public interface QueryDao {
        @SqlQuery("select * from product_store")
        List<ProductStore> listProductStore();

        @SqlQuery("select * from product_store " +
                "where product_store_id in (" +
                "select product_store_id from product_store_catalog " +
                "where prod_catalog_id=:cat)")
        List<ProductStore> getStoresByCatalog(@Bind("cat") String catalogId);

        @SqlQuery("select * from product_store")
        List<String> allIds();

        @SqlQuery("select * from product_store where product_store_id=:id")
        ProductStore getProductStore(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store")
        int countProductStore();

        @RegisterBeanMapper(StoreCatalog.class)
        @SqlQuery("select product_store_id, prod_catalog_id from product_store_catalog")
        List<StoreCatalog> storeCatalogs();
    }

    @Data
    public static class StoreCatalog {
        String productStoreId;
        String prodCatalogId;
    }

    @Test
    public void testQueryDao() {
        process(c -> {
            QueryDao dao = c.getHandle().attach(QueryDao.class);
            System.out.println(dao.listProductStore().stream().map(ps -> ps.getProductStoreId())
                    .collect(Collectors.toList()));
            assertThat(dao.allIds()).isEqualTo(dao.listProductStore().stream()
                    .map(ps -> ps.getProductStoreId())
                    .collect(Collectors.toList()));

            //
            String prodCatalogId = "RentalCatalog";
            Condition<ProductStore> cond = new Condition<>(m ->
                    m.getProductStoreId().equals("RentalStore"), "");
            assertThat(dao.getStoresByCatalog(prodCatalogId)
                    .stream().peek(e -> pretty(e)).collect(Collectors.toList()))
                    .have(cond);
            dao.storeCatalogs().forEach(e -> System.out.println(e));
        });
    }

    class ProductStoreMesh {
        ProductStore productStore;

        ProductStoreMesh(ProductStore productStore) {
            this.productStore = productStore;
        }

        Function<IProc.ProcContext, List<ProductStorePaymentSetting>> getPaymentSettings() {
            return c -> {
                ProductStoreDelegator.Agent agent = productStores.getAgent(c, this.productStore);
                return agent.getProductStorePaymentSetting();
            };
        }
    }

    Consumer<Tuple2<IProc.ProcContext, ProductStore>> paymentSettings() {
        return e -> {
            productStores.getAgent(e.f0, e.f1)
                    .getProductStorePaymentSetting()
                    .forEach(c -> e.f1.getRelProductStorePaymentSetting().add(c));
        };
    }

    Consumer<Tuple2<IProc.ProcContext, ProductStore>> emailSettings() {
        return e -> {
            productStores.getAgent(e.f0, e.f1)
                    .getProductStoreEmailSetting()
                    .forEach(c -> e.f1.getRelProductStoreEmailSetting().add(c));
        };
    }

    @Test
    public void testProductStoreRelates() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            paymentSettings()
                    .andThen(emailSettings())
                    .accept(of(c, productStores.get(c, "RentalStore")));
        });
    }


    Consumer<ProductStore> paymentSettings2(IProc.ProcContext ctx) {
        return e -> {
            productStores.getAgent(ctx, e)
                    .getProductStorePaymentSetting()
                    .forEach(c -> e.getRelProductStorePaymentSetting().add(c));
        };
    }

    Consumer<ProductStore> emailSettings2(IProc.ProcContext ctx) {
        return e -> {
            productStores.getAgent(ctx, e)
                    .getProductStoreEmailSetting()
                    .forEach(c -> e.getRelProductStoreEmailSetting().add(c));
        };
    }

    Consumer<ProductStore> printStores(){
        return e->{
            pretty(e);
            pretty(e.getRelProductStorePaymentSetting());
            pretty(e.getRelProductStoreEmailSetting());
        };
    }


    @Test
    public void testProductStoreRelatesWithConsumer() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            paymentSettings2(c)
                    .andThen(emailSettings2(c))
                    .andThen(printStores())
                    .accept(productStores.get(c, "RentalStore"));
        });
    }

    @Test
    public void testProductStoreMesh() {
        process(c -> {
            ProductStoreDelegator.Dao dao = c.getHandle().attach(ProductStoreDelegator.Dao.class);
            ProductStoreMesh mesh = new ProductStoreMesh(dao.getProductStore("RentalStore"));
            // productStores.getAgent(c, "RentalStore").getProductStorePaymentSetting();
            mesh.getPaymentSettings().apply(c).forEach(e -> pretty(e));
        });
    }

    @RegisterBeanMapper(ProductStore.class)
    public interface PrivDao {
        // 实际上还要删除所有的订单子项, 这里只为了测试;
        // 实际应用中所有的订单都不会被删除, 只会被标记取消
        @SqlUpdate("delete from order_header where product_store_id=:id")
        void removeOrders(@Bind("id") String id);
    }

    @Inject
    Orders orders;
    @Inject
    StatusTypes statusTypes;

    @Test
    public void testReceiveOrder() {
        process(c -> {
            PrivDao dao = c.getHandle().attach(PrivDao.class);
            String storeKey = "RentalStore";
            ProductStoreDelegator.Agent agent = productStores.getAgent(c, storeKey);

            dao.removeOrders(storeKey);
            // System.out.println(agent.getOrderHeader().size());
            assertEquals(0, agent.getOrderHeader().size());
            System.out.println(agent.getRecord().getProductStoreId());

            genericProcs.create(c,
                    OrderHeaderFlatData.newBuilder()
                            .setCreatedBy("admin")
                            .setCurrencyUom("USD")
                            .setEntryDate(nowTimestamp())
                            .setGrandTotal(getCurrency("108.0"))
                            .setOrderDate(getTimestamp("2008-06-10 13:27:07.024"))
                            .setOrderId(sequence.nextStringId())
                            .setOrderName("New Purchase Order")
                            .setOrderTypeId("PURCHASE_ORDER")
                            .setProductStoreId(agent.getRecord().getProductStoreId())
                            .setRemainingSubTotal(getCurrency("108.0"))
                            .setSalesChannelEnumId("UNKNWN_SALES_CHANNEL")
                            .setStatusId("ORDER_CREATED")
                            .setVisitId("10000")
                            .setWebSiteId("WebStore")
                            .build());

            // System.out.println(agent.getOrderHeader().size());
            List<OrderHeader> headers = agent.getOrderHeader();
            assertEquals(1, headers.size());

            System.out.println(headers.get(0).getStatusId());

            assertTrue(statusTypes.isValid("Order",
                    "ORDER_CREATED", "ORDER_CANCELLED"));

            // set-status需要在*-mesh类中调用, 这样才能发出状态修改事件,
            // 以及确保执行正确的切换; 这儿只作测试
            orders.setOrderStatus(headers.get(0).toDataBuilder().build(),
                    StatusItem_ORDER_CANCELLED.getStatusId());
            assertEquals(StatusItem_ORDER_CANCELLED.getStatusId(),
                    agent.getOrderHeader().get(0).getStatusId());

            // statusTypes.isValid("Budget", "BG_CREATED", "BG_REJECTED")

        });
    }
}

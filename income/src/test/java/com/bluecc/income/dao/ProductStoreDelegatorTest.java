package com.bluecc.income.dao;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.stub.Identity;
import com.bluecc.hubs.stub.ProductStoreData;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.ProductStore;
import com.bluecc.income.model.ProductStorePaymentSetting;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import com.google.protobuf.Descriptors;
import org.assertj.core.api.Condition;
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
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.Util.pretty;
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
        ProductStore store=liveObjectsProvider.get().get(ProductStore.class, "9000");
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
        CompletableFuture<List<IModel<?>>> cf=
            process(c -> {
                ProductStoreDelegator.Agent agent = productStores.getAgent(c, "9000");
                // ProductStore productStore = agent.merge(); // DON'T DO THIS

                c.getSubscriber().onNext(agent.getRecord());
                agent.getProductStorePaymentSetting().forEach(e -> {
                    c.getSubscriber().onNext(e);
                });
                c.getSubscriber().onComplete();
            }).collectList().toFuture();

        Set<String> allMethodTypes=cf.get().stream().peek(e -> System.out.println(e))
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
}

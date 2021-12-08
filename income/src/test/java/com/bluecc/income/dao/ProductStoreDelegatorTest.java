package com.bluecc.income.dao;

import com.bluecc.hubs.stub.Identity;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.ProductStore;
import com.bluecc.income.model.ProductStorePaymentSetting;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
            ProductStoreDelegator.Agent agent=productStores.getAgent(c, "9000");
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

    @Test
    public void testLiveObject() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProductStoreDelegator.Agent agent=productStores.getAgent(c, "9000");
            ProductStore productStore=agent.merge();
            pretty(productStore);
        });
    }
}

package com.bluecc.income.dao;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.stub.ProdCatalogFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.Product;
import com.bluecc.income.model.ProductStoreCatalog;
import com.github.javafaker.Faker;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class ProdCatalogDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ProdCatalogDelegator prodCatalogs;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProdCatalog");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            ProdCatalogFlatData flatData = ProdCatalogFlatData.newBuilder()
                    .setProdCatalogId(newId)
                    .setCatalogName(faker.hipster().word())
                    .build();
            assertEquals(1, prodCatalogs.create(ctx, flatData));
            assertEquals(1, prodCatalogs.update(ctx, flatData));
            assertEquals(1, prodCatalogs.find(ctx, flatData).size());
            assertEquals(1, prodCatalogs.findById(ctx, flatData).size());
            assertEquals(1, prodCatalogs.delete(ctx, flatData));
            assertEquals(0, prodCatalogs.find(ctx, flatData).size());
        });
    }

    @Test
    public void testAll() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            prodCatalogs.all(c, EntityNames.ProdCatalog, 0)
                    .forEach(e -> pretty(e));
        });
    }

    @Test
    public void testBelongs() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProdCatalogDelegator.Agent agent = prodCatalogs.getAgent(c, "RentalCatalog");
            agent.getProductStoreCatalog().forEach(e -> pretty(e));
            // Condition<? extends ProductStoreCatalog> cond=new Condition<>(
            //         e -> e.getProdCatalogId().equals("RentalCatalog"), "has-id");
            assertThat(agent.getProductStoreCatalog())
                    .hasSizeGreaterThan(0);
        });
    }

    @Inject
    ProductStoreCatalogDelegator productStoreCatalogDelegator;
    @Inject
    ProductStoreDelegator productStoreDelegator;

    @Test
    public void testForward() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProdCatalogDelegator.Agent agent = prodCatalogs.getAgent(c, "RentalCatalog");
            List<ProductStoreCatalog> cats = agent.getProductStoreCatalog();
            assertFalse(cats.isEmpty());
            List<String> storeIds = cats.stream()
                    .map(e -> e.agent(c, productStoreCatalogDelegator)
                            .getProductStore()).flatMap(el -> el.stream())
                    .map(e -> e.getProductStoreId())
                    .collect(Collectors.toList());
            System.out.println(storeIds);

            // ...
            long paymentSettsTotal = cats.stream()
                    .map(e -> e.agent(c, productStoreCatalogDelegator)
                            .getProductStore()).flatMap(el -> el.stream())
                    .map(e -> e.agent(c, productStoreDelegator).getProductStorePaymentSetting())
                    .flatMap(el -> el.stream())
                    .count();
            System.out.println(paymentSettsTotal);
        });
    }

    @Inject
    ProdCatalogCategoryDelegator prodCatalogCategoryDelegator;
    @Inject
    ProductCategoryDelegator productCategoryDelegator;
    @Test
    public void testCatCategory() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            ProdCatalogDelegator.Agent agent = prodCatalogs.getAgent(c, "RentalCatalog");
            List<Product> products=agent.getProdCatalogCategory()
                    .stream().peek(pcc -> pretty(pcc))
                    .map(pcc -> pcc.agent(c, prodCatalogCategoryDelegator).getProductCategory())
                    .flatMap(el -> el.stream())
                    .peek(pc -> System.out.println("pc: "+ pc))
                    // 因为没有跟随到rollup类别, 所以目前只是查找的直接绑定
                    // .map(pc -> pc.agent(c, productCategoryDelegator).getParentProductCategoryRollup())
                    .map(pc -> pc.agent(c, productCategoryDelegator).getPrimaryProduct())
                    .flatMap(el -> el.stream())
                    .peek(p -> System.out.println("p: "+p.getProductName()))
                    .collect(Collectors.toList());
            System.out.println(products.size());
        });
    }
}

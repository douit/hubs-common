package com.bluecc.income.dao;

import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.model.ProductCategoryRollup;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertEquals;

public class ProductCategoryRollupDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ProductCategoryRollupDelegator productCategoryRollups;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductCategoryRollup");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            ProductCategoryRollupFlatData flatData = ProductCategoryRollupFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productCategoryRollups.create(ctx, flatData));
            assertEquals(1, productCategoryRollups.update(ctx, flatData));
            assertEquals(1, productCategoryRollups.find(ctx, flatData).size());
            assertEquals(1, productCategoryRollups.findById(ctx, flatData).size());
            assertEquals(1, productCategoryRollups.delete(ctx, flatData));
            assertEquals(0, productCategoryRollups.find(ctx, flatData).size());
        });
    }

    @Test
    public void testAll() {
        process(c -> {
            printCatRollups(c);
            // printCatMembers(c);
        });
    }

    private void printCatRollups(IProc.ProcContext ctx) {
        ProductCategoryRollupDelegator.Dao dao = ctx.getHandle()
                .attach(ProductCategoryRollupDelegator.Dao.class);
        List<ProductCategoryRollup> rollupList = dao.listProductCategoryRollup();
        rollupList.stream()
                // .peek(e -> pretty(e))
                .map(roll -> {
                    return Tuple2.of(roll.getProductCategoryId(), rollupList.stream().filter(
                                    c -> c.getParentProductCategoryId().equals(roll.getProductCategoryId()))
                            .map(c -> c.getProductCategoryId())
                            .collect(Collectors.toList()));
                }).collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }

    private void printCatMembers(IProc.ProcContext c) {
        ProductCategoryMemberDelegator.Dao members =
                c.getHandle().attach(ProductCategoryMemberDelegator.Dao.class);
        members.listProductCategoryMember().forEach(e -> pretty(e));
    }
}

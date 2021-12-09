package com.bluecc.income.dao;

import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class FixedAssetDelegatorTest extends AbstractStoreProcTest {
    @Inject FixedAssetDelegator fixedAssets;

    @Before
    public void setUp() throws Exception {
        setupEntities("FixedAsset");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            FixedAssetFlatData flatData= FixedAssetFlatData.newBuilder()
                    .setFixedAssetId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, fixedAssets.create(ctx, flatData));
            assertEquals(1, fixedAssets.update(ctx, flatData));
            assertEquals(1, fixedAssets.find(ctx, flatData).size());
            assertEquals(1, fixedAssets.findById(ctx, flatData).size());
            assertEquals(1, fixedAssets.delete(ctx, flatData));
            assertEquals(0, fixedAssets.find(ctx, flatData).size());
        });
    }
}

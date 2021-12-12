package com.bluecc.income.dao;

import com.bluecc.hubs.stub.WebSiteFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class WebSiteDelegatorTest extends AbstractStoreProcTest {
    @Inject WebSiteDelegator webSites;

    @Before
    public void setUp() throws Exception {
        setupEntities("WebSite");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            WebSiteFlatData flatData= WebSiteFlatData.newBuilder()
                    .setWebSiteId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, webSites.create(ctx, flatData));
            assertEquals(1, webSites.update(ctx, flatData));
            assertEquals(1, webSites.find(ctx, flatData).size());
            assertEquals(1, webSites.findById(ctx, flatData).size());
            assertEquals(1, webSites.delete(ctx, flatData));
            assertEquals(0, webSites.find(ctx, flatData).size());
        });
    }
}

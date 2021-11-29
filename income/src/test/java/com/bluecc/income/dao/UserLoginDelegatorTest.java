package com.bluecc.income.dao;

import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class UserLoginDelegatorTest extends AbstractStoreProcTest {
    @Inject UserLoginDelegator userLogins;

    @Before
    public void setUp() throws Exception {
        setupEntities("UserLogin");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            UserLoginFlatData flatData= UserLoginFlatData.newBuilder()
                    .setUserLoginId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, userLogins.create(ctx, flatData));
            assertEquals(1, userLogins.update(ctx, flatData));
            assertEquals(1, userLogins.find(ctx, flatData).size());
            assertEquals(1, userLogins.findById(ctx, flatData).size());
            assertEquals(1, userLogins.delete(ctx, flatData));
            assertEquals(0, userLogins.find(ctx, flatData).size());
        });
    }
}

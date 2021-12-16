package com.bluecc.income.dao;

import com.bluecc.hubs.stub.SecurityGroupFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class SecurityGroupDelegatorTest extends AbstractStoreProcTest {
    @Inject SecurityGroupDelegator securityGroups;

    @Before
    public void setUp() throws Exception {
        setupEntities("SecurityGroup");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            SecurityGroupFlatData flatData= SecurityGroupFlatData.newBuilder()
                    .setGroupId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, securityGroups.create(ctx, flatData));
            assertEquals(1, securityGroups.update(ctx, flatData));
            assertEquals(1, securityGroups.find(ctx, flatData).size());
            assertEquals(1, securityGroups.findById(ctx, flatData).size());
            assertEquals(1, securityGroups.delete(ctx, flatData));
            assertEquals(0, securityGroups.find(ctx, flatData).size());
        });
    }
}

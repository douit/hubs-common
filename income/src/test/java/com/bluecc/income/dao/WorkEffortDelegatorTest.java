package com.bluecc.income.dao;

import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.cli.Printers;
import com.bluecc.income.model.WorkEffort;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class WorkEffortDelegatorTest extends AbstractStoreProcTest {
    @Inject WorkEffortDelegator workEfforts;

    @Before
    public void setUp() throws Exception {
        setupEntities("WorkEffort");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            WorkEffortFlatData flatData= WorkEffortFlatData.newBuilder()
                    .setWorkEffortId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, workEfforts.create(ctx, flatData));
            assertEquals(1, workEfforts.update(ctx, flatData));
            assertEquals(1, workEfforts.find(ctx, flatData).size());
            assertEquals(1, workEfforts.findById(ctx, flatData).size());
            assertEquals(1, workEfforts.delete(ctx, flatData));
            assertEquals(0, workEfforts.find(ctx, flatData).size());
        });
    }

    @Test
    public void testWorkflowMeta() {
        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            workEfforts.all(c).forEach(e -> {
                System.out.println(e.getWorkEffortId());
                workEfforts.getAgent(c, "9000")
                        .getChildWorkEffort()
                        .forEach(el -> {
                    System.out.println("\t"+el.getWorkEffortId());
                });
            });

            workEfforts.store(WorkEffort.builder()
                            .workEffortName("test one")
                    .build());
        });
    }

    @Test
    public void testChainQuery() {
        process(c -> {
            //Dao dao = c.getHandle().attach(//Dao.class);
            // workEfforts.getAgent(c, "9000");
            workEfforts.chainQuery(c,
                    WorkEffortDelegator.CHILD_WORK_EFFORT)
                    .values().forEach(e -> {
                        Printers.printChildren(e);
                    });
        });
    }
}

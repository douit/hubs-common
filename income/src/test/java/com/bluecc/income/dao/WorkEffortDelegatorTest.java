package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.model.WithSuppliers;
import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.EntityValue;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.cli.Printers;
import com.bluecc.income.exchange.ModelSerializer;
import com.bluecc.income.model.WorkEffort;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.income.exchange.ModelSerializer.getEntityValue;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void testChainQueryByInspectMeta() {
        process(c -> {
            String entityName="WorkEffort";

            Set<String> incls=protoMeta.getInspectMeta(entityName)
                    .getValidRelationNames();
            assertThat(incls).contains("child_work_effort");
            List<EntityValue> entityValues = workEfforts.chainQuery(c, incls)
                    .values().stream().map(e -> getEntityValue(e))
                    .collect(Collectors.toList());

            EntityBucket bucket=EntityBucket.newBuilder()
                    .setEntityType(entityName)
                    .addAllValues(entityValues)
                    .build();

            // workEfforts.chainQuery(c, incls.toArray(new String[0]))
            //         .values().stream().map(w -> w.)
            System.out.println(entityValues.size());

            String jsonStr=ProtoJsonUtils.toJson(bucket);

            System.out.println(jsonStr);
            dump(entityName+".json", jsonStr);
        });
    }


}

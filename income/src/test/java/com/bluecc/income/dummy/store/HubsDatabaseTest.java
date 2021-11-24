package com.bluecc.income.dummy.store;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.GuiceTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

import javax.inject.Inject;

import java.util.Map;

import static org.junit.Assert.*;


@RunWith(GuiceTestRunner.class)
public class HubsDatabaseTest {
    @Inject
    HubsStore hubsStore;

    @Test
    public void insertPerson() {
        int updated=hubsStore.getJdbi().withHandle(handle -> {
            Map<String, Object> ctx= ImmutableMap.of(
                    "last_name", "samlet",
                    "first_name", "wu");
            int r=handle.createUpdate("insert into person (last_name, first_name) " +
                            "values (:last_name, :first_name)")
                    .bindMap(ctx)
                    .execute();
            return r;
        });
        System.out.println(updated);
        assertEquals(1, updated);
    }

    @Test
    public void personProto(){
        PersonFlatData personFlatData= PersonFlatData.newBuilder()
                .setFirstName("samlet")
                .setLastName("wu")
                .build();
        personFlatData.getAllFields().forEach((k,v) ->
                System.out.println(k.getName()+", "+v.getClass().getName()));

    }

    @Test
    public void queryPersonProto(){
        HubsDatabase.queryPerson(hubsStore.jdbi)
                .forEach(p -> System.out.println(ProtoJsonUtils.toJson(p)));
    }
}
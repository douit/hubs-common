package com.bluecc.income.dummy.store;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.FlatMessageCollector;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class UpdaterTest extends AbstractStoreProcTest {
    @Before
    public void setUp() throws Exception {
        setupEntities("Person");
    }

    @Test
    public void testUpdateFlatMessage() {
        process(ctx -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            String newId=sequence.nextStringId();
            PersonFlatData flatData= PersonFlatData.newBuilder()
                    .setPartyId(newId)
                    .setLastName("samlet")
                    .setFirstName("wu")
                    .build();

            Map<String, Object> e= FlatMessageCollector.extract(flatData);

            List<String> names = new ArrayList<>(e.keySet());
            List<String> placers = names.stream().map(name -> ":" + name)
                    .collect(Collectors.toList());

            String table= ProtoTypes.getTableByMessage(flatData);

            // create
            int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                    .define("table", table)
                    .defineList("columns", names)
                    .defineList("placers", placers)
                    .bindMap(e)
                    .execute();
            assertEquals(1, total);

            // update
            // update something set name=:name where id=:id
            List<String> fieldsCond = names.stream()
                    .map(name -> name+" = :" + name)
                    .collect(Collectors.toList());
            List<String> idCondList= Lists.newArrayList();
            for (String entityKey : ProtoTypes.getEntityKeys(flatData)) {
                idCondList.add(String.format("%s=:%s", entityKey, entityKey));
            }
            String idCond=String.join(" and ", idCondList);
            total = ctx.getHandle().createUpdate("update <table> set <fields_cond> where <id_cond>")
                    .define("table", table)
                    .defineList("fields_cond", fieldsCond)
                    .define("id_cond", idCond)
                    .bindMap(e)
                    .execute();
            assertEquals(1, total);

            // delete
            // delete from person where last_name = :it
            total = ctx.getHandle().createUpdate("delete from <table> where <id_cond>")
                    .define("table", table)
                    .define("id_cond", idCond)
                    .bindMap(e)
                    .execute();
            assertEquals(1, total);
        });
    }
}

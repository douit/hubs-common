package com.bluecc.income.procs;

import com.bluecc.income.AbstractStoreProcTest;
import com.google.common.collect.Lists;
import org.jdbi.v3.core.statement.Query;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;

import static org.junit.Assert.*;

public class SelectorBindingsTest extends AbstractStoreProcTest {

    @Test
    public void testQueryBinds() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            Query selector = c.getHandle().select("select * from product "
                    +"where product_id in (<ids>)");

            SelectorBindings bindings=SelectorBindings.builder()
                    .listBinding("ids", Lists.newArrayList("RoomStd"))
                    .build();
            System.out.println(bindings.getMapBindings());
            // selector.bindList("ids", Lists.newArrayList("RoomStd"));
            // selector.bindMap(ImmutableMap.of("ids", Lists.newArrayList("RoomStd")));
            bindings.enrich(selector);

            selector.mapToMap().list().forEach(e -> System.out.println(e));
        });
    }

}
package com.bluecc.income.dummy.store;

import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.MessageMapCollector;
import com.bluecc.income.template.TemplateGlobalContext;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.customizer.TimestampedConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.income.exchange.ResourceHelper.readResource;

public class OrdersTest extends AbstractStoreProcTest {

    @Before
    public void setUp() throws Exception {
        setupEntities("OrderItem", "OrderHeader", "ProductPrice");
    }

    @Test
    public void testStoreCompound() {
        process(ctx -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            Map<String, MessageMapCollector.ResultData> resultMap=
                    genericProcs.storeCompoundObject(ctx,
                            readResource("order_head_simple",
                            OrderHeaderData.newBuilder())
                            .build());

            resultMap.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
        });
    }


    @Test
    public void testStoreCompound2() {
        process(ctx -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            Map<String, MessageMapCollector.ResultData> resultMap=
                    genericProcs.storeCompoundObject(ctx,
                            readResource("order_head_product",
                                    OrderHeaderData.newBuilder())
                                    .build());

            resultMap.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
        });
    }
}

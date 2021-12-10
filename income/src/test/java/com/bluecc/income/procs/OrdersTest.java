package com.bluecc.income.procs;

import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.income.AbstractOnceProcTest;
import com.bluecc.income.model.OrderHeader;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import java.math.BigDecimal;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.*;

public class OrdersTest extends AbstractOnceProcTest {
    @Inject
    Orders orders;

    @Before
    public void setUp() throws Exception {
        setupEntities("OrderHeader");
    }

    @Test
    public void setOrderStatus() {
        process(c -> {
            OrderHeaderFlatData order = orders.createOrderHeader(
                    PartyFlatData.newBuilder().setPartyId("admin").build(),
                    new BigDecimal("88.88"));
            orders.create(c, order);
            orders.setOrderStatus(order, "ORDER_SENT");
            OrderHeader orderHeader=orders.findOne(c, OrderHeaderFlatData.newBuilder()
                    .setOrderId(order.getOrderId())
                    .build(), OrderHeader.class);
            pretty(orderHeader);
            assertEquals("ORDER_SENT", orderHeader.getStatusId());
        });
    }
}
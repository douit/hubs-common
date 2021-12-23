package com.bluecc.income.dao;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.OrderStatusData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.cli.Printers;
import com.bluecc.income.model.OrderHeader;
import com.bluecc.income.model.OrderItem;
import com.bluecc.income.model.OrderStatus;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Locale;

import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.livecases.SalesOrder_DEMO10090.OrderHeader_DEMO10090;
import static com.bluecc.hubs.livecases.SalesOrder_DEMO10090.OrderItem_DEMO10090_00001;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderHeaderDelegatorTest extends AbstractStoreProcTest {
    @Inject
    OrderHeaderDelegator orderHeaders;

    @Before
    public void setUp() throws Exception {
        setupEntities("OrderHeader");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            OrderHeaderFlatData flatData = OrderHeaderFlatData.newBuilder()
                    .setOrderId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, orderHeaders.create(ctx, flatData));
            assertEquals(1, orderHeaders.update(ctx, flatData));
            assertEquals(1, orderHeaders.find(ctx, flatData).size());
            assertEquals(1, orderHeaders.findById(ctx, flatData).size());
            assertEquals(1, orderHeaders.delete(ctx, flatData));
            assertEquals(0, orderHeaders.find(ctx, flatData).size());
        });
    }

    @Test
    public void testStatus() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            // genericProcs.storeOrUpdate(c, OrderStatusData.newBuilder().setOrderId());
            genericProcs.findList(c, orderId("DEMO10090"), OrderHeader.class)
                    .forEach(e -> pretty(e));
            genericProcs.findRelation(c, orderId("DEMO10090"), "order_status",
                            OrderHeader.class, OrderStatus.class)
                    .forEach(e -> pretty(e));
            assertTrue((long) genericProcs.findList(c, orderStatusWithId("DEMO10090"), OrderStatus.class)
                    .size() > 0);
        });
    }

    static OrderHeaderFlatData orderId(String id) {
        return OrderHeaderFlatData.newBuilder().setOrderId(id).build();
    }

    static OrderStatusData orderStatusWithId(String id) {
        return OrderStatusData.newBuilder().setOrderId(id).build();
    }

    @Inject
    Provider<LiveObjects> liveObjects;

    @Test
    public void testPersistOrder() {
        String orderId = sequence.nextStringId();
        OrderHeader newOrder = OrderHeader.fromPrototype(OrderHeader_DEMO10090())
                .orderId(orderId)
                .build();
        OrderHeader po = liveObjects.get().persist(newOrder);
        System.out.println(po.getOrderId());

        OrderItem orderItem = liveObjects.get()
                .persist(OrderItem.fromPrototype(OrderItem_DEMO10090_00001())
                        .id(sequence.nextStringId())
                        .orderId(orderId)
                        .productId("GZ-2644")
                        .build());
        po.getRelOrderItem().add(orderItem);

        //
        // po.toHeadBuilder();
        Printers.printChildrenJson(po);
    }

    @Test
    public void shoppingListToSalesOrder(){
        // OrderHeaderData: product_store(seller), created_by_user_login(buyer)

    }
}

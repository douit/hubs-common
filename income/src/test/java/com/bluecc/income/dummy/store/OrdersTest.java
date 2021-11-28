package com.bluecc.income.dummy.store;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.MessageMapCollector;
import com.google.protobuf.Message;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

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
            Map<String, MessageMapCollector.ResultData> resultMap =
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
            String newId=sequence.nextStringId();
            Message inputData=buildWithId("order_head_product", newId);

            Map<String, MessageMapCollector.ResultData> resultMap =
                    genericProcs.storeCompoundObject(ctx,
                            inputData);

            resultMap.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
        });
    }

    Message buildWithId(String resourceName, String id) {
        Message.Builder builder =readResource(resourceName, OrderHeaderData.newBuilder());
        ProtoTypes.setEntityKey(builder, id);
        return builder.build();
    }
}

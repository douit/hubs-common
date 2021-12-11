package com.bluecc.income.procs;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.QueryRelations;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.dao.OrderHeaderDelegator;
import io.grpc.stub.StreamObserver;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class OrderRpcTest extends AbstractStoreProcTest {
    @Inject
    OrderRpc rpc;

    @Test
    public void findRelations() {
        rpc.findRelations(QueryRelations.newBuilder()
                .setKey("Demo1002")
                .addRelations(OrderHeaderDelegator.ORDER_ITEM)
                .build(), new StreamObserver<OrderHeaderData>() {
            @Override
            public void onNext(OrderHeaderData value) {
                System.out.println(value);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("all ok.");
            }
        });
    }
}

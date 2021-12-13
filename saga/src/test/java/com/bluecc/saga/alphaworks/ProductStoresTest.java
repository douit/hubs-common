package com.bluecc.saga.alphaworks;

import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.income.dao.ProductStoreDelegator;
import com.bluecc.income.model.OrderHeader;
import com.bluecc.income.procs.ProductStores;
import com.bluecc.saga.ActorTestBase;
import com.bluecc.saga.MeshTestBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import javax.inject.Inject;

import static com.bluecc.income.procs.AbstractProcs.getResultId;

public class ProductStoresTest extends MeshTestBase {
    interface IProductStoreEvent {
    }

    @Data
    @AllArgsConstructor
    static class ProductStoreEvent implements IProductStoreEvent {
        String whom;
        public ActorRef<ProductStoreEventResponse> replyTo;
    }

    @Data
    @AllArgsConstructor
    static class ReceiveOrderEvent implements IProductStoreEvent {
        String whom;
        public ActorRef<ProductStoreEventResponse> replyTo;
        OrderHeaderData orderHeaderData;
    }

    @Data
    @AllArgsConstructor
    static class ProductStoreEventResponse implements IProductStoreEvent {
        public String whom;
        public ActorRef<IProductStoreEvent> from;
        String message;
    }

    static class ProductStoreMesh extends AbstractBehavior<IProductStoreEvent> {
        ProductStoreDelegator delegator;
        ProductStoreFlatData data;

        public static Behavior<IProductStoreEvent> create(ProductStoreDelegator delegator,
                                                          ProductStoreFlatData data) {
            return Behaviors.setup(c -> new ProductStoreMesh(c, delegator, data));
        }

        private ProductStoreMesh(ActorContext<IProductStoreEvent> context,
                                 ProductStoreDelegator delegator,
                                 ProductStoreFlatData data) {
            super(context);
            this.delegator = delegator;
            this.data = data;
        }

        @Override
        public Receive<IProductStoreEvent> createReceive() {
            return newReceiveBuilder()
                    .onMessage(ProductStoreEvent.class, m -> {
                        delegator.process(c -> {
                            m.replyTo.tell(new ProductStoreEventResponse(m.whom,
                                    getContext().getSelf(), ""));
                        });

                        return Behaviors.same();
                    })
                    .onMessage(ReceiveOrderEvent.class, m -> {
                        delegator.process(c -> {
                            ProductStoreDelegator.Agent agent = delegator.getAgent(c, data.getProductStoreId());
                            // agent.getOrderHeader().add(OrderHeader.fromData())
                            String id = getResultId(delegator.storeCompoundObject(c, m.orderHeaderData));
                            m.replyTo.tell(new ProductStoreEventResponse(m.whom,
                                    getContext().getSelf(), id));
                        });

                        return Behaviors.same();
                    })

                    .build();
        }
    }

    @Inject
    ProductStores delegator;

    @Test
    public void testProductEvent() {
        TestProbe<ProductStoreEventResponse> testProbe = testKit.createTestProbe();

        ActorRef<IProductStoreEvent> underTest = testKit.spawn(
                ProductStoreMesh.create(delegator,
                        delegator.createRentalStore()), "store");
        underTest.tell(new ProductStoreEvent("Charles", testProbe.getRef()));
        testProbe.expectMessage(new ProductStoreEventResponse("Charles", underTest, ""));
    }

}


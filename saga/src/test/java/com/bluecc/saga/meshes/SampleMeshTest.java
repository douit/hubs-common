package com.bluecc.saga.meshes;

import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.bluecc.income.dao.InvoiceDelegator;
import com.bluecc.saga.MeshTestBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import javax.inject.Inject;

public class SampleMeshTest extends MeshTestBase {
    @Test
    public void testCount() {
        process(c -> {
            InvoiceDelegator.Dao dao = c.getHandle().attach(InvoiceDelegator.Dao.class);
            System.out.println(dao.countInvoice());
        });
    }

    interface IInvoiceEvent {
    }

    @Data
    @AllArgsConstructor
    static class InvoiceEvent implements IInvoiceEvent {
        String whom;
        public ActorRef<InvoiceEventResponse> replyTo;
    }

    @Data
    @AllArgsConstructor
    static class InvoiceEventResponse implements IInvoiceEvent {
        public String whom;
        public ActorRef<IInvoiceEvent> from;
        String message;
    }



    static class InvoiceMesh extends AbstractBehavior<IInvoiceEvent> {
        InvoiceDelegator invoiceDelegator;

        public static Behavior<IInvoiceEvent> create(InvoiceDelegator invoiceDelegator) {
            return Behaviors.setup(c-> new InvoiceMesh(c, invoiceDelegator));
        }

        private InvoiceMesh(ActorContext<IInvoiceEvent> context, InvoiceDelegator invoiceDelegator) {
            super(context);
            this.invoiceDelegator=invoiceDelegator;
        }

        @Override
        public Receive<IInvoiceEvent> createReceive() {
            return newReceiveBuilder()
                    .onMessage(InvoiceEvent.class, m -> {
                        System.out.println("prepare to do ...");
                        invoiceDelegator.process(c ->{
                            InvoiceDelegator.Dao dao = c.getHandle().attach(InvoiceDelegator.Dao.class);
                            System.out.println(dao.countInvoice());
                            m.replyTo.tell(new InvoiceEventResponse(m.whom, getContext().getSelf(),
                                    Integer.toString(dao.countInvoice())));
                        });

                        return Behaviors.same();
                    })
                    .build();
        }
    }

    @Inject
    InvoiceDelegator invoiceDelegator;
    @Test
    public void testInvoiceEvent() {
        TestProbe<InvoiceEventResponse> testProbe = testKit.createTestProbe();
        ActorRef<IInvoiceEvent> underTest = testKit.spawn(InvoiceMesh.create(invoiceDelegator), "InvoiceMesh");
        underTest.tell(new InvoiceEvent("Charles", testProbe.getRef()));
        // testProbe.expectMessage(new InvoiceEventResponse("Charles", underTest));
        testProbe.expectMessageClass(InvoiceEventResponse.class);

    }

}

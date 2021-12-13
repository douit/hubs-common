package com.bluecc.saga.alphaworks;

import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.stub.PartyData;
import com.bluecc.hubs.stub.QueryRelations;
import com.bluecc.income.dao.InvoiceDelegator;
import com.bluecc.income.dao.PartyDelegator;
import com.bluecc.income.model.Party;
import com.bluecc.saga.MeshTestBase;
import com.bluecc.saga.alphaworks.ConsolePrinter;
import com.bluecc.saga.common.DataListWrapper;
import com.bluecc.saga.common.IMessageEvent;
import com.bluecc.saga.common.TypedMessageEvent;
import com.google.protobuf.Message;
import com.google.protobuf.StringValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import javax.inject.Inject;

import java.util.List;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertTrue;

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
    static class QueryInvoiceEvent implements IInvoiceEvent {
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
                    .onMessage(QueryInvoiceEvent.class, this::onQuery)
                    .build();
        }

        InvoiceEventResponse resp(QueryInvoiceEvent r, String msg) {
            return new InvoiceEventResponse(r.whom, getContext().getSelf(), msg);
        }

        private Behavior<IInvoiceEvent> onQuery(QueryInvoiceEvent message) {
            message.replyTo.tell(resp(message, "hello"));
            return Behaviors.same();
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

    @Data
    @AllArgsConstructor
    public static class MessageEvent{
        Message data;
        public ActorRef<MessageEvent> replyTo;

        public void tell(String msg, ActorRef<MessageEvent> self){
            replyTo.tell(new MessageEvent(stringVal(msg), self));
        }
    }

    public static class Child {
        public static Behavior<MessageEvent> create(String who) {
            return Behaviors.receive((context, message) -> {
                System.out.println("hi, "+who);
                message.tell("all done.", context.getSelf());
                return Behaviors.same();
            });
        }
    }

    static StringValue stringVal(String val){
        return StringValue.newBuilder().setValue(val).build();
    }

    @Test
    public void testMessageChild() {
        TestProbe<MessageEvent> testProbe = testKit.createTestProbe();
        ActorRef<MessageEvent> underTest = testKit.spawn(Child.create("samlet"), "child");
        underTest.tell(new MessageEvent(stringVal("hi"), testProbe.getRef()));
        // testProbe.expectMessage(new InvoiceEventResponse("Charles", underTest));
        testProbe.expectMessageClass(MessageEvent.class);

    }


    public static class PartyEvent extends TypedMessageEvent<PartyData> {
        public PartyEvent(PartyData data, EventType eventType, ActorRef<IMessageEvent> replyTo) {
            super(data, eventType, replyTo);
        }

        public static void say(ActorRef<IMessageEvent> sender, ActorRef<IMessageEvent> receiver){
            receiver.tell(new PartyEvent(PartyData.getDefaultInstance(),
                    IMessageEvent.EventType.Talk,
                    sender));
        }
    }

    public static class QueryRelsEvent extends TypedMessageEvent<QueryRelations>{

        public QueryRelsEvent(QueryRelations data, EventType eventType, ActorRef<IMessageEvent> replyTo) {
            super(data, eventType, replyTo);
        }
    }

    public static Behavior<IMessageEvent> createCusomter() {
        return Behaviors.setup(context ->
                Behaviors.receive(IMessageEvent.class)
                        .onMessage(PartyEvent.class, message -> {
                            context.getLog().info(message.getData().toString());
                            message.getReplyTo().tell(new PartyEvent(message.getData(),
                                    IMessageEvent.EventType.Talk,
                                    context.getSelf()));
                            return Behaviors.same();
                        })
                        .build());
    }

    @Test
    public void testMessageEvent() {
        TestProbe<IMessageEvent> testProbe = testKit.createTestProbe();
        ActorRef<IMessageEvent> underTest = testKit.spawn(createCusomter(), "customer");
        underTest.tell(new PartyEvent(PartyData.getDefaultInstance(),
                IMessageEvent.EventType.Talk,
                testProbe.getRef()));
        // testProbe.expectMessage(new PartyEvent("Charles", underTest));
        testProbe.expectMessageClass(PartyEvent.class);

        ActorRef<IMessageEvent> unitSuplier = testKit.spawn(createSuplier(partyDelegator), "Suplier");
        PartyEvent.say(testProbe.getRef(), unitSuplier);
        testProbe.expectMessageClass(PartyEvent.class);

        unitSuplier.tell(new QueryRelsEvent(QueryRelations.newBuilder().build(),
                IMessageEvent.EventType.Retrieve, testProbe.getRef()));
        testProbe.expectMessageClass(DataListWrapper.class);
    }

    public static Behavior<IMessageEvent> createSuplier(PartyDelegator partyDelegator) {
        return Behaviors.setup(context ->
                Behaviors.receive(IMessageEvent.class)
                        .onMessage(PartyEvent.class, message -> {
                            context.getLog().info(message.getData().toString());
                            message.getReplyTo().tell(new PartyEvent(message.getData(),
                                    IMessageEvent.EventType.Talk,
                                    context.getSelf()));
                            return Behaviors.same();
                        })
                        .onMessage(QueryRelsEvent.class, message -> {
                            partyDelegator.process(c -> {
                                DataListWrapper dataList = new DataListWrapper(partyDelegator.getAgent(c, "admin").getPartyContactMech());
                                context.getLog().info(dataList.toString());
                                message.getReplyTo().tell(dataList);
                            });
                            return Behaviors.same();
                        })
                        .build());
    }


    @Inject
    PartyDelegator partyDelegator;
    @Test
    public void testQueryMechs() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
           Party party=partyDelegator.get(c, "admin");
           party.agent(c, partyDelegator)
                   .getPartyContactMech()
                   .forEach(e -> pretty(e));

            DataListWrapper dataList=new DataListWrapper(partyDelegator.getAgent(c, "admin").getPartyContactMech());
            assertTrue(dataList.getData().size()>0);
        });
    }
}

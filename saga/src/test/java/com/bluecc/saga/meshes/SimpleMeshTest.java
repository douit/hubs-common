package com.bluecc.saga.meshes;

import akka.actor.AbstractActor;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.bluecc.saga.ActorTestBase;
import com.bluecc.saga.dummy.actor.Greeter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

public class SimpleMeshTest extends ActorTestBase {
    interface ISimpleEvent {}
    @Data
    @AllArgsConstructor
    static class SimpleEvent implements ISimpleEvent{
        String whom;
        public ActorRef<SimpleEventResponse> replyTo;
    }

    @Data
    @AllArgsConstructor
    static class SimpleEventResponse implements ISimpleEvent{
        public String whom;
        public ActorRef<ISimpleEvent> from;
    }

    static class SimpleActor extends AbstractBehavior<ISimpleEvent> {
        public static Behavior<ISimpleEvent> create() {
            return Behaviors.setup(SimpleActor::new);
        }

        private SimpleActor(ActorContext<ISimpleEvent> context) {
            super(context);
        }

        @Override
        public Receive<ISimpleEvent> createReceive() {
            return newReceiveBuilder()
                    .onMessage(SimpleEvent.class, m -> {
                        System.out.println("hi, i'm here");
                        m.replyTo.tell(new SimpleEventResponse(m.whom, getContext().getSelf()));
                        return Behaviors.same();
                    })
                    .build();
        }
    }

    @Test
    public void testSimpleEvent() {
        TestProbe<SimpleEventResponse> testProbe = testKit.createTestProbe();
        ActorRef<ISimpleEvent> underTest = testKit.spawn(SimpleActor.create(), "SimpleActor");
        underTest.tell(new SimpleEvent("Charles", testProbe.getRef()));
        testProbe.expectMessage(new SimpleEventResponse("Charles", underTest));
    }

}

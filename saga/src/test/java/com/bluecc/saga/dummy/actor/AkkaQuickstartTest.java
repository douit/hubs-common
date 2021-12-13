package com.bluecc.saga.dummy.actor;

import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.bluecc.saga.ActorTestBase;
import org.junit.ClassRule;
import org.junit.Test;

//#definition
public class AkkaQuickstartTest extends ActorTestBase {

//#definition

    //#test
    @Test
    public void testGreeterActorSendingOfGreeting() {
        TestProbe<Greeter.Greeted> testProbe = testKit.createTestProbe();
        ActorRef<Greeter.Greet> underTest = testKit.spawn(Greeter.create(), "greeter");
        underTest.tell(new Greeter.Greet("Charles", testProbe.getRef()));
        testProbe.expectMessage(new Greeter.Greeted("Charles", underTest));

        ActorRef<Greeter.Greet> underTest2 = testKit.spawn(Greeter2.create(), "greeter2");
        underTest2.tell(new Greeter.Greet("Samlet", testProbe.getRef()));
        testProbe.expectMessage(new Greeter.Greeted("Samlet", underTest2));
    }
    //#test

    static class Greeter2 extends AbstractBehavior<Greeter.Greet> {
        public static Behavior<Greeter.Greet> create() {
            return Behaviors.setup(Greeter2::new);
        }

        private Greeter2(ActorContext<Greeter.Greet> context) {
            super(context);
        }

        @Override
        public Receive<Greeter.Greet> createReceive() {
            return newReceiveBuilder()
                    .onMessage(Greeter.Greet.class, m -> {
                        System.out.println("hi, i'm here");
                        m.replyTo.tell(new Greeter.Greeted(m.whom, getContext().getSelf()));
                        return Behaviors.same();
                    })
                    .build();
        }
    }
}

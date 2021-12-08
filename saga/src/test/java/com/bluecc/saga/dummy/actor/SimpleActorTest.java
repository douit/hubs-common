package com.bluecc.saga.dummy.actor;

import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import org.junit.ClassRule;
import org.junit.Test;
import org.scalatestplus.junit.JUnitSuite;

public class SimpleActorTest extends JUnitSuite {
    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    @Test
    public void askInActorWithStatusExample() {
        // no assert but should at least throw if completely broken
        ActorRef<Samples.Hal.Command> hal = testKit.spawn(Samples.Hal.create());
        // ActorRef<Samples.Dave.Command> dave = testKit.spawn(Samples.Dave.create(hal));
    }

    interface Samples {
        // #actor-ask
        public class Hal extends AbstractBehavior<Samples.Hal.Command> {

            public static Behavior<Samples.Hal.Command> create() {
                return Behaviors.setup(Hal::new);
            }

            private Hal(ActorContext<Samples.Hal.Command> context) {
                super(context);
            }

            public interface Command {
            }

            public static final class OpenThePodBayDoorsPlease implements Samples.Hal.Command {
                public final ActorRef<HalResponse> respondTo;

                public OpenThePodBayDoorsPlease(ActorRef<HalResponse> respondTo) {
                    this.respondTo = respondTo;
                }
            }

            public static final class HalResponse {
                public final String message;

                public HalResponse(String message) {
                    this.message = message;
                }
            }

            @Override
            public Receive<Command> createReceive() {
                return newReceiveBuilder()
                        .onMessage(OpenThePodBayDoorsPlease.class, this::onOpenThePodBayDoorsPlease)
                        .build();
            }

            private Behavior<Command> onOpenThePodBayDoorsPlease(OpenThePodBayDoorsPlease message) {
                message.respondTo.tell(new HalResponse("I'm sorry, Dave. I'm afraid I can't do that."));
                return this;
            }
        }
    }
}

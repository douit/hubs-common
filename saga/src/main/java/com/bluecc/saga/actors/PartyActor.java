package com.bluecc.saga.actors;

import akka.Done;
import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.lang.Thread.sleep;

@Slf4j
public class PartyActor {
    public static void main(String[] args) throws InterruptedException {
        // final ActorSystem<GreeterMain.SayHello> greeterMain =
        //             ActorSystem.create(GreeterMain.create(), "helloakka");
        ActorSystem<Event> actorMain =
                ActorSystem.create(Conductors.PartyConductor.create(
                        new DataAccessor() {
                            @Override
                            public CompletionStage<Done> update(Event event) {
                                log.info("update {}", event);
                                return CompletableFuture.completedFuture(Done.getInstance());
                            }
                        },
                        PartyActor.ReEnable.INSTANCE), "admin");
        actorMain.tell(Disable.INSTANCE);
        actorMain.tell(Disable.INSTANCE);  // cause unhandled(dead-letters)
        sleep(1000);
        actorMain.tell(ReEnable.INSTANCE);

        actorMain.tell(Assigned.INSTANCE);
        sleep(2000);
        actorMain.terminate();
    }

    public interface Event {
    }

    // general events
    public static final class SetTarget implements Event {
        public final ActorRef<ConsolePrinter> ref;

        public SetTarget(ActorRef<ConsolePrinter> ref) {
            this.ref = ref;
        }
    }

    @Data
    @Builder
    public static class Result implements Event {
        String status;
    }

    public enum DefaultStart implements Event {
        INSTANCE
    }

    // transitions

    public enum Assigned implements Event {
        INSTANCE
    }

    public enum ReEnable implements Event {
        INSTANCE
    }

    public enum Disable implements Event {
        INSTANCE
    }

    public enum ConvertLeadToContact implements Event {
        INSTANCE
    }


    public interface DataAccessor {
        CompletionStage<Done> update(Event event);
    }

    // --------------------
    interface Conductors {
        public class PartyConductor {

            public static Behavior<Event> create(DataAccessor dataAccessor, ReEnable ev) {
                return Behaviors.setup(ctx -> new PartyConductor(ctx, dataAccessor)
                        .partyEnabled(ev));
            }


            ActorContext<Event> context;
            DataAccessor dataAccessor;

            PartyConductor(ActorContext<Event> context, DataAccessor dataAccessor) {
                this.context = context;
                this.dataAccessor = dataAccessor;
            }

            public ActorContext<Event> getContext() {
                return context;
            }

            private Behavior<Event> leadAssigned(Assigned data) {
                CompletionStage<Done> futureResult = dataAccessor.update(data);
                getContext().pipeToSelf(
                        futureResult,
                        (ok, exc) -> {
                            return Result.builder()
                                    .status("ok")
                                    .build();
                        });
                // do something ...
                // return Behaviors.same();
                return Behaviors.receive(Event.class)
                        .onMessage(Result.class, message -> {
                            log.info("update done: {}", message);
                            return Behaviors.same();
                        })
                        .build();
            }

            private Behavior<Event> leadConverted(ConvertLeadToContact data) {

                // do something ...
                return Behaviors.same();
            }

            private Behavior<Event> partyDisabled(Disable data) {
                log.info("-> partyDisabled {}/{}", data.getDeclaringClass().getSimpleName(), data);
                return Behaviors.receive(Event.class)
                        .onMessage(ReEnable.class, message -> partyEnabled(message))
                        .build();
            }

            private Behavior<Event> partyEnabled(ReEnable data) {
                log.info("-> partyEnabled {}/{}", data.getDeclaringClass().getSimpleName(), data);
                return Behaviors.receive(Event.class)
                        .onMessage(Disable.class, message -> partyDisabled(message))
                        .onMessage(Assigned.class, message -> leadAssigned(message))
                        .onMessage(ConvertLeadToContact.class, message -> leadConverted(message))
                        .build();
            }

        }
    }

}

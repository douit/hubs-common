package com.bluecc.saga.alphaworks;

import akka.Done;
import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import com.bluecc.hubs.stub.Envelope;
import com.bluecc.hubs.stub.StringValue;
import com.bluecc.saga.common.IMessageEvent;
import com.bluecc.saga.common.StateAction;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

import static com.bluecc.hubs.ProtoTypes.packEntity;
import static java.lang.Thread.sleep;

@Slf4j
public class PartyAlphaMesh {
    public static void main(String[] args) throws InterruptedException {
        // final ActorSystem<GreeterMain.SayHello> greeterMain =
        //             ActorSystem.create(GreeterMain.create(), "helloakka");
        ActorSystem<Event> actorMain =
                ActorSystem.create(Conductors.PartyConductor.create(
                        event -> {
                            log.info("update {}", event);
                            return CompletableFuture.completedFuture(Done.getInstance());
                        },
                        ArrayListMultimap.create(),
                        PartyAlphaMesh.ReEnable.INSTANCE), "admin");
        actorMain.tell(Disable.INSTANCE);
        actorMain.tell(Disable.INSTANCE);  // cause unhandled(dead-letters)
        sleep(1000);
        actorMain.tell(ReEnable.INSTANCE);

        actorMain.tell(Assigned.pack("by samlet"));

        //+
        //+

        sleep(2000);
        actorMain.terminate();

    }

    public interface Event extends IMessageEvent {
    }

    // general events
    public static final class SetTarget implements Event {
        public final ActorRef<ConsolePrinter> ref;

        public SetTarget(ActorRef<ConsolePrinter> ref) {
            this.ref = ref;
        }
    }

    public enum ResultCode{
        OK, ERR
    }
    @Data
    @Builder
    public static class Result implements Event {
        ResultCode status;
        String message;
    }

    // public enum DefaultStart implements Event {
    //     INSTANCE
    // }

    // transitions
    @Data
    @AllArgsConstructor
    public static final class Assigned implements Event {
        Envelope data;
        public static Assigned pack(String cnt){
            return new Assigned(packEntity(StringValue.newBuilder()
                    .setValue(cnt)
                    .build()));
        }
    }

    @Data
    @Accessors(fluent = true)
    public static class DerivedEvent implements Event{
        String action;
        Object[] params;
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

    public static final class LeadAssigned{}
    public static final class PartyDisabled{}
    public static final class PartyEnabled{}

    // --------------------
    interface Conductors {
        public class PartyConductor {

            public static Behavior<Event> create(DataAccessor dataAccessor,
                                                 Multimap<Class<?>, StateAction<IMessageEvent>> actionMap,
                                                 ReEnable ev) {
                return Behaviors.setup(ctx -> new PartyConductor(ctx, actionMap, dataAccessor)
                        .partyEnabled(ev));
            }


            ActorContext<Event> context;
            DataAccessor dataAccessor;
            Multimap<Class<?>, StateAction<IMessageEvent>> actionMap;

            PartyConductor(ActorContext<Event> context, Multimap<Class<?>, StateAction<IMessageEvent>> actionMap,
                           DataAccessor dataAccessor) {
                this.context = context;
                this.dataAccessor = dataAccessor;
                this.actionMap = actionMap;
            }

            public ActorContext<Event> getContext() {
                return context;
            }

            private Behavior<Event> leadAssignedProposal(Assigned data) {
                log.info("leadAssignedProposal has action: {}", actionMap.get(LeadAssigned.class).size());
                CompletionStage<Done> futureResult = dataAccessor.update(data);
                getContext().pipeToSelf(
                        futureResult,
                        (ok, exc) -> {
                            return Result.builder()
                                    .status(ResultCode.OK)
                                    .build();
                        });
                // do something ...
                // return Behaviors.same();
                return Behaviors.receive(Event.class)
                        .onMessage(Result.class, message -> {
                            if(message.getStatus().equals(ResultCode.OK)) {
                                log.info("update done: {}", message);
                                return leadAssigned(data);
                            }else{
                                log.info("update fail: {}", message);
                                return Behaviors.same();
                            }
                        })
                        .build();
            }

            private Behavior<Event> leadAssigned(Assigned data) {
                return Behaviors.same();
            }

            private Behavior<Event> leadConverted(ConvertLeadToContact data) {

                // do something ...
                return Behaviors.same();
            }

            private Behavior<Event> partyDisabled(Disable data) {
                log.info("partyDisabled has action: {}", actionMap.get(PartyDisabled.class).size());
                log.info("-> partyDisabled {}/{}", data.getDeclaringClass().getSimpleName(), data);
                return Behaviors.receive(Event.class)
                        .onMessage(ReEnable.class, message -> partyEnabled(message))
                        .onMessage(DerivedEvent.class, message-> onDerivedEvent(PartyDisabled.class, message))
                        .build();
            }

            private Behavior<Event> partyEnabled(ReEnable data) {
                log.info("partyEnabled has action: {}", actionMap.get(PartyEnabled.class).size());
                log.info("-> partyEnabled {}/{}", data.getDeclaringClass().getSimpleName(), data);
                return Behaviors.receive(Event.class)
                        .onMessage(Disable.class, message -> {
                            onEvent(PartyEnabled.class, Disable.class, message);
                            return partyDisabled(message);
                        })
                        .onMessage(Assigned.class, message -> {
                            onEvent(PartyEnabled.class, Assigned.class, message);
                            return leadAssignedProposal(message);
                        })
                        .onMessage(ConvertLeadToContact.class, message -> {
                            onEvent(PartyEnabled.class, ConvertLeadToContact.class, message);
                            return leadConverted(message);
                        })
                        .onMessage(DerivedEvent.class, message-> onDerivedEvent(PartyEnabled.class, message))
                        .build();
            }

            private <T extends Event> void onEvent(Class<?> stateClass, Class<T> messageClass, T message) {
                actionMap.get(stateClass).stream().filter(sta -> sta.getAccepter()[0]==messageClass)
                        .forEach(sta -> sta.getAction()
                                .accept(message));
            }

            private Behavior<Event> onDerivedEvent(Class<?> actionClass,DerivedEvent message) {
                log.info("derive event: {}", message);
                System.out.println(actionMap.keySet());
                log.info("has action: {}", actionMap.get(actionClass).size());
                // actionMap.get(actionClass).stream()
                //         .filter(m -> m.getName().equals(message.action))
                //         .forEach(m -> {
                //             // fire it
                //             try {
                //                 log.info("fire it!");
                //                 // m.invoke(dataAccessor, message.params);
                //             } catch (Exception e) {
                //                 e.printStackTrace();
                //             }
                //         });
                return Behaviors.same();
            }

        }
    }

}

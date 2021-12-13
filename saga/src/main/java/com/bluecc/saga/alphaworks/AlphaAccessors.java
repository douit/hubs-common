package com.bluecc.saga.alphaworks;

import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.Terminated;
import akka.actor.typed.javadsl.Behaviors;
import com.bluecc.saga.dummy.actor.IntroTest;
import com.bluecc.saga.dummy.actor.IntroTest.ChatRoom;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface AlphaAccessors {
    public class Main {
        public static Behavior<Void> create() {
            return Behaviors.setup(
                    context -> {
                        ActorRef<ChatRoom.RoomCommand> chatRoom = context.spawn(ChatRoom.create(), "chatRoom");
                        ActorRef<ChatRoom.SessionEvent> gabbler = context.spawn(IntroTest.Gabbler.create(), "gabbler");

                        //
                        ActorRef<ConsolePrinter.PrintEvent> printer=context.spawn(ConsolePrinter.create(), "printer");
                        printer.tell(new ConsolePrinter.PrintMe("hi"));
                        //
                        context.watch(gabbler);
                        chatRoom.tell(new ChatRoom.GetSession("ol’ Gabbler", gabbler));

                        return Behaviors.receive(Void.class)
                                .onSignal(Terminated.class, sig -> Behaviors.stopped())
                                .build();
                    });
        }

        public static void main(String[] args) {
            actionMappings();
            ActorSystem.create(Main.create(), "Alpha");
        }


        private static void actionMappings() {
            // ClassToInstanceMap<PartyAlphaMesh.Event>  actions= MutableClassToInstanceMap.create();
            Multimap<Class<?>, Function<PartyAlphaMesh.Event,
                    CompletionStage<PartyAlphaMesh.Result>>> actions
                    = ArrayListMultimap.create();
            actions.put(PartyAlphaMesh.Assigned.class, e -> {
                System.out.println(".. assigned 1 called.");
                return CompletableFuture.completedFuture(PartyAlphaMesh.Result.builder()
                        .status(PartyAlphaMesh.ResultCode.OK)
                        .build());
            });
            actions.put(PartyAlphaMesh.Assigned.class, e -> {
                System.out.println(".. assigned 2 called.");
                return CompletableFuture.completedFuture(PartyAlphaMesh.Result.builder()
                        .status(PartyAlphaMesh.ResultCode.OK)
                        .build());
            });
            actions.put(PartyAlphaMesh.ReEnable.class, e -> {
                System.out.println(".. re-enable called.");
                return CompletableFuture.completedFuture(PartyAlphaMesh.Result.builder()
                        .status(PartyAlphaMesh.ResultCode.OK)
                        .build());
            });

            actions.get(PartyAlphaMesh.Assigned.class).forEach(e ->
                    e.apply(PartyAlphaMesh.Assigned.pack("by samlet")));
        }
    }

}

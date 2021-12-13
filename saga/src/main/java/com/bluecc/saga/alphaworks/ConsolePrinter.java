package com.bluecc.saga.alphaworks;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.Behaviors;
import lombok.AllArgsConstructor;
import lombok.Data;

public class ConsolePrinter {
    public interface PrintEvent { }
    @Data
    @AllArgsConstructor
    public static class PrintMe implements PrintEvent{
        public String message;
    }

    public static Behavior<PrintEvent> create() {
        return Behaviors.setup(context ->
                Behaviors.receive(PrintEvent.class)
                        .onMessage(PrintMe.class, message -> {
                            context.getLog().info(message.message);
                            return Behaviors.same();
                        })
                        .build());
    }
}


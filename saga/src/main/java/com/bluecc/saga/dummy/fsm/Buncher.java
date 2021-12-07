package com.bluecc.saga.dummy.fsm;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.Behaviors;
import com.bluecc.saga.dummy.fsm.BuncherEvents.Event;
import com.bluecc.saga.dummy.fsm.BuncherEvents.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Buncher {
    // FSM states represented as behaviors

    // initial state
    public static Behavior<Event> create() {
        return uninitialized();
    }

    private static Behavior<Event> uninitialized() {
        return Behaviors.receive(Event.class)
                .onMessage(
                        SetTarget.class, message -> idle(new Todo(message.ref, Collections.emptyList())))
                .build();
    }

    private static Behavior<Event> idle(Todo data) {
        return Behaviors.receive(Event.class)
                .onMessage(Queue.class, message -> active(data.addElement(message)))
                .build();
    }

    private static Behavior<Event> active(Todo data) {
        return Behaviors.withTimers(
                timers -> {
                    // State timeouts done with withTimers
                    timers.startSingleTimer("Timeout", Timeout.INSTANCE, Duration.ofSeconds(1));
                    return Behaviors.receive(Event.class)
                            .onMessage(Queue.class, message -> active(data.addElement(message)))
                            .onMessage(Flush.class, message -> activeOnFlushOrTimeout(data))
                            .onMessage(Timeout.class, message -> activeOnFlushOrTimeout(data))
                            .build();
                });
    }

    private static Behavior<Event> activeOnFlushOrTimeout(Todo data) {
        data.target.tell(new Batch(data.queue));
        return idle(data.copy(new ArrayList<>()));
    }

}
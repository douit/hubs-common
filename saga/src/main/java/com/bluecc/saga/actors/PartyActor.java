package com.bluecc.saga.actors;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.Behaviors;

public class PartyActor {
    public interface Event {}

    // general events
    public static final class SetTarget implements Event {
        public final ActorRef<ConsolePrinter> ref;

        public SetTarget(ActorRef<ConsolePrinter> ref) {
            this.ref = ref;
        }
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



    // --------------------
    interface Conductors {
        public class PartyConductor{

            public static Behavior<Event> create(ReEnable ev) {
                return Behaviors.setup(ctx -> new PartyConductor().partyEnabled(ev));
            }


            private Behavior<Event> leadAssigned(Assigned data) {

                // do something ...
                return Behaviors.same();
            }

            private Behavior<Event> leadConverted(ConvertLeadToContact data) {

                // do something ...
                return Behaviors.same();
            }

            private Behavior<Event> partyDisabled(Disable data) {
                return Behaviors.receive(Event.class)
                        .onMessage(ReEnable.class, message -> partyEnabled(message))
                        .build();
            }

            private Behavior<Event> partyEnabled(ReEnable data) {
                return Behaviors.receive(Event.class)
                        .onMessage(Disable.class, message -> partyDisabled(message))
                        .onMessage(Assigned.class, message -> leadAssigned(message))
                        .onMessage(ConvertLeadToContact.class, message -> leadConverted(message))
                        .build();
            }

        }
    }

}

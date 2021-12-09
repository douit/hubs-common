package com.bluecc.saga.meshes;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.Behaviors;
import com.bluecc.saga.common.ConsolePrinter;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderMesh {
        public interface Event {}

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
    
    public enum OrderCancelled implements Event {
        INSTANCE
    }
    
    public enum CancelOrder implements Event {
        INSTANCE
    }
    
    public enum ProcessOrder implements Event {
        INSTANCE
    }
    
    public enum HoldOrder implements Event {
        INSTANCE
    }
    
    public enum RejectOrder implements Event {
        INSTANCE
    }
    
    public enum CompleteOrder implements Event {
        INSTANCE
    }
    
    public enum ApproveOrder implements Event {
        INSTANCE
    }
    
    public enum OrderCompleted implements Event {
        INSTANCE
    }
    
    public enum SendOrder implements Event {
        INSTANCE
    }
        



    // --------------------
    public interface Conductors {
        
            public class OrderConductor {

        public static Behavior<Event> create(DefaultStart ev) {
            return Behaviors.setup(ctx -> new OrderConductor().orderCreated(ev));
        }
        
        
        private Behavior<Event> orderApproved(ApproveOrder data) {
            log.info("-> orderApproved {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(SendOrder.class, message -> orderSent(message))
                    .onMessage(ProcessOrder.class, message -> orderProcessing(message))
                    .onMessage(CompleteOrder.class, message -> orderCompleted(message))
                    .onMessage(CancelOrder.class, message -> orderCancelled(message))
                    .onMessage(HoldOrder.class, message -> orderHold(message))
                    .build();
        }
        
        private Behavior<Event> orderCancelled(OrderCancelled data) {
            log.info("-> orderCancelled {}/{}", data.getDeclaringClass().getSimpleName(), data);
            
            // do something ...
            return Behaviors.same();
        }
        private Behavior<Event> orderCancelled(CancelOrder data) {
            log.info("-> orderCancelled {}/{}", data.getDeclaringClass().getSimpleName(), data);
            
            // do something ...
            return Behaviors.same();
        }
        
        private Behavior<Event> orderCompleted(CompleteOrder data) {
            log.info("-> orderCompleted {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(ApproveOrder.class, message -> orderApproved(message))
                    .build();
        }
        private Behavior<Event> orderCompleted(OrderCompleted data) {
            log.info("-> orderCompleted {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(ApproveOrder.class, message -> orderApproved(message))
                    .build();
        }
        
        private Behavior<Event> orderCreated(DefaultStart data) {
            log.info("-> orderCreated {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(ProcessOrder.class, message -> orderProcessing(message))
                    .onMessage(ApproveOrder.class, message -> orderApproved(message))
                    .onMessage(HoldOrder.class, message -> orderHold(message))
                    .onMessage(RejectOrder.class, message -> orderRejected(message))
                    .onMessage(CancelOrder.class, message -> orderCancelled(message))
                    .build();
        }
        
        private Behavior<Event> orderHold(HoldOrder data) {
            log.info("-> orderHold {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(ProcessOrder.class, message -> orderProcessing(message))
                    .onMessage(ApproveOrder.class, message -> orderApproved(message))
                    .onMessage(CancelOrder.class, message -> orderCancelled(message))
                    .build();
        }
        
        private Behavior<Event> orderProcessing(ProcessOrder data) {
            log.info("-> orderProcessing {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(HoldOrder.class, message -> orderHold(message))
                    .onMessage(ApproveOrder.class, message -> orderApproved(message))
                    .onMessage(RejectOrder.class, message -> orderRejected(message))
                    .onMessage(CancelOrder.class, message -> orderCancelled(message))
                    .build();
        }
        
        private Behavior<Event> orderRejected(RejectOrder data) {
            log.info("-> orderRejected {}/{}", data.getDeclaringClass().getSimpleName(), data);
            
            // do something ...
            return Behaviors.same();
        }
        
        private Behavior<Event> orderSent(SendOrder data) {
            log.info("-> orderSent {}/{}", data.getDeclaringClass().getSimpleName(), data);
            return Behaviors.receive(Event.class)
                    .onMessage(OrderCompleted.class, message -> orderCompleted(message))
                    .onMessage(OrderCancelled.class, message -> orderCancelled(message))
                    .build();
        }

    }

        
    }
}

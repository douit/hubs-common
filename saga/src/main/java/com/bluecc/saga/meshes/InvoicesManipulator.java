package com.bluecc.saga.meshes;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.procs.CommonData;
import com.bluecc.income.procs.CommonData.PartyFromTo;
import com.bluecc.income.procs.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bluecc.income.procs.Invoices;

public class InvoicesManipulator {
    public interface Event {}

    
    @Data
    @AllArgsConstructor
    public static final class CreateInvoice implements Event {
        LocalDateTime dueDate;
    }
    

    public static class InvoicesWrapper {
        public static Behavior<Event> create(Invoices mani) {
            return Behaviors.setup(ctx -> new InvoicesWrapper(ctx, mani).behavior());
        }

        private final ActorContext<Event> context;
        Invoices mani;
        private InvoicesWrapper(ActorContext<Event> context, Invoices mani) {
            this.context = context;
            this.mani=mani;
        }

        private Behavior<Event> behavior() {
            return Behaviors.receive(Event.class)
                    .onMessage(CreateInvoice.class, this::onCreateInvoice)
                    .build();
        }

        
        private Behavior<Event> onCreateInvoice(CreateInvoice message) {
            context.getLog().info("CreateInvoice: {}", message.getClass().getSimpleName());
            mani.createInvoice(
                message.dueDate);                
            
            return Behaviors.same();
        }
        
    }
}

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
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrdersManipulator {
    public interface Event {}

    
    @Data
    @AllArgsConstructor
    public static final class CreateOrderHeader implements Event {
        PartyFlatData createdBy;
        BigDecimal grandTotal;
    }
    
    @Data
    @AllArgsConstructor
    public static final class AddOrderItem implements Event {
        OrderHeaderFlatData order;
        String seqId;
        String productId;
    }
    
    @Data
    @AllArgsConstructor
    public static final class CreateInvoice implements Event {
        PartyFromTo fromTo;
        LocalDateTime paidDate;
    }
    
    @Data
    @AllArgsConstructor
    public static final class AddInvoiceItem implements Event {
        InvoiceFlatData invoice;
        String seqId;
        String inventoryItemId;
        BigDecimal amount;
        BigDecimal quantity;
    }
    
    @Data
    @AllArgsConstructor
    public static final class AddOrderItemBilling implements Event {
        OrderItemFlatData orderItem;
        InvoiceItemFlatData invoiceItem;
        ItemIssuanceData itemIssuance;
    }
    
    @Data
    @AllArgsConstructor
    public static final class CreateShipment implements Event {
        PartyFromTo fromTo;
        OrderHeaderFlatData order;
        BigDecimal estimatedShipCost;
    }
    
    @Data
    @AllArgsConstructor
    public static final class AddShipmentItem implements Event {
        ShipmentFlatData shipment;
        String seqId;
        BigDecimal quantity;
    }
    
    @Data
    @AllArgsConstructor
    public static final class AddOrderStatus implements Event {
        OrderHeaderFlatData order;
        String statusId;
    }
    
    @Data
    @AllArgsConstructor
    public static final class SetOrderStatus implements Event {
        OrderHeaderFlatData order;
        String statusId;
    }
    

    @Slf4j
    public static class OrdersWrapper {
        public static Behavior<Event> create(Orders mani) {
            return Behaviors.setup(ctx -> new OrdersWrapper(ctx, mani).behavior());
        }

        private final ActorContext<Event> context;
        Orders mani;
        private OrdersWrapper(ActorContext<Event> context, Orders mani) {
            this.context = context;
            this.mani=mani;
        }

        private Behavior<Event> behavior() {
            // System.out.println(".. orders mani");
            return Behaviors.receive(Event.class)
                    .onMessage(CreateOrderHeader.class, this::onCreateOrderHeader)
                    .onMessage(AddOrderItem.class, this::onAddOrderItem)
                    .onMessage(CreateInvoice.class, this::onCreateInvoice)
                    .onMessage(AddInvoiceItem.class, this::onAddInvoiceItem)
                    .onMessage(AddOrderItemBilling.class, this::onAddOrderItemBilling)
                    .onMessage(CreateShipment.class, this::onCreateShipment)
                    .onMessage(AddShipmentItem.class, this::onAddShipmentItem)
                    .onMessage(AddOrderStatus.class, this::onAddOrderStatus)
                    .onMessage(SetOrderStatus.class, this::onSetOrderStatus)
                    .build();
        }

        
        private Behavior<Event> onCreateOrderHeader(CreateOrderHeader message) {
            context.getLog().info("CreateOrderHeader: {}", message.getClass().getSimpleName());
            // System.out.println(".. onCreateOrderHeader");
            mani.createOrderHeader(
                message.createdBy,
                message.grandTotal);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onAddOrderItem(AddOrderItem message) {
            context.getLog().info("AddOrderItem: {}", message.getClass().getName());
            mani.addOrderItem(
                message.order,
                message.seqId,
                message.productId);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onCreateInvoice(CreateInvoice message) {
            context.getLog().info("CreateInvoice: {}", message.getClass().getName());
            mani.createInvoice(
                message.fromTo,
                message.paidDate);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onAddInvoiceItem(AddInvoiceItem message) {
            context.getLog().info("AddInvoiceItem: {}", message.getClass().getName());
            mani.addInvoiceItem(
                message.invoice,
                message.seqId,
                message.inventoryItemId,
                message.amount,
                message.quantity);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onAddOrderItemBilling(AddOrderItemBilling message) {
            context.getLog().info("AddOrderItemBilling: {}", message.getClass().getName());
            mani.addOrderItemBilling(
                message.orderItem,
                message.invoiceItem,
                message.itemIssuance);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onCreateShipment(CreateShipment message) {
            context.getLog().info("CreateShipment: {}", message.getClass().getName());
            mani.createShipment(
                message.fromTo,
                message.order,
                message.estimatedShipCost);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onAddShipmentItem(AddShipmentItem message) {
            context.getLog().info("AddShipmentItem: {}", message.getClass().getName());
            mani.addShipmentItem(
                message.shipment,
                message.seqId,
                message.quantity);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onAddOrderStatus(AddOrderStatus message) {
            context.getLog().info("AddOrderStatus: {}", message.getClass().getName());
            mani.addOrderStatus(
                message.order,
                message.statusId);                
            
            return Behaviors.same();
        }
        
        private Behavior<Event> onSetOrderStatus(SetOrderStatus message) {
            context.getLog().info("SetOrderStatus: {}", message.getClass().getName());
            mani.setOrderStatus(
                message.order,
                message.statusId);                
            
            return Behaviors.same();
        }
        
    }
}

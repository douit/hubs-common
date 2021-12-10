package com.bluecc.saga.meshes;

import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.Terminated;
import akka.actor.typed.javadsl.Behaviors;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.income.procs.Orders;
import com.bluecc.saga.alphaworks.ConsolePrinter;

import java.math.BigDecimal;

import static com.bluecc.income.dummy.store.StoreModule.startup;
import static java.lang.Thread.sleep;

public interface OrdersMain {
    public class Main {
        public static Behavior<Void> create(Orders orders) {
            return Behaviors.setup(
                    context -> {

                        ActorRef<ConsolePrinter.PrintMe> printer = context.spawn(ConsolePrinter.create(), "printer");
                        printer.tell(new ConsolePrinter.PrintMe("hi"));
                        //

                        ActorRef<OrdersManipulator.Event> ordersMani = context.spawn(
                                OrdersManipulator.OrdersWrapper.create(orders), "orders");
                        ordersMani.tell(new OrdersManipulator.CreateOrderHeader(
                                PartyFlatData.newBuilder().setPartyId("admin").build(),
                                new BigDecimal("88.88")));

                        // context.watch(ordersMani);
                        System.out.println("...");
                        return Behaviors.receive(Void.class)
                                .onSignal(Terminated.class, sig -> Behaviors.stopped())
                                .build();
                    });
        }

        public static void main(String[] args) throws InterruptedException {
            Orders orders = startup(Orders.class);
            ActorSystem<Void> actorMain = ActorSystem.create(OrdersMain.Main.create(orders), "Alpha");
            sleep(1000);
            actorMain.terminate();
        }
    }
}

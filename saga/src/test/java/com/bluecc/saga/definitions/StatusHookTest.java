package com.bluecc.saga.definitions;

import akka.Done;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.income.exchange.IStatusUpdater;
import com.bluecc.saga.common.IMessageEvent;
import com.bluecc.saga.common.IMessageEvent.EventType;
import com.bluecc.saga.definitions.StatusXmlFormatTest.OrderStatusEnum;
import com.google.common.collect.Maps;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.Accessors;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.bluecc.hubs.fund.descriptor.EntityNames.OrderHeader;
import static com.bluecc.saga.definitions.StatusXmlFormatTest.OrderStatusEnum.*;
import static com.bluecc.saga.definitions.StatusXmlFormatTest.connect;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertFalse;

public class StatusHookTest {
    @Data
    @Builder
    // @Accessors(fluent = true)
    public static class Hook {
        OrderStatusEnum from;
        OrderStatusEnum to;
        IStatusUpdater handle;
        @Singular
        Map<EventType, EntityNames> events;
    }

    public static class Hooks {
        MutableValueGraph<OrderStatusEnum, IStatusUpdater> g;
        List<Hook> transitions = Lists.newArrayList();

        Hooks() {
            g = ValueGraphBuilder.directed().allowsSelfLoops(true).build();
        }

        public Hooks add(Hook hook) {
            this.transitions.add(hook);
            this.g.putEdgeValue(hook.from, hook.to, hook.handle);
            return this;
        }
    }

    @Test
    public void testGraph() {
        // MutableGraph<OrderStatusEnum> directedGraph = GraphBuilder.directed()
        //         .allowsSelfLoops(true).build();
        // connect(directedGraph, Created,
        //         Processing, Approved, Hold, Rejected, Cancelled);
        // connect(directedGraph, Processing,
        //         Hold, Approved, Rejected, Cancelled);

        Hooks hooks = new Hooks();

        hooks.add(Hook.builder()
                        .from(Created).to(Processing)
                        .event(EventType.Process, OrderHeader)
                        .handle(c -> {
                            System.out.println(".. fire Created to Processing");
                            return CompletableFuture.completedFuture(new ArrayList<>());
                        }).build())
                .add(Hook.builder()
                        .from(Created).to(Approved)
                        .event(EventType.Approve, OrderHeader)
                        .handle(c -> {
                            System.out.println(".. fire Created to Approved");
                            return CompletableFuture.completedFuture(new ArrayList<>());
                        }).build());

        IStatusUpdater defaultUpdater = c -> {
            System.out.println(".. no rule");
            return CompletableFuture.completedFuture(new ArrayList<>());
        };
        requireNonNull(hooks.g.edgeValueOrDefault(Created, Approved, defaultUpdater))
                .run(null);
        requireNonNull(hooks.g.edgeValueOrDefault(Created, Completed, defaultUpdater))
                .run(null);

        assertFalse(hooks.g.hasEdgeConnecting(Created, Completed));
    }
}

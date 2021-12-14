package com.bluecc.saga.definitions;

import akka.Done;
import com.bluecc.income.exchange.IStatusUpdater;
import com.bluecc.saga.definitions.StatusXmlFormatTest.OrderStatusEnum;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.bluecc.saga.definitions.StatusXmlFormatTest.OrderStatusEnum.*;
import static com.bluecc.saga.definitions.StatusXmlFormatTest.connect;
import static java.util.Objects.requireNonNull;

public class StatusHookTest {
    @Data
    @Accessors(fluent = true)
    public static class Hook {
        OrderStatusEnum from;
        OrderStatusEnum to;
        IStatusUpdater handle;
    }

    public static class Hooks {
        MutableValueGraph<OrderStatusEnum, IStatusUpdater> g;
        List<Hook> transitions = Lists.newArrayList();

        Hooks() {
            g = ValueGraphBuilder.directed().allowsSelfLoops(true).build();
        }

        public void add(Hook hook) {
            this.transitions.add(hook);
            this.g.putEdgeValue(hook.from, hook.to, hook.handle);
        }
    }

    @Test
    public void testGraph() {
        MutableGraph<OrderStatusEnum> directedGraph = GraphBuilder.directed()
                .allowsSelfLoops(true).build();
        // directedGraph.putEdge(Created, Processing);
        // directedGraph.putEdge(Created, Approved);
        connect(directedGraph, Created,
                Processing, Approved, Hold, Rejected, Cancelled);
        connect(directedGraph, Processing,
                Hold, Approved, Rejected, Cancelled);

        Hooks hooks = new Hooks();
        hooks.add(new Hook().from(Created).to(Processing).handle(c -> {
            System.out.println(".. fire Created to Processing");
            return CompletableFuture.completedFuture(new ArrayList<>());
        }));
        hooks.add(new Hook().from(Created).to(Approved).handle(c -> {
            System.out.println(".. fire Created to Approved");
            return CompletableFuture.completedFuture(new ArrayList<>());
        }));
        IStatusUpdater defaultUpdater = c -> {
            System.out.println(".. no rule");
            return CompletableFuture.completedFuture(new ArrayList<>());
        };
        requireNonNull(hooks.g.edgeValueOrDefault(Created, Approved, defaultUpdater))
                .run(null);
        requireNonNull(hooks.g.edgeValueOrDefault(Created, Completed, defaultUpdater))
                .run(null);
    }
}

package com.bluecc.income.procs;

import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.income.GuiceTestRunner;
import com.google.common.collect.ImmutableList;
import com.google.common.graph.MutableGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static com.bluecc.hubs.stereotypes.OrderSeedData.*;
import static com.bluecc.hubs.stereotypes.OrderSeedData.StatusValidChange_ORDER_COMPLETED_ORDER_APPROVED;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceTestRunner.class)
public class StatusTypesTest {

    @Inject
    StatusTypes statusTypes;

    @Test
    public void buildGraph() {
        MutableGraph<String> directedGraph = statusTypes.buildGraph(statusValidChangeList);
        String startStatus=statusItemList.get(0).getStatusId();
        System.out.println(directedGraph.successors(startStatus));
        assertThat(directedGraph.successors(startStatus)).containsOnly(
                "ORDER_CANCELLED", "ORDER_PROCESSING", "ORDER_APPROVED",
                "ORDER_HOLD", "ORDER_REJECTED"
        );
    }

    @Test
    public void getValidChanges() {
        String typeId="ORDER_STATUS";
        System.out.println(statusTypes.getAllStatusItemIds(typeId));
    }

    public static final List<StatusItemData> statusItemList = ImmutableList.of(
            StatusItem_ORDER_CREATED,
            StatusItem_ORDER_PROCESSING,
            StatusItem_ORDER_APPROVED,
            StatusItem_ORDER_SENT,
            StatusItem_ORDER_HOLD,
            StatusItem_ORDER_COMPLETED,
            StatusItem_ORDER_REJECTED,
            StatusItem_ORDER_CANCELLED);

    public static final List<StatusValidChangeData> statusValidChangeList = ImmutableList.of(
            StatusValidChange_ORDER_CREATED_ORDER_PROCESSING,
            StatusValidChange_ORDER_CREATED_ORDER_APPROVED,
            StatusValidChange_ORDER_CREATED_ORDER_HOLD,
            StatusValidChange_ORDER_CREATED_ORDER_REJECTED,
            StatusValidChange_ORDER_CREATED_ORDER_CANCELLED,

            StatusValidChange_ORDER_PROCESSING_ORDER_HOLD,
            StatusValidChange_ORDER_PROCESSING_ORDER_APPROVED,
            StatusValidChange_ORDER_PROCESSING_ORDER_REJECTED,
            StatusValidChange_ORDER_PROCESSING_ORDER_CANCELLED,

            StatusValidChange_ORDER_APPROVED_ORDER_SENT,
            StatusValidChange_ORDER_APPROVED_ORDER_PROCESSING,
            StatusValidChange_ORDER_APPROVED_ORDER_COMPLETED,
            StatusValidChange_ORDER_APPROVED_ORDER_CANCELLED,
            StatusValidChange_ORDER_APPROVED_ORDER_HOLD,
            StatusValidChange_ORDER_HOLD_ORDER_PROCESSING,
            StatusValidChange_ORDER_HOLD_ORDER_APPROVED,
            StatusValidChange_ORDER_HOLD_ORDER_CANCELLED,
            StatusValidChange_ORDER_SENT_ORDER_COMPLETED,
            StatusValidChange_ORDER_SENT_ORDER_CANCELLED,
            StatusValidChange_ORDER_COMPLETED_ORDER_APPROVED
    );

    @Test
    public void cacheGraph() {
        MutableGraph<String> g = statusTypes.cacheGraph("Budget");
        System.out.println(g.successors("BG_CREATED"));
        assertTrue(g.hasEdgeConnecting("BG_CREATED", "BG_REJECTED"));
        assertFalse(g.hasEdgeConnecting("BG_REJECTED", "BG_REVIEWED"));

        assertTrue(statusTypes.isValid("Budget",
                "BG_CREATED", "BG_REJECTED"));
    }
}
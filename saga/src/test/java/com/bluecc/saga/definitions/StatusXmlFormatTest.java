package com.bluecc.saga.definitions;

import com.bluecc.gentool.SeedScanner;
import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.Indicator;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.income.exchange.FlatMessageCollector;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import one.util.streamex.EntryStream;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bluecc.gentool.SeedScanner.buildStatusTransitions;
import static com.bluecc.hubs.ProtoTypes.castIndicator;
import static com.bluecc.hubs.stereotypes.OrderSeedData.*;
import static com.bluecc.hubs.stereotypes.OrderSeedData.StatusItem_ORDER_CANCELLED;
import static com.bluecc.saga.definitions.StatusXmlFormatTest.OrderStatusEnum.*;
import static com.google.common.graph.Graphs.transpose;
import static org.junit.Assert.assertEquals;

public class StatusXmlFormatTest {

    @Test
    public void testStatusDataToXml() throws ParserConfigurationException {
        Document doc = FlatMessageCollector.toXmlDocument(
                Iterables.concat(Collections.singletonList(StatusType_ORDER_STATUS),
                        statusItemList,
                        statusValidChangeList)
        );

        // System.out.println(doc);
        assertEquals(29, Util.childElements(doc.getDocumentElement()).size());
        assertEquals("ORDER_STATUS", Util.childElements(doc.getDocumentElement())
                .get(0).getAttribute("statusTypeId"));

        StatusTypeData statusTypeData = StatusType_ORDER_STATUS;
        ModelTransition.ObjectStatus objectStatus = getObjectStatus(doc, statusTypeData);

        printObjectStatus(objectStatus);
    }

    private ModelTransition.ObjectStatus getObjectStatus(Document doc, StatusTypeData statusTypeData) {
        SeedScanner scanner = new SeedScanner();
        Util.childElements(doc.getDocumentElement()).forEach(e -> scanner.processElement(e));
        scanner.setupChanges();
        scanner.printStatus();

        ModelTransition.StatusTransitions transitions = buildStatusTransitions(scanner,
                statusTypeData.getStatusTypeId());
        ModelTransition.ObjectStatus objectStatus = ModelTransition.ObjectStatus.builder()
                .name(statusTypeData.getDescription())
                .transitions(transitions)
                .build();
        return objectStatus;
    }

    private void printObjectStatus(ModelTransition.ObjectStatus objectStatus) {
        System.out.println(objectStatus.getStartEvent());

        ModelTransition.StatusTransitions mesh = objectStatus.getTransitions();
        mesh.getStates().forEach(state -> {
            System.out.println(objectStatus.getStateComments(state));
        });
    }

    StatusTypeData typeData(String typeName) {
        return StatusTypeData.newBuilder()
                .setDescription(typeName)
                .setHasTable(Indicator.NO)
                .setStatusTypeId(Util.toConstName(typeName) + "_STATUS")
                .build();
    }

    List<StatusItemData> statusItems(String typeName, String... items) {
        String prefix = Util.toConstName(typeName) + "_";
        return EntryStream.of(items).map(e ->
                StatusItemData.newBuilder()
                        .setDescription(e.getValue())
                        .setSequenceId(e.getKey().toString())
                        .setStatusCode(Util.toConstName(e.getValue()))
                        .setStatusId(prefix + Util.toConstName(e.getValue()))
                        .setStatusTypeId(prefix + "STATUS")
                        .build()).collect(Collectors.toList());
    }

    public final static StatusTypeData StatusType_ORDER_STATUS = StatusTypeData.newBuilder()
            .setDescription("Order")
            .setHasTable(castIndicator("N"))
            .setStatusTypeId("ORDER_STATUS")
            .build();

    enum OrderStatusEnum{
        Created, Processing, Approved, Sent, Hold, Completed, Rejected, Cancelled
    }

    @Test
    public void testEnum(){
        for (OrderStatusEnum value : OrderStatusEnum.values()) {
            System.out.println(value.name());
        }
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


    @Test
    public void testGraph(){
        MutableGraph<OrderStatusEnum> directedGraph = GraphBuilder.directed()
                .allowsSelfLoops(true).build();
        // directedGraph.putEdge(Created, Processing);
        // directedGraph.putEdge(Created, Approved);
        connect(directedGraph, Created,
                Processing, Approved, Hold, Rejected, Cancelled);
        connect(directedGraph, Processing,
                Hold, Approved, Rejected, Cancelled);

        Graph<OrderStatusEnum> transpose = transpose(directedGraph); // 反转
        for (OrderStatusEnum node : directedGraph.nodes()) {
            System.out.println(node+": "+directedGraph.inDegree(node)+", "+transpose.outDegree(node));
        }

        System.out.println(directedGraph.successors(Created));
        System.out.println(transpose.successors(Created));
    }

    static void connect(MutableGraph<OrderStatusEnum> directedGraph, OrderStatusEnum from,
                 OrderStatusEnum... to){
        for (OrderStatusEnum target : to) {
            directedGraph.putEdge(from, target);
        }
    }

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

}

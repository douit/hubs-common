package com.bluecc.livegen;

import com.bluecc.gentool.SeedScanner;
import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.Indicator;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.income.exchange.FlatMessageCollector;
import com.google.common.collect.Lists;
import com.google.protobuf.Message;
import io.vavr.Tuple3;
import io.vavr.control.Try;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import one.util.streamex.EntryStream;
import org.w3c.dom.Document;

import java.util.List;
import java.util.stream.Collectors;

import static com.bluecc.gentool.SeedScanner.buildStatusTransitions;

public class ModelStates {

    public static StatusTypeData typeData(String typeName) {
        return StatusTypeData.newBuilder()
                .setDescription(typeName)
                .setHasTable(Indicator.NO)
                .setStatusTypeId(Util.toConstName(typeName) + "_STATUS")
                .build();
    }

    public static List<StatusItemData> statusItems(String typeName, String... items) {
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


    public static StatusValidChangeData statusChanges(String typeName, String eventName,
                                                      String from, String to) {
        String prefix = Util.toConstName(typeName) + "_";
        return StatusValidChangeData.newBuilder()
                .setStatusId(prefix+ Util.toConstName(from))
                .setStatusIdTo(prefix+ Util.toConstName(to))
                .setTransitionName(eventName)
                .build();
    }


    public static void printObjectStatus(ModelTransition.ObjectStatus objectStatus) {
        System.out.println(objectStatus.getStartEvent());

        ModelTransition.StatusTransitions mesh = objectStatus.getTransitions();
        mesh.getStates().forEach(state -> {
            System.out.println(objectStatus.getStateComments(state));
        });
    }


    public static ModelTransition.ObjectStatus getObjectStatus(Document doc, StatusTypeData statusTypeData) {
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


    @Data
    @Builder
    public static class StatesDefs{
        String typeName;
        @Singular
        List<String> items;
        @Singular
        List<Tuple3<String, String, String>> changes;

        public List<Message> build(){
            List<Message> result= Lists.newArrayList();
            result.add(typeData(typeName));
            result.addAll(statusItems(typeName, items.toArray(new String[0])));
            changes.forEach(t -> result.add(statusChanges(typeName, t._1, t._2, t._3)));
            return result;
        }

        public void treePrint(){
            Try<Document> doc = Try.of(()-> FlatMessageCollector.toXmlDocument(build()));
            ModelTransition.ObjectStatus objectStatus = getObjectStatus(doc.get(),
                    typeData(typeName));
            printObjectStatus(objectStatus);
        }
    }

}


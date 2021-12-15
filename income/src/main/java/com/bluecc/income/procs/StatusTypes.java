package com.bluecc.income.procs;

import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.google.common.collect.Maps;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class StatusTypes {

    @Inject
    FactBag factBag;

    public Optional<String> getTransitionName(String statusId, String statusIdTo) {
        Optional<String> transName= factBag.allTypes("StatusValidChange", StatusValidChangeData::parseFrom)
                .stream().filter(e -> e.getStatusId().equals(statusId)
                        && e.getStatusIdTo().equals(statusIdTo))
                .findFirst()
                .map(e -> e.getTransitionName());
        return transName;
    }

    public Set<String> getValidChanges(String statusId){
        return factBag.allTypes("StatusValidChange", StatusValidChangeData::parseFrom)
                .stream().filter(e -> e.getStatusId().equals(statusId))
                .map(e -> e.getStatusIdTo())
                .collect(Collectors.toSet());
    }

    public List<StatusItemData> getAllStatusItems(String statusTypeId){
        return factBag.allTypes("StatusItem", StatusItemData::parseFrom)
                .stream().filter(e -> e.getStatusTypeId().equals(statusTypeId))
                .collect(Collectors.toList());
    }

    public List<String> getAllStatusItemIds(String statusTypeId){
        return getAllStatusItems(statusTypeId)
                .stream().map(e -> e.getStatusId())
                .collect(Collectors.toList());
    }

    Map<String, MutableGraph<String>> statusGraphs= Maps.newConcurrentMap();

    public MutableGraph<String> cacheGraph(String statusTypeName){
        return statusGraphs.computeIfAbsent(statusTypeName, st -> {
            ModelTransition.ObjectStatus objectStatus=ModelTransition.loadFromAsset(statusTypeName);
           return buildGraph(objectStatus);
        });
    }

    public boolean isValid(String statusTypeName, String from, String to){
        MutableGraph<String> g = cacheGraph(statusTypeName);
        return g.hasEdgeConnecting(from, to);
    }

    public MutableGraph<String> buildGraph(ModelTransition.ObjectStatus objectStatus){
        MutableGraph<String> directedGraph = GraphBuilder.directed()
                .allowsSelfLoops(true).build();
        objectStatus.getTransitions().getTransitions().forEach(stc ->{
            connect(directedGraph, stc.getStatusId(), stc.getStatusIdTo());
        });
        return directedGraph;
    }

    public MutableGraph<String> buildGraph(List<StatusValidChangeData> statusValidChangeList){
        MutableGraph<String> directedGraph = GraphBuilder.directed()
                .allowsSelfLoops(true).build();
        statusValidChangeList.forEach(stc ->{
            connect(directedGraph, stc.getStatusId(), stc.getStatusIdTo());
        });
        return directedGraph;
    }

    void connect(MutableGraph<String> directedGraph, String from,
                 String... to){
        for (String target : to) {
            directedGraph.putEdge(from, target);
        }
    }
}


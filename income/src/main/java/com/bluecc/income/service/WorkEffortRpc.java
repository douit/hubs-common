package com.bluecc.income.service;

import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.WorkEffortServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.WorkEffortDelegator;
import com.bluecc.income.model.WorkEffort;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WorkEffortRpc extends WorkEffortServiceGrpc.WorkEffortServiceImplBase {
    @Inject
    WorkEffortDelegator workEffortDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<WorkEffortData> responseObserver) {
        workEffortDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            workEffortDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

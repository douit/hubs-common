package com.bluecc.income.service;

import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.WorkEffortServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.WorkEffortDelegator;
import com.bluecc.income.model.WorkEffort;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import com.bluecc.hubs.fund.ProtoMeta;

@Slf4j
public class WorkEffortRpc extends WorkEffortServiceGrpc.WorkEffortServiceImplBase {
    @Inject
    WorkEffortDelegator workEffortDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<WorkEffortData> responseObserver) {
        workEffortDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("WorkEffort").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query work_effort and relates: {}", incls);

            workEffortDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

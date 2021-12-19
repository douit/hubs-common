package com.bluecc.income.service;

import com.bluecc.hubs.stub.FinAccountData;
import com.bluecc.hubs.stub.FinAccountServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.FinAccountDelegator;
import com.bluecc.income.model.FinAccount;
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
public class FinAccountRpc extends FinAccountServiceGrpc.FinAccountServiceImplBase {
    @Inject
    FinAccountDelegator finAccountDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<FinAccountData> responseObserver) {
        finAccountDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("FinAccount").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query fin_account and relates: {}", incls);

            finAccountDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

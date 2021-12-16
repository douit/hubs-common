package com.bluecc.income.service;

import com.bluecc.hubs.stub.FinAccountData;
import com.bluecc.hubs.stub.FinAccountServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.FinAccountDelegator;
import com.bluecc.income.model.FinAccount;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FinAccountRpc extends FinAccountServiceGrpc.FinAccountServiceImplBase {
    @Inject
    FinAccountDelegator finAccountDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<FinAccountData> responseObserver) {
        finAccountDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            finAccountDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

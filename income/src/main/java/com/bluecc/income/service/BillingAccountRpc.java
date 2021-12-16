package com.bluecc.income.service;

import com.bluecc.hubs.stub.BillingAccountData;
import com.bluecc.hubs.stub.BillingAccountServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.BillingAccountDelegator;
import com.bluecc.income.model.BillingAccount;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BillingAccountRpc extends BillingAccountServiceGrpc.BillingAccountServiceImplBase {
    @Inject
    BillingAccountDelegator billingAccountDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<BillingAccountData> responseObserver) {
        billingAccountDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            billingAccountDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

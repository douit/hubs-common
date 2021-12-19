package com.bluecc.income.service;

import com.bluecc.hubs.stub.BillingAccountData;
import com.bluecc.hubs.stub.BillingAccountServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.BillingAccountDelegator;
import com.bluecc.income.model.BillingAccount;
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
public class BillingAccountRpc extends BillingAccountServiceGrpc.BillingAccountServiceImplBase {
    @Inject
    BillingAccountDelegator billingAccountDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<BillingAccountData> responseObserver) {
        billingAccountDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("BillingAccount").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query billing_account and relates: {}", incls);

            billingAccountDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

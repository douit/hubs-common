package com.bluecc.income.service;

import com.bluecc.hubs.stub.PaymentData;
import com.bluecc.hubs.stub.PaymentServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PaymentDelegator;
import com.bluecc.income.model.Payment;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PaymentRpc extends PaymentServiceGrpc.PaymentServiceImplBase {
    @Inject
    PaymentDelegator paymentDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<PaymentData> responseObserver) {
        paymentDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            paymentDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.QuoteData;
import com.bluecc.hubs.stub.QuoteServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.QuoteDelegator;
import com.bluecc.income.model.Quote;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class QuoteRpc extends QuoteServiceGrpc.QuoteServiceImplBase {
    @Inject
    QuoteDelegator quoteDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<QuoteData> responseObserver) {
        quoteDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            quoteDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.QuoteData;
import com.bluecc.hubs.stub.QuoteServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.QuoteDelegator;
import com.bluecc.income.model.Quote;
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
public class QuoteRpc extends QuoteServiceGrpc.QuoteServiceImplBase {
    @Inject
    QuoteDelegator quoteDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<QuoteData> responseObserver) {
        quoteDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("Quote").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query quote and relates: {}", incls);

            quoteDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

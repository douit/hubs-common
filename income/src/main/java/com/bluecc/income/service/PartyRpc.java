package com.bluecc.income.service;

import com.bluecc.hubs.stub.PartyData;
import com.bluecc.hubs.stub.PartyServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PartyDelegator;
import com.bluecc.income.model.Party;
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
public class PartyRpc extends PartyServiceGrpc.PartyServiceImplBase {
    @Inject
    PartyDelegator partyDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<PartyData> responseObserver) {
        partyDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("Party").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query party and relates: {}", incls);

            partyDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

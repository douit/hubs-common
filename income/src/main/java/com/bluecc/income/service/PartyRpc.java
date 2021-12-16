package com.bluecc.income.service;

import com.bluecc.hubs.stub.PartyData;
import com.bluecc.hubs.stub.PartyServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PartyDelegator;
import com.bluecc.income.model.Party;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PartyRpc extends PartyServiceGrpc.PartyServiceImplBase {
    @Inject
    PartyDelegator partyDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<PartyData> responseObserver) {
        partyDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            partyDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

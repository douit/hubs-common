package com.bluecc.income.service;

import com.bluecc.hubs.stub.PartyGroupData;
import com.bluecc.hubs.stub.PartyGroupServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PartyGroupDelegator;
import com.bluecc.income.model.PartyGroup;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PartyGroupRpc extends PartyGroupServiceGrpc.PartyGroupServiceImplBase {
    @Inject
    PartyGroupDelegator partyGroupDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<PartyGroupData> responseObserver) {
        partyGroupDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            partyGroupDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

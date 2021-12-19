package com.bluecc.income.service;

import com.bluecc.hubs.stub.PartyGroupData;
import com.bluecc.hubs.stub.PartyGroupServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PartyGroupDelegator;
import com.bluecc.income.model.PartyGroup;
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
public class PartyGroupRpc extends PartyGroupServiceGrpc.PartyGroupServiceImplBase {
    @Inject
    PartyGroupDelegator partyGroupDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<PartyGroupData> responseObserver) {
        partyGroupDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("PartyGroup").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query party_group and relates: {}", incls);

            partyGroupDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

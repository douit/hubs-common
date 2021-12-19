package com.bluecc.income.service;

import com.bluecc.hubs.stub.PersonData;
import com.bluecc.hubs.stub.PersonServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PersonDelegator;
import com.bluecc.income.model.Person;
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
public class PersonRpc extends PersonServiceGrpc.PersonServiceImplBase {
    @Inject
    PersonDelegator personDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<PersonData> responseObserver) {
        personDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("Person").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query person and relates: {}", incls);

            personDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

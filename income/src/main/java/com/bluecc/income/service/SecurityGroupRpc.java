package com.bluecc.income.service;

import com.bluecc.hubs.stub.SecurityGroupData;
import com.bluecc.hubs.stub.SecurityGroupServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.SecurityGroupDelegator;
import com.bluecc.income.model.SecurityGroup;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SecurityGroupRpc extends SecurityGroupServiceGrpc.SecurityGroupServiceImplBase {
    @Inject
    SecurityGroupDelegator securityGroupDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<SecurityGroupData> responseObserver) {
        securityGroupDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            securityGroupDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

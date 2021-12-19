package com.bluecc.income.service;

import com.bluecc.hubs.stub.SecurityGroupData;
import com.bluecc.hubs.stub.SecurityGroupServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.SecurityGroupDelegator;
import com.bluecc.income.model.SecurityGroup;
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
public class SecurityGroupRpc extends SecurityGroupServiceGrpc.SecurityGroupServiceImplBase {
    @Inject
    SecurityGroupDelegator securityGroupDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<SecurityGroupData> responseObserver) {
        securityGroupDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("SecurityGroup").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query security_group and relates: {}", incls);

            securityGroupDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

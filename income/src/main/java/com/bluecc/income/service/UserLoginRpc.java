package com.bluecc.income.service;

import com.bluecc.hubs.stub.UserLoginData;
import com.bluecc.hubs.stub.UserLoginServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.UserLoginDelegator;
import com.bluecc.income.model.UserLogin;
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
public class UserLoginRpc extends UserLoginServiceGrpc.UserLoginServiceImplBase {
    @Inject
    UserLoginDelegator userLoginDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<UserLoginData> responseObserver) {
        userLoginDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("UserLogin").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query user_login and relates: {}", incls);

            userLoginDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

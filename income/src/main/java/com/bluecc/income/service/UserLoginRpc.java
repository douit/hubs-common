package com.bluecc.income.service;

import com.bluecc.hubs.stub.UserLoginData;
import com.bluecc.hubs.stub.UserLoginServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.UserLoginDelegator;
import com.bluecc.income.model.UserLogin;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class UserLoginRpc extends UserLoginServiceGrpc.UserLoginServiceImplBase {
    @Inject
    UserLoginDelegator userLoginDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<UserLoginData> responseObserver) {
        userLoginDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            userLoginDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

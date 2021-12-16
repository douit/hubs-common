package com.bluecc.income.service;

import com.bluecc.hubs.stub.FixedAssetData;
import com.bluecc.hubs.stub.FixedAssetServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.FixedAssetDelegator;
import com.bluecc.income.model.FixedAsset;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FixedAssetRpc extends FixedAssetServiceGrpc.FixedAssetServiceImplBase {
    @Inject
    FixedAssetDelegator fixedAssetDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<FixedAssetData> responseObserver) {
        fixedAssetDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            fixedAssetDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

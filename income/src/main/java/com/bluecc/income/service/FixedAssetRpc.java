package com.bluecc.income.service;

import com.bluecc.hubs.stub.FixedAssetData;
import com.bluecc.hubs.stub.FixedAssetServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.FixedAssetDelegator;
import com.bluecc.income.model.FixedAsset;
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
public class FixedAssetRpc extends FixedAssetServiceGrpc.FixedAssetServiceImplBase {
    @Inject
    FixedAssetDelegator fixedAssetDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<FixedAssetData> responseObserver) {
        fixedAssetDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("FixedAsset").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query fixed_asset and relates: {}", incls);

            fixedAssetDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

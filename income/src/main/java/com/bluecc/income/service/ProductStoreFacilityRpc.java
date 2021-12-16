package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductStoreFacilityData;
import com.bluecc.hubs.stub.ProductStoreFacilityServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductStoreFacilityDelegator;
import com.bluecc.income.model.ProductStoreFacility;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductStoreFacilityRpc extends ProductStoreFacilityServiceGrpc.ProductStoreFacilityServiceImplBase {
    @Inject
    ProductStoreFacilityDelegator productStoreFacilityDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProductStoreFacilityData> responseObserver) {
        productStoreFacilityDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            productStoreFacilityDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

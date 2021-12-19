package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductStoreFacilityData;
import com.bluecc.hubs.stub.ProductStoreFacilityServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductStoreFacilityDelegator;
import com.bluecc.income.model.ProductStoreFacility;
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
public class ProductStoreFacilityRpc extends ProductStoreFacilityServiceGrpc.ProductStoreFacilityServiceImplBase {
    @Inject
    ProductStoreFacilityDelegator productStoreFacilityDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProductStoreFacilityData> responseObserver) {
        productStoreFacilityDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProductStoreFacility").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query product_store_facility and relates: {}", incls);

            productStoreFacilityDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

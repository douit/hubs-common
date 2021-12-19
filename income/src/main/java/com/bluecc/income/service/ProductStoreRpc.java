package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductStoreData;
import com.bluecc.hubs.stub.ProductStoreServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductStoreDelegator;
import com.bluecc.income.model.ProductStore;
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
public class ProductStoreRpc extends ProductStoreServiceGrpc.ProductStoreServiceImplBase {
    @Inject
    ProductStoreDelegator productStoreDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProductStoreData> responseObserver) {
        productStoreDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProductStore").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query product_store and relates: {}", incls);

            productStoreDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

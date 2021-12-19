package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductData;
import com.bluecc.hubs.stub.ProductServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductDelegator;
import com.bluecc.income.model.Product;
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
public class ProductRpc extends ProductServiceGrpc.ProductServiceImplBase {
    @Inject
    ProductDelegator productDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProductData> responseObserver) {
        productDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("Product").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query product and relates: {}", incls);

            productDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductData;
import com.bluecc.hubs.stub.ProductServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductDelegator;
import com.bluecc.income.model.Product;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductRpc extends ProductServiceGrpc.ProductServiceImplBase {
    @Inject
    ProductDelegator productDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProductData> responseObserver) {
        productDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            productDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.hubs.stub.ProductCategoryRollupServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductCategoryRollupDelegator;
import com.bluecc.income.model.ProductCategoryRollup;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductCategoryRollupRpc extends ProductCategoryRollupServiceGrpc.ProductCategoryRollupServiceImplBase {
    @Inject
    ProductCategoryRollupDelegator productCategoryRollupDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProductCategoryRollupData> responseObserver) {
        productCategoryRollupDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            productCategoryRollupDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

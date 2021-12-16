package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductCategoryData;
import com.bluecc.hubs.stub.ProductCategoryServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductCategoryDelegator;
import com.bluecc.income.model.ProductCategory;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductCategoryRpc extends ProductCategoryServiceGrpc.ProductCategoryServiceImplBase {
    @Inject
    ProductCategoryDelegator productCategoryDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProductCategoryData> responseObserver) {
        productCategoryDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            productCategoryDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

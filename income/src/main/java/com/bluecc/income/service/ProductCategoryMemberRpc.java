package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductCategoryMemberData;
import com.bluecc.hubs.stub.ProductCategoryMemberServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductCategoryMemberDelegator;
import com.bluecc.income.model.ProductCategoryMember;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductCategoryMemberRpc extends ProductCategoryMemberServiceGrpc.ProductCategoryMemberServiceImplBase {
    @Inject
    ProductCategoryMemberDelegator productCategoryMemberDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProductCategoryMemberData> responseObserver) {
        productCategoryMemberDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            productCategoryMemberDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

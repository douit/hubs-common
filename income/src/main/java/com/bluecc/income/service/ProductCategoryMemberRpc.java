package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductCategoryMemberData;
import com.bluecc.hubs.stub.ProductCategoryMemberServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductCategoryMemberDelegator;
import com.bluecc.income.model.ProductCategoryMember;
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
public class ProductCategoryMemberRpc extends ProductCategoryMemberServiceGrpc.ProductCategoryMemberServiceImplBase {
    @Inject
    ProductCategoryMemberDelegator productCategoryMemberDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProductCategoryMemberData> responseObserver) {
        productCategoryMemberDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProductCategoryMember").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query product_category_member and relates: {}", incls);

            productCategoryMemberDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

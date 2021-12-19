package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.hubs.stub.ProductCategoryRollupServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductCategoryRollupDelegator;
import com.bluecc.income.model.ProductCategoryRollup;
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
public class ProductCategoryRollupRpc extends ProductCategoryRollupServiceGrpc.ProductCategoryRollupServiceImplBase {
    @Inject
    ProductCategoryRollupDelegator productCategoryRollupDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProductCategoryRollupData> responseObserver) {
        productCategoryRollupDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProductCategoryRollup").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query product_category_rollup and relates: {}", incls);

            productCategoryRollupDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductStoreCatalogData;
import com.bluecc.hubs.stub.ProductStoreCatalogServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductStoreCatalogDelegator;
import com.bluecc.income.model.ProductStoreCatalog;
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
public class ProductStoreCatalogRpc extends ProductStoreCatalogServiceGrpc.ProductStoreCatalogServiceImplBase {
    @Inject
    ProductStoreCatalogDelegator productStoreCatalogDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProductStoreCatalogData> responseObserver) {
        productStoreCatalogDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProductStoreCatalog").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query product_store_catalog and relates: {}", incls);

            productStoreCatalogDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

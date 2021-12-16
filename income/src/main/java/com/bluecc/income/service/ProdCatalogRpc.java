package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProdCatalogData;
import com.bluecc.hubs.stub.ProdCatalogServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProdCatalogDelegator;
import com.bluecc.income.model.ProdCatalog;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProdCatalogRpc extends ProdCatalogServiceGrpc.ProdCatalogServiceImplBase {
    @Inject
    ProdCatalogDelegator prodCatalogDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProdCatalogData> responseObserver) {
        prodCatalogDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            prodCatalogDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

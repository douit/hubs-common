package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProdCatalogCategoryData;
import com.bluecc.hubs.stub.ProdCatalogCategoryServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProdCatalogCategoryDelegator;
import com.bluecc.income.model.ProdCatalogCategory;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProdCatalogCategoryRpc extends ProdCatalogCategoryServiceGrpc.ProdCatalogCategoryServiceImplBase {
    @Inject
    ProdCatalogCategoryDelegator prodCatalogCategoryDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ProdCatalogCategoryData> responseObserver) {
        prodCatalogCategoryDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            prodCatalogCategoryDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

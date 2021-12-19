package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProdCatalogCategoryData;
import com.bluecc.hubs.stub.ProdCatalogCategoryServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProdCatalogCategoryDelegator;
import com.bluecc.income.model.ProdCatalogCategory;
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
public class ProdCatalogCategoryRpc extends ProdCatalogCategoryServiceGrpc.ProdCatalogCategoryServiceImplBase {
    @Inject
    ProdCatalogCategoryDelegator prodCatalogCategoryDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProdCatalogCategoryData> responseObserver) {
        prodCatalogCategoryDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProdCatalogCategory").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query prod_catalog_category and relates: {}", incls);

            prodCatalogCategoryDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProdCatalogData;
import com.bluecc.hubs.stub.ProdCatalogServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProdCatalogDelegator;
import com.bluecc.income.model.ProdCatalog;
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
public class ProdCatalogRpc extends ProdCatalogServiceGrpc.ProdCatalogServiceImplBase {
    @Inject
    ProdCatalogDelegator prodCatalogDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ProdCatalogData> responseObserver) {
        prodCatalogDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ProdCatalog").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query prod_catalog and relates: {}", incls);

            prodCatalogDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

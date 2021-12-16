package com.bluecc.income.service;

import com.bluecc.hubs.stub.WebSiteData;
import com.bluecc.hubs.stub.WebSiteServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.WebSiteDelegator;
import com.bluecc.income.model.WebSite;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WebSiteRpc extends WebSiteServiceGrpc.WebSiteServiceImplBase {
    @Inject
    WebSiteDelegator webSiteDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<WebSiteData> responseObserver) {
        webSiteDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            webSiteDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

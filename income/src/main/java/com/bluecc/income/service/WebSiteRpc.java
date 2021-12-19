package com.bluecc.income.service;

import com.bluecc.hubs.stub.WebSiteData;
import com.bluecc.hubs.stub.WebSiteServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.WebSiteDelegator;
import com.bluecc.income.model.WebSite;
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
public class WebSiteRpc extends WebSiteServiceGrpc.WebSiteServiceImplBase {
    @Inject
    WebSiteDelegator webSiteDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<WebSiteData> responseObserver) {
        webSiteDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("WebSite").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query web_site and relates: {}", incls);

            webSiteDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.OrderHeaderServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.OrderHeaderDelegator;
import com.bluecc.income.model.OrderHeader;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class OrderHeaderRpc extends OrderHeaderServiceGrpc.OrderHeaderServiceImplBase {
    @Inject
    OrderHeaderDelegator orderHeaderDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<OrderHeaderData> responseObserver) {
        orderHeaderDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            orderHeaderDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

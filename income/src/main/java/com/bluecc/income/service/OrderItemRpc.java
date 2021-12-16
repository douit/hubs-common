package com.bluecc.income.service;

import com.bluecc.hubs.stub.OrderItemData;
import com.bluecc.hubs.stub.OrderItemServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.OrderItemDelegator;
import com.bluecc.income.model.OrderItem;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class OrderItemRpc extends OrderItemServiceGrpc.OrderItemServiceImplBase {
    @Inject
    OrderItemDelegator orderItemDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<OrderItemData> responseObserver) {
        orderItemDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            orderItemDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

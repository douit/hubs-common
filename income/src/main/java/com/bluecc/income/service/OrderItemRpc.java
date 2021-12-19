package com.bluecc.income.service;

import com.bluecc.hubs.stub.OrderItemData;
import com.bluecc.hubs.stub.OrderItemServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.OrderItemDelegator;
import com.bluecc.income.model.OrderItem;
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
public class OrderItemRpc extends OrderItemServiceGrpc.OrderItemServiceImplBase {
    @Inject
    OrderItemDelegator orderItemDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<OrderItemData> responseObserver) {
        orderItemDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("OrderItem").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query order_item and relates: {}", incls);

            orderItemDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

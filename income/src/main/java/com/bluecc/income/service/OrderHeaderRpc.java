package com.bluecc.income.service;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.OrderHeaderServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.OrderHeaderDelegator;
import com.bluecc.income.model.OrderHeader;
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
public class OrderHeaderRpc extends OrderHeaderServiceGrpc.OrderHeaderServiceImplBase {
    @Inject
    OrderHeaderDelegator orderHeaderDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<OrderHeaderData> responseObserver) {
        orderHeaderDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("OrderHeader").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query order_header and relates: {}", incls);

            orderHeaderDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

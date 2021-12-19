package com.bluecc.income.service;

import com.bluecc.hubs.stub.InventoryItemData;
import com.bluecc.hubs.stub.InventoryItemServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.InventoryItemDelegator;
import com.bluecc.income.model.InventoryItem;
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
public class InventoryItemRpc extends InventoryItemServiceGrpc.InventoryItemServiceImplBase {
    @Inject
    InventoryItemDelegator inventoryItemDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<InventoryItemData> responseObserver) {
        inventoryItemDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("InventoryItem").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query inventory_item and relates: {}", incls);

            inventoryItemDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

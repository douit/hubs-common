package com.bluecc.income.service;

import com.bluecc.hubs.stub.ShoppingListData;
import com.bluecc.hubs.stub.ShoppingListServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ShoppingListDelegator;
import com.bluecc.income.model.ShoppingList;
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
public class ShoppingListRpc extends ShoppingListServiceGrpc.ShoppingListServiceImplBase {
    @Inject
    ShoppingListDelegator shoppingListDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<ShoppingListData> responseObserver) {
        shoppingListDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("ShoppingList").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query shopping_list and relates: {}", incls);

            shoppingListDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.stub.InvoiceItemData;
import com.bluecc.hubs.stub.InvoiceItemServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.InvoiceItemDelegator;
import com.bluecc.income.model.InvoiceItem;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class InvoiceItemRpc extends InvoiceItemServiceGrpc.InvoiceItemServiceImplBase {
    @Inject
    InvoiceItemDelegator invoiceItemDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<InvoiceItemData> responseObserver) {
        invoiceItemDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            invoiceItemDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

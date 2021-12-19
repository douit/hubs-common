package com.bluecc.income.service;

import com.bluecc.hubs.stub.InvoiceItemData;
import com.bluecc.hubs.stub.InvoiceItemServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.InvoiceItemDelegator;
import com.bluecc.income.model.InvoiceItem;
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
public class InvoiceItemRpc extends InvoiceItemServiceGrpc.InvoiceItemServiceImplBase {
    @Inject
    InvoiceItemDelegator invoiceItemDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<InvoiceItemData> responseObserver) {
        invoiceItemDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("InvoiceItem").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query invoice_item and relates: {}", incls);

            invoiceItemDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

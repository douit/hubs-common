package com.bluecc.income.service;

import com.bluecc.hubs.stub.InvoiceData;
import com.bluecc.hubs.stub.InvoiceServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.InvoiceDelegator;
import com.bluecc.income.model.Invoice;
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
public class InvoiceRpc extends InvoiceServiceGrpc.InvoiceServiceImplBase {
    @Inject
    InvoiceDelegator invoiceDelegator;
    @Inject
    ProtoMeta protoMeta;

    @Override
    public void findList(QueryList request, StreamObserver<InvoiceData> responseObserver) {
        invoiceDelegator.process(c -> {

            Set<String> incls = request.getRelationsList().isEmpty()
                    ? protoMeta.getInspectMeta("Invoice").getValidRelationNames()
                    : new HashSet<>(request.getRelationsList());
            
            log.info("query invoice and relates: {}", incls);

            invoiceDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

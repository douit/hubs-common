package com.bluecc.income.service;

import com.bluecc.hubs.stub.InvoiceData;
import com.bluecc.hubs.stub.InvoiceServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.InvoiceDelegator;
import com.bluecc.income.model.Invoice;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class InvoiceRpc extends InvoiceServiceGrpc.InvoiceServiceImplBase {
    @Inject
    InvoiceDelegator invoiceDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<InvoiceData> responseObserver) {
        invoiceDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            invoiceDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

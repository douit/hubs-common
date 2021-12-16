package com.bluecc.income.service;

import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.hubs.stub.ShipmentServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ShipmentDelegator;
import com.bluecc.income.model.Shipment;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ShipmentRpc extends ShipmentServiceGrpc.ShipmentServiceImplBase {
    @Inject
    ShipmentDelegator shipmentDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<ShipmentData> responseObserver) {
        shipmentDelegator.process(c -> {

            Set<String> incls = new HashSet<>(request.getRelationsList());
            shipmentDelegator.chainQueryDataList(c, incls, responseObserver);
            responseObserver.onCompleted();

        });
    }
}

package com.bluecc.income.procs;

import com.bluecc.hubs.stub.*;
import com.bluecc.income.dao.OrderHeaderDelegator;
import com.bluecc.income.model.OrderHeader;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;

import java.util.HashSet;
import java.util.stream.Collectors;

import static com.bluecc.income.procs.GenericProcs.wrap;

public class OrderRpc extends OrderHeaderServiceGrpc.OrderHeaderServiceImplBase {
    // @Inject
    // Orders orders;
    @Inject
    GenericProcs genericProcs;
    @Inject
    OrderHeaderDelegator orderHeaderDelegator;

    @Override
    public void create(OrderHeaderData request, StreamObserver<Response> responseObserver) {
        genericProcs.storeCompoundObject(request, responseObserver);
    }

    @Override
    public void update(OrderHeaderFlatData request, StreamObserver<Response> responseObserver) {
        // orders.process(c -> {
        //     orders.update(c, request);
        // });
        genericProcs.update(request, responseObserver);
    }

    @Override
    public void delete(OrderHeaderFlatData request, StreamObserver<Response> responseObserver) {
        genericProcs.delete(request, responseObserver);
    }

    @Override
    public void find(OrderHeaderFlatData request, StreamObserver<OrderHeaderFlatData> responseObserver) {
        genericProcs.process(c ->{
            OrderHeader rec=genericProcs.findOne(c , request, OrderHeader.class);
            if(rec!=null) {
                responseObserver.onNext(rec.toDataBuilder().build());
            }
            responseObserver.onCompleted();
        });
    }

    @Override
    public void deleteById(Identity request, StreamObserver<Response> responseObserver) {
        genericProcs.process(c -> {
            int result=genericProcs.delete(c, request);
            responseObserver.onNext(wrap(result));
            responseObserver.onCompleted();
        });
    }

    @Override
    public void findById(Identity request, StreamObserver<OrderHeaderFlatData> responseObserver) {
        genericProcs.process(c -> {
            OrderHeader rec=genericProcs.findOne(c, request, OrderHeader.class);
            if(rec!=null) {
                responseObserver.onNext(rec.toDataBuilder().build());
            }
            responseObserver.onCompleted();
        });
    }

    @Override
    public void findRelations(QueryRelations request, StreamObserver<OrderHeaderData> responseObserver) {
        orderHeaderDelegator.queryOrderHeaderRelations(request.getKey(),
                new HashSet<>(request.getRelationsList()))
                .apply("")
                .subscribe(e -> responseObserver.onNext((OrderHeaderData) e.toData()));
        responseObserver.onCompleted();
    }
}

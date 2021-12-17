package com.bluecc.income.procs;

import com.bluecc.hubs.stub.DataStoreServiceGrpc;
import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Map;

@Slf4j
public class DataStoreRpc extends DataStoreServiceGrpc.DataStoreServiceImplBase {
    @Inject
    Map<String, IDelegator> delegators;
    @Inject
    Buckets buckets;

    @Override
    public void findList(QueryProfile request, StreamObserver<EntityBucket> responseObserver) {
        IDelegator delegator=delegators.get(request.getDelegatorName());
        if(delegator==null){
            log.error("Cannot find delegator {}", request.getDelegatorName());
            responseObserver.onCompleted();
            return;
        }

        delegator.queryList(request, responseObserver);
        responseObserver.onCompleted();
    }
}

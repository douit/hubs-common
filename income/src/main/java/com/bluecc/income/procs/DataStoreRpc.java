package com.bluecc.income.procs;

import com.bluecc.hubs.stub.*;
import com.bluecc.income.exchange.IDelegator;
import com.google.common.base.Stopwatch;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

        Stopwatch stopwatch = Stopwatch.createStarted();
        delegator.queryList(request, responseObserver);
        stopwatch.stop();
        log.info("cost {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        responseObserver.onCompleted();
    }

}

package com.bluecc.income.exchange;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import io.grpc.stub.StreamObserver;

import java.io.Writer;

public interface IDelegator {
    void serialize(QueryList queryList, Writer writer);
    void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver);
}

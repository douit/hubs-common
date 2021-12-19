package com.bluecc.income.procs;

import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.stub.*;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.List;

public class EntityTypesRpc extends EntityTypesServiceGrpc.EntityTypesServiceImplBase {
    @Inject
    FactBag factBag;

    
    @Override
    public void queryStatusType(QueryType request, StreamObserver<StatusTypeList> responseObserver) {
        List<StatusTypeData> rs = factBag.allTypes("StatusType", StatusTypeData::parseFrom);
        responseObserver.onNext(StatusTypeList.newBuilder()
                .addAllData(rs)
                .build());
        responseObserver.onCompleted();
    }
    
    @Override
    public void queryStatusItem(QueryType request, StreamObserver<StatusItemList> responseObserver) {
        List<StatusItemData> rs = factBag.allTypes("StatusItem", StatusItemData::parseFrom);
        responseObserver.onNext(StatusItemList.newBuilder()
                .addAllData(rs)
                .build());
        responseObserver.onCompleted();
    }
    
}

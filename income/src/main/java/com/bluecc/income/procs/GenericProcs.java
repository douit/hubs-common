package com.bluecc.income.procs;

import com.bluecc.hubs.stub.Response;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.MessageMapCollector;
import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class GenericProcs extends AbstractProcs{
    public void storeCompoundObject(Message messageData, StreamObserver<Response> responseObserver) {
        process(ctx -> {
            Map<String, MessageMapCollector.ResultData> result=
                    storeCompoundObject(ctx, messageData);

            Response reply = null;
            reply = Response.newBuilder()
                    .setResult(Response.Result.OK)
                    .setMessage(result.get("_id_").getChildId())
                    .build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        });
    }
}


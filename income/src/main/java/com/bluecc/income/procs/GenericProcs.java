package com.bluecc.income.procs;

import com.bluecc.hubs.stub.Response;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.MessageMapCollector;
import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Singleton
@Slf4j
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

    public void storeOrUpdate(IProc.ProcContext c, Message e) {
        List<Map<String, Object>> rs= findById(c, e);
        if(rs.isEmpty()) {
            create(c, e);
        }else{
            log.debug("it exists, update it");
            update(c, e);
        }
    }
}


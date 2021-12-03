package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.stub.Response;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.MessageMapCollector;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonObject;
import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;

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

    public void storeDataFile(IProc.ProcContext c, String source){
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, source, false);
        DataFill dataFill=new DataFill();
        Multimap<String, Message> dataMap=dataFill.setupData(dataList);
        dataMap.asMap().forEach((k,v)->{
            v.forEach(e ->{
                String ent=ProtoTypes.getEntityTypeByMessage(e);
                if(ProtoTypes.hasTable(e)) {
                    log.debug("store {}: {}", ent, e);
                    storeOrUpdate(c, e);
                }else{
                    log.info("entity {} doesn't has table, ignore",
                            ent);
                }
            });
        });
    }
}


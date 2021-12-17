package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.model.WithSuppliers;
import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.EntityValue;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IChainQuery;
import com.bluecc.income.exchange.IProc;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.income.exchange.ModelSerializer.getEntityValue;

public class Buckets {
    ProtoMeta protoMeta;
    GenericProcs genericProcs;

    @Inject
    public Buckets(ProtoMeta protoMeta, GenericProcs genericProcs) {
        this.protoMeta = protoMeta;
        this.genericProcs = genericProcs;
    }

    public <T extends WithSuppliers> void queryList(IChainQuery<T> chainQuery,
                          QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        genericProcs.process(c -> {
            responseObserver.onNext(queryValues(chainQuery, c, request.getDelegatorName()));
        });
    }

    public <T extends WithSuppliers> EntityBucket queryValues(IChainQuery<T> chainQuery,
                                                              IProc.ProcContext c,
                                                              String entityName) {
        Set<String> incls = protoMeta.getInspectMeta(entityName)
                .getValidRelationNames();
        List<EntityValue> entityValues = chainQuery.chainQuery(c, incls)
                .values().stream().map(e -> getEntityValue(e))
                .collect(Collectors.toList());
        EntityBucket bucket = EntityBucket.newBuilder()
                .setEntityType(entityName)
                .addAllValues(entityValues)
                .build();
        return bucket;
    }

    public <T extends WithSuppliers> String serializeToString(IChainQuery<T> chainQuery,
                                                              IProc.ProcContext c,
                                                              String entityName) {
        EntityBucket bucket = queryValues(chainQuery, c, entityName);
        return ProtoJsonUtils.toJson(bucket);
    }

    public <T extends WithSuppliers> void writeTo(IChainQuery<T> chainQuery,
                                                  String entityName,
                                                  Writer writer) {
        genericProcs.process(c -> {
            EntityBucket bucket = queryValues(chainQuery, c, entityName);
            try {
                writer.write(ProtoJsonUtils.toJson(bucket));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

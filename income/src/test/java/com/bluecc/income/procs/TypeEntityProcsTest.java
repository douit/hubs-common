package com.bluecc.income.procs;

import com.bluecc.hubs.fund.FnUtil;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.stub.CustRequestTypeData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.income.GuiceTestRunner;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.junit.runner.RunWith;
import reactor.core.publisher.Flux;

import javax.inject.Inject;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.FnUtil.wrap;
import static org.junit.Assert.*;

@RunWith(GuiceTestRunner.class)
public class TypeEntityProcsTest {
    @Inject
    TypeEntityProcs typeEntityProcs;

    @Test
    public void getEntityData() throws InvalidProtocolBufferException {
        CustRequestTypeData.Builder custReqType=CustRequestTypeData.newBuilder();
        typeEntityProcs.factBag.getEntityData("RF_BUGFIX", custReqType);
        CustRequestTypeData data=custReqType.build();
        System.out.println(data);
        assertEquals("Request For Bug Fix", data.getDescription());
    }

    @Test
    public void getAll(){
        typeEntityProcs.factBag.all("StatusType").forEach((k,v)->{
            try {
                StatusTypeData d=StatusTypeData.parseFrom(v);
                System.out.println(k+": "+d);
            } catch (InvalidProtocolBufferException e) {
                fail(e.getMessage());
            }
        });


        FnUtil.CheckedFunction<byte[],StatusTypeData> parseFn=StatusTypeData::parseFrom;
        List<StatusTypeData> ds= typeEntityProcs.factBag.all("StatusType")
                .readAllMap()
                .values().stream()
                // .map(wrap(bytes -> StatusTypeData.parseFrom(bytes)))
                .map(wrap(parseFn))
                .collect(Collectors.toList());
        System.out.println(ds.size());
        // Flux.fromIterable(typeEntityProcs.factBag.all("StatusType").readAllMap()
        //                 .values())
        //         .map(bytes -> StatusTypeData.parseFrom(bytes))
        //         .oner
    }

    @Test
    public void testAllTypes(){
        List<StatusTypeData> ds=typeEntityProcs.factBag
                .allTypes("StatusType", StatusTypeData::parseFrom);
        System.out.println(ds.size());
        ds.forEach(e -> System.out.println(e.getDescription()));
    }

}
package com.bluecc.income.endpoint;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.feed.DataBuilder;
import com.bluecc.income.exchange.MessageMapCollector;
import com.bluecc.income.procs.AbstractProcs;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.annotation.Default;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.Post;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.bluecc.hubs.fund.Util.prettyJson;
import static com.bluecc.income.dummy.store.StoreModule.startup;
import static com.linecorp.armeria.common.HttpStatus.BAD_REQUEST;
import static com.linecorp.armeria.common.HttpStatus.OK;

@Slf4j
public class HttpEndpoints extends AbstractProcs {
    public static void main(String[] args) {
        HttpEndpoints endpoints = startup(HttpEndpoints.class);
        endpoints.init();
        endpoints.serve();
    }

    @Inject
    ProtoMeta protoMeta;

    void init(){
        setupEntities("OrderItem", "OrderHeader", "ProductPrice");
    }
    void serve() {
        ServerBuilder sb = Server.builder();
        sb.http(4940);

        sb.service("/", (ctx, req) -> HttpResponse.of("ok!"));
        sb.annotatedService(new Object() {
            @Get("/schema")
            public HttpResponse greet(@Param("name") String name,
                                      @Param("type") @Default("entity") String type) {
                EntityMeta meta = protoMeta.getEntityMeta(name);
                if (meta != null) {
                    return HttpResponse.of(MediaType.JSON,
                            prettyJson(meta));
                } else {
                    return HttpResponse.of(HttpStatus.NOT_FOUND,
                            MediaType.PLAIN_TEXT_UTF_8,
                            "Cannot find template %s(%s)",
                            name, type
                    );
                }
            }
        });

        sb.annotatedService(new Object() {
            @Post("/store")
            public HttpResponse greet(@Param("name") String name, String body){
                System.out.println(name+": "+body);
                Message.Builder builder = builderFor(name);
                try {
                    JsonFormat.parser().merge(body, builder);
                    String newId=sequence.nextStringId();
                    ProtoTypes.setEntityKey(builder, newId);

                    process(ctx -> {
                        Message inputData= builder.build();
                        Map<String, MessageMapCollector.ResultData> resultMap =
                                storeCompoundObject(ctx, inputData);

                        resultMap.forEach((k, v) -> {
                            System.out.println(k + ": " + v);
                        });
                    });

                    return HttpResponse.of(OK, MediaType.JSON,
                            prettyJson(ImmutableMap.of("id", newId)));
                } catch (InvalidProtocolBufferException e) {
                    log.error(e.getMessage(), e);
                    return HttpResponse.of(BAD_REQUEST);
                }
            }
        });

        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
        future.join();
    }

    DataBuilder dataBuilder=new DataBuilder();
    private Message.Builder builderFor(String name) {
        // return OrderHeaderData.newBuilder();
        return dataBuilder.procData(name, false).getBuilder();
    }
}

/*
POST http://localhost:4940/store?name=Shipment
{
  "shipment_id": "s_1",
  "shipment_type_id": "COMMON",
  "estimated_ship_cost": {"value": "18.95"},
  "origin_facility_id": "f_1",
  "destination_facility_id": "f_2",
  "origin_postal_address": {
    "to_name": "joe",
    "city": "beijing",
    "address1": "123 Main St",
    "address2": "Apt B",
    "postal_code": "90210"
  },
  "destination_postal_address": {
    "to_name": "frank",
    "city": "beijing",
    "address1": "234 Main St",
    "address2": "Apt B",
    "postal_code": "90210"
  }
}


 */
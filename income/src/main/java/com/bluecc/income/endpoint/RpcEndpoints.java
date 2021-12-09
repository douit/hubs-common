package com.bluecc.income.endpoint;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.procs.GenericProcs;
import com.bluecc.hubs.fund.tenant.Tenants;
import com.bluecc.income.service.ServiceFacade;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.bluecc.hubs.ProtoTypes.extractEnvelopeData;
import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.income.dummy.store.StoreModule.startup;

/**
 * $ just i endpoint.RpcEndpoints
 */
@Slf4j
public class RpcEndpoints {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--profile", "-p"})
        String profile="default";
    }
    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        final ServiceFacade server = startup(opts.profile, ServiceFacade.class);
        server.start();
        server.blockUntilShutdown();
    }

    public static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            log.info("{}", reply);
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    public static class RoutinesImpl extends RoutinesGrpc.RoutinesImplBase {
        Sequence sequence=new Sequence(null);
        @Inject
        GenericProcs genericProcs;

        @Override
        public void storeValue(Envelope request, StreamObserver<Response> responseObserver) {
            log.info("receive {}", request.getDataType());

            Response reply = null;
            Any any = request.getData();
            try {
                if (any.is(StringValue.class)) {
                    StringValue resultVal = any.unpack(StringValue.class);
                    // StringValue.Builder builder=StringValue.newBuilder(resultVal);

                    reply = Response.newBuilder()
                            .setResult(Response.Result.OK)
                            .setMessage(resultVal.getValue())
                            .build();
                    responseObserver.onNext(reply);
                    responseObserver.onCompleted();

                }else{
                    Message.Builder builder = extractEnvelopeData(request);

                    String newId=sequence.nextStringId();
                    ProtoTypes.setEntityKey(builder, newId);

                    // invoke: onNext, onCompleted
                    genericProcs.storeCompoundObject(builder.build(), responseObserver);
                }
            } catch (InvalidProtocolBufferException e) {
                log.error(e.getMessage(), e);
                reply = Response.newBuilder()
                        .setResult(Response.Result.ERR)
                        .setMessage(e.getMessage())
                        .build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }

        }
    }

}

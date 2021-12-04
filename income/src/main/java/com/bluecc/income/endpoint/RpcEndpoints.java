package com.bluecc.income.endpoint;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.procs.GenericProcs;
import com.bluecc.hubs.fund.tenant.Tenants;
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

        final RpcEndpoints server = startup(opts.profile, RpcEndpoints.class);
        server.start();
        server.blockUntilShutdown();
    }

    private Server server;

    @Inject
    GreeterImpl greeter;
    @Inject
    RoutinesImpl routines;
    @Inject
    HeaderServerInterceptor interceptor;
    @Inject
    Tenants.TenantConf conf;

    private void start() throws IOException {
        pretty(conf);

        /* The port on which the server should run */
        int port = conf.getServer().getPort();
        server = ServerBuilder.forPort(port)
                .addService(greeter)
                .addService(ServerInterceptors.intercept(routines, interceptor))
                .build()
                .start();
        log.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    RpcEndpoints.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            log.info("{}", reply);
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    static class RoutinesImpl extends RoutinesGrpc.RoutinesImplBase {
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

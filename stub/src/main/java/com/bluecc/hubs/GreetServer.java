package com.bluecc.hubs;

import com.bluecc.hubs.stub.*;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * $ just rpc GreetServer
 */
@Slf4j
public class GreetServer {
    // private static final Logger logger = Logger.getLogger(GreetServer.class.getName());
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50056;
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .addService(new RoutinesDummyImpl())
                .build()
                .start();
        log.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    GreetServer.this.stop();
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

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final GreetServer server = new GreetServer();
        server.start();
        server.blockUntilShutdown();
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

    static class RoutinesDummyImpl extends RoutinesGrpc.RoutinesImplBase {
        @Override
        public void storeValue(Envelope request, StreamObserver<Response> responseObserver) {
            log.info("receive {}", request.getDataType());

            Response reply = null;
            Any any = request.getData();
            try {
                if (any.is(StringValue.class)) {
                    StringValue resultVal = any.unpack(StringValue.class);
                    reply = Response.newBuilder()
                            .setResult(Response.Result.OK)
                            .setMessage(resultVal.getValue())
                            .build();

                }
            } catch (InvalidProtocolBufferException e) {
                log.error(e.getMessage(), e);
                reply = Response.newBuilder()
                        .setResult(Response.Result.ERR)
                        .setMessage(e.getMessage())
                        .build();
            }

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}

package com.bluecc.income.service;

import com.bluecc.hubs.fund.tenant.Tenants;
import com.bluecc.income.endpoint.HeaderServerInterceptor;
import com.bluecc.income.endpoint.RpcEndpoints;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.bluecc.hubs.fund.Util.pretty;

@Slf4j
public class ServiceFacade {

    private Server server;

    @Inject
    RpcEndpoints.GreeterImpl greeter;
    @Inject
    RpcEndpoints.RoutinesImpl routines;

    @Inject
    HeaderServerInterceptor interceptor;
    @Inject
    Tenants.TenantConf conf;

    // # Services

    // # Services

    public void start() throws IOException {
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
                    ServiceFacade.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
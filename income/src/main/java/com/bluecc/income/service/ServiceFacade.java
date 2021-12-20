package com.bluecc.income.service;

import com.bluecc.hubs.fund.tenant.Tenants;
import com.bluecc.income.endpoint.HeaderServerInterceptor;
import com.bluecc.income.endpoint.RpcEndpoints;
import com.bluecc.income.procs.DataStoreRpc;
import com.bluecc.income.procs.EntityTypesRpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Provider;
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
    Provider<DataStoreRpc> dataStoreRpcProvider;
    @Inject
    Provider<EntityTypesRpc> entityTypesRpcProvider;

    @Inject
    HeaderServerInterceptor interceptor;
    @Inject
    Tenants.TenantConf conf;

    // # Services
    
    @Inject Provider<ProdCatalogRpc> prodCatalogRpc;
    @Inject Provider<ProductStoreRpc> productStoreRpc;
    @Inject Provider<ProductStoreFacilityRpc> productStoreFacilityRpc;
    @Inject Provider<ProductStoreCatalogRpc> productStoreCatalogRpc;
    @Inject Provider<WebSiteRpc> webSiteRpc;
    @Inject Provider<ProdCatalogCategoryRpc> prodCatalogCategoryRpc;
    @Inject Provider<ProductCategoryRpc> productCategoryRpc;
    @Inject Provider<ProductCategoryRollupRpc> productCategoryRollupRpc;
    @Inject Provider<ProductCategoryMemberRpc> productCategoryMemberRpc;
    @Inject Provider<ProductRpc> productRpc;
    @Inject Provider<OrderHeaderRpc> orderHeaderRpc;
    @Inject Provider<OrderItemRpc> orderItemRpc;
    @Inject Provider<ShoppingListRpc> shoppingListRpc;
    @Inject Provider<PaymentRpc> paymentRpc;
    @Inject Provider<InvoiceRpc> invoiceRpc;
    @Inject Provider<InvoiceItemRpc> invoiceItemRpc;
    @Inject Provider<ShipmentRpc> shipmentRpc;
    @Inject Provider<InventoryItemRpc> inventoryItemRpc;
    @Inject Provider<PartyRpc> partyRpc;
    @Inject Provider<PersonRpc> personRpc;
    @Inject Provider<PartyGroupRpc> partyGroupRpc;
    @Inject Provider<UserLoginRpc> userLoginRpc;
    @Inject Provider<BillingAccountRpc> billingAccountRpc;
    @Inject Provider<FinAccountRpc> finAccountRpc;
    @Inject Provider<QuoteRpc> quoteRpc;
    @Inject Provider<FixedAssetRpc> fixedAssetRpc;
    @Inject Provider<SecurityGroupRpc> securityGroupRpc;
    @Inject Provider<WorkEffortRpc> workEffortRpc;
    // # Services

    public void start() throws IOException {
        pretty(conf);

        /* The port on which the server should run */
        int port = conf.getServer().getPort();
        server = ServerBuilder.forPort(port)
                .addService(greeter)
                .addService(ServerInterceptors.intercept(routines, interceptor))
                .addService(ServerInterceptors.intercept(dataStoreRpcProvider.get(), interceptor))
                .addService(ServerInterceptors.intercept(entityTypesRpcProvider.get(), interceptor))
                .addService(ServerInterceptors.intercept(prodCatalogRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productStoreRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productStoreFacilityRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productStoreCatalogRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(webSiteRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(prodCatalogCategoryRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productCategoryRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productCategoryRollupRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productCategoryMemberRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(productRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(orderHeaderRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(orderItemRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(shoppingListRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(paymentRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(invoiceRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(invoiceItemRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(shipmentRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(inventoryItemRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(partyRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(personRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(partyGroupRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(userLoginRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(billingAccountRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(finAccountRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(quoteRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(fixedAssetRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(securityGroupRpc.get(), interceptor))
                .addService(ServerInterceptors.intercept(workEffortRpc.get(), interceptor))
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

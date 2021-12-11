package com.bluecc.income.procs;

import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.income.dao.ProductStoreDelegator;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ProductStores extends ProductStoreDelegator {
    public CompletableFuture<List<IModel<?>>> queryProductStoreSettings(String storeId){
        CompletableFuture<List<IModel<?>>> cf=
                process(c -> {
                    ProductStoreDelegator.Agent agent = getAgent(c, storeId);
                    // ProductStore productStore = agent.merge(); // DON'T DO THIS

                    c.getSubscriber().onNext(agent.getRecord());
                    agent.getProductStorePaymentSetting().forEach(e -> {
                        c.getSubscriber().onNext(e);
                    });
                    c.getSubscriber().onComplete();
                }).collectList().toFuture();
        return cf;
    }
}



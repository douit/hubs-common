package com.bluecc.saga;

import com.google.inject.*;

public class SagaModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
    }

    public static Injector startup(){
        return Guice.createInjector(new SagaModule());
    }

    public static <T> T startup(Class<T> clz){
        return startup().getInstance(clz);
    }

    @Provides
    @Singleton
    public HubsClient hubsClient(){
        return new HubsClient("localhost", 50056);
    }
}


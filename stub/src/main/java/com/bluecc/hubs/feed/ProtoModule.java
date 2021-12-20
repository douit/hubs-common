package com.bluecc.hubs.feed;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ProtoModule extends AbstractModule {
    @Override
    protected void configure() {
        super.configure();

        bind(ISharedData.class).to(SharedData.class);
    }

    public static Injector startup(){
        return Guice.createInjector(new ProtoModule());
    }

    public static <T> T startup(Class<T> clz){
        return startup().getInstance(clz);
    }
}


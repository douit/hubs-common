package com.bluecc.gentool;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GenModule extends AbstractModule {
    @Override
    protected void configure() {
        super.configure();
    }

    public static Injector startup(){
        return Guice.createInjector(new GenModule());
    }

    public static <T> T startup(Class<T> clz){
        return startup().getInstance(clz);
    }
}


package com.bluecc.domain.generic.procs;

import com.bluecc.domain.guice.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class SqlProcs {
    private static final Injector injector = Guice
            .createInjector(new ServiceModule());
    public static void main(String[] args) {

    }
}

package com.bluecc.testkit;

import com.bluecc.income.dummy.store.StoreModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class GuiceTestRunner extends BlockJUnit4ClassRunner {

    private static final Injector injector = Guice
            .createInjector(new StoreModule("test"));

    public GuiceTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        return injector.getInstance(getTestClass().getJavaClass());
    }
}

package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IService;
import com.bluecc.income.procs.Security;
import com.bluecc.income.procs.ShoppingCarts;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ServicesPluginModule extends AbstractModule {
    // Reflections reflections = new Reflections("com.bluecc.income.procs");
    public void configure() {
        Multibinder<IService> binder =
                Multibinder.newSetBinder(binder(), IService.class);
        binder.addBinding().to(Security.class);
        binder.addBinding().to(ShoppingCarts.class);

        // MapBinder<String, IService> uriBinder =
        //         MapBinder.newMapBinder(binder(), String.class, IService.class);

        // uriBinder.addBinding("ProdCatalog").to(ProdCatalogDelegator.class);
        // Set<Class<? extends IService>> serviceClasses= reflections.get(SubTypes.of(IService.class).asClass());
        // serviceClasses.forEach(clz -> uriBinder.addBinding(clz.getSimpleName())
        //         .to(clz));
    }
}

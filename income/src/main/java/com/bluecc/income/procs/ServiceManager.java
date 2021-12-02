package com.bluecc.income.procs;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.pubs.Eca;
import com.bluecc.hubs.fund.pubs.Ecas;
import com.bluecc.hubs.fund.pubs.Services;
import com.bluecc.income.dummy.store.StoreModule;
import com.google.inject.Injector;
import org.reflections.Reflections;

import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class ServiceManager extends AbstractFunctionManager{
    private static final Injector injector = StoreModule.startup();
    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();
        Reflections reflections = new Reflections("com.bluecc.income.exchange");
        Set<Class<?>> annotated =
                reflections.get(SubTypes.of(TypesAnnotated.with(Services.class)).asClass());
        annotated.forEach(e -> {
            System.out.println(e.getName());
            serviceManager.registerFn(Action.class, injector.getInstance(e));
        });
    }
}

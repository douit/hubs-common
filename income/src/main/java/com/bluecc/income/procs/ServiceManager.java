package com.bluecc.income.procs;

import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.pubs.Services;
import com.bluecc.income.dummy.store.StoreModule;
import com.google.inject.Injector;
import org.reflections.Reflections;
import reactor.core.publisher.Flux;

import java.util.Set;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class ServiceManager extends AbstractFunctionManager{
    private static final Injector injector = StoreModule.startup();
    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();
        // fire one
        serviceManager.fireOne("personProcs");
    }

    public ServiceManager(){
        Reflections reflections = new Reflections("com.bluecc.income.exchange");
        Set<Class<?>> annotated =
                reflections.get(SubTypes.of(TypesAnnotated.with(Services.class)).asClass());
        annotated.forEach(e -> {
            System.out.println(e.getName());
            registerFn(Action.class, injector.getInstance(e));
        });
    }

    // static final TypeReference<String> tokenString=new TypeReference<String>(){};
    // static final TypeReference<Message> tokenMessage=new TypeReference<Message>(){};
    @SuppressWarnings("unchecked")
    public void fireOne(String procName){
        FireProc proc = syncs.get(procName);
        // if(tokenString.getType()==proc.typeArguments[0]){
        //     System.out.println("input parameter is string");
        // }
        Flux<IModel<?>> flux=(Flux<IModel<?>>)proc.fn.apply("fire-one");
        flux.subscribe(e -> pretty(e));
    }
}

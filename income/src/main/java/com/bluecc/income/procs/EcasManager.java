package com.bluecc.income.procs;

import com.bluecc.hubs.fund.pubs.Eca;
import com.bluecc.hubs.fund.pubs.Ecas;
import com.bluecc.income.dummy.store.StoreModule;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Builder;
import lombok.Data;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class EcasManager {
    private static final Injector injector = StoreModule.startup();
    public static void main(String[] args) {
        EcasManager ecasManager=new EcasManager();
        Reflections reflections = new Reflections("com.bluecc.income.procs");
        Set<Class<?>> annotated =
                reflections.get(SubTypes.of(TypesAnnotated.with(Ecas.class)).asClass());
        annotated.forEach(e -> {
            System.out.println(e.getName());
            ecasManager.registerFn(injector.getInstance(e));
        });
    }

    Map<String, FireProc> syncs = Maps.newConcurrentMap();
    Map<String, FireJob> asyncs = Maps.newConcurrentMap();

    @Data
    @Builder
    public static class FireProc {
        Function<Object, Object> fn;
        Type[] typeArguments;
    }

    @Data
    @Builder
    public static class FireJob {
        Consumer<Object> fn;
        Type[] typeArguments;
    }

    public void registerFn(Object... fnList) {
        for (Object fn : fnList) {
            for (Method method : fn.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Eca.class)) {
                    String returnType=method.getReturnType().getSimpleName();
                    if(returnType.equals("Function")) {
                        registerSyncMethod(fn, method);
                    }else if(returnType.equals("Consumer")){
                        registerAsyncMethod(fn, method);
                    }else{
                        throw new RuntimeException("Cannot register fn with type "+returnType);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void registerSyncMethod(Object fn, Method method) {
        System.out.format("\t- %s: %s -> %s\n",
                method.getDeclaringClass().getSimpleName(),
                method.getName(),
                "sync");
        // Preconditions.checkArgument(returnType.equals("Function"),
        //         "Only register function with Bean annotation");

        Function<Object, Object> proc;
        try {
            Type[] actualTypeArguments = getTypeArguments(method);
            proc = (Function<Object, Object>) method.invoke(fn);
            syncs.put(method.getName(), FireProc.builder()
                    .fn(proc)
                    .typeArguments(actualTypeArguments)
                    .build());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Cannot register fn " + method.getName());
        }
    }

    @SuppressWarnings("unchecked")
    private void registerAsyncMethod(Object fn, Method method) {
        System.out.format("\t- %s: %s -> %s\n",
                method.getDeclaringClass().getSimpleName(),
                method.getName(),
                "async");

        Consumer<Object> proc;
        try {
            Type[] actualTypeArguments = getTypeArguments(method);
            proc = (Consumer<Object>) method.invoke(fn);
            asyncs.put(method.getName(), FireJob.builder()
                    .fn(proc)
                    .typeArguments(actualTypeArguments)
                    .build());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Cannot register fn " + method.getName());
        }
    }

    private static Type[] getTypeArguments(Method method) {
        Type genericReturnType = method.getGenericReturnType();
        Type[] actualTypeArguments = null;
        if (genericReturnType instanceof ParameterizedType) {
            actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
        }
        return actualTypeArguments;
    }

}

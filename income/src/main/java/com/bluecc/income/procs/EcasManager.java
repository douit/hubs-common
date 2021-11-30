package com.bluecc.income.procs;

import com.bluecc.hubs.fund.pubs.Condition;
import com.bluecc.hubs.fund.pubs.Eca;
import com.bluecc.hubs.fund.pubs.Ecas;
import com.bluecc.hubs.stub.Envelope;
import com.bluecc.hubs.stub.StringValue;
import com.bluecc.income.dummy.store.StoreModule;
import com.google.common.collect.Maps;
import com.google.inject.Injector;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mvel2.MVEL;
import org.reflections.Reflections;

import java.io.Serializable;
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

@Slf4j
public class EcasManager {
    private static final Injector injector = StoreModule.startup();

    public static void main(String[] args) {
        EcasManager ecasManager = new EcasManager();
        Reflections reflections = new Reflections("com.bluecc.income.procs");
        Set<Class<?>> annotated =
                reflections.get(SubTypes.of(TypesAnnotated.with(Ecas.class)).asClass());
        annotated.forEach(e -> {
            System.out.println(e.getName());
            ecasManager.registerFn(injector.getInstance(e));
        });

        // fire one
        Object result=ecasManager.process("info",
                StringValue.newBuilder().setValue("hi").build());
        System.out.println("response: "+result);
        result=ecasManager.process("info",
                StringValue.newBuilder().setValue("hello").build());
        System.out.println("response: "+result);
    }

    Map<String, FireProc> syncs = Maps.newConcurrentMap();
    Map<String, FireJob> asyncs = Maps.newConcurrentMap();

    @Data
    @Builder
    public static class FireProc {
        Function<Object, Object> fn;
        Type[] typeArguments;
        Serializable conditionExpr; // compiled expression
    }

    @Data
    @Builder
    public static class FireJob {
        Consumer<Object> fn;
        Type[] typeArguments;
        Serializable conditionExpr;
    }

    public void registerFn(Object... fnList) {
        for (Object fn : fnList) {
            for (Method method : fn.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Eca.class)) {
                    String returnType = method.getReturnType().getSimpleName();
                    if (returnType.equals("Function")) {
                        registerSyncMethod(fn, method);
                    } else if (returnType.equals("Consumer")) {
                        registerAsyncMethod(fn, method);
                    } else {
                        throw new RuntimeException("Cannot register fn with type " + returnType);
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
                    .conditionExpr(compileCondition(method))
                    .build());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Cannot register fn " + method.getName());
        }
    }

    private Serializable compileCondition(Method method) {
        Condition cond= method.getAnnotation(Condition.class);
        if(cond!=null){
            return MVEL.compileExpression(cond.value());
        }
        return null;
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
                    .conditionExpr(compileCondition(method))
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

    public Object process(String procName, Object message) {
        if (procName.contains("|")) {
            return processFilter(procName.split("\\|"), message);
        }

        FireProc proc = syncs.get(procName);
        if (proc != null) {
            return executeProc(message, proc.fn, proc.conditionExpr);
        } else {
            log.warn("Cannot handle " + procName);
        }
        return Envelope.newBuilder().setDataType("fail").build();
    }

    private Object executeProc(Object message, Function<Object, Object> fn, Serializable conditionExpr) {
        boolean check = (boolean)MVEL.executeExpression(conditionExpr, message);
        if(check) {
            return fn.apply(message);
        }else{
            return Envelope.newBuilder().setDataType("unmatched").build();
        }
    }

    public Object processFilter(String[] procs, Object message) {
        FireProc proc = syncs.get(procs[0]);
        if (proc == null) {
            throw new RuntimeException("Cannot find function " + procs[0]);
        }
        Function<Object, Object> fn = proc.fn;
        for (int i = 1; i < procs.length; ++i) {
            FireProc nextProc = syncs.get(procs[i]);
            if (nextProc != null) {
                fn = fn.andThen(nextProc.fn);
            } else {
                throw new RuntimeException("Cannot find function " + procs[i]);
            }
        }
        return executeProc(message, fn, proc.conditionExpr);
    }
}

package com.bluecc.income.procs;

import com.bluecc.hubs.fund.pubs.Condition;
import com.bluecc.hubs.fund.pubs.Eca;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class AbstractFunctionManager {

    protected Map<String, EcasManager.FireProc> syncs = Maps.newConcurrentMap();
    protected Map<String, EcasManager.FireJob> asyncs = Maps.newConcurrentMap();


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

    public void registerFn(Class<? extends Annotation> annotationClass, Object... fnList) {
        for (Object fn : fnList) {
            for (Method method : fn.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotationClass)) {
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
    protected void registerSyncMethod(Object fn, Method method) {
        System.out.format("\t- %s: %s -> %s\n",
                method.getDeclaringClass().getSimpleName(),
                method.getName(),
                "sync");
        // Preconditions.checkArgument(returnType.equals("Function"),
        //         "Only register function with Bean annotation");

        Function<Object, Object> proc;
        try {
            Type[] actualTypeArguments = getTypeArguments(method);
            String fnTypes= Arrays.stream(actualTypeArguments)
                    .map(t -> t.getTypeName())
                    .collect(Collectors.joining(", "));
            log.debug("fn {} parameters: {}", method.getName(), fnTypes);
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
    protected void registerAsyncMethod(Object fn, Method method) {
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

    protected static Type[] getTypeArguments(Method method) {
        Type genericReturnType = method.getGenericReturnType();
        Type[] actualTypeArguments = null;
        if (genericReturnType instanceof ParameterizedType) {
            actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
        }
        return actualTypeArguments;
    }
}

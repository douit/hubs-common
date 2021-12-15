package com.bluecc.hubs.fund;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class FnUtil {

    @FunctionalInterface
    public interface CheckedFunction<T,R> {
        R apply(T t) throws Exception;
    }

    public static <T,R> Function<T,R> wrap(CheckedFunction<T,R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T> T uncheckCall(Callable<T> callable) {
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Type[] getActualTypeArguments(Method method){
        Type genericReturnType = method.getGenericReturnType();
        Type[] actualTypeArguments = null;
        if (genericReturnType instanceof ParameterizedType) {
            actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
        }
        return actualTypeArguments;
    }
}

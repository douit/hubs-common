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
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

@Slf4j
public class EcasManager extends AbstractFunctionManager{
    private static final Injector injector = StoreModule.startup();

    public static void main(String[] args) {
        EcasManager ecasManager = new EcasManager();
        Reflections reflections = new Reflections("com.bluecc.income.procs");
        Set<Class<?>> annotated =
                reflections.get(SubTypes.of(TypesAnnotated.with(Ecas.class)).asClass());
        annotated.forEach(e -> {
            System.out.println(e.getName());
            ecasManager.registerFn(Eca.class, injector.getInstance(e));
        });

        // fire one
        Object result=ecasManager.process("info",
                StringValue.newBuilder().setValue("hi").build());
        System.out.println("response: "+result);
        result=ecasManager.process("info",
                StringValue.newBuilder().setValue("hello").build());
        System.out.println("response: "+result);
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

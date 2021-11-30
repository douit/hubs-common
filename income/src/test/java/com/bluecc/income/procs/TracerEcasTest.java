package com.bluecc.income.procs;

import com.bluecc.hubs.stub.Envelope;
import com.bluecc.hubs.stub.StringValue;
import com.bluecc.income.GuiceTestRunner;
import com.google.protobuf.Message;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

import static org.junit.Assert.*;

@RunWith(GuiceTestRunner.class)
public class TracerEcasTest {
    @Inject
    TracerEcas tracerEcas;

    @Test
    @SuppressWarnings("unchecked")
    public void info() throws NoSuchMethodException {
        // Function<Integer, String> intToString = Object::toString;
        Method method=TracerEcas.class.getMethod("info");
        // Function<Message, Envelope> fn=tracerEcas.info();
        try {
            Function<Message, Envelope> fn=(Function<Message, Envelope>)method.invoke(tracerEcas);
            fn.apply(StringValue.newBuilder().setValue("hi").build());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
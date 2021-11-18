package com.bluecc.domain.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Inject;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class FireEventInterceptor implements MethodInterceptor {
    @Inject
    private IEventProvider eventProvider;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Fire annotation = method.getAnnotation(Fire.class);
        if (annotation == null) {
            return invocation.proceed();
        }

        String eventName=annotation.value().isEmpty()?method.getName():annotation.value();
        EventData eventData= EventData.builder()
                .eventName(eventName)
                .timestamp(LocalDateTime.now())
                .build();
        try {
            Object rv = invocation.proceed();
            eventProvider.onSuccess(eventData, rv);
            return rv;
        } catch (Exception e) {
            eventProvider.onFail(eventData, e);
            throw e;
        } finally {
            eventProvider.onEnd(eventData);
        }
    }
}

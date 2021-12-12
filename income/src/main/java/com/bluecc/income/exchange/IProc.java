package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.model.IModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jdbi.v3.core.Handle;
import org.reactivestreams.Subscriber;

public interface IProc {
    @Data
    @AllArgsConstructor
    public static class ProcContext{
        Handle handle;
        Subscriber<IModel<?>> subscriber;
        public <T> T attach(Class<T> extensionType) {
            return handle.attach(extensionType);
        }
    }
    void proc(ProcContext ctx);
}


package com.bluecc.income.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jdbi.v3.core.Handle;

public interface IProc {
    @Data
    @AllArgsConstructor
    public static class ProcContext{
        Handle handle;
    }
    void proc(ProcContext ctx);
}


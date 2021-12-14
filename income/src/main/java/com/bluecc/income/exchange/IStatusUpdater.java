package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.model.IModel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IStatusUpdater {
    CompletableFuture<List<IModel<?>>> run(IProc.ProcContext ctx);
}


package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.model.WithSuppliers;
import com.bluecc.income.model.ProductStore;

import java.util.Map;
import java.util.Set;

public interface IChainQuery<T extends WithSuppliers> {
    Map<String, T> chainQuery(IProc.ProcContext c, Set<String> incls);
}

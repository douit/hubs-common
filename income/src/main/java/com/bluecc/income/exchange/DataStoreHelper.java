package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.descriptor.INameSymbol;

import java.util.Map;

import static java.lang.String.format;

public class DataStoreHelper {
    public static Map<String, Object> queryMap(IProc.ProcContext c, INameSymbol symbol, Long id) {
        Map<String, Object> rec = c.getHandle()
                .createQuery(format("select * from %s where %s=:id",
                        symbol.getTable(), symbol.getTableKeys().get(0)))
                .bind("id", id)
                .mapToMap().one();
        return rec;
    }
}



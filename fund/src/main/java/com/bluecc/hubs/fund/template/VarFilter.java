package com.bluecc.hubs.fund.template;

import com.bluecc.hubs.fund.Util;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

public class VarFilter implements Filter {
    @Override
    public Object filter(Object o, JinjavaInterpreter jinjavaInterpreter, String... strings) {
        // Preconditions.checkNotNull(o, "filter object is null");
        if (o == null) {
            return "**NONE**";
        }
        return Util.toVarName(o.toString());
    }

    @Override
    public String getName() {
        return "varName";
    }
}
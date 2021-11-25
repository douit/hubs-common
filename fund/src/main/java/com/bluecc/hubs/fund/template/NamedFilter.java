package com.bluecc.hubs.fund.template;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

import java.util.function.Function;

public class NamedFilter implements Filter {
    String filterName;
    Function<Object, String> fn;
    public NamedFilter(String filterName, Function<Object, String> fn){
        this.filterName=filterName;
        this.fn=fn;
    }

    @Override
    public String getName() {
        return filterName;
    }

    @Override
    public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
        return fn.apply(var);
    }
}


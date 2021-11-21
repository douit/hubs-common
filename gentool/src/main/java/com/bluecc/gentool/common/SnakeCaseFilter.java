package com.bluecc.gentool.common;

import com.google.common.base.Preconditions;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

public class SnakeCaseFilter implements Filter {
    @Override
    public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
        Preconditions.checkNotNull(var, getName()+" object is null");
        return Util.toSnakecase(var.toString());
    }

    @Override
    public String getName() {
        return "snakeCase";
    }
}

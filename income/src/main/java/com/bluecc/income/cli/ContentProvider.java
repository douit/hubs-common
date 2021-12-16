package com.bluecc.income.cli;

import java.util.List;

public class ContentProvider implements IContentProvider {
    String name;
    String data;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public List<Object> getChildren() {
        return children;
    }

    List<Object> children;
}


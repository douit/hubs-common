package com.bluecc.hubs.fund.descriptor;

import lombok.Getter;

import java.util.List;

public enum DummyNames implements INameSymbol{
    ADDRESS("Address", "Address entity"),
    TEL("Tel", "Phone number"),
    ;

    @Getter(onMethod_ = {@Override})
    public final String entityName;
    @Getter(onMethod_ = {@Override})
    public final String description;

    private DummyNames(String entityName, String description){
        this.entityName=entityName;
        this.description=description;
    }

    @Override
    public String[] getKeys() {
        return new String[0];
    }

    @Override
    public List<String> getTableKeys() {
        return null;
    }

    @Override
    public String getTable() {
        return null;
    }
}


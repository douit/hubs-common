package com.bluecc.gentool.descriptor;

import lombok.Getter;

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
}


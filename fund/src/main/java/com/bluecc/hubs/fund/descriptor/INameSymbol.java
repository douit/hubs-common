package com.bluecc.hubs.fund.descriptor;

import java.util.List;

public interface INameSymbol {
    String getEntityName();
    String getDescription();
    String[] getKeys();
    List<String> getTableKeys();
    String getTable();

    default boolean hasCombineKeys(){
        return getTableKeys().size()>1;
    }
}

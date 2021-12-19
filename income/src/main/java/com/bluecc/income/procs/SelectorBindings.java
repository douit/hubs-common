package com.bluecc.income.procs;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.jdbi.v3.core.statement.Query;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class SelectorBindings{
    @Singular
    Map<String, Object> mapBindings;
    @Singular
    Map<String, List<?>> listBindings;

    public Query enrich(Query selector){
        if(listBindings!=null) {
            listBindings.forEach((k, v) -> selector.bindList(k, v));
        }
        selector.bindMap(this.getMapBindings());
        return selector;
    }

    public static SelectorBindings of(String key, Object val){
        return SelectorBindings.builder()
                .mapBinding(key, val)
                .build();
    }

    public static SelectorBindings of(String key, Object val, String k2, Object v2){
        return SelectorBindings.builder()
                .mapBinding(key, val)
                .mapBinding(k2, v2)
                .build();
    }

    public static SelectorBindings stringList(String key, List<String> vals){
        return SelectorBindings.builder()
                .listBinding(key, vals)
                .build();
    }

    public static SelectorBindings EMPTY = SelectorBindings.builder().build();
}

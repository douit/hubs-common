package com.bluecc.hubs.fund.model;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public interface WithSuppliers {
    Map<String, Supplier<List<?>>> suppliers();
}

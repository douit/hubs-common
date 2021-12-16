package com.bluecc.income.cli;

import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.model.WithSuppliers;

import java.util.List;

public class Printers {

    public static void printChildren(WithSuppliers obj) {
        System.out.println(Util.toString(obj));
        String indent="\t";
        obj.suppliers().forEach((k, v)-> {
            List<?> values=v.get();
            if(!values.isEmpty()) {
                // System.out.println(k+": "+prettyJson(v.get()));
                System.out.println(indent+k + ": ");
                values.forEach(row -> {
                    System.out.println(indent+"\t" + Util.toString(row));
                });
            }
        });
    }
}

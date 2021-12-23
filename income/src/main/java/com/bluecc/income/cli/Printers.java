package com.bluecc.income.cli;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.fund.model.WithSuppliers;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Printers {

    public static void printChildren(WithSuppliers obj) {
        System.out.println(Util.toString(obj));
        String indent = "\t";
        obj.suppliers().forEach((k, v) -> {
            List<?> values = v.get();
            if (!values.isEmpty()) {
                // System.out.println(k+": "+prettyJson(v.get()));
                System.out.println(indent + k + ": ");
                values.forEach(row -> {
                    System.out.println(indent + "\t" + Util.toString(row));
                });
            }
        });
    }

    static final String DEFAULT_INDENT="  ";
    static String indent(int times){
        return StringUtils.repeat(DEFAULT_INDENT, times);
    }

    public static void printChildrenJson(WithSuppliers obj) {
        System.out.println(dataJsonString(obj, ""));
        obj.suppliers().forEach((k, v) -> {
            List<?> values = v.get();
            if (!values.isEmpty()) {
                // System.out.println(k+": "+prettyJson(v.get()));
                System.out.println(indent(1) + "Ⓜ️ "+k + ": ");
                values.forEach(row -> {
                    System.out.println(indent(2) + dataJsonString(row, indent(2)));
                });
            }
        });
    }

    static String dataString(Object obj, String indent){
        return ((IModel<?>)obj).toData().toString()
                .replaceAll("\n", "\n"+indent);
    }

    static String dataJsonString(Object obj, String indent){
        return ProtoJsonUtils.toJson(((IModel<?>)obj).toData())
                .replaceAll("\n", "\n"+indent);
    }
}

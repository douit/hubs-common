package com.bluecc.gentool.dummy;

import com.bluecc.gentool.common.Util;

import java.util.List;
import java.util.stream.Collectors;

public class SeedCollector {
    public static String dataFile = "dataset/OrderDemoData.xml";

    static List<String> entityList() {
        return SeedReader.collectEntityNames(dataFile).stream()
                .map(e -> Util.toSnakecase(e))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SeedReader.collectEntityNames(dataFile)
                .forEach(e -> System.out.println(e));
    }
}

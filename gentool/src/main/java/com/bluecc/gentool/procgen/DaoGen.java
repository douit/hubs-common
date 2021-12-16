package com.bluecc.gentool.procgen;

import com.bluecc.hubs.fund.TemplateUtil;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;

public class DaoGen {
    public static void main(String[] args) throws IOException {
        Descriptors descriptors = new Descriptors();

        String code=TemplateUtil.build("templates/dao.j2",
                ImmutableMap.of("ds",
                        descriptors.paramObjects()));
        System.out.println(code);

    }
}

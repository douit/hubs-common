package com.bluecc.gentool.procgen;

import com.bluecc.hubs.fund.TemplateUtil;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;

public class DescriptorsGen {
    public static void main(String[] args) throws IOException {
        Descriptors descriptors = new Descriptors();

        String code=TemplateUtil.build("templates/show_descriptors.j2",
                ImmutableMap.of("ds",
                        descriptors.paramObjects()));
        System.out.println(code);

    }
}

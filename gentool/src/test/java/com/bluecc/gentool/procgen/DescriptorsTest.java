package com.bluecc.gentool.procgen;

import org.junit.Test;

import static org.junit.Assert.*;

public class DescriptorsTest {

    @Test
    public void paramObjects() {
        Descriptors descriptors = new Descriptors();
        descriptors.paramObjects().items.stream()
                .filter(e -> e.name.equals("Customer"))
                .map(e -> String.join(", ", e.attrs))
                .forEach(e -> System.out.println(e));
    }
}
package com.bluecc.gentool.procgen;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import org.junit.Test;

import java.util.stream.Collectors;

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

    @Test
    public void paramFields() {
        Descriptors descriptors = new Descriptors();
        descriptors.paramObjects().items.stream()
                .filter(e -> e.name.equals("CustomerParams"))
                .map(e -> e.sigulars.stream()
                        .filter(s -> s== EntityNames.Person)
                        .flatMap(s -> s.getFields().stream())
                        .collect(Collectors.toList()))
                .forEach(e -> System.out.println(e));
    }
}
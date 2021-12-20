package com.bluecc.hubs.fund;

import org.junit.Test;

import static org.junit.Assert.*;

public class InflectorTest {

    @Test
    public void pluralize() {
        System.out.println(Inflector.getInstance().pluralize("work_effort"));
        System.out.println(Inflector.getInstance().pluralize("party"));
        System.out.println(Inflector.getInstance().pluralize("person"));
    }
}
package com.bluecc.hubs.fund;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigLoadersTest {

    @Test
    public void getExportTypes() {
        new ConfigLoaders().getExportTypes().forEach(e -> System.out.println(e));
    }
}
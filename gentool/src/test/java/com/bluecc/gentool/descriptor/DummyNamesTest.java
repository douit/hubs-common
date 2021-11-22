package com.bluecc.gentool.descriptor;

import com.bluecc.hubs.fund.descriptor.DummyNames;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyNamesTest {

    @Test
    public void values() {
        DummyNames symbol=DummyNames.ADDRESS;
        System.out.println(symbol.getEntityName());
    }
}


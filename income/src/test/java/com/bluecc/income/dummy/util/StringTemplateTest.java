package com.bluecc.income.dummy.util;

import org.junit.Test;
import org.stringtemplate.v4.ST;

import static org.junit.Assert.assertEquals;

public class StringTemplateTest {
    @Test
    public void testSimple(){
        ST hello = new ST("Hello, <name>");
        hello.add("name", "World");
        System.out.println(hello.render());
    }

    @Test
    public void testTemplate(){
        ST st = new ST("<items:{it|<it.id>: <it.lastName>, <it.firstName>\n}>");
        st.addAggr("items.{ firstName ,lastName, id }", "Ter", "Parr", 99); // add() uses varargs
        st.addAggr("items.{firstName, lastName ,id}", "Tom", "Burns", 34);
        String expecting =
                "99: Parr, Ter\n"+
                        "34: Burns, Tom\n";
        assertEquals(expecting, st.render());
    }
}

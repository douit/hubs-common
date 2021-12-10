package com.bluecc.hubs.fund;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintersTest {
    @Test
    public void testPrint(){
        Printers.TreeNode node= Printers.TreeNode.builder()
                .name("family")
                .data("samlet's")
                .child(Printers.TreeNode.builder()
                        .name("house")
                        .data("wide")
                        .build())
                .child(Printers.TreeNode.builder()
                        .name("car")
                        .data("small")
                        .build())
                .build();
        System.out.println(node);
        // family samlet's
        // ├── house wide
        // └── car small

        System.out.println(node.toStringPrefix("//\t"));
    }

}
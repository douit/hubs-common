package com.bluecc.hubs.fund;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTransitionTest {

    @Test
    public void getTransitions() {
        ModelTransition modelTransition=new ModelTransition();
        ModelTransition.ObjectStatus statusTransitions= modelTransition.getTransitions("Order");
        assertNotNull(statusTransitions);
        System.out.println(statusTransitions
                .getTransitions()
                .getEventNames());
    }
}
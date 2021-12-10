package com.bluecc.hubs.fund;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTransitionTest {
    ModelTransition modelTransition=new ModelTransition();
    @Test
    public void getTransitions() {

        ModelTransition.ObjectStatus statusTransitions= modelTransition.getTransitions("Order");
        assertNotNull(statusTransitions);
        System.out.println(statusTransitions
                .getTransitions()
                .getEventNames());

        // test repeated events
        String state="ORDER_COMPLETED";
        statusTransitions.getTransitions()
                .getEventSources(state)
                .forEach(e -> System.out.println(e));
        assertEquals(2,
                statusTransitions.getTransitions()
                .getEventSources(state).size());

        System.out.println("test all states --------");
        for (String st : statusTransitions.getTransitions().getStates()) {
            System.out.println(st+": "+statusTransitions.getTransitions()
                    .getEventSources(st));
        }
    }

    @Test
    public void testStartEvent(){
        ModelTransition.ObjectStatus statusTransitions= modelTransition.getTransitions("Task");
        assertNotNull(statusTransitions);
        String firstState=statusTransitions.getTransitions().getStates().get(0);
        System.out.println(firstState);

        // System.out.println(statusTransitions.getStartEvent());
        assertEquals("DefaultStart", statusTransitions.getStartEvent());
    }

    @Test
    public void testEventPrefix(){
        ModelTransition.ObjectStatus statusTransitions= modelTransition.getTransitions("QuoteStatus");
        System.out.println(statusTransitions.getStartEvent());
        assertEquals("QUO", statusTransitions.getTransitions().getStatePrefix());

    }
}
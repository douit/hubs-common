package com.bluecc.hubs.fund;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Map;

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

    static final String DEFAULT_INDENT="  ";
    static String indent(int times){
        return StringUtils.repeat(DEFAULT_INDENT, times);
    }

    @Test
    public void testModelTransitionYaml(){
        // String objTrans="Order";
        String objTrans="Party";
        ModelTransition.ObjectStatus statusTransitions= modelTransition
                .getTransitions(objTrans);
        assertNotNull(statusTransitions);
        System.out.println(statusTransitions
                .getTransitions()
                .getEventNames());

        System.out.println("meshes:");
        // Map<String, Object> meshMap= Maps.newHashMap();
        // meshMap.put("start", statusTransitions.getStartEvent());
        int level=1;
        System.out.format("%s%s:\n", indent(level), Util.toVarName(objTrans));

        level++;
        System.out.format("%sstart: %s\n", indent(level),statusTransitions.getStartState());
        System.out.println(indent(level)+"states:");

        // for (String state : statusTransitions.getTransitions().states) {
        level++;
        for (String state : statusTransitions.getTransitions().getAvailableStates()) {
            String stateName=ModelTransition.toVar(state);
            System.out.println(indent(level)+stateName+":");
            // System.out.println("to:");
            int finalLevel = level+1;
            statusTransitions.getTransitions().getFromTransitions(state).forEach(chg ->{
                System.out.format("%s%s: %s\n", indent(finalLevel),
                        chg.getEventVarName(),
                        chg.getToHandler());
            });
        }
    }
}
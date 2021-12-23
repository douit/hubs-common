package com.bluecc.hubs.fund;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Paths;
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

    static void format(Writer writer, String format, Object...args) throws IOException {
        writer.append(String.format(format, args));
    }

    @Test
    public void testModelTransitionYaml() throws IOException {
        String objTrans="Order";
        // String objTrans="Party";
        StringWriter writer=new StringWriter();
        printTransitionsTo(objTrans, writer);

        writer.close();
        System.out.println(writer.toString());
    }

    @Test
    public void testModelTransitionYamlFile() throws IOException {
        String objTrans="Order";
        String targetPath=SystemDefs.prependHubsHome("asset/mesh");
        // String objTrans="Party";
        Writer writer=new FileWriter(Paths.get(targetPath, objTrans+".yml").toFile());
        printTransitionsTo(objTrans, writer);
        writer.close();
    }

    private void printTransitionsTo(String objTrans, Writer writer) throws IOException {
        ModelTransition.ObjectStatus statusTransitions= modelTransition
                .getTransitions(objTrans);
        assertNotNull(statusTransitions);
        System.out.println(statusTransitions
                .getTransitions()
                .getEventNames());

        writer.append("meshes:\n");
        // Map<String, Object> meshMap= Maps.newHashMap();
        // meshMap.put("start", statusTransitions.getStartEvent());
        int level=1;
        format(writer, "%s%s:\n", indent(level), Util.toVarName(objTrans));

        level++;
        format(writer, "%sstart: %s\n", indent(level),statusTransitions.getStartState());
        format(writer, indent(level)+"states:\n");

        // for (String state : statusTransitions.getTransitions().states) {
        level++;
        for (String state : statusTransitions.getTransitions().getAvailableStates()) {
            String stateName=ModelTransition.toVar(state);
            format(writer, indent(level)+stateName+":\n");
            // System.out.println("to:");
            int finalLevel = level+1;
            statusTransitions.getTransitions().getFromTransitions(state).forEach(chg ->{
                try {
                    format(writer, "%s%s: %s\n", indent(finalLevel),
                            chg.getEventVarName(),
                            chg.getToHandler());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }
}
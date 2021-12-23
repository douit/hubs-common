package com.bluecc.hubs.fund;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.MeshProfiles.containsMethodCall;
import static com.bluecc.hubs.fund.MeshProfiles.parseEvent;
import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class MeshProfilesTest {
    Yaml yaml=new Yaml();


    private MeshProfiles.MeshesProfile orderMeshes() throws FileNotFoundException {
        File simpleFile= SystemDefs.prependHubsHomeFile("asset/mesh/Order.yml");
        MeshProfiles.MeshesProfile profile=yaml.loadAs(new FileReader(simpleFile),
                MeshProfiles.MeshesProfile.class);
        return profile;
    }

    @Test
    public void testEventSources() throws FileNotFoundException {
        MeshProfiles.MeshesProfile profile = orderMeshes();
        MeshProfiles.MeshProfile mesh = profile.getMeshProfile("order");
        mesh.getMeshStates().forEach(st -> {
            System.out.println(st.stateName);
            st.getBranchList().forEach(b -> {
                System.out.format("\t%s - %s\n", b.getEvent().getEventName(), b.getTargetState());
            });
        });

        System.out.println("succ: "+mesh.getGraph().successors("orderHold"));
        System.out.println("pred: "+mesh.getGraph().predecessors("orderHold"));

        System.out.println("pred: "+mesh.getGraph().predecessors("orderCancelled"));
        System.out.println("all events ===> ");
        mesh.getGraph().predecessors("orderCancelled").forEach(st ->{
            System.out.println("orderCancelled -> "+ st);
            System.out.println("\t"+mesh.getGraph().edgeValue(st, "orderCancelled")
                    .orElse(null));
        });

        String stateName="orderCancelled";
        Set<String> collectEvts = mesh.getGraph().predecessors(stateName).stream()
                .map(st -> mesh.getGraph().edgeValue(st, stateName))
                .filter(o -> o.isPresent())
                .map(ev -> ev.get().getEventName())
                .collect(Collectors.toSet());
        System.out.println(collectEvts);

        //
        assertThat(mesh.getEventSources(stateName)).containsOnly("orderCancelled", "cancelOrder");
    }

    @Test
    public void loadBranches() throws FileNotFoundException {
        MeshProfiles.MeshesProfile profile = sampleMeshes();
        MeshProfiles.MeshProfile dummyStore=profile.getMeshProfile("dummyStore");
        dummyStore.getMeshStates().forEach(st -> {
            System.out.println(st.stateName);
            st.getBranchList().forEach(b -> {
                System.out.format("\t%s - %s\n", b.getEvent().getEventName(), b.getTargetState());
            });
        });

        System.out.println(dummyStore.getGraph().successors("openning"));
        assertTrue(dummyStore.getGraph().hasEdgeConnecting("opened", "ordering"));
        assertFalse(dummyStore.getGraph().hasEdgeConnecting("opened", "openning"));
    }

    @Test
    public void loadMap() throws FileNotFoundException {
        MeshProfiles.MeshesProfile profile = sampleMeshes();
        // Map<String, Object> orderingProfile=(Map<String, Object>)profile.getMeshProfile("dummyStore")
        //         .getStates().get("orderingProfile");
        // System.out.println(orderingProfile.keySet());

        // System.out.println(orderingProfile.get("forward").getClass().getName());
        // processForward("forward", (List<String>)orderingProfile.get("forward"));

        // branches
        MeshProfiles.MeshProfile dummyStore=profile.getMeshProfile("dummyStore");
        Map<String, Object> branches=dummyStore.getRawBranches("ordering");
        System.out.println("state ordering -> ");
        branches.forEach((k, v) ->{
            System.out.println("\t- "+k+" => "+v);
        });
        // dummyStore.setBranchList(branches.entrySet().stream().map(e ->{
        //     return new MeshProfiles.Branch(parseEvent(e.getKey()),
        //             e.getValue().toString());
        // }).collect(Collectors.toList()));

        pretty(dummyStore);

        // dummyStore.setProfileList(dummyStore.getProfiles().stream().map(e -> {
        //     MeshProfiles.StateProfile stateProfile=new MeshProfiles.StateProfile();
        //     return stateProfile;
        // }).collect(Collectors.toList()));
        System.out.println("--------------------");
        dummyStore.getProfiles().forEach(p -> pretty(p));
    }


    private MeshProfiles.MeshesProfile sampleMeshes() throws FileNotFoundException {
        File simpleFile=SystemDefs.prependHubsHomeFile("asset/mesh/draft.yml");
        MeshProfiles.MeshesProfile profile=yaml.loadAs(new FileReader(simpleFile),
                MeshProfiles.MeshesProfile.class);
        return profile;
    }

    // private void processForward(String name, List<String> forward) {
    //     Preconditions.checkArgument(forward.size()==3,
    //             "Invalid forward config: %s", forward);
    //     System.out.println(new MeshProfiles.ForwardProfile(
    //             forward.get(0),
    //             forward.get(1),
    //             forward.get(2)));
    // }

    @Test
    public void testMethodParse(){
        MeshProfiles.EventProfile event=new MeshProfiles.EventProfile();
        assertTrue(containsMethodCall("processorComplete(orderId, status)", event));
        System.out.println(event);
        event=new MeshProfiles.EventProfile();
        assertTrue(containsMethodCall("if(afterTime('10'))", event));
        System.out.println(event);
        boolean isInvoke=containsMethodCall("processorComplete", event);
        assertFalse(isInvoke);
    }

    @Test
    public void loadWorkflows() throws FileNotFoundException {
        MeshProfiles.MeshesProfile profile = sampleMeshes();
        MeshProfiles.WorkflowProfile workflowProfile=profile.getWorkflows().get("order");
        workflowProfile.getSequence().forEach(s ->{
            System.out.println(s.getClass().getSimpleName()+": "+s);
            if(s instanceof Map){
                System.out.println("\tsignal: "+joinString(((Map<?, ?>) s).get("enter")));
            }
        });
    }

    @SuppressWarnings("unchecked")
    private String joinString(Object enter) {
        if(enter instanceof List){
            return String.join("|", (List<String>)enter);
        }else{
            return enter.toString();
        }
    }
}



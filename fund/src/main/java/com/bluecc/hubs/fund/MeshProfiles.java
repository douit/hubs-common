package com.bluecc.hubs.fund;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import lombok.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MeshProfiles {

    @Data
    public static class MeshesProfile {
        Map<String, MeshProfile> meshes;
        Map<String, WorkflowProfile> workflows;
        public MeshProfile getMeshProfile(String name){
            return meshes.get(name);
        }
    }

    @Data
    public static class WorkflowProfile{
        Map<String, Object> start;
        List<Object> sequence;
        Map<String, Object> stats;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @SuppressWarnings("unchecked")
    public static class MeshProfile{
        String start;
        String entity;
        Map<String, Object> states;
        @ToString.Exclude
        MutableValueGraph<String, EventProfile> g;

        List<MeshState> _stateList;
        List<StateProfile> _profileList;

        public MutableValueGraph<String, EventProfile> getGraph(){
            if(g==null){
                g = ValueGraphBuilder.directed().allowsSelfLoops(true).build();
                getMeshStates().forEach(st -> {
                    st.getBranchList().forEach(b -> {
                        g.putEdgeValue(st.stateName, b.getTargetState(), b.getEvent());
                    });
                });
            }
            return g;
        }

        public List<String> getStateItemNames(){
            return states.keySet().stream()
                    .filter(f -> !f.endsWith("Profile"))
                    .collect(Collectors.toList());
        }

        public List<MeshState> getMeshStates(){
            if(_stateList==null) {
                _stateList= getStateItemNames().stream().map(name ->
                                new MeshState(name, getRawBranches(name)))
                        .collect(Collectors.toList());
            }
            return _stateList;
        }

        public List<StateProfile> getProfiles(){
            if(_profileList==null) {
                _profileList= states.keySet().stream()
                        .filter(f -> f.endsWith("Profile"))
                        .map(f -> new StateProfile(f, (Map<String, List<String>>) states.get(f)))
                        .collect(Collectors.toList());
            }
            return _profileList;
        }

        public Map<String, Object> getRawBranches(String stateName){
            return (Map<String, Object>)states.get(stateName);
        }

        public Set<String> getTargetStates(String state){
            return getGraph().successors(state);
        }

        public boolean isConnected(String from, String to){
            return getGraph().hasEdgeConnecting(from, to);
        }

        public Optional<EventProfile> getBranchEvent(String from, String to){
            return getGraph().edgeValue(from, to);
        }

        public MeshState getMeshState(String stateName){
            return getMeshStates().stream().filter(m -> m.getStateName().equals(stateName))
                    .findFirst().orElse(null);
        }

        public Set<String> getEventSources(String stateName){
            return this.getGraph().predecessors(stateName).stream()
                    .map(st -> getGraph().edgeValue(st, stateName))
                    .filter(o -> o.isPresent())
                    .map(ev -> ev.get().getEventName())
                    .collect(Collectors.toSet());
        }
    }

    @Data
    public static class MeshState{
        String stateName;
        List<Branch> branchList;

        public MeshState(String name, Map<String, Object> rawBranches) {
            this.stateName=name;
            if(rawBranches==null){
                this.branchList=Lists.newArrayList();
            }else {
                setBranchList(rawBranches.entrySet().stream().map(e -> {
                    return new MeshProfiles.Branch(parseEvent(e.getKey()),
                            e.getValue().toString());
                }).collect(Collectors.toList()));
            }
        }

        public boolean hasBranch(){
            return !branchList.isEmpty();
        }
    }

    @Data
    @AllArgsConstructor
    public static class Branch{
        EventProfile event;
        String targetState;
    }

    @Data
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EventProfile{
        String eventExpression;
        String keyword;
        String methodName;

        List<String> parameters= Lists.newArrayList();

        public boolean isSymbol(){
            return Util.isEmpty(methodName);
        }

        public boolean isCondition(){
            return Util.isNotEmpty(keyword);
        }
        public String getEventName(){
            if(isSymbol()){
                return eventExpression;
            }else if(isCondition()){
                return keyword;
            }else{
                return methodName;
            }
        }

        public void setParametersByString(String parameters){
            this.parameters.addAll(Arrays.stream(parameters.split(","))
                    .map(p -> p.trim())
                    .collect(Collectors.toList()));
        }
    }

    @Data
    public static class StateProfile{
        String profileName;
        String stateName;
        List<IStateProfileItem> profiles=Lists.newArrayList();

        public StateProfile(String profileName, Map<String, List<String>> stringListMap) {
            this.profileName=profileName;
            this.stateName=profileName.substring(0, profileName.indexOf("Profile"));
            stringListMap.forEach((k,v)->{
                switch (k){
                    case "enter":
                        Preconditions.checkArgument(v.size()==2, "2 parameters");
                        profiles.add(new EnterProfile(v.get(0), v.get(1)));
                        break;
                    case "timeout": profiles.add(new Timeout(v.get(0), v.get(1))); break;
                    default:
                        // forward and others
                        parseProfileConfig(k, v);
                }
            });
        }

        private void parseProfileConfig(String expr, List<String> pars) {
            profiles.add(new ActionProfile(parseEvent(expr), pars));
        }
    }

    public interface IStateProfileItem{
        String getName();
    }

    @Data
    @AllArgsConstructor
    public static class ActionProfile implements IStateProfileItem{
        public String getName(){
            return event.methodName;
        }
        EventProfile event;
        List<String> parameters;
    }

    @Data
    @AllArgsConstructor
    public static class EnterProfile implements IStateProfileItem{
        public String getName(){
            return "enter";
        }
        String processor;
        String invoke;
    }

    @Data
    @AllArgsConstructor
    public static class Timeout implements IStateProfileItem{
        public String getName(){
            return "timeout";
        }
        String timeExpr;
        String branch;
    }


    public static MeshProfiles.EventProfile parseEvent(String key) {
        MeshProfiles.EventProfile event=new MeshProfiles.EventProfile();
        event.setEventExpression(key);
        containsMethodCall(key, event);
        return event;
    }

    /**
     * Matches strings like {@code obj.myMethod(params)} and
     * {@code if (something)} Remembers what's in front of the parentheses and
     * what's inside.
     * <p>
     * {@code (?U)} lets {@code \\w} also match non-ASCII letters.
     */
    public static final Pattern PARENTHESES_REGEX = Pattern
            .compile("(?U)([.\\w]+)\\s*\\((.*)\\)");

    /*
     * After these Java keywords may come an opening parenthesis.
     */
    private static final List<String> keyWordsBeforeParens = Arrays.asList("while", "for",
            "if", "try", "catch", "switch");

    public static boolean containsMethodCall(final String s, MeshProfiles.EventProfile event) {
        final Matcher matcher = PARENTHESES_REGEX.matcher(s);

        while (matcher.find()) {
            final String beforeParens = matcher.group(1);
            final String insideParens = matcher.group(2);
            if (keyWordsBeforeParens.contains(beforeParens)) {
                // System.out.println("Keyword: " + beforeParens);
                event.setKeyword(beforeParens);
                // System.out.println("- method call: "+insideParens);
                return containsMethodCall(insideParens, event);
            } else {
                // System.out.println("Method name: " + beforeParens);
                // System.out.println("- params: "+insideParens);
                event.setMethodName(beforeParens);
                event.setParametersByString(insideParens);
                return true;
            }
        }
        return false;
    }

}

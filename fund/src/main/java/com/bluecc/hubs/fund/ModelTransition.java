package com.bluecc.hubs.fund;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Data;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class ModelTransition {
    Map<String, ObjectStatus> transitionsMap = Maps.newHashMap();

    public ObjectStatus getTransitions(String name) {
        ObjectStatus transitions = transitionsMap.get(name);
        if (transitions == null) {
            transitions = loadFromAsset(name);
            transitionsMap.put(name, transitions);
        }
        return transitions;
    }

    public ObjectStatus loadFromAsset(String name) {
        try {
            return ObjectStatus.builder()
                    .name(name)
                    .transitions(
                            Util.readJsonFile(StatusTransitions.class,
                                    SystemDefs.prependHubsHomeFile("asset/transitions/" + name + ".json")))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Data
    @Builder
    public static class ObjectStatus {
        String name;
        String defaultHandler;
        StatusTransitions transitions;

        public String getStartState(){
            return transitions.getStateNames().get(0);
        }

        public String getStartEvent(){
            return transitions.getEventSource(transitions.states.get(0));
        }

        public String getClassName(){
            return name.replaceAll("[\\-]", "");
        }
    }

    static String toVar(String s){
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, s);
    }

    @Data
    @Builder
    public static class StatusTransitions {
        Set<String> events;
        List<String> states;
        List<StatusValidChange> transitions;

        public Set<String> getEventNames(){
            return events.stream().map(e -> Util.wordsToClassName(e))
                    .collect(Collectors.toSet());
        }

        public Set<String> getEventSources(String state) {
            Set<String> sources= transitions.stream()
                    .filter(s -> s.getStatusIdTo().equals(state))
                    .map(s -> s.getEventName()).collect(Collectors.toSet());
            if(sources.isEmpty()){
                sources.add("DefaultStart");
            }
            return sources;
        }

        public String getEventSource(String state){
            return transitions.stream().filter(s -> s.getStatusIdTo().equals(state))
                    .map(s -> s.getEventName())
                    .findFirst()
                    .orElse("DefaultStart");
        }

        public List<String> getStateNames(){
            return states.stream().map(e -> toVar(e))
                    .collect(Collectors.toList());
        }

        public List<String> getAvailableStates(){
            Set<String> allStatus= Sets.newHashSet();
            for (StatusValidChange transition : transitions) {
                allStatus.add(transition.getStatusId());
                allStatus.add(transition.getStatusIdTo());
            }
            return allStatus.stream().sorted().collect(Collectors.toList());
        }

        public List<StatusValidChange> getFromTransitions(String state){
            return transitions.stream().filter(f -> f.statusId.equals(state))
                    .collect(Collectors.toList());
        }

        public boolean hasTransitions(String state){
            return !getFromTransitions(state).isEmpty();
        }

        public static StatusTransitions createBy(List<StatusValidChange> transitions,
                                                 List<String> statusItems) {
            return StatusTransitions.builder()
                    .events(transitions.stream().map(t -> t.transitionName)
                            .collect(Collectors.toSet()))
                    .transitions(transitions)
                    .states(statusItems)
                    .build();
        }
    }

    @Data
    @Builder
    public static class StatusType {
        // description="Project" hasTable="N" parentTypeId="WORK_EFFORT_STATUS"
        // statusTypeId="WE_PROJECT_STATUS"
        String description;
        String statusTypeId;
        String parentTypeId;

        public String getClassName() {
            return Util.wordsToClassName(description);
        }
    }

    @Data
    @Builder
    public static class StatusItem {
        // description="Planning" sequenceId="01" statusCode="PLANNING"
        // statusId="WEPR_PLANNING" statusTypeId="WE_PROJECT_STATUS"
        String statusId;
        String description;
        String sequenceId;
        String statusCode;
        String statusTypeId;
    }

    @Data
    @Builder
    public static class StatusValidChange {
        // statusId="WEPR_PLANNING" statusIdTo="WEPR_IN_PROGRESS" transitionName="Begin Project"
        String statusId;
        String statusIdTo;
        String transitionName;

        public String getEventName(){
            return Util.wordsToClassName(transitionName);
        }
        public String getToHandler(){
            return toVar(statusIdTo);
        }
        public String getFromHandler(){
            return toVar(statusId);
        }

        public StatusItem from;
        public StatusItem to;
        public StatusType statusType;

    }


}

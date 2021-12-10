package com.bluecc.gentool;

import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.Printers;

import java.util.List;
import java.util.stream.Collectors;

public class MeshPrinter {
    public static void main(String[] args) {
        ModelTransition modelTransition = new ModelTransition();
        ModelTransition.ObjectStatus statusTransitions =
                modelTransition.getTransitions("QuoteStatus");
        System.out.println(statusTransitions.getStartEvent());

        ModelTransition.StatusTransitions mesh = statusTransitions.getTransitions();
        mesh.getStates().forEach(state -> {
            System.out.println(statusTransitions.getStateComments(state));
        });
    }

}

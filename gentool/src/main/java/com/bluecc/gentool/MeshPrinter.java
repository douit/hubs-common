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
            Printers.TreeNode node = Printers.TreeNode.builder()
                    .name(statusTransitions.getName())
                    .data(state)
                    .children(
                            collectToTreeNodes(mesh, state))
                    .build();

            System.out.println(node.toStringPrefix("//\t"));
        });
    }

    private static List<Printers.TreeNode> collectToTreeNodes(ModelTransition.StatusTransitions mesh, String state) {
        return mesh.getFromTransitions(state)
                .stream()
                .map(change -> Printers.TreeNode.builder()
                        .name(change.getTransitionName())
                        .data(change.getTo().getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}

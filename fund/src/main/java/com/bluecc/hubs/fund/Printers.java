package com.bluecc.hubs.fund;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Iterator;
import java.util.List;

public class Printers {
    @Data
    @Builder
    public static class TreeNode {

        private String name;
        private Object data;
        @Singular
        private List<TreeNode> children;

        public String toString() {
            StringBuilder buffer = new StringBuilder();
            print(buffer, "", "");
            return buffer.toString();
        }

        public String toStringPrefix(String prefix) {
            StringBuilder buffer = new StringBuilder();
            print(buffer, prefix, prefix);
            return buffer.toString();
        }

        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(name);
            buffer.append(": ").append(data);
            buffer.append('\n');
            for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
                TreeNode next = it.next();
                if (it.hasNext()) {
                    next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
                } else {
                    next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }
}

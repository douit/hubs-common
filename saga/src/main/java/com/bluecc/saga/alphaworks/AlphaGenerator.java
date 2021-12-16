package com.bluecc.saga.alphaworks;

import com.beust.jcommander.JCommander;
import com.bluecc.hubs.fund.Printers;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.pubs.Exclude;
import com.bluecc.hubs.fund.pubs.Persist;
import com.bluecc.hubs.fund.pubs.StatusUpdater;
import com.bluecc.income.procs.Invoices;
import com.bluecc.income.procs.Orders;
import com.google.common.collect.ImmutableMap;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * $ just saga AlphaGenerator
 */
public class AlphaGenerator {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @com.beust.jcommander.Parameter(names = {"--silent", "-s"})
        boolean silent=false;
    }

    static boolean verbose=false;
    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        genClasses(opts, Orders.class, Invoices.class);
    }

    private static void genClasses(Opts opts, Class<?>... classes) throws IOException {
        for (Class<?> clz : classes) {
            ExecutorInfo info = extractClassInfo(clz);
            // pretty(info);
            if(!opts.silent) {
                System.out.println(info.asTreeNode().toString());
            }

            String cnt = TemplateUtil.build("templates/actor_wrapper.j2",
                    ImmutableMap.of("obj", info));
            // System.out.println(cnt);
            String targetDir = "saga/src/main/java/com/bluecc/saga/meshes";
            Path targetFile = Paths.get(targetDir,
                    String.format("%sManipulator.java", info.name));
            Util.writeFile(cnt, targetFile);
        }
    }

    public enum ExecuteType{
        Persist, StatusUpdater
    }

    @Data
    @Builder
    public static class ExecutorInfo{
        String name;
        @Singular
        List<ExecuteInfo> processors;

        public Printers.TreeNode asTreeNode() {
            return Printers.TreeNode.builder()
                    .name(name)
                    .data(String.format("total %d", processors.size()))
                    .children(processors.stream()
                            .map(p -> p.asTreeNode())
                            .collect(Collectors.toList()))
                    .build();
        };
    }

    @Data
    @Builder
    public static class ExecuteInfo{
        @SerializedName("execute_type")
        ExecuteType executeType;
        String name;
        List<ParamInfo> params;

        public String getClassName(){
            return Util.toClassName(name);
        }

        public Printers.TreeNode asTreeNode(){
            return Printers.TreeNode.builder()
                    .name(wrapIcon(name))
                    .data(executeType)
                    .children(requireNonNull(params).stream()
                            .map(p -> Printers.TreeNode.builder()
                                    .name(p.getName())
                                    .data(p.getTypeName())
                                    .build())
                            .collect(Collectors.toList()))
                    .build();
        }

        private String wrapIcon(String name) {
            switch (executeType){
                case Persist:
                    return "🆕 "+name;
                case StatusUpdater:
                    return "Ⓜ️ "+name;
            }
            return name;
        }
    }

    @Data
    @Builder
    public static class ParamInfo{
        @Exclude
        Class<?> clazz;
        String name;
        @SerializedName("type")
        String typeName;
    }

    private static ExecutorInfo extractClassInfo(Class<?> clz) {
        ExecutorInfo.ExecutorInfoBuilder executorInfo= ExecutorInfo.builder()
                .name(clz.getSimpleName());

        for (Method method : clz.getDeclaredMethods()) {
            ExecuteInfo.ExecuteInfoBuilder builder= ExecuteInfo.builder()
                    .name(method.getName());

            // System.out.println(method.getName());
            if(method.isAnnotationPresent(Persist.class)){
                // System.out.println("\t"+"persist");
                extractMethodInfo(method);
                builder.executeType(ExecuteType.Persist)
                        .params(extractMethodInfo(method));
                executorInfo.processor(builder.build());
            }else {
                StatusUpdater statusUpdater = method.getAnnotation(StatusUpdater.class);
                if (statusUpdater != null) {
                    // System.out.format("\tstatus-updater: %s\n", statusUpdater.value());
                    extractMethodInfo(method);

                    builder.executeType(ExecuteType.StatusUpdater)
                            .params(extractMethodInfo(method));
                    executorInfo.processor(builder.build());
                }
            }

        }
        return executorInfo.build();
    }

    private static List<ParamInfo> extractMethodInfo(Method method) {
        if(verbose) {
            for (Parameter parameter : method.getParameters()) {
                System.out.format("\t- %s | %s\n", parameter.getType().getName(),
                        parameter.getName());
            }
        }
        return Arrays.stream(method.getParameters())
                .map(p -> ParamInfo.builder()
                        .clazz(p.getType())
                        .typeName(p.getType().getSimpleName())
                        .name(p.getName())
                        .build())
                .collect(Collectors.toList());

    }
}

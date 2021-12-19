package com.bluecc.hubs.fund;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SystemDefs {
    public static final String HUBS_COMMON_HOME = "/opt/app/hubs-common";

    public static String prependHubsHome(String fileOrDir) {
        return HUBS_COMMON_HOME + "/" + fileOrDir;
    }

    public static String prependApiHome(String fileOrDir) {
        return "/opt/app/apiset/" + fileOrDir;
    }

    public static String protoDir() {
        return prependApiHome("entity/src/main/proto");
    }

    public static String facadeProtoDir() {
        return prependApiHome("facade/src/main/proto");
    }

    public static Path getFacadeTypesProtoFile(){
        return Paths.get(facadeProtoDir(), "facade_types.proto");
    }

    public static File prependHubsHomeFile(String fileOrDir) {
        return new File(HUBS_COMMON_HOME + "/" + fileOrDir);
    }

    public static File prependHubsHomeFile(File fileOrDir) {
        return new File(HUBS_COMMON_HOME + "/" + fileOrDir);
    }
}


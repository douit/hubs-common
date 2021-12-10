package com.bluecc.hubs.fund;

import java.io.File;

public class SystemDefs {
    public static final String HUBS_COMMON_HOME="/opt/app/hubs-common";
    public static String prependHubsHome(String fileOrDir){
        return HUBS_COMMON_HOME+"/"+fileOrDir;
    }
    public static String prependApiHome(String fileOrDir){
        return "/opt/app/apiset/"+fileOrDir;
    }

    public static File prependHubsHomeFile(String fileOrDir){
        return new File(HUBS_COMMON_HOME+"/"+fileOrDir);
    }

    public static File prependHubsHomeFile(File fileOrDir){
        return new File(HUBS_COMMON_HOME+"/"+fileOrDir);
    }
}


package com.bluecc.gentool;

import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Singleton
public class GenConfig {

    @Data
    public static class GenConf{
        private String modelDir;
        private String daoDir;
        private String daoTestDir;
    }

    public static void main(String[] args) throws IOException {
        GenConf conf=loadConfig();
        System.out.println(conf);
    }

    public GenConf getConf() {
        return conf;
    }

    GenConf conf;
    GenConfig() throws IOException {
        this.conf=loadConfig();
    }

    public static GenConf loadConfig() throws IOException {
        String cnt= Util.readFile("config/gen_conf.yml");
        Yaml yaml = new Yaml();
        GenConf obj = yaml.loadAs(cnt, GenConf.class);
        return obj;
    }

    public File prependModelFile(String fileName){
        return new File(SystemDefs.prependHubsHome(
                getConf().getModelDir()+"/"+fileName));
    }
    public File prependDaoFile(String fileName){
        return new File(SystemDefs.prependHubsHome(
                getConf().getDaoDir()+"/"+fileName));
    }

    public File prependDaoTestFile(String fileName){
        return new File(SystemDefs.prependHubsHome(
                getConf().getDaoTestDir()+"/"+fileName));
    }
}

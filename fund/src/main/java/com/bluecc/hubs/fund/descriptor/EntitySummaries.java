package com.bluecc.hubs.fund.descriptor;

import com.bluecc.hubs.fund.SystemDefs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EntitySummaries {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CommonUse {
        String entity;
        List<String> fields;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EntitySummary {
        List<CommonUse> commonUses;
    }

    public static final String SUMMARY_CFG= SystemDefs.prependHubsHome("asset/facts/common_use.yml");
    public static EntitySummary load() throws FileNotFoundException {
        Yaml yaml=new Yaml();
        return yaml.loadAs(new FileReader(SUMMARY_CFG), EntitySummary.class);
    }
}

package com.bluecc.gentool.procgen;

import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.gentool.dummy.SeedCollector.dataFile;
import static com.bluecc.hubs.fund.DataSetUtil.collectEntitiesFromResources;

public class ProcGen {

    public static void main(String[] args) throws IOException {
        startGen();
    }

    public static void startGen() throws IOException {
        Set<String> entityList = collectEntitiesFromResources();
        ProcGen procGen = new ProcGen();
        String code = procGen.gen(entityList);
        // System.out.println(code);

        //
        // File targetFile = SystemDefs.prependHubsHomeFile(
        //         "gentool/src/main/java/com/bluecc/gentool/descriptor/"
        //                 + "EntityNames.java");
        File targetFile = SystemDefs.prependHubsHomeFile(
                "fund/src/main/java/com/bluecc/hubs/fund/descriptor/EntityNames.java");
        Util.writeFile(code, targetFile);
    }

    EntityMetaManager entityMetaManager;

    ProcGen() {
        entityMetaManager = new EntityMetaManager();
    }

    String gen(Set<String> entityList) throws IOException {
        List<EntityMeta> metaList = entityList.stream()
                .sorted()
                .map(name -> entityMetaManager.readEntityMeta(name))
                .collect(Collectors.toList());
        Map<String, Object> ctx = ImmutableMap.of("ents", metaList);
        return TemplateUtil.build("templates/symbols.j2",
                ctx);
    }

}

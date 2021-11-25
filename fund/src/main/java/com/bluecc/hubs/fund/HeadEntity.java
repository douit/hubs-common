package com.bluecc.hubs.fund;

import lombok.Data;

import java.io.IOException;
import java.util.Map;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;

public class HeadEntity {
    @Data
    public static class HeadEntities{
        Map<String, EntityMeta.HeadEntity> entities;
    }

    private static HeadEntities headEntities;
    public static HeadEntities getHeadEntities()  {
        if(headEntities==null) {
            synchronized (HeadEntities.class) {
                try {
                    headEntities = Util.readJsonFile(HeadEntities.class,
                            prependHubsHomeFile("asset/facts/head_ents.json"));
                } catch (IOException e) {
                    throw new RuntimeException("Cannot read head-ents config", e);
                }
            }
        }
        return headEntities;
    }
}


package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMetaManager;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.google.inject.*;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.codec.KryoCodec;
import org.redisson.config.Config;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


import static com.bluecc.hubs.fund.SeedReader.*;
import static com.bluecc.hubs.fund.Util.GSON;

public class EntitySeeder {
    private static final Injector injector = Guice
            .createInjector(new AbstractModule() {
                @Override
                protected void configure() {
                    super.configure();
                    bind(EntityMetaManager.class).in(Scopes.SINGLETON);
                }
            });

    public static void main(String[] args) {

        EntitySeeder seeder=injector.getInstance(EntitySeeder.class);
        seeder.start();
        seeder.validate("ContactMechType");
        seeder.shutdown();
    }

    @Inject
    EntityMetaManager metaManager;
    RedissonClient redisson;

    EntitySeeder() {
        // Config config = new Config();
        // config.setCodec(new KryoCodec(Arrays.asList(EntityTypeKey.class, EntityTypeValue.class)))
        //         .useSingleServer().setAddress("127.0.0.1:6379");
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        redisson = Redisson.create(config);
    }

    void start() {
         String dataFile="dataset/seed/PartySeedData.xml";

         // clear
        Set<String> nameSet = collectEntityNames(dataFile);
        nameSet.forEach(name -> {
            RMap<String, String> rmap = redisson.getMap(name);
            rmap.clear();
        });

        // collect data
        Multimap<String, JsonObject> dataList= ArrayListMultimap.create();
        collectEntityData(dataList, dataFile);
        for (String key : dataList.keySet()) {
            Map<String, String> valueMap= Maps.newHashMap();
            for (JsonObject jsonObject : dataList.get(key)) {
                // pretty(jsonObject);
                String keyString=metaManager.getKeys(key).stream()
                        .map(k -> jsonObject.get(k).getAsString())
                        .collect(Collectors.joining(":"));
                String valString=GSON.toJson(jsonObject);
                // String buildKey=String.format("%s.%s = %s", key, keyString, valString);
                valueMap.put(keyString, valString);
                System.out.println(key+" -- "+keyString+": "+valString);
            }

            RMap<String, String> rmap = redisson.getMap(key);
            rmap.putAll(valueMap);
        }
    }

    void shutdown(){
        redisson.shutdown();
    }

    void validate(String entityName){
        System.out.println("----------- >>> "+entityName);
        RMap<String, String> rmap = redisson.getMap(entityName);
        rmap.forEach((key, value) -> System.out.println("***** "+key + ": " + value));
    }
}

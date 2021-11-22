package com.bluecc.gentool.dummy;

import com.bluecc.gentool.common.ServiceMeta;
import com.bluecc.gentool.common.ServiceMeta.*;
import com.bluecc.hubs.fund.EntityMeta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.bluecc.gentool.common.ServiceMeta.ServiceMode.*;
import static com.bluecc.gentool.common.ServiceMeta.ServiceMode.SYNC;
import static com.google.common.collect.Lists.newArrayList;

public class DummyMeta {
    public static final Gson GSON = new GsonBuilder()
            // .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
//             .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .setPrettyPrinting()
            .create();
    public static final EntityMeta partyMeta = EntityMeta.builder()
            .name("Party")
            .field(EntityMeta.FieldMeta.builder()
                    .name("partyId").type("id")
                    .javaType("String")
                    .build())
            .field(EntityMeta.FieldMeta.builder()
                    .name("lastName").type("string")
                    .javaType("String")
                    .build())
            .build();

    public static final ServiceMeta createPersonMeta = ServiceMeta.builder()
            .name("createPerson")
            .input(ParamMeta.builder()
                    .name("firstName").type("string")
                    .build())
            .input(ParamMeta.builder()
                    .name("lastName").type("string")
                    .build())
            .eca("commit", newArrayList(
                    Eca.builder()
                            .condition(EcaCondition.builder()
                                    .shortDisplayDescription("[]")
                                    .build())
                            .action(EcaAction.builder()
                                    .serviceName("createParty")
                                    .serviceMode(SYNC)
                                    .build())
                            .build()
            ))
            .build();

    public static void main(String[] args) {
        System.out.println(GSON.toJson(partyMeta));
        System.out.println(GSON.toJson(createPersonMeta));
    }
}


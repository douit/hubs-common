package com.bluecc.hubs.dummy;

import com.bluecc.domain.dummy.procs.PersonProcs;
import com.bluecc.domain.guice.ServiceModule;
import com.bluecc.domain.sql.model.Person;
import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.stub.PersonObject;
import com.bluecc.hubs.stub.PersonObjects;
import com.github.javafaker.Faker;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.bluecc.domain.util.JsonUtil.GSON;

public class DomainCli {
    private static final Injector injector = Guice
            .createInjector(new ServiceModule());

    public static void main(String[] args) {
        storeProc();

        PersonProcs procs = injector.getInstance(PersonProcs.class);
        List<Person> rs = procs.all();
        rs.forEach(e -> {
            System.out.println(e.getPartyId());

            System.out.println(GSON.toJson(e));

            PersonObjects personObjects=PersonObjects.newBuilder()
                    .addObjects(PersonObject.newBuilder()
                            .setPartyId(e.getPartyId())
                            .setFirstName(e.getFirstName())
                            .setLastName(e.getLastName())
                            .build())
                    .build();
            try {
                String jsonString=ProtoJsonUtils.toJson(personObjects);
                System.out.println(jsonString);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private static void storeProc() {
        Faker faker = new Faker(new Locale("zh-CN"));

        PersonProcs procs = injector.getInstance(PersonProcs.class);
        procs.jdbcHelper.truncate("person");

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setLastName(faker.name().lastName());
            p.setFirstName(faker.name().firstName());
            Long pid = procs.save(p);
            System.out.println("save ok: " + pid);
        }
    }
}



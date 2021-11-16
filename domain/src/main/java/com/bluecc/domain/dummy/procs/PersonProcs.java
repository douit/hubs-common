package com.bluecc.domain.dummy.procs;

// import com.alibaba.fastjson.JSON;
import com.bluecc.domain.dummy.guice.ServiceModule;
import com.bluecc.domain.dummy.guice.Transactional;
import com.bluecc.domain.dummy.repository.AbstractRepository;
import com.bluecc.domain.sql.model.Person;
import com.bluecc.domain.sql.model.User;
import com.bluecc.domain.util.JdbcHelper;
import com.bluecc.domain.util.Sequence;
import com.github.javafaker.Faker;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.querydsl.core.types.Predicate;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static com.bluecc.domain.sql.model.QUser.user;
import static com.bluecc.domain.sql.model.QPerson.person;
import static com.bluecc.domain.util.JsonUtil.GSON;

public class PersonProcs extends AbstractRepository {
    @Inject
    Sequence sequence;

    @Transactional
    public Person findById(String id) {
        return selectFrom(person).where(person.partyId.eq(id)).fetchOne();
    }

    @Transactional
    public String save(Person entity) {
        if (entity.getPartyId() != null) {
            update(person).populate(entity).execute();
            return entity.getPartyId();
        }

        // String uid=sequence.nextStringId();
        // entity.setPartyId(uid);
        // // return insert(person).populate(entity)
        // //         .executeWithKey(person.partyId);
        // // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        // insert(person).populate(entity)
        //         .executeWithKey(person.partyId);
        // return uid;

        String uid=sequence.nextStringId();
        entity.setPartyId(uid);
        return create(entity);
    }

    @Transactional
    public String create(Person entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(person).populate(entity)
                .executeWithKey(person.partyId);
        return entity.getPartyId();
    }

    @Transactional
    public List<Person> findAll(Predicate expr) {
        return selectFrom(person).where(expr).fetch();
    }

    @Transactional
    public List<Person> all() {
        return selectFrom(person).fetch();
    }

    private static final Injector injector = Guice
            .createInjector(new ServiceModule());

    @Data
    @Builder
    static class PersonDo{
        String partyId;
        String lastName;
        String fristName;
    }

    @Inject
    JdbcHelper jdbcHelper;
    public static void main(String[] args) {
        Faker faker;
        faker = new Faker(new Locale("zh-CN"));

        PersonProcs procs=injector.getInstance(PersonProcs.class);
        procs.jdbcHelper.truncate("person");

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setLastName(faker.name().lastName());
            p.setFirstName(faker.name().firstName());
            String pid = procs.save(p);
            System.out.println("save ok: " + pid);
        }

        List<Person> rs=procs.all();
        rs.forEach(e -> {
            // ?? 使用gson序列化的结果与直接获取bean的属性不一致,
            // 还是需要用transform提取字段值到dto中
            System.out.println(e.getPartyId());

            PersonDo pdo=PersonDo.builder()
                    .partyId(e.getPartyId())
                    .fristName(e.getFirstName())
                    .lastName(e.getLastName())
                    .build();

            System.out.println(GSON.toJson(e));
            System.out.println(GSON.toJson(pdo));
            // String jsonObject = JSON.toJSONString(e);
            // System.out.println(jsonObject);
        });
    }
}


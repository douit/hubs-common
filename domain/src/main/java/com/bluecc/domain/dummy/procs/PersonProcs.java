package com.bluecc.domain.dummy.procs;

import com.bluecc.domain.dummy.guice.ServiceModule;
import com.bluecc.domain.dummy.guice.Transactional;
import com.bluecc.domain.dummy.repository.AbstractRepository;
import com.bluecc.domain.sql.model.Person;
import com.bluecc.domain.sql.model.User;
import com.bluecc.domain.util.Sequence;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.querydsl.core.types.Predicate;

import java.util.List;
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

        // String uid=UUID.randomUUID().toString();
        String uid=sequence.nextStringId();
        entity.setPartyId(uid);
        // return insert(person).populate(entity)
        //         .executeWithKey(person.partyId);
        insert(person).populate(entity)
                .executeWithKey(person.partyId);
        return uid;
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

    public static void main(String[] args) {
        PersonProcs procs=injector.getInstance(PersonProcs.class);

        Person p=new Person();
        p.setLastName("Samlet");
        p.setFirstName("Wu");
        String pid=procs.save(p);
        System.out.println("save ok: "+pid);

        procs.all().forEach(e -> {
            // ?? 使用gson序列化的结果与直接获取bean的属性不一致,
            // 还是需要用transform提取字段值到dto中
            System.out.println(e.getPartyId());
            System.out.println(GSON.toJson(p));
        });
    }
}

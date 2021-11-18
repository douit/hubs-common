package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.dummy.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QPerson.person;

// Person
public class PersonRepository extends AbstractRepository {
    @Transactional
    public Long save(Person entity) {
        if (entity.getPartyId() != null) {
            update(person).populate(entity).execute();
            return entity.getPartyId();
        }
        return insert(person).populate(entity)
                .executeWithKey(person.partyId);
    }

    @Transactional
    public Person findById(Long id) {
        return selectFrom(person).where(person.partyId.eq(id)).fetchOne();
    }


    @Transactional
    public List<Person> findAll(Predicate expr) {
        return selectFrom(person).where(expr).fetch();
    }
}


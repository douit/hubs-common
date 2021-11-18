package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.dummy.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QParty.party;

// Party
public class PartyRepository extends AbstractRepository {
    @Transactional
    public Long save(Party entity) {
        if (entity.getPartyId() != null) {
            update(party).populate(entity).execute();
            return entity.getPartyId();
        }
        return insert(party).populate(entity)
                .executeWithKey(party.partyId);
    }

    @Transactional
    public Party findById(Long id) {
        return selectFrom(party).where(party.partyId.eq(id)).fetchOne();
    }


    @Transactional
    public List<Party> findAll(Predicate expr) {
        return selectFrom(party).where(expr).fetch();
    }
}


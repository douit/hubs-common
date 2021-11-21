package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;
import org.joda.time.DateTime;

import com.bluecc.domain.sql.model.*;
import com.querydsl.core.types.QBean;
import static com.querydsl.core.types.Projections.bean;

import static com.bluecc.domain.sql.model.QOrderRole.orderRole;

// Order Role
public class OrderRoleRepository extends AbstractRepository {
    public static final QBean<OrderRole> orderRoleBean = bean(OrderRole.class, orderRole.all());

    @Transactional
    public Long save(OrderRole entity) {
        if (entity.getId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(orderRole).populate(entity).execute();
            return entity.getId();
        }
        entity.setCreatedStamp(DateTime.now());
        return insert(orderRole).populate(entity)
                .executeWithKey(orderRole.id);
    }

    @Transactional
    public OrderRole findById(Long id) {
        return selectFrom(orderRole).where(orderRole.id.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderRole> findAll(Predicate expr) {
        return selectFrom(orderRole).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(orderRole).fetchCount();
    }

    @Transactional
    public void delete(OrderRole s) {
        delete(orderRole)
            .where(orderRole.id.eq(s.getId()))
            .execute();
    }
}

/*
-- keys: orderId, partyId, roleTypeId

-- fields --
    
    Long orderId
    Long partyId
    String roleTypeId

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    - RoleType (one-nofk, autoRelation: false, keymaps: roleTypeId)
    + OrderItem (many, autoRelation: false, keymaps: orderId)
*/



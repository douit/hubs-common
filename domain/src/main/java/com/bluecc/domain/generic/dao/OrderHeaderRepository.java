package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.dummy.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QOrderHeader.orderHeader;

// Order Header
public class OrderHeaderRepository extends AbstractRepository {
    @Transactional
    public Long save(OrderHeader entity) {
        if (entity.getOrderId() != null) {
            update(orderHeader).populate(entity).execute();
            return entity.getOrderId();
        }
        return insert(orderHeader).populate(entity)
                .executeWithKey(orderHeader.orderId);
    }

    @Transactional
    public OrderHeader findById(Long id) {
        return selectFrom(orderHeader).where(orderHeader.orderId.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderHeader> findAll(Predicate expr) {
        return selectFrom(orderHeader).where(expr).fetch();
    }
}


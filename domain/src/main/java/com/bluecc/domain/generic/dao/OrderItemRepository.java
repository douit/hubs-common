package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.dummy.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QOrderItem.orderItem;

// Order Item
public class OrderItemRepository extends AbstractRepository {
    @Transactional
    public Long save(OrderItem entity) {
        if (entity.getId() != null) {
            update(orderItem).populate(entity).execute();
            return entity.getId();
        }
        return insert(orderItem).populate(entity)
                .executeWithKey(orderItem.id);
    }

    @Transactional
    public OrderItem findById(Long id) {
        return selectFrom(orderItem).where(orderItem.id.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderItem> findAll(Predicate expr) {
        return selectFrom(orderItem).where(expr).fetch();
    }
}


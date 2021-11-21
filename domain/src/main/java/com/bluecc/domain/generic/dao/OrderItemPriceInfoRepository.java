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

import static com.bluecc.domain.sql.model.QOrderItemPriceInfo.orderItemPriceInfo;

// Order Item Price Info
public class OrderItemPriceInfoRepository extends AbstractRepository {
    public static final QBean<OrderItemPriceInfo> orderItemPriceInfoBean = bean(OrderItemPriceInfo.class, orderItemPriceInfo.all());

    @Transactional
    public Long save(OrderItemPriceInfo entity) {
        if (entity.getOrderItemPriceInfoId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(orderItemPriceInfo).populate(entity).execute();
            return entity.getOrderItemPriceInfoId();
        }
        entity.setCreatedStamp(DateTime.now());
        return insert(orderItemPriceInfo).populate(entity)
                .executeWithKey(orderItemPriceInfo.orderItemPriceInfoId);
    }

    @Transactional
    public OrderItemPriceInfo findById(Long id) {
        return selectFrom(orderItemPriceInfo).where(orderItemPriceInfo.orderItemPriceInfoId.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderItemPriceInfo> findAll(Predicate expr) {
        return selectFrom(orderItemPriceInfo).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(orderItemPriceInfo).fetchCount();
    }

    @Transactional
    public void delete(OrderItemPriceInfo s) {
        delete(orderItemPriceInfo)
            .where(orderItemPriceInfo.orderItemPriceInfoId.eq(s.getOrderItemPriceInfoId()))
            .execute();
    }
}

/*
-- keys: orderItemPriceInfoId

-- fields --
    
    Long orderItemPriceInfoId
    Long orderId
    Long orderItemSeqId
    Long productPriceRuleId
    Long productPriceActionSeqId
    java.math.BigDecimal modifyAmount
    String description
    String rateCode

-- relations --
    
    - OrderHeader (one-nofk, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - ProductPriceRule (one-nofk, autoRelation: false, keymaps: productPriceRuleId)
    - ProductPriceAction (one, autoRelation: false, keymaps: productPriceRuleId, productPriceActionSeqId)
*/



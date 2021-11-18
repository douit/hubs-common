package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.dummy.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QOrderAdjustment.orderAdjustment;

// Order Adjustment
public class OrderAdjustmentRepository extends AbstractRepository {
    @Transactional
    public Long save(OrderAdjustment entity) {
        if (entity.getOrderAdjustmentId() != null) {
            update(orderAdjustment).populate(entity).execute();
            return entity.getOrderAdjustmentId();
        }
        return insert(orderAdjustment).populate(entity)
                .executeWithKey(orderAdjustment.orderAdjustmentId);
    }

    @Transactional
    public OrderAdjustment findById(Long id) {
        return selectFrom(orderAdjustment).where(orderAdjustment.orderAdjustmentId.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderAdjustment> findAll(Predicate expr) {
        return selectFrom(orderAdjustment).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(orderAdjustment).fetchCount();
    }

    @Transactional
    public void delete(OrderAdjustment s) {
        delete(orderAdjustment)
            .where(orderAdjustment.orderAdjustmentId.eq(s.getOrderAdjustmentId()))
            .execute();
    }
}

/*
-- keys: orderAdjustmentId

-- fields --
    
    Long orderAdjustmentId
    Long orderAdjustmentTypeId
    Long orderId
    Long orderItemSeqId
    Long shipGroupSeqId
    String comments
    String description
    java.math.BigDecimal amount
    java.math.BigDecimal recurringAmount
    java.math.BigDecimal amountAlreadyIncluded
    Long productPromoId
    Long productPromoRuleId
    Long productPromoActionSeqId
    Long productFeatureId
    Long correspondingProductId
    Long taxAuthorityRateSeqId
    Long sourceReferenceId
    java.math.BigDecimal sourcePercentage
    Long customerReferenceId
    Long primaryGeoId
    Long secondaryGeoId
    java.math.BigDecimal exemptAmount
    Long taxAuthGeoId
    Long taxAuthPartyId
    Long overrideGlAccountId
    String includeInTax
    String includeInShipping
    String isManual
    java.sql.Timestamp createdDate
    Long createdByUserLogin
    java.sql.Timestamp lastModifiedDate
    Long lastModifiedByUserLogin
    Long originalAdjustmentId

-- relations --
    
    - OrderAdjustmentType (one, autoRelation: false, keymaps: orderAdjustmentTypeId)
    + OrderAdjustmentTypeAttr (many, autoRelation: false, keymaps: orderAdjustmentTypeId)
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - UserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - OrderItem (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - OrderItemShipGroup (one-nofk, autoRelation: false, keymaps: orderId, shipGroupSeqId)
    - OrderItemShipGroupAssoc (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - ProductPromoRule (one-nofk, autoRelation: false, keymaps: productPromoId, productPromoRuleId)
    - ProductPromoAction (one-nofk, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    - PrimaryGeo (one, autoRelation: false, keymaps: primaryGeoId -> geoId)
    - SecondaryGeo (one, autoRelation: false, keymaps: secondaryGeoId -> geoId)
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - OverrideGlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
    - TaxAuthorityRateProduct (one, autoRelation: false, keymaps: taxAuthorityRateSeqId)
    - OrderAdjustment (one-nofk, autoRelation: false, keymaps: originalAdjustmentId -> orderAdjustmentId)
    + OrderAdjustmentAttribute (many, autoRelation: true, keymaps: orderAdjustmentId)
    + OrderAdjustmentBilling (many, autoRelation: true, keymaps: orderAdjustmentId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: orderAdjustmentId)
*/



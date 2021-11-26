package com.bluecc.domain.generic.dao;

import com.bluecc.domain.util.Sequence;
import com.google.inject.Inject;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;
import org.joda.time.DateTime;

import com.bluecc.domain.sql.model.*;
import com.querydsl.core.types.QBean;
import static com.querydsl.core.types.Projections.bean;

import static com.bluecc.domain.sql.model.QProductPrice.productPrice;

// Product Price
public class ProductPriceRepository extends AbstractRepository {
    @Inject Sequence sequence;

    public static final QBean<ProductPrice> productPriceBean = bean(ProductPrice.class, productPrice.all());

    @Transactional
    public String save(ProductPrice entity) {
        if (entity.getId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(productPrice).populate(entity).execute();
            return entity.getId();
        }
        entity.setCreatedStamp(DateTime.now());
        String uid=sequence.nextStringId();
        entity.setId(uid);
        return create(entity);
        // return insert(productPrice).populate(entity)
        //        .executeWithKey(productPrice.id);
    }

    @Transactional
    public String create(ProductPrice entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(productPrice).populate(entity)
                .executeWithKey(productPrice.id);
        return entity.getId();
    }

    @Transactional
    public ProductPrice findById(String id) {
        return selectFrom(productPrice).where(productPrice.id.eq(id)).fetchOne();
    }


    @Transactional
    public List<ProductPrice> findAll(Predicate expr) {
        return selectFrom(productPrice).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(productPrice).fetchCount();
    }

    @Transactional
    public void delete(ProductPrice s) {
        delete(productPrice)
            .where(productPrice.id.eq(s.getId()))
            .execute();
    }
}

/*
-- keys: productId, productPriceTypeId, productPricePurposeId, currencyUomId, productStoreGroupId, fromDate

-- fields --
    
    String productId
    String productPriceTypeId
    String productPricePurposeId
    String currencyUomId
    String productStoreGroupId
    java.sql.Timestamp fromDate
    java.sql.Timestamp thruDate
    java.math.BigDecimal price
    String termUomId
    String customPriceCalcService
    java.math.BigDecimal priceWithoutTax
    java.math.BigDecimal priceWithTax
    java.math.BigDecimal taxAmount
    java.math.BigDecimal taxPercentage
    String taxAuthPartyId
    String taxAuthGeoId
    String taxInPrice
    java.sql.Timestamp createdDate
    String createdByUserLogin
    java.sql.Timestamp lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - ProductPriceType (one, autoRelation: false, keymaps: productPriceTypeId)
    - ProductPricePurpose (one, autoRelation: false, keymaps: productPricePurposeId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - TermUom (one, autoRelation: false, keymaps: termUomId -> uomId)
    - ProductStoreGroup (one, autoRelation: false, keymaps: productStoreGroupId)
    - CustomMethod (one, autoRelation: false, keymaps: customPriceCalcService -> customMethodId)
    - TaxAuthorityParty (one, autoRelation: false, keymaps: taxAuthPartyId -> partyId)
    - TaxAuthorityGeo (one, autoRelation: false, keymaps: taxAuthGeoId -> geoId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    + ProductPriceChange (many, autoRelation: true, keymaps: productId, productPriceTypeId, productPricePurposeId, currencyUomId, productStoreGroupId, fromDate)
*/



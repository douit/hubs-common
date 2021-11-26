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

import static com.bluecc.domain.sql.model.QPartyGroup.partyGroup;

// Party Group
public class PartyGroupRepository extends AbstractRepository {
    @Inject Sequence sequence;

    public static final QBean<PartyGroup> partyGroupBean = bean(PartyGroup.class, partyGroup.all());

    @Transactional
    public String save(PartyGroup entity) {
        if (entity.getPartyId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(partyGroup).populate(entity).execute();
            return entity.getPartyId();
        }
        entity.setCreatedStamp(DateTime.now());
        String uid=sequence.nextStringId();
        entity.setPartyId(uid);
        return create(entity);
        // return insert(partyGroup).populate(entity)
        //        .executeWithKey(partyGroup.partyId);
    }

    @Transactional
    public String create(PartyGroup entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(partyGroup).populate(entity)
                .executeWithKey(partyGroup.partyId);
        return entity.getPartyId();
    }

    @Transactional
    public PartyGroup findById(String id) {
        return selectFrom(partyGroup).where(partyGroup.partyId.eq(id)).fetchOne();
    }


    @Transactional
    public List<PartyGroup> findAll(Predicate expr) {
        return selectFrom(partyGroup).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(partyGroup).fetchCount();
    }

    @Transactional
    public void delete(PartyGroup s) {
        delete(partyGroup)
            .where(partyGroup.partyId.eq(s.getPartyId()))
            .execute();
    }
}

/*
-- keys: partyId

-- fields --
    
    String partyId
    String groupName
    String groupNameLocal
    String officeSiteName
    java.math.BigDecimal annualRevenue
    Long numEmployees
    String tickerSymbol
    String comments
    String logoImageUrl

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - Affiliate (one-nofk, autoRelation: true, keymaps: partyId)
    + PartyContactMech (many, autoRelation: true, keymaps: partyId)
    + PartyContactMechPurpose (many, autoRelation: true, keymaps: partyId)
    + ToPartyInvitationGroupAssoc (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + ProdCatalogRole (many, autoRelation: true, keymaps: partyId)
    + ProductStoreRole (many, autoRelation: true, keymaps: partyId)
    + ToShipment (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + FromShipment (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + CarrierShipmentRouteSegment (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + UserLogin (many, autoRelation: true, keymaps: partyId)
    + WebSiteRole (many, autoRelation: true, keymaps: partyId)
*/



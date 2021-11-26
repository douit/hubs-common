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

import static com.bluecc.domain.sql.model.QPartyRole.partyRole;

// Party Role
public class PartyRoleRepository extends AbstractRepository {
    @Inject Sequence sequence;

    public static final QBean<PartyRole> partyRoleBean = bean(PartyRole.class, partyRole.all());

    @Transactional
    public String save(PartyRole entity) {
        if (entity.getId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(partyRole).populate(entity).execute();
            return entity.getId();
        }
        entity.setCreatedStamp(DateTime.now());
        String uid=sequence.nextStringId();
        entity.setId(uid);
        return create(entity);
        // return insert(partyRole).populate(entity)
        //        .executeWithKey(partyRole.id);
    }

    @Transactional
    public String create(PartyRole entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(partyRole).populate(entity)
                .executeWithKey(partyRole.id);
        return entity.getId();
    }

    @Transactional
    public PartyRole findById(String id) {
        return selectFrom(partyRole).where(partyRole.id.eq(id)).fetchOne();
    }


    @Transactional
    public List<PartyRole> findAll(Predicate expr) {
        return selectFrom(partyRole).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(partyRole).fetchCount();
    }

    @Transactional
    public void delete(PartyRole s) {
        delete(partyRole)
            .where(partyRole.id.eq(s.getId()))
            .execute();
    }
}

/*
-- keys: partyId, roleTypeId

-- fields --
    
    String partyId
    String roleTypeId

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    + RoleTypeAttr (many, autoRelation: false, keymaps: roleTypeId)
    + PartyAttribute (many, autoRelation: false, keymaps: partyId)
    + AcctgTrans (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + AcctgTransEntry (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FromAgreement (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + ToAgreement (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + AgreementRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + BillingAccountRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + BudgetRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + CarrierShipmentMethod (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ToCommunicationEvent (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + FromCommunicationEvent (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + CommunicationEventRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ContentRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + CustRequestParty (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + DataResourceRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ToEmployment (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + FromEmployment (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + FacilityGroupRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FacilityParty (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FinAccountRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FixedAsset (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + GlAccountOrganization (many, autoRelation: true, keymaps: partyId -> organizationPartyId, roleTypeId)
    + GlAccountRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + Invoice (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + InvoiceRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ItemIssuanceRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + MarketingCampaignRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + OrderItemRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + CarrierOrderItemShipGroup (many, autoRelation: true, keymaps: partyId -> carrierPartyId, roleTypeId -> carrierRoleTypeId)
    + OrderRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ToPartyBenefit (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + FromPartyBenefit (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + PartyContactMech (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PartyFixedAssetAssignment (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PartyGlAccount (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PartyNeed (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FromPartyRelationship (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + ToPartyRelationship (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + ToPayment (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + PayrollPreference (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + EmployeePerfReview (many, autoRelation: true, keymaps: partyId -> employeePartyId, roleTypeId -> employeeRoleTypeId)
    + ManagerPerfReview (many, autoRelation: true, keymaps: partyId -> managerPartyId, roleTypeId -> managerRoleTypeId)
    + EmployeePerfReviewItem (many, autoRelation: true, keymaps: partyId -> employeePartyId, roleTypeId -> employeeRoleTypeId)
    + PerformanceNote (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PicklistRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProdCatalogRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductCategoryRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductStoreGroupRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductStoreRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + QuoteRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + RequirementRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + SalesOpportunityRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + SegmentGroupRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ShipmentCostEstimate (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ShipmentReceiptRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + Subscription (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + OriginatedFromSubscription (many, autoRelation: true, keymaps: partyId -> originatedFromPartyId, roleTypeId -> originatedFromRoleTypeId)
    + TimesheetRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + WebSiteRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + WorkEffortPartyAssignment (many, autoRelation: true, keymaps: partyId, roleTypeId)
*/



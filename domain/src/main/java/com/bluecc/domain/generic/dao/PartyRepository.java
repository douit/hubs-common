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

    @Transactional
    public long count() {
        return selectFrom(party).fetchCount();
    }

    @Transactional
    public void delete(Party s) {
        delete(party)
            .where(party.partyId.eq(s.getPartyId()))
            .execute();
    }
}

/*
-- keys: partyId

-- fields --
    
    Long partyId
    Long partyTypeId
    Long externalId
    Long preferredCurrencyUomId
    String description
    Long statusId
    java.sql.Timestamp createdDate
    Long createdByUserLogin
    java.sql.Timestamp lastModifiedDate
    Long lastModifiedByUserLogin
    Long dataSourceId
    String isUnread

-- relations --
    
    - PartyType (one, autoRelation: false, keymaps: partyTypeId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    - Uom (one, autoRelation: false, keymaps: preferredCurrencyUomId -> uomId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    + PartyTypeAttr (many, autoRelation: false, keymaps: partyTypeId)
    - DataSource (one, autoRelation: false, keymaps: dataSourceId)
    + AcctgTrans (many, autoRelation: true, keymaps: partyId)
    + AcctgTransEntry (many, autoRelation: true, keymaps: partyId)
    - Affiliate (one-nofk, autoRelation: true, keymaps: partyId)
    + FromAgreement (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ToAgreement (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + AgreementPartyApplic (many, autoRelation: true, keymaps: partyId)
    + AgreementRole (many, autoRelation: true, keymaps: partyId)
    + BillingAccountRole (many, autoRelation: true, keymaps: partyId)
    + BudgetReview (many, autoRelation: true, keymaps: partyId)
    + BudgetRole (many, autoRelation: true, keymaps: partyId)
    + CarrierShipmentBoxType (many, autoRelation: true, keymaps: partyId)
    + CarrierShipmentMethod (many, autoRelation: true, keymaps: partyId)
    + ToCommunicationEvent (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + FromCommunicationEvent (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + CommunicationEventRole (many, autoRelation: true, keymaps: partyId)
    + OwnerContactList (many, autoRelation: true, keymaps: partyId -> ownerPartyId)
    + ContactListCommStatus (many, autoRelation: true, keymaps: partyId)
    + ContactListParty (many, autoRelation: true, keymaps: partyId)
    + ContentApproval (many, autoRelation: true, keymaps: partyId)
    + CommittedByContentRevision (many, autoRelation: true, keymaps: partyId -> committedByPartyId)
    + ContentRole (many, autoRelation: true, keymaps: partyId)
    + CostComponent (many, autoRelation: true, keymaps: partyId)
    + FromCustRequest (many, autoRelation: true, keymaps: partyId -> fromPartyId)
    + CustRequestParty (many, autoRelation: true, keymaps: partyId)
    + CustRequestType (many, autoRelation: true, keymaps: partyId)
    + OrganizationCustomTimePeriod (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + DataResourceRole (many, autoRelation: true, keymaps: partyId)
    + EbayShippingMethod (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + EmplLeave (many, autoRelation: true, keymaps: partyId)
    + ApproverEmplLeave (many, autoRelation: true, keymaps: partyId -> approverPartyId)
    + EmplPosition (many, autoRelation: true, keymaps: partyId)
    + EmplPositionFulfillment (many, autoRelation: true, keymaps: partyId)
    + ToEmployment (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + FromEmployment (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ApplyingEmploymentApp (many, autoRelation: true, keymaps: partyId -> applyingPartyId)
    + ReferredByEmploymentApp (many, autoRelation: true, keymaps: partyId -> referredByPartyId)
    + ApproverEmploymentApp (many, autoRelation: true, keymaps: partyId -> approverPartyId)
    + OwnerFacility (many, autoRelation: true, keymaps: partyId -> ownerPartyId)
    + FacilityCarrierShipment (many, autoRelation: true, keymaps: partyId)
    + FacilityGroupRole (many, autoRelation: true, keymaps: partyId)
    + FacilityParty (many, autoRelation: true, keymaps: partyId)
    + OrganizationFinAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + OwnerFinAccount (many, autoRelation: true, keymaps: partyId -> ownerPartyId)
    + FinAccountRole (many, autoRelation: true, keymaps: partyId)
    + FinAccountTrans (many, autoRelation: true, keymaps: partyId)
    + PerformedByFinAccountTrans (many, autoRelation: true, keymaps: partyId -> performedByPartyId)
    + OrganizationFinAccountTypeGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + FixedAsset (many, autoRelation: true, keymaps: partyId)
    + GovAgencyFixedAssetRegistration (many, autoRelation: true, keymaps: partyId -> govAgencyPartyId)
    + FixedAssetTypeGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + GiftCardFulfillment (many, autoRelation: true, keymaps: partyId)
    + GlAccountHistory (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + GlAccountOrganization (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + GlAccountRole (many, autoRelation: true, keymaps: partyId)
    + OrganizationGlAccountTypeDefault (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + GlJournal (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + GlReconciliation (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + InventoryItem (many, autoRelation: true, keymaps: partyId)
    + OwnerInventoryItem (many, autoRelation: true, keymaps: partyId -> ownerPartyId)
    + FromInvoice (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + Invoice (many, autoRelation: true, keymaps: partyId)
    + TaxAuthorityInvoiceItem (many, autoRelation: true, keymaps: partyId -> taxAuthPartyId)
    + OverrideOrgInvoiceItem (many, autoRelation: true, keymaps: partyId -> overrideOrgPartyId)
    + FromInvoiceItemAssoc (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ToInvoiceItemAssoc (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + OrganizationInvoiceItemTypeGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + InvoiceRole (many, autoRelation: true, keymaps: partyId)
    + ItemIssuanceRole (many, autoRelation: true, keymaps: partyId)
    + IntervieweeJobInterview (many, autoRelation: true, keymaps: partyId -> jobIntervieweePartyId)
    + InterviewerJobInterview (many, autoRelation: true, keymaps: partyId -> jobInterviewerPartyId)
    + MarketingCampaignRole (many, autoRelation: true, keymaps: partyId)
    + NoteNoteData (many, autoRelation: true, keymaps: partyId -> noteParty)
    + OrderItemRole (many, autoRelation: true, keymaps: partyId)
    + SupplierOrderItemShipGroup (many, autoRelation: true, keymaps: partyId -> supplierPartyId)
    + VendorOrderItemShipGroup (many, autoRelation: true, keymaps: partyId -> vendorPartyId)
    + CarrierOrderItemShipGroup (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + OrderRole (many, autoRelation: true, keymaps: partyId)
    - PartyAcctgPreference (one-nofk, autoRelation: true, keymaps: partyId)
    + PartyAttribute (many, autoRelation: true, keymaps: partyId)
    + ToPartyBenefit (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + FromPartyBenefit (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + PartyCarrierAccount (many, autoRelation: true, keymaps: partyId)
    + CarrierPartyCarrierAccount (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + PartyClassification (many, autoRelation: true, keymaps: partyId)
    + PartyContactMech (many, autoRelation: true, keymaps: partyId)
    + PartyContactMechPurpose (many, autoRelation: true, keymaps: partyId)
    + PartyContent (many, autoRelation: true, keymaps: partyId)
    + PartyDataSource (many, autoRelation: true, keymaps: partyId)
    + PartyFixedAssetAssignment (many, autoRelation: true, keymaps: partyId)
    + PartyGeoPoint (many, autoRelation: true, keymaps: partyId)
    + OrganizationPartyGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + PartyGlAccount (many, autoRelation: true, keymaps: partyId)
    - PartyGroup (one-nofk, autoRelation: true, keymaps: partyId)
    - PartyIcsAvsOverride (one-nofk, autoRelation: true, keymaps: partyId)
    + PartyIdentification (many, autoRelation: true, keymaps: partyId)
    + PartyInvitation (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ToPartyInvitationGroupAssoc (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + PartyNameHistory (many, autoRelation: true, keymaps: partyId)
    + PartyNeed (many, autoRelation: true, keymaps: partyId)
    + PartyNote (many, autoRelation: true, keymaps: partyId)
    + PartyPrefDocTypeTpl (many, autoRelation: true, keymaps: partyId)
    + PartyProfileDefault (many, autoRelation: true, keymaps: partyId)
    + PartyQual (many, autoRelation: true, keymaps: partyId)
    + PartyRate (many, autoRelation: true, keymaps: partyId)
    + FromPartyRelationship (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ToPartyRelationship (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + PartyResume (many, autoRelation: true, keymaps: partyId)
    + PartyRole (many, autoRelation: true, keymaps: partyId)
    + PartySkill (many, autoRelation: true, keymaps: partyId)
    + PartyStatus (many, autoRelation: true, keymaps: partyId)
    + PartyTaxAuthInfo (many, autoRelation: true, keymaps: partyId)
    + FromPayment (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ToPayment (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + PaymentGlAccountTypeMap (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + PaymentMethod (many, autoRelation: true, keymaps: partyId)
    + OrganizationPaymentMethodTypeGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + PayrollPreference (many, autoRelation: true, keymaps: partyId)
    + EmployeePerfReview (many, autoRelation: true, keymaps: partyId -> employeePartyId)
    + ManagerPerfReview (many, autoRelation: true, keymaps: partyId -> managerPartyId)
    + EmployeePerfReviewItem (many, autoRelation: true, keymaps: partyId -> employeePartyId)
    + PerformanceNote (many, autoRelation: true, keymaps: partyId)
    - Person (one-nofk, autoRelation: true, keymaps: partyId)
    + PersonTraining (many, autoRelation: true, keymaps: partyId)
    + ProdCatalogRole (many, autoRelation: true, keymaps: partyId)
    + ProductAverageCost (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + ProductCategoryGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + ProductCategoryRole (many, autoRelation: true, keymaps: partyId)
    + ProductGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + TaxAuthorityProductPrice (many, autoRelation: true, keymaps: partyId -> taxAuthPartyId)
    + ProductPromo (many, autoRelation: true, keymaps: partyId -> overrideOrgPartyId)
    + ProductPromoCodeParty (many, autoRelation: true, keymaps: partyId)
    + ProductPromoUse (many, autoRelation: true, keymaps: partyId)
    + ProductRole (many, autoRelation: true, keymaps: partyId)
    + ProductStore (many, autoRelation: true, keymaps: partyId -> payToPartyId)
    + ProductStoreGroupRole (many, autoRelation: true, keymaps: partyId)
    + ProductStoreRole (many, autoRelation: true, keymaps: partyId)
    + ProductStoreShipmentMeth (many, autoRelation: true, keymaps: partyId -> companyPartyId)
    + VendorProductStoreVendorPayment (many, autoRelation: true, keymaps: partyId -> vendorPartyId)
    + VendorProductStoreVendorShipment (many, autoRelation: true, keymaps: partyId -> vendorPartyId)
    + CarrierProductStoreVendorShipment (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + Quote (many, autoRelation: true, keymaps: partyId)
    + QuoteRole (many, autoRelation: true, keymaps: partyId)
    + RateAmount (many, autoRelation: true, keymaps: partyId)
    + ReorderGuideline (many, autoRelation: true, keymaps: partyId)
    + RequirementRole (many, autoRelation: true, keymaps: partyId)
    + RespondingParty (many, autoRelation: true, keymaps: partyId)
    + ReturnHeader (many, autoRelation: true, keymaps: partyId -> fromPartyId)
    + ToReturnHeader (many, autoRelation: true, keymaps: partyId -> toPartyId)
    + OrganizationSalesForecast (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + InternalSalesForecast (many, autoRelation: true, keymaps: partyId -> internalPartyId)
    + OrganizationSalesForecastHistory (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + InternalSalesForecastHistory (many, autoRelation: true, keymaps: partyId -> internalPartyId)
    + SalesOpportunityRole (many, autoRelation: true, keymaps: partyId)
    + SegmentGroupRole (many, autoRelation: true, keymaps: partyId)
    + ToShipment (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + FromShipment (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + ShipmentCostEstimate (many, autoRelation: true, keymaps: partyId)
    + ShipmentReceiptRole (many, autoRelation: true, keymaps: partyId)
    + CarrierShipmentRouteSegment (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + ShoppingList (many, autoRelation: true, keymaps: partyId)
    + Subscription (many, autoRelation: true, keymaps: partyId)
    + OriginatedFromSubscription (many, autoRelation: true, keymaps: partyId -> originatedFromPartyId)
    + SupplierProduct (many, autoRelation: true, keymaps: partyId)
    + SupplierProductFeature (many, autoRelation: true, keymaps: partyId)
    + SurveyResponse (many, autoRelation: true, keymaps: partyId)
    + TaxAuthTaxAuthority (many, autoRelation: true, keymaps: partyId -> taxAuthPartyId)
    + OrganizationTaxAuthorityGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    + TimeEntry (many, autoRelation: true, keymaps: partyId)
    + Timesheet (many, autoRelation: true, keymaps: partyId)
    + ClientTimesheet (many, autoRelation: true, keymaps: partyId -> clientPartyId)
    + TimesheetRole (many, autoRelation: true, keymaps: partyId)
    + UserLogin (many, autoRelation: true, keymaps: partyId)
    + UserLoginHistory (many, autoRelation: true, keymaps: partyId)
    + OrganizationVarianceReasonGlAccount (many, autoRelation: true, keymaps: partyId -> organizationPartyId)
    - Vendor (one-nofk, autoRelation: true, keymaps: partyId)
    + VendorVendorProduct (many, autoRelation: true, keymaps: partyId -> vendorPartyId)
    + WebSiteRole (many, autoRelation: true, keymaps: partyId)
    + WebUserPreference (many, autoRelation: true, keymaps: partyId)
    + WorkEffortEventReminder (many, autoRelation: true, keymaps: partyId)
    + WorkEffortPartyAssignment (many, autoRelation: true, keymaps: partyId)
*/



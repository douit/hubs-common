package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.PartyFlatData;

import com.bluecc.hubs.stub.PartyData;
import com.bluecc.income.dao.PartyDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyData.class,
        symbol = EntityNames.Party)
public class Party implements IEventModel<PartyFlatData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String partyId;
    String partyTypeId;
    String externalId;
    String preferredCurrencyUomId;
    String description;
    String statusId;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    String dataSourceId;
    Character isUnread;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyFlatData.Builder toDataBuilder() {
        PartyFlatData.Builder builder = PartyFlatData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (partyTypeId != null) {
            builder.setPartyTypeId(partyTypeId);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (preferredCurrencyUomId != null) {
            builder.setPreferredCurrencyUomId(preferredCurrencyUomId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (isUnread != null) {
            builder.setIsUnread(getIndicator(isUnread));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Party fromData(PartyFlatData data) {
        return Party.builder()
                .partyId(data.getPartyId())
                .partyTypeId(data.getPartyTypeId())
                .externalId(data.getExternalId())
                .preferredCurrencyUomId(data.getPreferredCurrencyUomId())
                .description(data.getDescription())
                .statusId(data.getStatusId())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .dataSourceId(data.getDataSourceId())
                .isUnread(getIndicatorChar(data.getIsUnread()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

        // relations
     
    @Exclude
    List<UserLogin> relCreatedByUserLogin= new ArrayList<>(); 
    @Exclude
    List<UserLogin> relLastModifiedByUserLogin= new ArrayList<>(); 
    @Exclude
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    List<AcctgTransEntry> relAcctgTransEntry= new ArrayList<>(); 
    @Exclude
    List<Agreement> relFromAgreement= new ArrayList<>(); 
    @Exclude
    List<Agreement> relToAgreement= new ArrayList<>(); 
    @Exclude
    List<BillingAccountRole> relBillingAccountRole= new ArrayList<>(); 
    @Exclude
    List<CarrierShipmentBoxType> relCarrierShipmentBoxType= new ArrayList<>(); 
    @Exclude
    List<CarrierShipmentMethod> relCarrierShipmentMethod= new ArrayList<>(); 
    @Exclude
    List<CommunicationEvent> relToCommunicationEvent= new ArrayList<>(); 
    @Exclude
    List<CommunicationEvent> relFromCommunicationEvent= new ArrayList<>(); 
    @Exclude
    List<CommunicationEventRole> relCommunicationEventRole= new ArrayList<>(); 
    @Exclude
    List<ContentRole> relContentRole= new ArrayList<>(); 
    @Exclude
    List<CustRequest> relFromCustRequest= new ArrayList<>(); 
    @Exclude
    List<CustRequestType> relCustRequestType= new ArrayList<>(); 
    @Exclude
    List<Facility> relOwnerFacility= new ArrayList<>(); 
    @Exclude
    List<FinAccount> relOrganizationFinAccount= new ArrayList<>(); 
    @Exclude
    List<FinAccount> relOwnerFinAccount= new ArrayList<>(); 
    @Exclude
    List<FinAccountRole> relFinAccountRole= new ArrayList<>(); 
    @Exclude
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
    @Exclude
    List<FinAccountTrans> relPerformedByFinAccountTrans= new ArrayList<>(); 
    @Exclude
    List<FixedAsset> relFixedAsset= new ArrayList<>(); 
    @Exclude
    List<FixedAssetRegistration> relGovAgencyFixedAssetRegistration= new ArrayList<>(); 
    @Exclude
    List<GlAccountTypeDefault> relOrganizationGlAccountTypeDefault= new ArrayList<>(); 
    @Exclude
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    @Exclude
    List<InventoryItem> relOwnerInventoryItem= new ArrayList<>(); 
    @Exclude
    List<Invoice> relFromInvoice= new ArrayList<>(); 
    @Exclude
    List<Invoice> relInvoice= new ArrayList<>(); 
    @Exclude
    List<InvoiceItem> relTaxAuthorityInvoiceItem= new ArrayList<>(); 
    @Exclude
    List<InvoiceItem> relOverrideOrgInvoiceItem= new ArrayList<>(); 
    @Exclude
    List<InvoiceItemTypeGlAccount> relOrganizationInvoiceItemTypeGlAccount= new ArrayList<>(); 
    @Exclude
    List<InvoiceRole> relInvoiceRole= new ArrayList<>(); 
    @Exclude
    List<OrderItemShipGroup> relSupplierOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    List<OrderItemShipGroup> relVendorOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    List<OrderItemShipGroup> relCarrierOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    List<OrderRole> relOrderRole= new ArrayList<>(); 
    @Exclude
    List<PartyAcctgPreference> relPartyAcctgPreference= new ArrayList<>(); 
    @Exclude
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    @Exclude
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    @Exclude
    List<PartyGeoPoint> relPartyGeoPoint= new ArrayList<>(); 
    @Exclude
    List<PartyGroup> relPartyGroup= new ArrayList<>(); 
    @Exclude
    List<PartyIdentification> relPartyIdentification= new ArrayList<>(); 
    @Exclude
    List<PartyRate> relPartyRate= new ArrayList<>(); 
    @Exclude
    List<PartyRelationship> relFromPartyRelationship= new ArrayList<>(); 
    @Exclude
    List<PartyRelationship> relToPartyRelationship= new ArrayList<>(); 
    @Exclude
    List<PartyRole> relPartyRole= new ArrayList<>(); 
    @Exclude
    List<PartyStatus> relPartyStatus= new ArrayList<>(); 
    @Exclude
    List<PartyTaxAuthInfo> relPartyTaxAuthInfo= new ArrayList<>(); 
    @Exclude
    List<Payment> relFromPayment= new ArrayList<>(); 
    @Exclude
    List<Payment> relToPayment= new ArrayList<>(); 
    @Exclude
    List<PaymentGlAccountTypeMap> relPaymentGlAccountTypeMap= new ArrayList<>(); 
    @Exclude
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    List<PaymentMethodTypeGlAccount> relOrganizationPaymentMethodTypeGlAccount= new ArrayList<>(); 
    @Exclude
    List<Person> relPerson= new ArrayList<>(); 
    @Exclude
    List<ProductCategoryRole> relProductCategoryRole= new ArrayList<>(); 
    @Exclude
    List<ProductPrice> relTaxAuthorityProductPrice= new ArrayList<>(); 
    @Exclude
    List<ProductPromo> relProductPromo= new ArrayList<>(); 
    @Exclude
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    @Exclude
    List<ProductStoreShipmentMeth> relProductStoreShipmentMeth= new ArrayList<>(); 
    @Exclude
    List<Quote> relQuote= new ArrayList<>(); 
    @Exclude
    List<QuoteRole> relQuoteRole= new ArrayList<>(); 
    @Exclude
    List<RateAmount> relRateAmount= new ArrayList<>(); 
    @Exclude
    List<Shipment> relToShipment= new ArrayList<>(); 
    @Exclude
    List<Shipment> relFromShipment= new ArrayList<>(); 
    @Exclude
    List<ShipmentCostEstimate> relShipmentCostEstimate= new ArrayList<>(); 
    @Exclude
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    List<SupplierProduct> relSupplierProduct= new ArrayList<>(); 
    @Exclude
    List<SupplierProductFeature> relSupplierProductFeature= new ArrayList<>(); 
    @Exclude
    List<TaxAuthority> relTaxAuthTaxAuthority= new ArrayList<>(); 
    @Exclude
    List<TaxAuthorityGlAccount> relOrganizationTaxAuthorityGlAccount= new ArrayList<>(); 
    @Exclude
    List<UserLogin> relUserLogin= new ArrayList<>();

    public PartyDelegator.Agent agent(IProc.ProcContext ctx,
                                             PartyDelegator delegator){
        return delegator.getAgent(ctx, this.getPartyId());
    }

    public PartyData.Builder toHeadBuilder() {
        PartyData.Builder builder = PartyData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (partyTypeId != null) {
            builder.setPartyTypeId(partyTypeId);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (preferredCurrencyUomId != null) {
            builder.setPreferredCurrencyUomId(preferredCurrencyUomId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (isUnread != null) {
            builder.setIsUnread(getIndicator(isUnread));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: partyId

-- fields --
    
    String partyId
    String partyTypeId
    String externalId
    String preferredCurrencyUomId
    String description
    String statusId
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin
    String dataSourceId
    Character isUnread

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


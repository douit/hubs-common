//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.PartyFlatData;

import com.bluecc.hubs.stub.PartyData;
import com.bluecc.income.dao.PartyDelegator;
import static com.bluecc.income.dao.PartyDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyData.class,
        symbol = EntityNames.Party)
public class Party implements IEventModel<PartyFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RId 
    String partyId;
    @SerializedName("party_type_id") 
    String partyTypeId;
    @SerializedName("external_id") 
    String externalId;
    @SerializedName("preferred_currency_uom_id") 
    String preferredCurrencyUomId;
    @SerializedName("description") 
    String description;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
    @SerializedName("data_source_id") 
    String dataSourceId;
    @SerializedName("is_unread") 
    Character isUnread;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return partyId;
    }

        
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
        if (tenantId != null) {
            builder.setTenantId(tenantId);
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
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addCreatedByUserLogin")
    @SerializedName("created_by_user_login") 
    List<UserLogin> relCreatedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByUserLogin")
    @SerializedName("last_modified_by_user_login") 
    List<UserLogin> relLastModifiedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    @SerializedName("acctg_trans") 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTransEntry")
    @SerializedName("acctg_trans_entry") 
    List<AcctgTransEntry> relAcctgTransEntry= new ArrayList<>(); 
    @Exclude
    @Singular("addFromAgreement")
    @SerializedName("from_agreement") 
    List<Agreement> relFromAgreement= new ArrayList<>(); 
    @Exclude
    @Singular("addToAgreement")
    @SerializedName("to_agreement") 
    List<Agreement> relToAgreement= new ArrayList<>(); 
    @Exclude
    @Singular("addBillingAccountRole")
    @SerializedName("billing_account_role") 
    List<BillingAccountRole> relBillingAccountRole= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentBoxType")
    @SerializedName("carrier_shipment_box_type") 
    List<CarrierShipmentBoxType> relCarrierShipmentBoxType= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentMethod")
    @SerializedName("carrier_shipment_method") 
    List<CarrierShipmentMethod> relCarrierShipmentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addToCommunicationEvent")
    @SerializedName("to_communication_event") 
    List<CommunicationEvent> relToCommunicationEvent= new ArrayList<>(); 
    @Exclude
    @Singular("addFromCommunicationEvent")
    @SerializedName("from_communication_event") 
    List<CommunicationEvent> relFromCommunicationEvent= new ArrayList<>(); 
    @Exclude
    @Singular("addCommunicationEventRole")
    @SerializedName("communication_event_role") 
    List<CommunicationEventRole> relCommunicationEventRole= new ArrayList<>(); 
    @Exclude
    @Singular("addContentRole")
    @SerializedName("content_role") 
    List<ContentRole> relContentRole= new ArrayList<>(); 
    @Exclude
    @Singular("addFromCustRequest")
    @SerializedName("from_cust_request") 
    List<CustRequest> relFromCustRequest= new ArrayList<>(); 
    @Exclude
    @Singular("addCustRequestType")
    @SerializedName("cust_request_type") 
    List<CustRequestType> relCustRequestType= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerFacility")
    @SerializedName("owner_facility") 
    List<Facility> relOwnerFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addOrganizationFinAccount")
    @SerializedName("organization_fin_account") 
    List<FinAccount> relOrganizationFinAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerFinAccount")
    @SerializedName("owner_fin_account") 
    List<FinAccount> relOwnerFinAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountRole")
    @SerializedName("fin_account_role") 
    List<FinAccountRole> relFinAccountRole= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountTrans")
    @SerializedName("fin_account_trans") 
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addPerformedByFinAccountTrans")
    @SerializedName("performed_by_fin_account_trans") 
    List<FinAccountTrans> relPerformedByFinAccountTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAsset")
    @SerializedName("fixed_asset") 
    List<FixedAsset> relFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addGovAgencyFixedAssetRegistration")
    @SerializedName("gov_agency_fixed_asset_registration") 
    List<FixedAssetRegistration> relGovAgencyFixedAssetRegistration= new ArrayList<>(); 
    @Exclude
    @Singular("addOrganizationGlAccountTypeDefault")
    @SerializedName("organization_gl_account_type_default") 
    List<GlAccountTypeDefault> relOrganizationGlAccountTypeDefault= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItem")
    @SerializedName("inventory_item") 
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerInventoryItem")
    @SerializedName("owner_inventory_item") 
    List<InventoryItem> relOwnerInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addFromInvoice")
    @SerializedName("from_invoice") 
    List<Invoice> relFromInvoice= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoice")
    @SerializedName("invoice") 
    List<Invoice> relInvoice= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthorityInvoiceItem")
    @SerializedName("tax_authority_invoice_item") 
    List<InvoiceItem> relTaxAuthorityInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOverrideOrgInvoiceItem")
    @SerializedName("override_org_invoice_item") 
    List<InvoiceItem> relOverrideOrgInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrganizationInvoiceItemTypeGlAccount")
    @SerializedName("organization_invoice_item_type_gl_account") 
    List<InvoiceItemTypeGlAccount> relOrganizationInvoiceItemTypeGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceRole")
    @SerializedName("invoice_role") 
    List<InvoiceRole> relInvoiceRole= new ArrayList<>(); 
    @Exclude
    @Singular("addSupplierOrderItemShipGroup")
    @SerializedName("supplier_order_item_ship_group") 
    List<OrderItemShipGroup> relSupplierOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addVendorOrderItemShipGroup")
    @SerializedName("vendor_order_item_ship_group") 
    List<OrderItemShipGroup> relVendorOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierOrderItemShipGroup")
    @SerializedName("carrier_order_item_ship_group") 
    List<OrderItemShipGroup> relCarrierOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderRole")
    @SerializedName("order_role") 
    List<OrderRole> relOrderRole= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyAcctgPreference")
    @SerializedName("party_acctg_preference") 
    List<PartyAcctgPreference> relPartyAcctgPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMech")
    @SerializedName("party_contact_mech") 
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMechPurpose")
    @SerializedName("party_contact_mech_purpose") 
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyGeoPoint")
    @SerializedName("party_geo_point") 
    List<PartyGeoPoint> relPartyGeoPoint= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyGroup")
    @SerializedName("party_group") 
    List<PartyGroup> relPartyGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyIdentification")
    @SerializedName("party_identification") 
    List<PartyIdentification> relPartyIdentification= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyRate")
    @SerializedName("party_rate") 
    List<PartyRate> relPartyRate= new ArrayList<>(); 
    @Exclude
    @Singular("addFromPartyRelationship")
    @SerializedName("from_party_relationship") 
    List<PartyRelationship> relFromPartyRelationship= new ArrayList<>(); 
    @Exclude
    @Singular("addToPartyRelationship")
    @SerializedName("to_party_relationship") 
    List<PartyRelationship> relToPartyRelationship= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyRole")
    @SerializedName("party_role") 
    List<PartyRole> relPartyRole= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyStatus")
    @SerializedName("party_status") 
    List<PartyStatus> relPartyStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyTaxAuthInfo")
    @SerializedName("party_tax_auth_info") 
    List<PartyTaxAuthInfo> relPartyTaxAuthInfo= new ArrayList<>(); 
    @Exclude
    @Singular("addFromPayment")
    @SerializedName("from_payment") 
    List<Payment> relFromPayment= new ArrayList<>(); 
    @Exclude
    @Singular("addToPayment")
    @SerializedName("to_payment") 
    List<Payment> relToPayment= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentGlAccountTypeMap")
    @SerializedName("payment_gl_account_type_map") 
    List<PaymentGlAccountTypeMap> relPaymentGlAccountTypeMap= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentMethod")
    @SerializedName("payment_method") 
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addOrganizationPaymentMethodTypeGlAccount")
    @SerializedName("organization_payment_method_type_gl_account") 
    List<PaymentMethodTypeGlAccount> relOrganizationPaymentMethodTypeGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addPerson")
    @SerializedName("person") 
    List<Person> relPerson= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryRole")
    @SerializedName("product_category_role") 
    List<ProductCategoryRole> relProductCategoryRole= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthorityProductPrice")
    @SerializedName("tax_authority_product_price") 
    List<ProductPrice> relTaxAuthorityProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPromo")
    @SerializedName("product_promo") 
    List<ProductPromo> relProductPromo= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStore")
    @SerializedName("product_store") 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreRole")
    @SerializedName("product_store_role") 
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreShipmentMeth")
    @SerializedName("product_store_shipment_meth") 
    List<ProductStoreShipmentMeth> relProductStoreShipmentMeth= new ArrayList<>(); 
    @Exclude
    @Singular("addQuote")
    @SerializedName("quote") 
    List<Quote> relQuote= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteRole")
    @SerializedName("quote_role") 
    List<QuoteRole> relQuoteRole= new ArrayList<>(); 
    @Exclude
    @Singular("addRateAmount")
    @SerializedName("rate_amount") 
    List<RateAmount> relRateAmount= new ArrayList<>(); 
    @Exclude
    @Singular("addToShipment")
    @SerializedName("to_shipment") 
    List<Shipment> relToShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addFromShipment")
    @SerializedName("from_shipment") 
    List<Shipment> relFromShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentCostEstimate")
    @SerializedName("shipment_cost_estimate") 
    List<ShipmentCostEstimate> relShipmentCostEstimate= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentRouteSegment")
    @SerializedName("carrier_shipment_route_segment") 
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    @Singular("addSupplierProduct")
    @SerializedName("supplier_product") 
    List<SupplierProduct> relSupplierProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addSupplierProductFeature")
    @SerializedName("supplier_product_feature") 
    List<SupplierProductFeature> relSupplierProductFeature= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthTaxAuthority")
    @SerializedName("tax_auth_tax_authority") 
    List<TaxAuthority> relTaxAuthTaxAuthority= new ArrayList<>(); 
    @Exclude
    @Singular("addOrganizationTaxAuthorityGlAccount")
    @SerializedName("organization_tax_authority_gl_account") 
    List<TaxAuthorityGlAccount> relOrganizationTaxAuthorityGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLogin")
    @SerializedName("user_login") 
    List<UserLogin> relUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortPartyAssignment")
    @SerializedName("work_effort_party_assignment") 
    List<WorkEffortPartyAssignment> relWorkEffortPartyAssignment= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(CREATED_BY_USER_LOGIN, getter(this, Party::getRelCreatedByUserLogin)); 
        supplierMap.put(LAST_MODIFIED_BY_USER_LOGIN, getter(this, Party::getRelLastModifiedByUserLogin)); 
        supplierMap.put(ACCTG_TRANS, getter(this, Party::getRelAcctgTrans)); 
        supplierMap.put(ACCTG_TRANS_ENTRY, getter(this, Party::getRelAcctgTransEntry)); 
        supplierMap.put(FROM_AGREEMENT, getter(this, Party::getRelFromAgreement)); 
        supplierMap.put(TO_AGREEMENT, getter(this, Party::getRelToAgreement)); 
        supplierMap.put(BILLING_ACCOUNT_ROLE, getter(this, Party::getRelBillingAccountRole)); 
        supplierMap.put(CARRIER_SHIPMENT_BOX_TYPE, getter(this, Party::getRelCarrierShipmentBoxType)); 
        supplierMap.put(CARRIER_SHIPMENT_METHOD, getter(this, Party::getRelCarrierShipmentMethod)); 
        supplierMap.put(TO_COMMUNICATION_EVENT, getter(this, Party::getRelToCommunicationEvent)); 
        supplierMap.put(FROM_COMMUNICATION_EVENT, getter(this, Party::getRelFromCommunicationEvent)); 
        supplierMap.put(COMMUNICATION_EVENT_ROLE, getter(this, Party::getRelCommunicationEventRole)); 
        supplierMap.put(CONTENT_ROLE, getter(this, Party::getRelContentRole)); 
        supplierMap.put(FROM_CUST_REQUEST, getter(this, Party::getRelFromCustRequest)); 
        supplierMap.put(CUST_REQUEST_TYPE, getter(this, Party::getRelCustRequestType)); 
        supplierMap.put(OWNER_FACILITY, getter(this, Party::getRelOwnerFacility)); 
        supplierMap.put(ORGANIZATION_FIN_ACCOUNT, getter(this, Party::getRelOrganizationFinAccount)); 
        supplierMap.put(OWNER_FIN_ACCOUNT, getter(this, Party::getRelOwnerFinAccount)); 
        supplierMap.put(FIN_ACCOUNT_ROLE, getter(this, Party::getRelFinAccountRole)); 
        supplierMap.put(FIN_ACCOUNT_TRANS, getter(this, Party::getRelFinAccountTrans)); 
        supplierMap.put(PERFORMED_BY_FIN_ACCOUNT_TRANS, getter(this, Party::getRelPerformedByFinAccountTrans)); 
        supplierMap.put(FIXED_ASSET, getter(this, Party::getRelFixedAsset)); 
        supplierMap.put(GOV_AGENCY_FIXED_ASSET_REGISTRATION, getter(this, Party::getRelGovAgencyFixedAssetRegistration)); 
        supplierMap.put(ORGANIZATION_GL_ACCOUNT_TYPE_DEFAULT, getter(this, Party::getRelOrganizationGlAccountTypeDefault)); 
        supplierMap.put(INVENTORY_ITEM, getter(this, Party::getRelInventoryItem)); 
        supplierMap.put(OWNER_INVENTORY_ITEM, getter(this, Party::getRelOwnerInventoryItem)); 
        supplierMap.put(FROM_INVOICE, getter(this, Party::getRelFromInvoice)); 
        supplierMap.put(INVOICE, getter(this, Party::getRelInvoice)); 
        supplierMap.put(TAX_AUTHORITY_INVOICE_ITEM, getter(this, Party::getRelTaxAuthorityInvoiceItem)); 
        supplierMap.put(OVERRIDE_ORG_INVOICE_ITEM, getter(this, Party::getRelOverrideOrgInvoiceItem)); 
        supplierMap.put(ORGANIZATION_INVOICE_ITEM_TYPE_GL_ACCOUNT, getter(this, Party::getRelOrganizationInvoiceItemTypeGlAccount)); 
        supplierMap.put(INVOICE_ROLE, getter(this, Party::getRelInvoiceRole)); 
        supplierMap.put(SUPPLIER_ORDER_ITEM_SHIP_GROUP, getter(this, Party::getRelSupplierOrderItemShipGroup)); 
        supplierMap.put(VENDOR_ORDER_ITEM_SHIP_GROUP, getter(this, Party::getRelVendorOrderItemShipGroup)); 
        supplierMap.put(CARRIER_ORDER_ITEM_SHIP_GROUP, getter(this, Party::getRelCarrierOrderItemShipGroup)); 
        supplierMap.put(ORDER_ROLE, getter(this, Party::getRelOrderRole)); 
        supplierMap.put(PARTY_ACCTG_PREFERENCE, getter(this, Party::getRelPartyAcctgPreference)); 
        supplierMap.put(PARTY_CONTACT_MECH, getter(this, Party::getRelPartyContactMech)); 
        supplierMap.put(PARTY_CONTACT_MECH_PURPOSE, getter(this, Party::getRelPartyContactMechPurpose)); 
        supplierMap.put(PARTY_GEO_POINT, getter(this, Party::getRelPartyGeoPoint)); 
        supplierMap.put(PARTY_GROUP, getter(this, Party::getRelPartyGroup)); 
        supplierMap.put(PARTY_IDENTIFICATION, getter(this, Party::getRelPartyIdentification)); 
        supplierMap.put(PARTY_RATE, getter(this, Party::getRelPartyRate)); 
        supplierMap.put(FROM_PARTY_RELATIONSHIP, getter(this, Party::getRelFromPartyRelationship)); 
        supplierMap.put(TO_PARTY_RELATIONSHIP, getter(this, Party::getRelToPartyRelationship)); 
        supplierMap.put(PARTY_ROLE, getter(this, Party::getRelPartyRole)); 
        supplierMap.put(PARTY_STATUS, getter(this, Party::getRelPartyStatus)); 
        supplierMap.put(PARTY_TAX_AUTH_INFO, getter(this, Party::getRelPartyTaxAuthInfo)); 
        supplierMap.put(FROM_PAYMENT, getter(this, Party::getRelFromPayment)); 
        supplierMap.put(TO_PAYMENT, getter(this, Party::getRelToPayment)); 
        supplierMap.put(PAYMENT_GL_ACCOUNT_TYPE_MAP, getter(this, Party::getRelPaymentGlAccountTypeMap)); 
        supplierMap.put(PAYMENT_METHOD, getter(this, Party::getRelPaymentMethod)); 
        supplierMap.put(ORGANIZATION_PAYMENT_METHOD_TYPE_GL_ACCOUNT, getter(this, Party::getRelOrganizationPaymentMethodTypeGlAccount)); 
        supplierMap.put(PERSON, getter(this, Party::getRelPerson)); 
        supplierMap.put(PRODUCT_CATEGORY_ROLE, getter(this, Party::getRelProductCategoryRole)); 
        supplierMap.put(TAX_AUTHORITY_PRODUCT_PRICE, getter(this, Party::getRelTaxAuthorityProductPrice)); 
        supplierMap.put(PRODUCT_PROMO, getter(this, Party::getRelProductPromo)); 
        supplierMap.put(PRODUCT_STORE, getter(this, Party::getRelProductStore)); 
        supplierMap.put(PRODUCT_STORE_ROLE, getter(this, Party::getRelProductStoreRole)); 
        supplierMap.put(PRODUCT_STORE_SHIPMENT_METH, getter(this, Party::getRelProductStoreShipmentMeth)); 
        supplierMap.put(QUOTE, getter(this, Party::getRelQuote)); 
        supplierMap.put(QUOTE_ROLE, getter(this, Party::getRelQuoteRole)); 
        supplierMap.put(RATE_AMOUNT, getter(this, Party::getRelRateAmount)); 
        supplierMap.put(TO_SHIPMENT, getter(this, Party::getRelToShipment)); 
        supplierMap.put(FROM_SHIPMENT, getter(this, Party::getRelFromShipment)); 
        supplierMap.put(SHIPMENT_COST_ESTIMATE, getter(this, Party::getRelShipmentCostEstimate)); 
        supplierMap.put(CARRIER_SHIPMENT_ROUTE_SEGMENT, getter(this, Party::getRelCarrierShipmentRouteSegment)); 
        supplierMap.put(SUPPLIER_PRODUCT, getter(this, Party::getRelSupplierProduct)); 
        supplierMap.put(SUPPLIER_PRODUCT_FEATURE, getter(this, Party::getRelSupplierProductFeature)); 
        supplierMap.put(TAX_AUTH_TAX_AUTHORITY, getter(this, Party::getRelTaxAuthTaxAuthority)); 
        supplierMap.put(ORGANIZATION_TAX_AUTHORITY_GL_ACCOUNT, getter(this, Party::getRelOrganizationTaxAuthorityGlAccount)); 
        supplierMap.put(USER_LOGIN, getter(this, Party::getRelUserLogin)); 
        supplierMap.put(WORK_EFFORT_PARTY_ASSIGNMENT, getter(this, Party::getRelWorkEffortPartyAssignment)); 
        supplierMap.put(TENANT, getter(this, Party::getRelTenant));

        return supplierMap;
    };

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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


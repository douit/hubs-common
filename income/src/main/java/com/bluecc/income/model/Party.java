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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

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
public class Party implements IEventModel<PartyFlatData.Builder>, Serializable {
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
     
    List<UserLogin> relCreatedByUserLogin= new ArrayList<>(); 
    List<UserLogin> relLastModifiedByUserLogin= new ArrayList<>(); 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    List<AcctgTransEntry> relAcctgTransEntry= new ArrayList<>(); 
    List<Agreement> relFromAgreement= new ArrayList<>(); 
    List<Agreement> relToAgreement= new ArrayList<>(); 
    List<BillingAccountRole> relBillingAccountRole= new ArrayList<>(); 
    List<CarrierShipmentBoxType> relCarrierShipmentBoxType= new ArrayList<>(); 
    List<CarrierShipmentMethod> relCarrierShipmentMethod= new ArrayList<>(); 
    List<CommunicationEvent> relToCommunicationEvent= new ArrayList<>(); 
    List<CommunicationEvent> relFromCommunicationEvent= new ArrayList<>(); 
    List<CommunicationEventRole> relCommunicationEventRole= new ArrayList<>(); 
    List<ContentRole> relContentRole= new ArrayList<>(); 
    List<CustRequest> relFromCustRequest= new ArrayList<>(); 
    List<CustRequestType> relCustRequestType= new ArrayList<>(); 
    List<FinAccount> relOrganizationFinAccount= new ArrayList<>(); 
    List<FinAccount> relOwnerFinAccount= new ArrayList<>(); 
    List<FixedAsset> relFixedAsset= new ArrayList<>(); 
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    List<InventoryItem> relOwnerInventoryItem= new ArrayList<>(); 
    List<Invoice> relFromInvoice= new ArrayList<>(); 
    List<Invoice> relInvoice= new ArrayList<>(); 
    List<InvoiceItem> relTaxAuthorityInvoiceItem= new ArrayList<>(); 
    List<InvoiceItem> relOverrideOrgInvoiceItem= new ArrayList<>(); 
    List<InvoiceRole> relInvoiceRole= new ArrayList<>(); 
    List<OrderItemShipGroup> relSupplierOrderItemShipGroup= new ArrayList<>(); 
    List<OrderItemShipGroup> relVendorOrderItemShipGroup= new ArrayList<>(); 
    List<OrderItemShipGroup> relCarrierOrderItemShipGroup= new ArrayList<>(); 
    List<OrderRole> relOrderRole= new ArrayList<>(); 
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    List<PartyGeoPoint> relPartyGeoPoint= new ArrayList<>(); 
    List<PartyGroup> relPartyGroup= new ArrayList<>(); 
    List<PartyIdentification> relPartyIdentification= new ArrayList<>(); 
    List<PartyRelationship> relFromPartyRelationship= new ArrayList<>(); 
    List<PartyRelationship> relToPartyRelationship= new ArrayList<>(); 
    List<PartyRole> relPartyRole= new ArrayList<>(); 
    List<PartyStatus> relPartyStatus= new ArrayList<>(); 
    List<PartyTaxAuthInfo> relPartyTaxAuthInfo= new ArrayList<>(); 
    List<Payment> relFromPayment= new ArrayList<>(); 
    List<Payment> relToPayment= new ArrayList<>(); 
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    List<Person> relPerson= new ArrayList<>(); 
    List<ProductCategoryRole> relProductCategoryRole= new ArrayList<>(); 
    List<ProductPrice> relTaxAuthorityProductPrice= new ArrayList<>(); 
    List<ProductPromo> relProductPromo= new ArrayList<>(); 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    List<ProductStoreShipmentMeth> relProductStoreShipmentMeth= new ArrayList<>(); 
    List<Quote> relQuote= new ArrayList<>(); 
    List<QuoteRole> relQuoteRole= new ArrayList<>(); 
    List<Shipment> relToShipment= new ArrayList<>(); 
    List<Shipment> relFromShipment= new ArrayList<>(); 
    List<ShipmentCostEstimate> relShipmentCostEstimate= new ArrayList<>(); 
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    List<SupplierProduct> relSupplierProduct= new ArrayList<>(); 
    List<SupplierProductFeature> relSupplierProductFeature= new ArrayList<>(); 
    List<TaxAuthority> relTaxAuthTaxAuthority= new ArrayList<>(); 
    List<TaxAuthorityGlAccount> relOrganizationTaxAuthorityGlAccount= new ArrayList<>(); 
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

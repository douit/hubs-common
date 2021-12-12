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
    List<FinAccount> relOrganizationFinAccount= new ArrayList<>(); 
    @Exclude
    List<FinAccount> relOwnerFinAccount= new ArrayList<>(); 
    @Exclude
    List<FixedAsset> relFixedAsset= new ArrayList<>(); 
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
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
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

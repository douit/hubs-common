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

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.PartyGroupFlatData;

import com.bluecc.hubs.stub.PartyGroupData;
import com.bluecc.income.dao.PartyGroupDelegator;
import static com.bluecc.income.dao.PartyGroupDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyGroupData.class,
        symbol = EntityNames.PartyGroup)
public class PartyGroup implements IEventModel<PartyGroupFlatData.Builder>, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @RId String partyId;
    String groupName;
    String groupNameLocal;
    String officeSiteName;
    java.math.BigDecimal annualRevenue;
    Long numEmployees;
    String tickerSymbol;
    String comments;
    String logoImageUrl;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyGroupFlatData.Builder toDataBuilder() {
        PartyGroupFlatData.Builder builder = PartyGroupFlatData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (groupName != null) {
            builder.setGroupName(groupName);
        }
        if (groupNameLocal != null) {
            builder.setGroupNameLocal(groupNameLocal);
        }
        if (officeSiteName != null) {
            builder.setOfficeSiteName(officeSiteName);
        }
        if (annualRevenue != null) {
            builder.setAnnualRevenue(getCurrency(annualRevenue));
        }
        if (numEmployees != null) {
            builder.setNumEmployees(numEmployees);
        }
        if (tickerSymbol != null) {
            builder.setTickerSymbol(tickerSymbol);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (logoImageUrl != null) {
            builder.setLogoImageUrl(logoImageUrl);
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

    public static PartyGroup fromData(PartyGroupFlatData data) {
        return PartyGroup.builder()
                .partyId(data.getPartyId())
                .groupName(data.getGroupName())
                .groupNameLocal(data.getGroupNameLocal())
                .officeSiteName(data.getOfficeSiteName())
                .annualRevenue(getBigDecimal(data.getAnnualRevenue()))
                .numEmployees(data.getNumEmployees())
                .tickerSymbol(data.getTickerSymbol())
                .comments(data.getComments())
                .logoImageUrl(data.getLogoImageUrl())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addParty")
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMech")
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMechPurpose")
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreRole")
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    @Exclude
    @Singular("addToShipment")
    List<Shipment> relToShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addFromShipment")
    List<Shipment> relFromShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentRouteSegment")
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLogin")
    List<UserLogin> relUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARTY, getter(this, PartyGroup::getRelParty)); 
        supplierMap.put(PARTY_CONTACT_MECH, getter(this, PartyGroup::getRelPartyContactMech)); 
        supplierMap.put(PARTY_CONTACT_MECH_PURPOSE, getter(this, PartyGroup::getRelPartyContactMechPurpose)); 
        supplierMap.put(PRODUCT_STORE_ROLE, getter(this, PartyGroup::getRelProductStoreRole)); 
        supplierMap.put(TO_SHIPMENT, getter(this, PartyGroup::getRelToShipment)); 
        supplierMap.put(FROM_SHIPMENT, getter(this, PartyGroup::getRelFromShipment)); 
        supplierMap.put(CARRIER_SHIPMENT_ROUTE_SEGMENT, getter(this, PartyGroup::getRelCarrierShipmentRouteSegment)); 
        supplierMap.put(USER_LOGIN, getter(this, PartyGroup::getRelUserLogin)); 
        supplierMap.put(TENANT, getter(this, PartyGroup::getRelTenant));

        return supplierMap;
    };

    public PartyGroupDelegator.Agent agent(IProc.ProcContext ctx,
                                             PartyGroupDelegator delegator){
        return delegator.getAgent(ctx, this.getPartyId());
    }

    public PartyGroupData.Builder toHeadBuilder() {
        PartyGroupData.Builder builder = PartyGroupData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (groupName != null) {
            builder.setGroupName(groupName);
        }
        if (groupNameLocal != null) {
            builder.setGroupNameLocal(groupNameLocal);
        }
        if (officeSiteName != null) {
            builder.setOfficeSiteName(officeSiteName);
        }
        if (annualRevenue != null) {
            builder.setAnnualRevenue(getCurrency(annualRevenue));
        }
        if (numEmployees != null) {
            builder.setNumEmployees(numEmployees);
        }
        if (tickerSymbol != null) {
            builder.setTickerSymbol(tickerSymbol);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (logoImageUrl != null) {
            builder.setLogoImageUrl(logoImageUrl);
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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


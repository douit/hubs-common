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
public class PartyGroup implements IEventModel<PartyGroupFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RId 
    String partyId;
    @SerializedName("group_name") 
    String groupName;
    @SerializedName("group_name_local") 
    String groupNameLocal;
    @SerializedName("office_site_name") 
    String officeSiteName;
    @SerializedName("annual_revenue") 
    java.math.BigDecimal annualRevenue;
    @SerializedName("num_employees") 
    Long numEmployees;
    @SerializedName("ticker_symbol") 
    String tickerSymbol;
    @SerializedName("comments") 
    String comments;
    @SerializedName("logo_image_url") 
    String logoImageUrl;
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

    public PartyGroupFlatData.Builder toDataBuilder() {
        PartyGroupFlatData.Builder builder = PartyGroupFlatData.newBuilder();
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getGroupName() != null) {
            builder.setGroupName(getGroupName());
        }
        if (getGroupNameLocal() != null) {
            builder.setGroupNameLocal(getGroupNameLocal());
        }
        if (getOfficeSiteName() != null) {
            builder.setOfficeSiteName(getOfficeSiteName());
        }
        if (getAnnualRevenue() != null) {
            builder.setAnnualRevenue(getCurrency(getAnnualRevenue()));
        }
        if (getNumEmployees() != null) {
            builder.setNumEmployees(getNumEmployees());
        }
        if (getTickerSymbol() != null) {
            builder.setTickerSymbol(getTickerSymbol());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getLogoImageUrl() != null) {
            builder.setLogoImageUrl(getLogoImageUrl());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static PartyGroup fromData(PartyGroupFlatData data) {
        return fromPrototype(data).build();
    }

    public static PartyGroup.PartyGroupBuilder fromPrototype(PartyGroupFlatData data) {
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
                ;
    }

        // relations
     
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMech")
    @SerializedName("party_contact_mech") 
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMechPurpose")
    @SerializedName("party_contact_mech_purpose") 
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreRole")
    @SerializedName("product_store_role") 
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    @Exclude
    @Singular("addToShipment")
    @SerializedName("to_shipment") 
    List<Shipment> relToShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addFromShipment")
    @SerializedName("from_shipment") 
    List<Shipment> relFromShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentRouteSegment")
    @SerializedName("carrier_shipment_route_segment") 
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLogin")
    @SerializedName("user_login") 
    List<UserLogin> relUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
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
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getGroupName() != null) {
            builder.setGroupName(getGroupName());
        }
        if (getGroupNameLocal() != null) {
            builder.setGroupNameLocal(getGroupNameLocal());
        }
        if (getOfficeSiteName() != null) {
            builder.setOfficeSiteName(getOfficeSiteName());
        }
        if (getAnnualRevenue() != null) {
            builder.setAnnualRevenue(getCurrency(getAnnualRevenue()));
        }
        if (getNumEmployees() != null) {
            builder.setNumEmployees(getNumEmployees());
        }
        if (getTickerSymbol() != null) {
            builder.setTickerSymbol(getTickerSymbol());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getLogoImageUrl() != null) {
            builder.setLogoImageUrl(getLogoImageUrl());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
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


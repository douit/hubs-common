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

import com.bluecc.hubs.stub.PartyGroupFlatData;

import com.bluecc.hubs.stub.PartyGroupData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyGroupData.class,
        symbol = EntityNames.PartyGroup)
public class PartyGroup implements IEventModel<PartyGroupFlatData.Builder>, Serializable {
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
                
                .build();
    }

        // relations
     
    List<Party> relParty= new ArrayList<>(); 
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    List<Shipment> relToShipment= new ArrayList<>(); 
    List<Shipment> relFromShipment= new ArrayList<>(); 
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    List<UserLogin> relUserLogin= new ArrayList<>();

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

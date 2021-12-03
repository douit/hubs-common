package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;

import com.bluecc.hubs.fund.model.IModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyGroupFlatData;

import com.bluecc.hubs.stub.PartyGroupData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyGroup implements IModel, Serializable {
    private static final long serialVersionUID = 1L;

    String partyId;
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

    @SuppressWarnings("unchecked")
    public <T extends Message.Builder> T toDataBuilder() {
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
                    
        return (T)builder;
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

    
    @SuppressWarnings("unchecked")
    public <T extends Message.Builder> T toHeadBuilder() {
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
                    
        return (T)builder;
    }

}

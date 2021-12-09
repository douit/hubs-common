package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.PartyFlatData;

import com.bluecc.hubs.stub.PartyData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
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

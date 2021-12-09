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

import com.bluecc.hubs.stub.TelecomNumberData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TelecomNumberData.class,
        symbol = EntityNames.TelecomNumber)
public class TelecomNumber implements IEventModel<TelecomNumberData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String contactMechId;
    String countryCode;
    String areaCode;
    String contactNumber;
    String askForName;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TelecomNumberData.Builder toDataBuilder() {
        TelecomNumberData.Builder builder = TelecomNumberData.newBuilder();
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (countryCode != null) {
            builder.setCountryCode(countryCode);
        }
        if (areaCode != null) {
            builder.setAreaCode(areaCode);
        }
        if (contactNumber != null) {
            builder.setContactNumber(contactNumber);
        }
        if (askForName != null) {
            builder.setAskForName(askForName);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TelecomNumber fromData(TelecomNumberData data) {
        return TelecomNumber.builder()
                .contactMechId(data.getContactMechId())
                .countryCode(data.getCountryCode())
                .areaCode(data.getAreaCode())
                .contactNumber(data.getContactNumber())
                .askForName(data.getAskForName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}

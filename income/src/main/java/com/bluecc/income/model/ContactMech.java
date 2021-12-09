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

import com.bluecc.hubs.stub.ContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ContactMech implements IEventModel<ContactMechData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String contactMechId;
    String contactMechTypeId;
    String infoString;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContactMechData.Builder toDataBuilder() {
        ContactMechData.Builder builder = ContactMechData.newBuilder();
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (contactMechTypeId != null) {
            builder.setContactMechTypeId(contactMechTypeId);
        }
        if (infoString != null) {
            builder.setInfoString(infoString);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ContactMech fromData(ContactMechData data) {
        return ContactMech.builder()
                .contactMechId(data.getContactMechId())
                .contactMechTypeId(data.getContactMechTypeId())
                .infoString(data.getInfoString())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}

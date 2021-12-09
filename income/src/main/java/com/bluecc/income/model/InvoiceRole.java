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

import com.bluecc.hubs.stub.InvoiceRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class InvoiceRole implements IEventModel<InvoiceRoleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String invoiceId;
    @RIndex String partyId;
    @RIndex String roleTypeId;
    java.time.LocalDateTime datetimePerformed;
    java.math.BigDecimal percentage;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceRoleData.Builder toDataBuilder() {
        InvoiceRoleData.Builder builder = InvoiceRoleData.newBuilder();
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (datetimePerformed != null) {
            builder.setDatetimePerformed(getTimestamp(datetimePerformed));
        }
        if (percentage != null) {
            builder.setPercentage(getFixedPoint(percentage));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static InvoiceRole fromData(InvoiceRoleData data) {
        return InvoiceRole.builder()
                .invoiceId(data.getInvoiceId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .datetimePerformed(getLocalDateTime(data.getDatetimePerformed()))
                .percentage(getBigDecimal(data.getPercentage()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

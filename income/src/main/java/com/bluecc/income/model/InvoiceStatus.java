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

import com.bluecc.hubs.stub.InvoiceStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class InvoiceStatus implements IEventModel<InvoiceStatusData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String statusId;
    @RIndex String invoiceId;
    java.time.LocalDateTime statusDate;
    String changeByUserLoginId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceStatusData.Builder toDataBuilder() {
        InvoiceStatusData.Builder builder = InvoiceStatusData.newBuilder();
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (statusDate != null) {
            builder.setStatusDate(getTimestamp(statusDate));
        }
        if (changeByUserLoginId != null) {
            builder.setChangeByUserLoginId(changeByUserLoginId);
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

    public static InvoiceStatus fromData(InvoiceStatusData data) {
        return InvoiceStatus.builder()
                .statusId(data.getStatusId())
                .invoiceId(data.getInvoiceId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

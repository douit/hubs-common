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

import com.bluecc.hubs.stub.InvoiceStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InvoiceStatusData.class,
        symbol = EntityNames.InvoiceStatus)
public class InvoiceStatus implements IEventModel<InvoiceStatusData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("status_id")
	@RIndex 
    String statusId;
    @SerializedName("invoice_id")
	@RIndex 
    String invoiceId;
    @SerializedName("status_date") 
    java.time.LocalDateTime statusDate;
    @SerializedName("change_by_user_login_id") 
    String changeByUserLoginId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceStatusData.Builder toDataBuilder() {
        InvoiceStatusData.Builder builder = InvoiceStatusData.newBuilder();
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getStatusDate() != null) {
            builder.setStatusDate(getTimestamp(getStatusDate()));
        }
        if (getChangeByUserLoginId() != null) {
            builder.setChangeByUserLoginId(getChangeByUserLoginId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static InvoiceStatus fromData(InvoiceStatusData data) {
        return fromPrototype(data).build();
    }

    public static InvoiceStatus.InvoiceStatusBuilder fromPrototype(InvoiceStatusData data) {
        return InvoiceStatus.builder()
                .statusId(data.getStatusId())
                .invoiceId(data.getInvoiceId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: statusId, invoiceId, statusDate

-- fields --
    
    String statusId
    String invoiceId
    java.time.LocalDateTime statusDate
    String changeByUserLoginId

-- relations --
    
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - Invoice (one, autoRelation: false, keymaps: invoiceId)
    - ChangeByUserLogin (one, autoRelation: false, keymaps: changeByUserLoginId -> userLoginId)
*/


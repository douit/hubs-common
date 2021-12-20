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

import com.bluecc.hubs.stub.InvoiceRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InvoiceRoleData.class,
        symbol = EntityNames.InvoiceRole)
public class InvoiceRole implements IEventModel<InvoiceRoleData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("invoice_id")
	@RIndex 
    String invoiceId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("role_type_id")
	@RIndex 
    String roleTypeId;
    @SerializedName("datetime_performed") 
    java.time.LocalDateTime datetimePerformed;
    @SerializedName("percentage") 
    java.math.BigDecimal percentage;
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

    public InvoiceRoleData.Builder toDataBuilder() {
        InvoiceRoleData.Builder builder = InvoiceRoleData.newBuilder();
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getDatetimePerformed() != null) {
            builder.setDatetimePerformed(getTimestamp(getDatetimePerformed()));
        }
        if (getPercentage() != null) {
            builder.setPercentage(getFixedPoint(getPercentage()));
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

    public static InvoiceRole fromData(InvoiceRoleData data) {
        return fromPrototype(data).build();
    }

    public static InvoiceRole.InvoiceRoleBuilder fromPrototype(InvoiceRoleData data) {
        return InvoiceRole.builder()
                .invoiceId(data.getInvoiceId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .datetimePerformed(getLocalDateTime(data.getDatetimePerformed()))
                .percentage(getBigDecimal(data.getPercentage()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: invoiceId, partyId, roleTypeId

-- fields --
    
    String invoiceId
    String partyId
    String roleTypeId
    java.time.LocalDateTime datetimePerformed
    java.math.BigDecimal percentage

-- relations --
    
    - Invoice (one, autoRelation: false, keymaps: invoiceId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one-nofk, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
*/


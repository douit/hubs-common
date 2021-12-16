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


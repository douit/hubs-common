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

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.InvoiceItemTypeGlAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InvoiceItemTypeGlAccountData.class,
        symbol = EntityNames.InvoiceItemTypeGlAccount)
public class InvoiceItemTypeGlAccount implements IEventModel<InvoiceItemTypeGlAccountData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String invoiceItemTypeId;
    @RIndex String organizationPartyId;
    String glAccountId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceItemTypeGlAccountData.Builder toDataBuilder() {
        InvoiceItemTypeGlAccountData.Builder builder = InvoiceItemTypeGlAccountData.newBuilder();
        if (invoiceItemTypeId != null) {
            builder.setInvoiceItemTypeId(invoiceItemTypeId);
        }
        if (organizationPartyId != null) {
            builder.setOrganizationPartyId(organizationPartyId);
        }
        if (glAccountId != null) {
            builder.setGlAccountId(glAccountId);
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

    public static InvoiceItemTypeGlAccount fromData(InvoiceItemTypeGlAccountData data) {
        return InvoiceItemTypeGlAccount.builder()
                .invoiceItemTypeId(data.getInvoiceItemTypeId())
                .organizationPartyId(data.getOrganizationPartyId())
                .glAccountId(data.getGlAccountId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: invoiceItemTypeId, organizationPartyId

-- fields --
    
    String invoiceItemTypeId
    String organizationPartyId
    String glAccountId

-- relations --
    
    - InvoiceItemType (one, autoRelation: false, keymaps: invoiceItemTypeId)
    - OrganizationParty (one, autoRelation: false, keymaps: organizationPartyId -> partyId)
    - GlAccount (one, autoRelation: false, keymaps: glAccountId)
*/


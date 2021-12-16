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

import com.bluecc.hubs.stub.CustRequestTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CustRequestTypeData.class,
        symbol = EntityNames.CustRequestType)
public class CustRequestType implements IEventModel<CustRequestTypeData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String custRequestTypeId;
    String parentTypeId;
    Character hasTable;
    String description;
    String partyId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CustRequestTypeData.Builder toDataBuilder() {
        CustRequestTypeData.Builder builder = CustRequestTypeData.newBuilder();
        if (custRequestTypeId != null) {
            builder.setCustRequestTypeId(custRequestTypeId);
        }
        if (parentTypeId != null) {
            builder.setParentTypeId(parentTypeId);
        }
        if (hasTable != null) {
            builder.setHasTable(getIndicator(hasTable));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static CustRequestType fromData(CustRequestTypeData data) {
        return CustRequestType.builder()
                .custRequestTypeId(data.getCustRequestTypeId())
                .parentTypeId(data.getParentTypeId())
                .hasTable(getIndicatorChar(data.getHasTable()))
                .description(data.getDescription())
                .partyId(data.getPartyId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: custRequestTypeId

-- fields --
    
    String custRequestTypeId
    String parentTypeId
    Character hasTable
    String description
    String partyId

-- relations --
    
    - ParentCustRequestType (one, autoRelation: false, keymaps: parentTypeId -> custRequestTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
    + PartyRelationship (many, autoRelation: false, keymaps: partyId -> partyIdFrom)
    + CustRequest (many, autoRelation: true, keymaps: custRequestTypeId)
    + CustRequestCategory (many, autoRelation: true, keymaps: custRequestTypeId)
    + CustRequestResolution (many, autoRelation: true, keymaps: custRequestTypeId)
    + ChildCustRequestType (many, autoRelation: true, keymaps: custRequestTypeId -> parentTypeId)
    + CustRequestTypeAttr (many, autoRelation: true, keymaps: custRequestTypeId)
*/


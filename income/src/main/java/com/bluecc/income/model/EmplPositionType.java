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

import com.bluecc.hubs.stub.EmplPositionTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = EmplPositionTypeData.class,
        symbol = EntityNames.EmplPositionType)
public class EmplPositionType implements IEventModel<EmplPositionTypeData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String emplPositionTypeId;
    String parentTypeId;
    Character hasTable;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EmplPositionTypeData.Builder toDataBuilder() {
        EmplPositionTypeData.Builder builder = EmplPositionTypeData.newBuilder();
        if (emplPositionTypeId != null) {
            builder.setEmplPositionTypeId(emplPositionTypeId);
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
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static EmplPositionType fromData(EmplPositionTypeData data) {
        return EmplPositionType.builder()
                .emplPositionTypeId(data.getEmplPositionTypeId())
                .parentTypeId(data.getParentTypeId())
                .hasTable(getIndicatorChar(data.getHasTable()))
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: emplPositionTypeId

-- fields --
    
    String emplPositionTypeId
    String parentTypeId
    Character hasTable
    String description

-- relations --
    
    - ParentEmplPositionType (one, autoRelation: false, keymaps: parentTypeId -> emplPositionTypeId)
    + EmplPosition (many, autoRelation: true, keymaps: emplPositionTypeId)
    + ChildEmplPositionType (many, autoRelation: true, keymaps: emplPositionTypeId -> parentTypeId)
    + EmplPositionTypeClass (many, autoRelation: true, keymaps: emplPositionTypeId)
    + EmplPositionTypeRate (many, autoRelation: true, keymaps: emplPositionTypeId)
    + RateAmount (many, autoRelation: true, keymaps: emplPositionTypeId)
    + ValidResponsibility (many, autoRelation: true, keymaps: emplPositionTypeId)
*/


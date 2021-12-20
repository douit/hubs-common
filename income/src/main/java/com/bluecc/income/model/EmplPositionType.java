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

import com.bluecc.hubs.stub.EmplPositionTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = EmplPositionTypeData.class,
        symbol = EntityNames.EmplPositionType)
public class EmplPositionType implements IEventModel<EmplPositionTypeData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("empl_position_type_id")
	@RId 
    String emplPositionTypeId;
    @SerializedName("parent_type_id") 
    String parentTypeId;
    @SerializedName("has_table") 
    Character hasTable;
    @SerializedName("description") 
    String description;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return emplPositionTypeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EmplPositionTypeData.Builder toDataBuilder() {
        EmplPositionTypeData.Builder builder = EmplPositionTypeData.newBuilder();
        if (getEmplPositionTypeId() != null) {
            builder.setEmplPositionTypeId(getEmplPositionTypeId());
        }
        if (getParentTypeId() != null) {
            builder.setParentTypeId(getParentTypeId());
        }
        if (getHasTable() != null) {
            builder.setHasTable(getIndicator(getHasTable()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static EmplPositionType fromData(EmplPositionTypeData data) {
        return fromPrototype(data).build();
    }

    public static EmplPositionType.EmplPositionTypeBuilder fromPrototype(EmplPositionTypeData data) {
        return EmplPositionType.builder()
                .emplPositionTypeId(data.getEmplPositionTypeId())
                .parentTypeId(data.getParentTypeId())
                .hasTable(getIndicatorChar(data.getHasTable()))
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
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


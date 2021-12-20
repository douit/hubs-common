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

import com.bluecc.hubs.stub.ElectronicTextData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ElectronicTextData.class,
        symbol = EntityNames.ElectronicText)
public class ElectronicText implements IEventModel<ElectronicTextData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("data_resource_id")
	@RId 
    String dataResourceId;
    @SerializedName("text_data") 
    String textData;
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
        return dataResourceId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ElectronicTextData.Builder toDataBuilder() {
        ElectronicTextData.Builder builder = ElectronicTextData.newBuilder();
        if (getDataResourceId() != null) {
            builder.setDataResourceId(getDataResourceId());
        }
        if (getTextData() != null) {
            builder.setTextData(getTextData());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ElectronicText fromData(ElectronicTextData data) {
        return fromPrototype(data).build();
    }

    public static ElectronicText.ElectronicTextBuilder fromPrototype(ElectronicTextData data) {
        return ElectronicText.builder()
                .dataResourceId(data.getDataResourceId())
                .textData(data.getTextData())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: dataResourceId

-- fields --
    
    String dataResourceId
    String textData

-- relations --
    
    - DataResource (one, autoRelation: false, keymaps: dataResourceId)
*/


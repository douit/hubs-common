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

import com.bluecc.hubs.stub.UomConversionDatedData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = UomConversionDatedData.class,
        symbol = EntityNames.UomConversionDated)
public class UomConversionDated implements IEventModel<UomConversionDatedData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("uom_id")
	@RIndex 
    String uomId;
    @SerializedName("uom_id_to")
	@RIndex 
    String uomIdTo;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("conversion_factor") 
    Double conversionFactor;
    @SerializedName("custom_method_id") 
    String customMethodId;
    @SerializedName("decimal_scale") 
    Long decimalScale;
    @SerializedName("rounding_mode") 
    String roundingMode;
    @SerializedName("purpose_enum_id") 
    String purposeEnumId;
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

    public UomConversionDatedData.Builder toDataBuilder() {
        UomConversionDatedData.Builder builder = UomConversionDatedData.newBuilder();
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getUomIdTo() != null) {
            builder.setUomIdTo(getUomIdTo());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getConversionFactor() != null) {
            builder.setConversionFactor(getConversionFactor());
        }
        if (getCustomMethodId() != null) {
            builder.setCustomMethodId(getCustomMethodId());
        }
        if (getDecimalScale() != null) {
            builder.setDecimalScale(getDecimalScale());
        }
        if (getRoundingMode() != null) {
            builder.setRoundingMode(getRoundingMode());
        }
        if (getPurposeEnumId() != null) {
            builder.setPurposeEnumId(getPurposeEnumId());
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

    public static UomConversionDated fromData(UomConversionDatedData data) {
        return fromPrototype(data).build();
    }

    public static UomConversionDated.UomConversionDatedBuilder fromPrototype(UomConversionDatedData data) {
        return UomConversionDated.builder()
                .uomId(data.getUomId())
                .uomIdTo(data.getUomIdTo())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .conversionFactor(data.getConversionFactor())
                .customMethodId(data.getCustomMethodId())
                .decimalScale(data.getDecimalScale())
                .roundingMode(data.getRoundingMode())
                .purposeEnumId(data.getPurposeEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: uomId, uomIdTo, fromDate

-- fields --
    
    String uomId
    String uomIdTo
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Double conversionFactor
    String customMethodId
    Long decimalScale
    String roundingMode
    String purposeEnumId

-- relations --
    
    - DatedMainUom (one, autoRelation: false, keymaps: uomId)
    - DatedConvToUom (one, autoRelation: false, keymaps: uomIdTo -> uomId)
    - uomCustomMethodCustomMethod (one, autoRelation: false, keymaps: customMethodId)
    - PurposeEnumeration (one, autoRelation: false, keymaps: purposeEnumId -> enumId)
*/


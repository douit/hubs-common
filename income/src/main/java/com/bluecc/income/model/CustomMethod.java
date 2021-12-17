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

import com.bluecc.hubs.stub.CustomMethodData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CustomMethodData.class,
        symbol = EntityNames.CustomMethod)
public class CustomMethod implements IEventModel<CustomMethodData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("custom_method_id")
	@RId 
    String customMethodId;
    @SerializedName("custom_method_type_id") 
    String customMethodTypeId;
    @SerializedName("custom_method_name") 
    String customMethodName;
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
        return customMethodId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CustomMethodData.Builder toDataBuilder() {
        CustomMethodData.Builder builder = CustomMethodData.newBuilder();
        if (customMethodId != null) {
            builder.setCustomMethodId(customMethodId);
        }
        if (customMethodTypeId != null) {
            builder.setCustomMethodTypeId(customMethodTypeId);
        }
        if (customMethodName != null) {
            builder.setCustomMethodName(customMethodName);
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

    public static CustomMethod fromData(CustomMethodData data) {
        return CustomMethod.builder()
                .customMethodId(data.getCustomMethodId())
                .customMethodTypeId(data.getCustomMethodTypeId())
                .customMethodName(data.getCustomMethodName())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: customMethodId

-- fields --
    
    String customMethodId
    String customMethodTypeId
    String customMethodName
    String description

-- relations --
    
    - CustomMethodType (one, autoRelation: false, keymaps: customMethodTypeId)
    + Content (many, autoRelation: true, keymaps: customMethodId)
    + CostComponentCalc (many, autoRelation: true, keymaps: customMethodId -> costCustomMethodId)
    + FixedAssetDepMethod (many, autoRelation: true, keymaps: customMethodId -> depreciationCustomMethodId)
    + InvoicePartyAcctgPreference (many, autoRelation: true, keymaps: customMethodId -> invoiceSeqCustMethId)
    + QuotePartyAcctgPreference (many, autoRelation: true, keymaps: customMethodId -> quoteSeqCustMethId)
    + OrderPartyAcctgPreference (many, autoRelation: true, keymaps: customMethodId -> orderSeqCustMethId)
    + ProductAssoc (many, autoRelation: true, keymaps: customMethodId -> estimateCalcMethod)
    + ProductPrice (many, autoRelation: true, keymaps: customMethodId -> customPriceCalcService)
    + ProductPromoAction (many, autoRelation: true, keymaps: customMethodId)
    + ProductPromoCond (many, autoRelation: true, keymaps: customMethodId)
    + ProductStorePaymentSetting (many, autoRelation: true, keymaps: customMethodId -> paymentCustomMethodId)
    + ProductStoreShipmentMeth (many, autoRelation: true, keymaps: customMethodId -> shipmentCustomMethodId)
    + ProductStoreTelecomSetting (many, autoRelation: true, keymaps: customMethodId -> telecomCustomMethodId)
    + uomCustomMethodUomConversion (many, autoRelation: true, keymaps: customMethodId)
    + uomCustomMethodUomConversionDated (many, autoRelation: true, keymaps: customMethodId)
    + WorkEffort (many, autoRelation: true, keymaps: customMethodId -> estimateCalcMethod)
*/


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

import com.bluecc.hubs.stub.ProductPromoRuleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoRuleData.class,
        symbol = EntityNames.ProductPromoRule)
public class ProductPromoRule implements IEventModel<ProductPromoRuleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productPromoId;
    @RIndex String productPromoRuleId;
    String ruleName;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoRuleData.Builder toDataBuilder() {
        ProductPromoRuleData.Builder builder = ProductPromoRuleData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (ruleName != null) {
            builder.setRuleName(ruleName);
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

    public static ProductPromoRule fromData(ProductPromoRuleData data) {
        return ProductPromoRule.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .ruleName(data.getRuleName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productPromoId, productPromoRuleId

-- fields --
    
    String productPromoId
    String productPromoRuleId
    String ruleName

-- relations --
    
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    + OrderAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + ProductPromoAction (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + ProductPromoCond (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
*/


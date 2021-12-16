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

import com.bluecc.hubs.stub.ProductPriceRuleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPriceRuleData.class,
        symbol = EntityNames.ProductPriceRule)
public class ProductPriceRule implements IEventModel<ProductPriceRuleData.Builder>, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RId String productPriceRuleId;
    String ruleName;
    String description;
    Character isSale;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPriceRuleData.Builder toDataBuilder() {
        ProductPriceRuleData.Builder builder = ProductPriceRuleData.newBuilder();
        if (productPriceRuleId != null) {
            builder.setProductPriceRuleId(productPriceRuleId);
        }
        if (ruleName != null) {
            builder.setRuleName(ruleName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (isSale != null) {
            builder.setIsSale(getIndicator(isSale));
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductPriceRule fromData(ProductPriceRuleData data) {
        return ProductPriceRule.builder()
                .productPriceRuleId(data.getProductPriceRuleId())
                .ruleName(data.getRuleName())
                .description(data.getDescription())
                .isSale(getIndicatorChar(data.getIsSale()))
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: productPriceRuleId

-- fields --
    
    String productPriceRuleId
    String ruleName
    String description
    Character isSale
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    + MarketingCampaignPrice (many, autoRelation: true, keymaps: productPriceRuleId)
    + OrderItemPriceInfo (many, autoRelation: true, keymaps: productPriceRuleId)
    + ProductPriceAction (many, autoRelation: true, keymaps: productPriceRuleId)
    + ProductPriceCond (many, autoRelation: true, keymaps: productPriceRuleId)
*/


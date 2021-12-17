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

import com.bluecc.hubs.stub.ProductConfigProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductConfigProductData.class,
        symbol = EntityNames.ProductConfigProduct)
public class ProductConfigProduct implements IEventModel<ProductConfigProductData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("config_item_id")
	@RIndex 
    String configItemId;
    @SerializedName("config_option_id")
	@RIndex 
    String configOptionId;
    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("sequence_num") 
    Long sequenceNum;
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

    public ProductConfigProductData.Builder toDataBuilder() {
        ProductConfigProductData.Builder builder = ProductConfigProductData.newBuilder();
        if (configItemId != null) {
            builder.setConfigItemId(configItemId);
        }
        if (configOptionId != null) {
            builder.setConfigOptionId(configOptionId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
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

    public static ProductConfigProduct fromData(ProductConfigProductData data) {
        return ProductConfigProduct.builder()
                .configItemId(data.getConfigItemId())
                .configOptionId(data.getConfigOptionId())
                .productId(data.getProductId())
                .quantity(getBigDecimal(data.getQuantity()))
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: configItemId, configOptionId, productId

-- fields --
    
    String configItemId
    String configOptionId
    String productId
    java.math.BigDecimal quantity
    Long sequenceNum

-- relations --
    
    - ConfigItemProductConfigItem (one, autoRelation: false, keymaps: configItemId)
    - ConfigOptionProductConfigOption (one, autoRelation: false, keymaps: configItemId, configOptionId)
    - ProductProduct (one, autoRelation: false, keymaps: productId)
    + ProductConfigOptionProductOption (many, autoRelation: true, keymaps: configItemId, configOptionId, productId)
*/


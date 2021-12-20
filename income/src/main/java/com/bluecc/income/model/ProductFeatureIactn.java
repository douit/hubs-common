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

import com.bluecc.hubs.stub.ProductFeatureIactnData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFeatureIactnData.class,
        symbol = EntityNames.ProductFeatureIactn)
public class ProductFeatureIactn implements IEventModel<ProductFeatureIactnData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_feature_id")
	@RIndex 
    String productFeatureId;
    @SerializedName("product_feature_id_to")
	@RIndex 
    String productFeatureIdTo;
    @SerializedName("product_feature_iactn_type_id") 
    String productFeatureIactnTypeId;
    @SerializedName("product_id") 
    String productId;
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

    public ProductFeatureIactnData.Builder toDataBuilder() {
        ProductFeatureIactnData.Builder builder = ProductFeatureIactnData.newBuilder();
        if (getProductFeatureId() != null) {
            builder.setProductFeatureId(getProductFeatureId());
        }
        if (getProductFeatureIdTo() != null) {
            builder.setProductFeatureIdTo(getProductFeatureIdTo());
        }
        if (getProductFeatureIactnTypeId() != null) {
            builder.setProductFeatureIactnTypeId(getProductFeatureIactnTypeId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
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

    public static ProductFeatureIactn fromData(ProductFeatureIactnData data) {
        return fromPrototype(data).build();
    }

    public static ProductFeatureIactn.ProductFeatureIactnBuilder fromPrototype(ProductFeatureIactnData data) {
        return ProductFeatureIactn.builder()
                .productFeatureId(data.getProductFeatureId())
                .productFeatureIdTo(data.getProductFeatureIdTo())
                .productFeatureIactnTypeId(data.getProductFeatureIactnTypeId())
                .productId(data.getProductId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productFeatureId, productFeatureIdTo

-- fields --
    
    String productFeatureId
    String productFeatureIdTo
    String productFeatureIactnTypeId
    String productId

-- relations --
    
    - ProductFeatureIactnType (one, autoRelation: false, keymaps: productFeatureIactnTypeId)
    - MainProductFeature (one, autoRelation: false, keymaps: productFeatureId)
    - AssocProductFeature (one, autoRelation: false, keymaps: productFeatureIdTo -> productFeatureId)
*/


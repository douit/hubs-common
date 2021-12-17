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

import com.bluecc.hubs.stub.ProductStorePaymentSettingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStorePaymentSettingData.class,
        symbol = EntityNames.ProductStorePaymentSetting)
public class ProductStorePaymentSetting implements IEventModel<ProductStorePaymentSettingData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RIndex 
    String productStoreId;
    @SerializedName("payment_method_type_id")
	@RIndex 
    String paymentMethodTypeId;
    @SerializedName("payment_service_type_enum_id")
	@RIndex 
    String paymentServiceTypeEnumId;
    @SerializedName("payment_service") 
    String paymentService;
    @SerializedName("payment_custom_method_id") 
    String paymentCustomMethodId;
    @SerializedName("payment_gateway_config_id") 
    String paymentGatewayConfigId;
    @SerializedName("payment_properties_path") 
    String paymentPropertiesPath;
    @SerializedName("apply_to_all_products") 
    Character applyToAllProducts;
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

    public ProductStorePaymentSettingData.Builder toDataBuilder() {
        ProductStorePaymentSettingData.Builder builder = ProductStorePaymentSettingData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (paymentServiceTypeEnumId != null) {
            builder.setPaymentServiceTypeEnumId(paymentServiceTypeEnumId);
        }
        if (paymentService != null) {
            builder.setPaymentService(paymentService);
        }
        if (paymentCustomMethodId != null) {
            builder.setPaymentCustomMethodId(paymentCustomMethodId);
        }
        if (paymentGatewayConfigId != null) {
            builder.setPaymentGatewayConfigId(paymentGatewayConfigId);
        }
        if (paymentPropertiesPath != null) {
            builder.setPaymentPropertiesPath(paymentPropertiesPath);
        }
        if (applyToAllProducts != null) {
            builder.setApplyToAllProducts(getIndicator(applyToAllProducts));
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

    public static ProductStorePaymentSetting fromData(ProductStorePaymentSettingData data) {
        return ProductStorePaymentSetting.builder()
                .productStoreId(data.getProductStoreId())
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .paymentServiceTypeEnumId(data.getPaymentServiceTypeEnumId())
                .paymentService(data.getPaymentService())
                .paymentCustomMethodId(data.getPaymentCustomMethodId())
                .paymentGatewayConfigId(data.getPaymentGatewayConfigId())
                .paymentPropertiesPath(data.getPaymentPropertiesPath())
                .applyToAllProducts(getIndicatorChar(data.getApplyToAllProducts()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productStoreId, paymentMethodTypeId, paymentServiceTypeEnumId

-- fields --
    
    String productStoreId
    String paymentMethodTypeId
    String paymentServiceTypeEnumId
    String paymentService
    String paymentCustomMethodId
    String paymentGatewayConfigId
    String paymentPropertiesPath
    Character applyToAllProducts

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - PaymentMethodType (one, autoRelation: false, keymaps: paymentMethodTypeId)
    - Enumeration (one, autoRelation: false, keymaps: paymentServiceTypeEnumId -> enumId)
    - PaymentGatewayConfig (one, autoRelation: false, keymaps: paymentGatewayConfigId)
    - CustomMethod (one, autoRelation: false, keymaps: paymentCustomMethodId -> customMethodId)
*/


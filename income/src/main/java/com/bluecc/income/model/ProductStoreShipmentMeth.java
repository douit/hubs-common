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

import com.bluecc.hubs.stub.ProductStoreShipmentMethData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreShipmentMethData.class,
        symbol = EntityNames.ProductStoreShipmentMeth)
public class ProductStoreShipmentMeth implements IEventModel<ProductStoreShipmentMethData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_ship_meth_id")
	@RId 
    String productStoreShipMethId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("shipment_method_type_id") 
    String shipmentMethodTypeId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("role_type_id") 
    String roleTypeId;
    @SerializedName("company_party_id") 
    String companyPartyId;
    @SerializedName("min_weight") 
    java.math.BigDecimal minWeight;
    @SerializedName("max_weight") 
    java.math.BigDecimal maxWeight;
    @SerializedName("min_size") 
    java.math.BigDecimal minSize;
    @SerializedName("max_size") 
    java.math.BigDecimal maxSize;
    @SerializedName("min_total") 
    java.math.BigDecimal minTotal;
    @SerializedName("max_total") 
    java.math.BigDecimal maxTotal;
    @SerializedName("allow_usps_addr") 
    Character allowUspsAddr;
    @SerializedName("require_usps_addr") 
    Character requireUspsAddr;
    @SerializedName("allow_company_addr") 
    Character allowCompanyAddr;
    @SerializedName("require_company_addr") 
    Character requireCompanyAddr;
    @SerializedName("include_no_charge_items") 
    Character includeNoChargeItems;
    @SerializedName("include_feature_group") 
    String includeFeatureGroup;
    @SerializedName("exclude_feature_group") 
    String excludeFeatureGroup;
    @SerializedName("include_geo_id") 
    String includeGeoId;
    @SerializedName("exclude_geo_id") 
    String excludeGeoId;
    @SerializedName("service_name") 
    String serviceName;
    @SerializedName("config_props") 
    String configProps;
    @SerializedName("shipment_custom_method_id") 
    String shipmentCustomMethodId;
    @SerializedName("shipment_gateway_config_id") 
    String shipmentGatewayConfigId;
    @SerializedName("sequence_number") 
    Long sequenceNumber;
    @SerializedName("allowance_percent") 
    java.math.BigDecimal allowancePercent;
    @SerializedName("minimum_price") 
    java.math.BigDecimal minimumPrice;
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
        return productStoreShipMethId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreShipmentMethData.Builder toDataBuilder() {
        ProductStoreShipmentMethData.Builder builder = ProductStoreShipmentMethData.newBuilder();
        if (productStoreShipMethId != null) {
            builder.setProductStoreShipMethId(productStoreShipMethId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (shipmentMethodTypeId != null) {
            builder.setShipmentMethodTypeId(shipmentMethodTypeId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (companyPartyId != null) {
            builder.setCompanyPartyId(companyPartyId);
        }
        if (minWeight != null) {
            builder.setMinWeight(getFixedPoint(minWeight));
        }
        if (maxWeight != null) {
            builder.setMaxWeight(getFixedPoint(maxWeight));
        }
        if (minSize != null) {
            builder.setMinSize(getFixedPoint(minSize));
        }
        if (maxSize != null) {
            builder.setMaxSize(getFixedPoint(maxSize));
        }
        if (minTotal != null) {
            builder.setMinTotal(getCurrency(minTotal));
        }
        if (maxTotal != null) {
            builder.setMaxTotal(getCurrency(maxTotal));
        }
        if (allowUspsAddr != null) {
            builder.setAllowUspsAddr(getIndicator(allowUspsAddr));
        }
        if (requireUspsAddr != null) {
            builder.setRequireUspsAddr(getIndicator(requireUspsAddr));
        }
        if (allowCompanyAddr != null) {
            builder.setAllowCompanyAddr(getIndicator(allowCompanyAddr));
        }
        if (requireCompanyAddr != null) {
            builder.setRequireCompanyAddr(getIndicator(requireCompanyAddr));
        }
        if (includeNoChargeItems != null) {
            builder.setIncludeNoChargeItems(getIndicator(includeNoChargeItems));
        }
        if (includeFeatureGroup != null) {
            builder.setIncludeFeatureGroup(includeFeatureGroup);
        }
        if (excludeFeatureGroup != null) {
            builder.setExcludeFeatureGroup(excludeFeatureGroup);
        }
        if (includeGeoId != null) {
            builder.setIncludeGeoId(includeGeoId);
        }
        if (excludeGeoId != null) {
            builder.setExcludeGeoId(excludeGeoId);
        }
        if (serviceName != null) {
            builder.setServiceName(serviceName);
        }
        if (configProps != null) {
            builder.setConfigProps(configProps);
        }
        if (shipmentCustomMethodId != null) {
            builder.setShipmentCustomMethodId(shipmentCustomMethodId);
        }
        if (shipmentGatewayConfigId != null) {
            builder.setShipmentGatewayConfigId(shipmentGatewayConfigId);
        }
        if (sequenceNumber != null) {
            builder.setSequenceNumber(sequenceNumber);
        }
        if (allowancePercent != null) {
            builder.setAllowancePercent(getFixedPoint(allowancePercent));
        }
        if (minimumPrice != null) {
            builder.setMinimumPrice(getCurrency(minimumPrice));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductStoreShipmentMeth fromData(ProductStoreShipmentMethData data) {
        return ProductStoreShipmentMeth.builder()
                .productStoreShipMethId(data.getProductStoreShipMethId())
                .productStoreId(data.getProductStoreId())
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .companyPartyId(data.getCompanyPartyId())
                .minWeight(getBigDecimal(data.getMinWeight()))
                .maxWeight(getBigDecimal(data.getMaxWeight()))
                .minSize(getBigDecimal(data.getMinSize()))
                .maxSize(getBigDecimal(data.getMaxSize()))
                .minTotal(getBigDecimal(data.getMinTotal()))
                .maxTotal(getBigDecimal(data.getMaxTotal()))
                .allowUspsAddr(getIndicatorChar(data.getAllowUspsAddr()))
                .requireUspsAddr(getIndicatorChar(data.getRequireUspsAddr()))
                .allowCompanyAddr(getIndicatorChar(data.getAllowCompanyAddr()))
                .requireCompanyAddr(getIndicatorChar(data.getRequireCompanyAddr()))
                .includeNoChargeItems(getIndicatorChar(data.getIncludeNoChargeItems()))
                .includeFeatureGroup(data.getIncludeFeatureGroup())
                .excludeFeatureGroup(data.getExcludeFeatureGroup())
                .includeGeoId(data.getIncludeGeoId())
                .excludeGeoId(data.getExcludeGeoId())
                .serviceName(data.getServiceName())
                .configProps(data.getConfigProps())
                .shipmentCustomMethodId(data.getShipmentCustomMethodId())
                .shipmentGatewayConfigId(data.getShipmentGatewayConfigId())
                .sequenceNumber(data.getSequenceNumber())
                .allowancePercent(getBigDecimal(data.getAllowancePercent()))
                .minimumPrice(getBigDecimal(data.getMinimumPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: productStoreShipMethId

-- fields --
    
    String productStoreShipMethId
    String productStoreId
    String shipmentMethodTypeId
    String partyId
    String roleTypeId
    String companyPartyId
    java.math.BigDecimal minWeight
    java.math.BigDecimal maxWeight
    java.math.BigDecimal minSize
    java.math.BigDecimal maxSize
    java.math.BigDecimal minTotal
    java.math.BigDecimal maxTotal
    Character allowUspsAddr
    Character requireUspsAddr
    Character allowCompanyAddr
    Character requireCompanyAddr
    Character includeNoChargeItems
    String includeFeatureGroup
    String excludeFeatureGroup
    String includeGeoId
    String excludeGeoId
    String serviceName
    String configProps
    String shipmentCustomMethodId
    String shipmentGatewayConfigId
    Long sequenceNumber
    java.math.BigDecimal allowancePercent
    java.math.BigDecimal minimumPrice

-- relations --
    
    - Party (one-nofk, autoRelation: false, keymaps: companyPartyId -> partyId)
    - ShipmentMethodType (one, autoRelation: false, keymaps: shipmentMethodTypeId)
    - IncludeGeo (one-nofk, autoRelation: false, keymaps: includeGeoId -> geoId)
    - ExcludeGeo (one-nofk, autoRelation: false, keymaps: excludeGeoId -> geoId)
    - ShipmentGatewayConfig (one, autoRelation: false, keymaps: shipmentGatewayConfigId)
    - CustomMethod (one, autoRelation: false, keymaps: shipmentCustomMethodId -> customMethodId)
    + ShipmentCostEstimate (many, autoRelation: true, keymaps: productStoreShipMethId)
*/


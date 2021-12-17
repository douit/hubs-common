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

import com.bluecc.hubs.stub.ShipmentCostEstimateData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentCostEstimateData.class,
        symbol = EntityNames.ShipmentCostEstimate)
public class ShipmentCostEstimate implements IEventModel<ShipmentCostEstimateData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_cost_estimate_id")
	@RId 
    String shipmentCostEstimateId;
    @SerializedName("shipment_method_type_id") 
    String shipmentMethodTypeId;
    @SerializedName("carrier_party_id") 
    String carrierPartyId;
    @SerializedName("carrier_role_type_id") 
    String carrierRoleTypeId;
    @SerializedName("product_store_ship_meth_id") 
    String productStoreShipMethId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("role_type_id") 
    String roleTypeId;
    @SerializedName("geo_id_to") 
    String geoIdTo;
    @SerializedName("geo_id_from") 
    String geoIdFrom;
    @SerializedName("weight_break_id") 
    String weightBreakId;
    @SerializedName("weight_uom_id") 
    String weightUomId;
    @SerializedName("weight_unit_price") 
    java.math.BigDecimal weightUnitPrice;
    @SerializedName("quantity_break_id") 
    String quantityBreakId;
    @SerializedName("quantity_uom_id") 
    String quantityUomId;
    @SerializedName("quantity_unit_price") 
    java.math.BigDecimal quantityUnitPrice;
    @SerializedName("price_break_id") 
    String priceBreakId;
    @SerializedName("price_uom_id") 
    String priceUomId;
    @SerializedName("price_unit_price") 
    java.math.BigDecimal priceUnitPrice;
    @SerializedName("order_flat_price") 
    java.math.BigDecimal orderFlatPrice;
    @SerializedName("order_price_percent") 
    java.math.BigDecimal orderPricePercent;
    @SerializedName("order_item_flat_price") 
    java.math.BigDecimal orderItemFlatPrice;
    @SerializedName("shipping_price_percent") 
    java.math.BigDecimal shippingPricePercent;
    @SerializedName("product_feature_group_id") 
    String productFeatureGroupId;
    @SerializedName("oversize_unit") 
    java.math.BigDecimal oversizeUnit;
    @SerializedName("oversize_price") 
    java.math.BigDecimal oversizePrice;
    @SerializedName("feature_percent") 
    java.math.BigDecimal featurePercent;
    @SerializedName("feature_price") 
    java.math.BigDecimal featurePrice;
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
        return shipmentCostEstimateId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentCostEstimateData.Builder toDataBuilder() {
        ShipmentCostEstimateData.Builder builder = ShipmentCostEstimateData.newBuilder();
        if (shipmentCostEstimateId != null) {
            builder.setShipmentCostEstimateId(shipmentCostEstimateId);
        }
        if (shipmentMethodTypeId != null) {
            builder.setShipmentMethodTypeId(shipmentMethodTypeId);
        }
        if (carrierPartyId != null) {
            builder.setCarrierPartyId(carrierPartyId);
        }
        if (carrierRoleTypeId != null) {
            builder.setCarrierRoleTypeId(carrierRoleTypeId);
        }
        if (productStoreShipMethId != null) {
            builder.setProductStoreShipMethId(productStoreShipMethId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (geoIdTo != null) {
            builder.setGeoIdTo(geoIdTo);
        }
        if (geoIdFrom != null) {
            builder.setGeoIdFrom(geoIdFrom);
        }
        if (weightBreakId != null) {
            builder.setWeightBreakId(weightBreakId);
        }
        if (weightUomId != null) {
            builder.setWeightUomId(weightUomId);
        }
        if (weightUnitPrice != null) {
            builder.setWeightUnitPrice(getCurrency(weightUnitPrice));
        }
        if (quantityBreakId != null) {
            builder.setQuantityBreakId(quantityBreakId);
        }
        if (quantityUomId != null) {
            builder.setQuantityUomId(quantityUomId);
        }
        if (quantityUnitPrice != null) {
            builder.setQuantityUnitPrice(getCurrency(quantityUnitPrice));
        }
        if (priceBreakId != null) {
            builder.setPriceBreakId(priceBreakId);
        }
        if (priceUomId != null) {
            builder.setPriceUomId(priceUomId);
        }
        if (priceUnitPrice != null) {
            builder.setPriceUnitPrice(getCurrency(priceUnitPrice));
        }
        if (orderFlatPrice != null) {
            builder.setOrderFlatPrice(getCurrency(orderFlatPrice));
        }
        if (orderPricePercent != null) {
            builder.setOrderPricePercent(getFixedPoint(orderPricePercent));
        }
        if (orderItemFlatPrice != null) {
            builder.setOrderItemFlatPrice(getCurrency(orderItemFlatPrice));
        }
        if (shippingPricePercent != null) {
            builder.setShippingPricePercent(getFixedPoint(shippingPricePercent));
        }
        if (productFeatureGroupId != null) {
            builder.setProductFeatureGroupId(productFeatureGroupId);
        }
        if (oversizeUnit != null) {
            builder.setOversizeUnit(getFixedPoint(oversizeUnit));
        }
        if (oversizePrice != null) {
            builder.setOversizePrice(getCurrency(oversizePrice));
        }
        if (featurePercent != null) {
            builder.setFeaturePercent(getFixedPoint(featurePercent));
        }
        if (featurePrice != null) {
            builder.setFeaturePrice(getCurrency(featurePrice));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ShipmentCostEstimate fromData(ShipmentCostEstimateData data) {
        return ShipmentCostEstimate.builder()
                .shipmentCostEstimateId(data.getShipmentCostEstimateId())
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .carrierPartyId(data.getCarrierPartyId())
                .carrierRoleTypeId(data.getCarrierRoleTypeId())
                .productStoreShipMethId(data.getProductStoreShipMethId())
                .productStoreId(data.getProductStoreId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .geoIdTo(data.getGeoIdTo())
                .geoIdFrom(data.getGeoIdFrom())
                .weightBreakId(data.getWeightBreakId())
                .weightUomId(data.getWeightUomId())
                .weightUnitPrice(getBigDecimal(data.getWeightUnitPrice()))
                .quantityBreakId(data.getQuantityBreakId())
                .quantityUomId(data.getQuantityUomId())
                .quantityUnitPrice(getBigDecimal(data.getQuantityUnitPrice()))
                .priceBreakId(data.getPriceBreakId())
                .priceUomId(data.getPriceUomId())
                .priceUnitPrice(getBigDecimal(data.getPriceUnitPrice()))
                .orderFlatPrice(getBigDecimal(data.getOrderFlatPrice()))
                .orderPricePercent(getBigDecimal(data.getOrderPricePercent()))
                .orderItemFlatPrice(getBigDecimal(data.getOrderItemFlatPrice()))
                .shippingPricePercent(getBigDecimal(data.getShippingPricePercent()))
                .productFeatureGroupId(data.getProductFeatureGroupId())
                .oversizeUnit(getBigDecimal(data.getOversizeUnit()))
                .oversizePrice(getBigDecimal(data.getOversizePrice()))
                .featurePercent(getBigDecimal(data.getFeaturePercent()))
                .featurePrice(getBigDecimal(data.getFeaturePrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: shipmentCostEstimateId

-- fields --
    
    String shipmentCostEstimateId
    String shipmentMethodTypeId
    String carrierPartyId
    String carrierRoleTypeId
    String productStoreShipMethId
    String productStoreId
    String partyId
    String roleTypeId
    String geoIdTo
    String geoIdFrom
    String weightBreakId
    String weightUomId
    java.math.BigDecimal weightUnitPrice
    String quantityBreakId
    String quantityUomId
    java.math.BigDecimal quantityUnitPrice
    String priceBreakId
    String priceUomId
    java.math.BigDecimal priceUnitPrice
    java.math.BigDecimal orderFlatPrice
    java.math.BigDecimal orderPricePercent
    java.math.BigDecimal orderItemFlatPrice
    java.math.BigDecimal shippingPricePercent
    String productFeatureGroupId
    java.math.BigDecimal oversizeUnit
    java.math.BigDecimal oversizePrice
    java.math.BigDecimal featurePercent
    java.math.BigDecimal featurePrice

-- relations --
    
    - CarrierShipmentMethod (one, autoRelation: false, keymaps: shipmentMethodTypeId, carrierPartyId -> partyId, carrierRoleTypeId -> roleTypeId)
    - ProductStoreShipmentMeth (one, autoRelation: false, keymaps: productStoreShipMethId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one-nofk, autoRelation: false, keymaps: partyId, roleTypeId)
    - WeightUom (one, autoRelation: false, keymaps: weightUomId -> uomId)
    - QuantityUom (one, autoRelation: false, keymaps: quantityUomId -> uomId)
    - PriceUom (one, autoRelation: false, keymaps: priceUomId -> uomId)
    - ToGeo (one, autoRelation: false, keymaps: geoIdTo -> geoId)
    - FromGeo (one, autoRelation: false, keymaps: geoIdFrom -> geoId)
    - WeightQuantityBreak (one, autoRelation: false, keymaps: weightBreakId -> quantityBreakId)
    - QuantityQuantityBreak (one, autoRelation: false, keymaps: quantityBreakId)
    - PriceQuantityBreak (one, autoRelation: false, keymaps: priceBreakId -> quantityBreakId)
*/


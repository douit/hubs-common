package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ShipmentCostEstimateData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentCostEstimate implements IEventModel<ShipmentCostEstimateData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String shipmentCostEstimateId;
    String shipmentMethodTypeId;
    String carrierPartyId;
    String carrierRoleTypeId;
    String productStoreShipMethId;
    String productStoreId;
    String partyId;
    String roleTypeId;
    String geoIdTo;
    String geoIdFrom;
    String weightBreakId;
    String weightUomId;
    java.math.BigDecimal weightUnitPrice;
    String quantityBreakId;
    String quantityUomId;
    java.math.BigDecimal quantityUnitPrice;
    String priceBreakId;
    String priceUomId;
    java.math.BigDecimal priceUnitPrice;
    java.math.BigDecimal orderFlatPrice;
    java.math.BigDecimal orderPricePercent;
    java.math.BigDecimal orderItemFlatPrice;
    java.math.BigDecimal shippingPricePercent;
    String productFeatureGroupId;
    java.math.BigDecimal oversizeUnit;
    java.math.BigDecimal oversizePrice;
    java.math.BigDecimal featurePercent;
    java.math.BigDecimal featurePrice;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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

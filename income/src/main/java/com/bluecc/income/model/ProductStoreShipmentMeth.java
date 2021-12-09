package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.ProductStoreShipmentMethData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreShipmentMethData.class,
        symbol = EntityNames.ProductStoreShipmentMeth)
public class ProductStoreShipmentMeth implements IEventModel<ProductStoreShipmentMethData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String productStoreShipMethId;
    String productStoreId;
    String shipmentMethodTypeId;
    String partyId;
    String roleTypeId;
    String companyPartyId;
    java.math.BigDecimal minWeight;
    java.math.BigDecimal maxWeight;
    java.math.BigDecimal minSize;
    java.math.BigDecimal maxSize;
    java.math.BigDecimal minTotal;
    java.math.BigDecimal maxTotal;
    Character allowUspsAddr;
    Character requireUspsAddr;
    Character allowCompanyAddr;
    Character requireCompanyAddr;
    Character includeNoChargeItems;
    String includeFeatureGroup;
    String excludeFeatureGroup;
    String includeGeoId;
    String excludeGeoId;
    String serviceName;
    String configProps;
    String shipmentCustomMethodId;
    String shipmentGatewayConfigId;
    Long sequenceNumber;
    java.math.BigDecimal allowancePercent;
    java.math.BigDecimal minimumPrice;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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

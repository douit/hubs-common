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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.SupplierProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class SupplierProduct implements IEventModel<SupplierProductData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productId;
    @RIndex String partyId;
    java.time.LocalDateTime availableFromDate;
    java.time.LocalDateTime availableThruDate;
    String supplierPrefOrderId;
    String supplierRatingTypeId;
    java.math.BigDecimal standardLeadTimeDays;
    @RIndex java.math.BigDecimal minimumOrderQuantity;
    java.math.BigDecimal orderQtyIncrements;
    java.math.BigDecimal unitsIncluded;
    String quantityUomId;
    String agreementId;
    String agreementItemSeqId;
    java.math.BigDecimal lastPrice;
    java.math.BigDecimal shippingPrice;
    @RIndex String currencyUomId;
    String supplierProductName;
    String supplierProductId;
    Character canDropShip;
    String comments;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SupplierProductData.Builder toDataBuilder() {
        SupplierProductData.Builder builder = SupplierProductData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (availableFromDate != null) {
            builder.setAvailableFromDate(getTimestamp(availableFromDate));
        }
        if (availableThruDate != null) {
            builder.setAvailableThruDate(getTimestamp(availableThruDate));
        }
        if (supplierPrefOrderId != null) {
            builder.setSupplierPrefOrderId(supplierPrefOrderId);
        }
        if (supplierRatingTypeId != null) {
            builder.setSupplierRatingTypeId(supplierRatingTypeId);
        }
        if (standardLeadTimeDays != null) {
            builder.setStandardLeadTimeDays(getFixedPoint(standardLeadTimeDays));
        }
        if (minimumOrderQuantity != null) {
            builder.setMinimumOrderQuantity(getFixedPoint(minimumOrderQuantity));
        }
        if (orderQtyIncrements != null) {
            builder.setOrderQtyIncrements(getFixedPoint(orderQtyIncrements));
        }
        if (unitsIncluded != null) {
            builder.setUnitsIncluded(getFixedPoint(unitsIncluded));
        }
        if (quantityUomId != null) {
            builder.setQuantityUomId(quantityUomId);
        }
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (agreementItemSeqId != null) {
            builder.setAgreementItemSeqId(agreementItemSeqId);
        }
        if (lastPrice != null) {
            builder.setLastPrice(getCurrency(lastPrice));
        }
        if (shippingPrice != null) {
            builder.setShippingPrice(getCurrency(shippingPrice));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (supplierProductName != null) {
            builder.setSupplierProductName(supplierProductName);
        }
        if (supplierProductId != null) {
            builder.setSupplierProductId(supplierProductId);
        }
        if (canDropShip != null) {
            builder.setCanDropShip(getIndicator(canDropShip));
        }
        if (comments != null) {
            builder.setComments(comments);
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

    public static SupplierProduct fromData(SupplierProductData data) {
        return SupplierProduct.builder()
                .productId(data.getProductId())
                .partyId(data.getPartyId())
                .availableFromDate(getLocalDateTime(data.getAvailableFromDate()))
                .availableThruDate(getLocalDateTime(data.getAvailableThruDate()))
                .supplierPrefOrderId(data.getSupplierPrefOrderId())
                .supplierRatingTypeId(data.getSupplierRatingTypeId())
                .standardLeadTimeDays(getBigDecimal(data.getStandardLeadTimeDays()))
                .minimumOrderQuantity(getBigDecimal(data.getMinimumOrderQuantity()))
                .orderQtyIncrements(getBigDecimal(data.getOrderQtyIncrements()))
                .unitsIncluded(getBigDecimal(data.getUnitsIncluded()))
                .quantityUomId(data.getQuantityUomId())
                .agreementId(data.getAgreementId())
                .agreementItemSeqId(data.getAgreementItemSeqId())
                .lastPrice(getBigDecimal(data.getLastPrice()))
                .shippingPrice(getBigDecimal(data.getShippingPrice()))
                .currencyUomId(data.getCurrencyUomId())
                .supplierProductName(data.getSupplierProductName())
                .supplierProductId(data.getSupplierProductId())
                .canDropShip(getIndicatorChar(data.getCanDropShip()))
                .comments(data.getComments())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

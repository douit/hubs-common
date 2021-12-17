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

import com.bluecc.hubs.stub.SupplierProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SupplierProductData.class,
        symbol = EntityNames.SupplierProduct)
public class SupplierProduct implements IEventModel<SupplierProductData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("available_from_date") 
    java.time.LocalDateTime availableFromDate;
    @SerializedName("available_thru_date") 
    java.time.LocalDateTime availableThruDate;
    @SerializedName("supplier_pref_order_id") 
    String supplierPrefOrderId;
    @SerializedName("supplier_rating_type_id") 
    String supplierRatingTypeId;
    @SerializedName("standard_lead_time_days") 
    java.math.BigDecimal standardLeadTimeDays;
    @SerializedName("minimum_order_quantity")
	@RIndex 
    java.math.BigDecimal minimumOrderQuantity;
    @SerializedName("order_qty_increments") 
    java.math.BigDecimal orderQtyIncrements;
    @SerializedName("units_included") 
    java.math.BigDecimal unitsIncluded;
    @SerializedName("quantity_uom_id") 
    String quantityUomId;
    @SerializedName("agreement_id") 
    String agreementId;
    @SerializedName("agreement_item_seq_id") 
    String agreementItemSeqId;
    @SerializedName("last_price") 
    java.math.BigDecimal lastPrice;
    @SerializedName("shipping_price") 
    java.math.BigDecimal shippingPrice;
    @SerializedName("currency_uom_id")
	@RIndex 
    String currencyUomId;
    @SerializedName("supplier_product_name") 
    String supplierProductName;
    @SerializedName("supplier_product_id") 
    String supplierProductId;
    @SerializedName("can_drop_ship") 
    Character canDropShip;
    @SerializedName("comments") 
    String comments;
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


/*
-- keys: productId, partyId, currencyUomId, minimumOrderQuantity, availableFromDate

-- fields --
    
    String productId
    String partyId
    java.time.LocalDateTime availableFromDate
    java.time.LocalDateTime availableThruDate
    String supplierPrefOrderId
    String supplierRatingTypeId
    java.math.BigDecimal standardLeadTimeDays
    java.math.BigDecimal minimumOrderQuantity
    java.math.BigDecimal orderQtyIncrements
    java.math.BigDecimal unitsIncluded
    String quantityUomId
    String agreementId
    String agreementItemSeqId
    java.math.BigDecimal lastPrice
    java.math.BigDecimal shippingPrice
    String currencyUomId
    String supplierProductName
    String supplierProductId
    Character canDropShip
    String comments

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - SupplierPrefOrder (one, autoRelation: false, keymaps: supplierPrefOrderId)
    - SupplierRatingType (one, autoRelation: false, keymaps: supplierRatingTypeId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - QuantityUom (one, autoRelation: false, keymaps: quantityUomId -> uomId)
    - AgreementItem (one, autoRelation: false, keymaps: agreementId, agreementItemSeqId)
*/


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
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getAvailableFromDate() != null) {
            builder.setAvailableFromDate(getTimestamp(getAvailableFromDate()));
        }
        if (getAvailableThruDate() != null) {
            builder.setAvailableThruDate(getTimestamp(getAvailableThruDate()));
        }
        if (getSupplierPrefOrderId() != null) {
            builder.setSupplierPrefOrderId(getSupplierPrefOrderId());
        }
        if (getSupplierRatingTypeId() != null) {
            builder.setSupplierRatingTypeId(getSupplierRatingTypeId());
        }
        if (getStandardLeadTimeDays() != null) {
            builder.setStandardLeadTimeDays(getFixedPoint(getStandardLeadTimeDays()));
        }
        if (getMinimumOrderQuantity() != null) {
            builder.setMinimumOrderQuantity(getFixedPoint(getMinimumOrderQuantity()));
        }
        if (getOrderQtyIncrements() != null) {
            builder.setOrderQtyIncrements(getFixedPoint(getOrderQtyIncrements()));
        }
        if (getUnitsIncluded() != null) {
            builder.setUnitsIncluded(getFixedPoint(getUnitsIncluded()));
        }
        if (getQuantityUomId() != null) {
            builder.setQuantityUomId(getQuantityUomId());
        }
        if (getAgreementId() != null) {
            builder.setAgreementId(getAgreementId());
        }
        if (getAgreementItemSeqId() != null) {
            builder.setAgreementItemSeqId(getAgreementItemSeqId());
        }
        if (getLastPrice() != null) {
            builder.setLastPrice(getCurrency(getLastPrice()));
        }
        if (getShippingPrice() != null) {
            builder.setShippingPrice(getCurrency(getShippingPrice()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getSupplierProductName() != null) {
            builder.setSupplierProductName(getSupplierProductName());
        }
        if (getSupplierProductId() != null) {
            builder.setSupplierProductId(getSupplierProductId());
        }
        if (getCanDropShip() != null) {
            builder.setCanDropShip(getIndicator(getCanDropShip()));
        }
        if (getComments() != null) {
            builder.setComments(getComments());
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

    public static SupplierProduct fromData(SupplierProductData data) {
        return fromPrototype(data).build();
    }

    public static SupplierProduct.SupplierProductBuilder fromPrototype(SupplierProductData data) {
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
                ;
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


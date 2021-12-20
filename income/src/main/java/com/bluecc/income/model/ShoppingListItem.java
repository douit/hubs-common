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

import com.bluecc.hubs.stub.ShoppingListItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShoppingListItemData.class,
        symbol = EntityNames.ShoppingListItem)
public class ShoppingListItem implements IEventModel<ShoppingListItemData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shopping_list_id")
	@RIndex 
    String shoppingListId;
    @SerializedName("shopping_list_item_seq_id")
	@RIndex 
    String shoppingListItemSeqId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("modified_price") 
    java.math.BigDecimal modifiedPrice;
    @SerializedName("reserv_start") 
    java.time.LocalDateTime reservStart;
    @SerializedName("reserv_length") 
    java.math.BigDecimal reservLength;
    @SerializedName("reserv_persons") 
    java.math.BigDecimal reservPersons;
    @SerializedName("quantity_purchased") 
    java.math.BigDecimal quantityPurchased;
    @SerializedName("config_id") 
    String configId;
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

    public ShoppingListItemData.Builder toDataBuilder() {
        ShoppingListItemData.Builder builder = ShoppingListItemData.newBuilder();
        if (shoppingListId != null) {
            builder.setShoppingListId(shoppingListId);
        }
        if (shoppingListItemSeqId != null) {
            builder.setShoppingListItemSeqId(shoppingListItemSeqId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (modifiedPrice != null) {
            builder.setModifiedPrice(getCurrency(modifiedPrice));
        }
        if (reservStart != null) {
            builder.setReservStart(getTimestamp(reservStart));
        }
        if (reservLength != null) {
            builder.setReservLength(getFixedPoint(reservLength));
        }
        if (reservPersons != null) {
            builder.setReservPersons(getFixedPoint(reservPersons));
        }
        if (quantityPurchased != null) {
            builder.setQuantityPurchased(getFixedPoint(quantityPurchased));
        }
        if (configId != null) {
            builder.setConfigId(configId);
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

    public static ShoppingListItem fromData(ShoppingListItemData data) {
        return ShoppingListItem.builder()
                .shoppingListId(data.getShoppingListId())
                .shoppingListItemSeqId(data.getShoppingListItemSeqId())
                .productId(data.getProductId())
                .quantity(getBigDecimal(data.getQuantity()))
                .modifiedPrice(getBigDecimal(data.getModifiedPrice()))
                .reservStart(getLocalDateTime(data.getReservStart()))
                .reservLength(getBigDecimal(data.getReservLength()))
                .reservPersons(getBigDecimal(data.getReservPersons()))
                .quantityPurchased(getBigDecimal(data.getQuantityPurchased()))
                .configId(data.getConfigId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: shoppingListId, shoppingListItemSeqId

-- fields --
    
    String shoppingListId
    String shoppingListItemSeqId
    String productId
    java.math.BigDecimal quantity
    java.math.BigDecimal modifiedPrice
    java.time.LocalDateTime reservStart
    java.math.BigDecimal reservLength
    java.math.BigDecimal reservPersons
    java.math.BigDecimal quantityPurchased
    String configId

-- relations --
    
    - ShoppingList (one, autoRelation: false, keymaps: shoppingListId)
    - Product (one, autoRelation: false, keymaps: productId)
    + OrderItem (many, autoRelation: true, keymaps: shoppingListId, shoppingListItemSeqId)
    + ShoppingListItemSurvey (many, autoRelation: true, keymaps: shoppingListId, shoppingListItemSeqId)
*/


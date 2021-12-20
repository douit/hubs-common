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

import com.bluecc.hubs.stub.ShoppingListFlatData;

import com.bluecc.hubs.stub.ShoppingListData;
import com.bluecc.income.dao.ShoppingListDelegator;
import static com.bluecc.income.dao.ShoppingListDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShoppingListData.class,
        symbol = EntityNames.ShoppingList)
public class ShoppingList implements IEventModel<ShoppingListFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("shopping_list_id")
	@RId 
    String shoppingListId;
    @SerializedName("shopping_list_type_id") 
    String shoppingListTypeId;
    @SerializedName("parent_shopping_list_id") 
    String parentShoppingListId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("visitor_id") 
    String visitorId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("list_name") 
    String listName;
    @SerializedName("description") 
    String description;
    @SerializedName("is_public") 
    Character isPublic;
    @SerializedName("is_active") 
    Character isActive;
    @SerializedName("currency_uom") 
    String currencyUom;
    @SerializedName("shipment_method_type_id") 
    String shipmentMethodTypeId;
    @SerializedName("carrier_party_id") 
    String carrierPartyId;
    @SerializedName("carrier_role_type_id") 
    String carrierRoleTypeId;
    @SerializedName("contact_mech_id") 
    String contactMechId;
    @SerializedName("payment_method_id") 
    String paymentMethodId;
    @SerializedName("recurrence_info_id") 
    String recurrenceInfoId;
    @SerializedName("last_ordered_date") 
    java.time.LocalDateTime lastOrderedDate;
    @SerializedName("last_admin_modified") 
    java.time.LocalDateTime lastAdminModified;
    @SerializedName("product_promo_code_id") 
    String productPromoCodeId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return shoppingListId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShoppingListFlatData.Builder toDataBuilder() {
        ShoppingListFlatData.Builder builder = ShoppingListFlatData.newBuilder();
        if (shoppingListId != null) {
            builder.setShoppingListId(shoppingListId);
        }
        if (shoppingListTypeId != null) {
            builder.setShoppingListTypeId(shoppingListTypeId);
        }
        if (parentShoppingListId != null) {
            builder.setParentShoppingListId(parentShoppingListId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (visitorId != null) {
            builder.setVisitorId(visitorId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (listName != null) {
            builder.setListName(listName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (isPublic != null) {
            builder.setIsPublic(getIndicator(isPublic));
        }
        if (isActive != null) {
            builder.setIsActive(getIndicator(isActive));
        }
        if (currencyUom != null) {
            builder.setCurrencyUom(currencyUom);
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
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
        }
        if (lastOrderedDate != null) {
            builder.setLastOrderedDate(getTimestamp(lastOrderedDate));
        }
        if (lastAdminModified != null) {
            builder.setLastAdminModified(getTimestamp(lastAdminModified));
        }
        if (productPromoCodeId != null) {
            builder.setProductPromoCodeId(productPromoCodeId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static ShoppingList fromData(ShoppingListFlatData data) {
        return ShoppingList.builder()
                .shoppingListId(data.getShoppingListId())
                .shoppingListTypeId(data.getShoppingListTypeId())
                .parentShoppingListId(data.getParentShoppingListId())
                .productStoreId(data.getProductStoreId())
                .visitorId(data.getVisitorId())
                .partyId(data.getPartyId())
                .listName(data.getListName())
                .description(data.getDescription())
                .isPublic(getIndicatorChar(data.getIsPublic()))
                .isActive(getIndicatorChar(data.getIsActive()))
                .currencyUom(data.getCurrencyUom())
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .carrierPartyId(data.getCarrierPartyId())
                .carrierRoleTypeId(data.getCarrierRoleTypeId())
                .contactMechId(data.getContactMechId())
                .paymentMethodId(data.getPaymentMethodId())
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .lastOrderedDate(getLocalDateTime(data.getLastOrderedDate()))
                .lastAdminModified(getLocalDateTime(data.getLastAdminModified()))
                .productPromoCodeId(data.getProductPromoCodeId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addParentShoppingList")
    @SerializedName("parent_shopping_list") 
    List<ShoppingList> relParentShoppingList= new ArrayList<>(); 
    @Exclude
    @Singular("addSiblingShoppingList")
    @SerializedName("sibling_shopping_list") 
    List<ShoppingList> relSiblingShoppingList= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStore")
    @SerializedName("product_store") 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreShipmentMeth")
    @SerializedName("product_store_shipment_meth") 
    List<ProductStoreShipmentMeth> relProductStoreShipmentMeth= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentMethod")
    @SerializedName("carrier_shipment_method") 
    List<CarrierShipmentMethod> relCarrierShipmentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addContactMech")
    @SerializedName("contact_mech") 
    List<ContactMech> relContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPostalAddress")
    @SerializedName("postal_address") 
    List<PostalAddress> relPostalAddress= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentMethod")
    @SerializedName("payment_method") 
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addRecurrenceInfo")
    @SerializedName("recurrence_info") 
    List<RecurrenceInfo> relRecurrenceInfo= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPromoCode")
    @SerializedName("product_promo_code") 
    List<ProductPromoCode> relProductPromoCode= new ArrayList<>(); 
    @Exclude
    @Singular("addAutoOrderOrderHeader")
    @SerializedName("auto_order_order_header") 
    List<OrderHeader> relAutoOrderOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addChildShoppingList")
    @SerializedName("child_shopping_list") 
    List<ShoppingList> relChildShoppingList= new ArrayList<>(); 
    @Exclude
    @Singular("addShoppingListItem")
    @SerializedName("shopping_list_item") 
    List<ShoppingListItem> relShoppingListItem= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARENT_SHOPPING_LIST, getter(this, ShoppingList::getRelParentShoppingList)); 
        supplierMap.put(SIBLING_SHOPPING_LIST, getter(this, ShoppingList::getRelSiblingShoppingList)); 
        supplierMap.put(PRODUCT_STORE, getter(this, ShoppingList::getRelProductStore)); 
        supplierMap.put(PARTY, getter(this, ShoppingList::getRelParty)); 
        supplierMap.put(PRODUCT_STORE_SHIPMENT_METH, getter(this, ShoppingList::getRelProductStoreShipmentMeth)); 
        supplierMap.put(CARRIER_SHIPMENT_METHOD, getter(this, ShoppingList::getRelCarrierShipmentMethod)); 
        supplierMap.put(CONTACT_MECH, getter(this, ShoppingList::getRelContactMech)); 
        supplierMap.put(POSTAL_ADDRESS, getter(this, ShoppingList::getRelPostalAddress)); 
        supplierMap.put(PAYMENT_METHOD, getter(this, ShoppingList::getRelPaymentMethod)); 
        supplierMap.put(RECURRENCE_INFO, getter(this, ShoppingList::getRelRecurrenceInfo)); 
        supplierMap.put(PRODUCT_PROMO_CODE, getter(this, ShoppingList::getRelProductPromoCode)); 
        supplierMap.put(AUTO_ORDER_ORDER_HEADER, getter(this, ShoppingList::getRelAutoOrderOrderHeader)); 
        supplierMap.put(CHILD_SHOPPING_LIST, getter(this, ShoppingList::getRelChildShoppingList)); 
        supplierMap.put(SHOPPING_LIST_ITEM, getter(this, ShoppingList::getRelShoppingListItem)); 
        supplierMap.put(TENANT, getter(this, ShoppingList::getRelTenant));

        return supplierMap;
    };

    public ShoppingListDelegator.Agent agent(IProc.ProcContext ctx,
                                             ShoppingListDelegator delegator){
        return delegator.getAgent(ctx, this.getShoppingListId());
    }

    public ShoppingListData.Builder toHeadBuilder() {
        ShoppingListData.Builder builder = ShoppingListData.newBuilder();
        if (shoppingListId != null) {
            builder.setShoppingListId(shoppingListId);
        }
        if (shoppingListTypeId != null) {
            builder.setShoppingListTypeId(shoppingListTypeId);
        }
        if (visitorId != null) {
            builder.setVisitorId(visitorId);
        }
        if (listName != null) {
            builder.setListName(listName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (isPublic != null) {
            builder.setIsPublic(getIndicator(isPublic));
        }
        if (isActive != null) {
            builder.setIsActive(getIndicator(isActive));
        }
        if (currencyUom != null) {
            builder.setCurrencyUom(currencyUom);
        }
        if (carrierPartyId != null) {
            builder.setCarrierPartyId(carrierPartyId);
        }
        if (carrierRoleTypeId != null) {
            builder.setCarrierRoleTypeId(carrierRoleTypeId);
        }
        if (lastOrderedDate != null) {
            builder.setLastOrderedDate(getTimestamp(lastOrderedDate));
        }
        if (lastAdminModified != null) {
            builder.setLastAdminModified(getTimestamp(lastAdminModified));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: shoppingListId

-- fields --
    
    String shoppingListId
    String shoppingListTypeId
    String parentShoppingListId
    String productStoreId
    String visitorId
    String partyId
    String listName
    String description
    Character isPublic
    Character isActive
    String currencyUom
    String shipmentMethodTypeId
    String carrierPartyId
    String carrierRoleTypeId
    String contactMechId
    String paymentMethodId
    String recurrenceInfoId
    java.time.LocalDateTime lastOrderedDate
    java.time.LocalDateTime lastAdminModified
    String productPromoCodeId

-- relations --
    
    - ParentShoppingList (one, autoRelation: false, keymaps: parentShoppingListId -> shoppingListId)
    + SiblingShoppingList (many, autoRelation: false, keymaps: parentShoppingListId)
    - ShoppingListType (one, autoRelation: false, keymaps: shoppingListTypeId)
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - Party (one, autoRelation: false, keymaps: partyId)
    + ProductStoreShipmentMeth (many, autoRelation: false, keymaps: productStoreId, shipmentMethodTypeId, carrierPartyId -> partyId, carrierRoleTypeId -> roleTypeId)
    - CarrierShipmentMethod (one, autoRelation: false, keymaps: shipmentMethodTypeId, carrierPartyId -> partyId, carrierRoleTypeId -> roleTypeId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - PostalAddress (one-nofk, autoRelation: false, keymaps: contactMechId)
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    - RecurrenceInfo (one, autoRelation: false, keymaps: recurrenceInfoId)
    - ProductPromoCode (one, autoRelation: false, keymaps: productPromoCodeId)
    + AutoOrderOrderHeader (many, autoRelation: true, keymaps: shoppingListId -> autoOrderShoppingListId)
    + ChildShoppingList (many, autoRelation: true, keymaps: shoppingListId -> parentShoppingListId)
    + ShoppingListItem (many, autoRelation: true, keymaps: shoppingListId)
    + ShoppingListItemSurvey (many, autoRelation: true, keymaps: shoppingListId)
    + ShoppingListWorkEffort (many, autoRelation: true, keymaps: shoppingListId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


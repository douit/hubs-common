package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.exchange.IProc;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.OrderItemData;

public class OrderItemDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(OrderItem.class)
    public interface Dao {
        @SqlQuery("select * from order_item")
        List<OrderItem> listOrderItem();
        @SqlQuery("select * from order_item where id=:id")
        OrderItem getOrderItem(@Bind("id") String id);

        @SqlQuery("select count(*) from order_item")
        int countOrderItem();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final OrderItem rec;
        final Message p1;
        OrderItem persistObject;

        Agent(IProc.ProcContext ctx, OrderItem rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public OrderItem getRecord(){
            return rec;
        }

        public OrderItem merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<OrderHeader> getOrderHeader(){
            return getRelationValues(ctx, p1, "order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeOrderHeader(){
            return getOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getProduct(){
            return getRelationValues(ctx, p1, "product", Product.class);
        }

        public List<Product> mergeProduct(){
            return getProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InventoryItem> getFromInventoryItem(){
            return getRelationValues(ctx, p1, "from_inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeFromInventoryItem(){
            return getFromInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacilityLocation> getProductFacilityLocation(){
            return getRelationValues(ctx, p1, "product_facility_location", ProductFacilityLocation.class);
        }

        public List<ProductFacilityLocation> mergeProductFacilityLocation(){
            return getProductFacilityLocation().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacilityLocation().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getDontCancelSetUserLogin(){
            return getRelationValues(ctx, p1, "dont_cancel_set_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeDontCancelSetUserLogin(){
            return getDontCancelSetUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDontCancelSetUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<QuoteItem> getQuoteItem(){
            return getRelationValues(ctx, p1, "quote_item", QuoteItem.class);
        }

        public List<QuoteItem> mergeQuoteItem(){
            return getQuoteItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuoteItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getChangeByUserLogin(){
            return getRelationValues(ctx, p1, "change_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeChangeByUserLogin(){
            return getChangeByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getAcquireFixedAsset(){
            return getRelationValues(ctx, p1, "acquire_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeAcquireFixedAsset(){
            return getAcquireFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcquireFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ItemIssuance> getItemIssuance(){
            return getRelationValues(ctx, p1, "item_issuance", ItemIssuance.class);
        }

        public List<ItemIssuance> mergeItemIssuance(){
            return getItemIssuance().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelItemIssuance().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderAdjustment> getOrderAdjustment(){
            return getRelationValues(ctx, p1, "order_adjustment", OrderAdjustment.class);
        }

        public List<OrderAdjustment> mergeOrderAdjustment(){
            return getOrderAdjustment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderAdjustment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemBilling> getOrderItemBilling(){
            return getRelationValues(ctx, p1, "order_item_billing", OrderItemBilling.class);
        }

        public List<OrderItemBilling> mergeOrderItemBilling(){
            return getOrderItemBilling().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemBilling().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemPriceInfo> getOrderItemPriceInfo(){
            return getRelationValues(ctx, p1, "order_item_price_info", OrderItemPriceInfo.class);
        }

        public List<OrderItemPriceInfo> mergeOrderItemPriceInfo(){
            return getOrderItemPriceInfo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemPriceInfo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroupAssoc> getOrderItemShipGroupAssoc(){
            return getRelationValues(ctx, p1, "order_item_ship_group_assoc", OrderItemShipGroupAssoc.class);
        }

        public List<OrderItemShipGroupAssoc> mergeOrderItemShipGroupAssoc(){
            return getOrderItemShipGroupAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemShipGroupAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGrpInvRes> getOrderItemShipGrpInvRes(){
            return getRelationValues(ctx, p1, "order_item_ship_grp_inv_res", OrderItemShipGrpInvRes.class);
        }

        public List<OrderItemShipGrpInvRes> mergeOrderItemShipGrpInvRes(){
            return getOrderItemShipGrpInvRes().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemShipGrpInvRes().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderPaymentPreference> getOrderPaymentPreference(){
            return getRelationValues(ctx, p1, "order_payment_preference", OrderPaymentPreference.class);
        }

        public List<OrderPaymentPreference> mergeOrderPaymentPreference(){
            return getOrderPaymentPreference().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderPaymentPreference().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderStatus> getOrderStatus(){
            return getRelationValues(ctx, p1, "order_status", OrderStatus.class);
        }

        public List<OrderStatus> mergeOrderStatus(){
            return getOrderStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentReceipt> getShipmentReceipt(){
            return getRelationValues(ctx, p1, "shipment_receipt", ShipmentReceipt.class);
        }

        public List<ShipmentReceipt> mergeShipmentReceipt(){
            return getShipmentReceipt().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentReceipt().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        OrderItemData p = OrderItemData.newBuilder()
                .setId(key)
                .build();
        OrderItem rec = findOne(ctx, p, OrderItem.class);
        return new Agent(ctx, rec);
    }

         
    public static final String ORDER_HEADER="order_header";
         
    public static final String PRODUCT="product";
         
    public static final String FROM_INVENTORY_ITEM="from_inventory_item";
         
    public static final String PRODUCT_FACILITY_LOCATION="product_facility_location";
         
    public static final String DONT_CANCEL_SET_USER_LOGIN="dont_cancel_set_user_login";
         
    public static final String QUOTE_ITEM="quote_item";
         
    public static final String CHANGE_BY_USER_LOGIN="change_by_user_login";
         
    public static final String ACQUIRE_FIXED_ASSET="acquire_fixed_asset";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String ORDER_ADJUSTMENT="order_adjustment";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String ORDER_ITEM_PRICE_INFO="order_item_price_info";
         
    public static final String ORDER_ITEM_SHIP_GROUP_ASSOC="order_item_ship_group_assoc";
         
    public static final String ORDER_ITEM_SHIP_GRP_INV_RES="order_item_ship_grp_inv_res";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String ORDER_STATUS="order_status";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryOrderItemRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            OrderItemData p = OrderItemData.newBuilder()
                    .setId(key)
                    .build();
            List<OrderItemData.Builder> ds = find(ctx, p, OrderItem.class).stream()
                    .map(e -> {
                        OrderItemData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set order_header to head entity                        
                        if(relationsDemand.contains("order_header")) {
                            getRelationValues(ctx, p1, "order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.setOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_inventory_item to head entity                        
                        if(relationsDemand.contains("from_inventory_item")) {
                            getRelationValues(ctx, p1, "from_inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.setFromInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_facility_location to head entity                        
                        if(relationsDemand.contains("product_facility_location")) {
                            getRelationValues(ctx, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.addProductFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set dont_cancel_set_user_login to head entity                        
                        if(relationsDemand.contains("dont_cancel_set_user_login")) {
                            getRelationValues(ctx, p1, "dont_cancel_set_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setDontCancelSetUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set quote_item to head entity                        
                        if(relationsDemand.contains("quote_item")) {
                            getRelationValues(ctx, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.setQuoteItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set change_by_user_login to head entity                        
                        if(relationsDemand.contains("change_by_user_login")) {
                            getRelationValues(ctx, p1, "change_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setChangeByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set acquire_fixed_asset to head entity                        
                        if(relationsDemand.contains("acquire_fixed_asset")) {
                            getRelationValues(ctx, p1, "acquire_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addAcquireFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set item_issuance to head entity                        
                        if(relationsDemand.contains("item_issuance")) {
                            getRelationValues(ctx, p1, "item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_adjustment to head entity                        
                        if(relationsDemand.contains("order_adjustment")) {
                            getRelationValues(ctx, p1, "order_adjustment",
                                            OrderAdjustment.class)
                                    .forEach(el -> pb.addOrderAdjustment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_billing to head entity                        
                        if(relationsDemand.contains("order_item_billing")) {
                            getRelationValues(ctx, p1, "order_item_billing",
                                            OrderItemBilling.class)
                                    .forEach(el -> pb.addOrderItemBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_price_info to head entity                        
                        if(relationsDemand.contains("order_item_price_info")) {
                            getRelationValues(ctx, p1, "order_item_price_info",
                                            OrderItemPriceInfo.class)
                                    .forEach(el -> pb.addOrderItemPriceInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_group_assoc to head entity                        
                        if(relationsDemand.contains("order_item_ship_group_assoc")) {
                            getRelationValues(ctx, p1, "order_item_ship_group_assoc",
                                            OrderItemShipGroupAssoc.class)
                                    .forEach(el -> pb.addOrderItemShipGroupAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_grp_inv_res to head entity                        
                        if(relationsDemand.contains("order_item_ship_grp_inv_res")) {
                            getRelationValues(ctx, p1, "order_item_ship_grp_inv_res",
                                            OrderItemShipGrpInvRes.class)
                                    .forEach(el -> pb.addOrderItemShipGrpInvRes(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_payment_preference to head entity                        
                        if(relationsDemand.contains("order_payment_preference")) {
                            getRelationValues(ctx, p1, "order_payment_preference",
                                            OrderPaymentPreference.class)
                                    .forEach(el -> pb.addOrderPaymentPreference(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_status to head entity                        
                        if(relationsDemand.contains("order_status")) {
                            getRelationValues(ctx, p1, "order_status",
                                            OrderStatus.class)
                                    .forEach(el -> pb.addOrderStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

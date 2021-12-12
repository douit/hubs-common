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
import com.bluecc.hubs.stub.OrderHeaderData;

public class OrderHeaderDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(OrderHeader.class)
    public interface Dao {
        @SqlQuery("select * from order_header")
        List<OrderHeader> listOrderHeader();
        @SqlQuery("select * from order_header where order_id=:id")
        OrderHeader getOrderHeader(@Bind("id") String id);

        @SqlQuery("select count(*) from order_header")
        int countOrderHeader();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final OrderHeader rec;
        final Message p1;
        OrderHeader persistObject;

        Agent(IProc.ProcContext ctx, OrderHeader rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public OrderHeader getRecord(){
            return rec;
        }

        public OrderHeader merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<BillingAccount> getBillingAccount(){
            return getRelationValues(ctx, p1, "billing_account", BillingAccount.class);
        }

        public List<BillingAccount> mergeBillingAccount(){
            return getBillingAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelBillingAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStore> getProductStore(){
            return getRelationValues(ctx, p1, "product_store", ProductStore.class);
        }

        public List<ProductStore> mergeProductStore(){
            return getProductStore().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStore().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getCreatedByUserLogin(){
            return getRelationValues(ctx, p1, "created_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeCreatedByUserLogin(){
            return getCreatedByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WebSite> getWebSite(){
            return getRelationValues(ctx, p1, "web_site", WebSite.class);
        }

        public List<WebSite> mergeWebSite(){
            return getWebSite().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWebSite().add(c))
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
         
        public List<OrderContactMech> getOrderContactMech(){
            return getRelationValues(ctx, p1, "order_contact_mech", OrderContactMech.class);
        }

        public List<OrderContactMech> mergeOrderContactMech(){
            return getOrderContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderContactMech().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getOrderItem(){
            return getRelationValues(ctx, p1, "order_item", OrderItem.class);
        }

        public List<OrderItem> mergeOrderItem(){
            return getOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItem().add(c))
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
         
        public List<OrderItemShipGroup> getOrderItemShipGroup(){
            return getRelationValues(ctx, p1, "order_item_ship_group", OrderItemShipGroup.class);
        }

        public List<OrderItemShipGroup> mergeOrderItemShipGroup(){
            return getOrderItemShipGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemShipGroup().add(c))
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
         
        public List<OrderRole> getOrderRole(){
            return getRelationValues(ctx, p1, "order_role", OrderRole.class);
        }

        public List<OrderRole> mergeOrderRole(){
            return getOrderRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderRole().add(c))
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
         
        public List<Shipment> getPrimaryShipment(){
            return getRelationValues(ctx, p1, "primary_shipment", Shipment.class);
        }

        public List<Shipment> mergePrimaryShipment(){
            return getPrimaryShipment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryShipment().add(c))
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
        OrderHeaderData p = OrderHeaderData.newBuilder()
                .setOrderId(key)
                .build();
        OrderHeader rec = findOne(ctx, p, OrderHeader.class);
        return new Agent(ctx, rec);
    }

         
    public static final String BILLING_ACCOUNT="billing_account";
         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String CREATED_BY_USER_LOGIN="created_by_user_login";
         
    public static final String WEB_SITE="web_site";
         
    public static final String ACQUIRE_FIXED_ASSET="acquire_fixed_asset";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String ORDER_ADJUSTMENT="order_adjustment";
         
    public static final String ORDER_CONTACT_MECH="order_contact_mech";
         
    public static final String ORDER_ITEM="order_item";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String ORDER_ITEM_PRICE_INFO="order_item_price_info";
         
    public static final String ORDER_ITEM_SHIP_GROUP="order_item_ship_group";
         
    public static final String ORDER_ITEM_SHIP_GROUP_ASSOC="order_item_ship_group_assoc";
         
    public static final String ORDER_ITEM_SHIP_GRP_INV_RES="order_item_ship_grp_inv_res";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String ORDER_ROLE="order_role";
         
    public static final String ORDER_STATUS="order_status";
         
    public static final String PRIMARY_SHIPMENT="primary_shipment";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryOrderHeaderRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            OrderHeaderData p = OrderHeaderData.newBuilder()
                    .setOrderId(key)
                    .build();
            List<OrderHeaderData.Builder> ds = find(ctx, p, OrderHeader.class).stream()
                    .map(e -> {
                        OrderHeaderData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set billing_account to head entity                        
                        if(relationsDemand.contains("billing_account")) {
                            getRelationValues(ctx, p1, "billing_account",
                                            BillingAccount.class)
                                    .forEach(el -> pb.setBillingAccount(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set created_by_user_login to head entity                        
                        if(relationsDemand.contains("created_by_user_login")) {
                            getRelationValues(ctx, p1, "created_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setCreatedByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set web_site to head entity                        
                        if(relationsDemand.contains("web_site")) {
                            getRelationValues(ctx, p1, "web_site",
                                            WebSite.class)
                                    .forEach(el -> pb.setWebSite(
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
                                               
                        // add/set order_contact_mech to head entity                        
                        if(relationsDemand.contains("order_contact_mech")) {
                            getRelationValues(ctx, p1, "order_contact_mech",
                                            OrderContactMech.class)
                                    .forEach(el -> pb.addOrderContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item to head entity                        
                        if(relationsDemand.contains("order_item")) {
                            getRelationValues(ctx, p1, "order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addOrderItem(
                                             el.toHeadBuilder().build()));
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
                                               
                        // add/set order_item_ship_group to head entity                        
                        if(relationsDemand.contains("order_item_ship_group")) {
                            getRelationValues(ctx, p1, "order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addOrderItemShipGroup(
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
                                               
                        // add/set order_role to head entity                        
                        if(relationsDemand.contains("order_role")) {
                            getRelationValues(ctx, p1, "order_role",
                                            OrderRole.class)
                                    .forEach(el -> pb.addOrderRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_status to head entity                        
                        if(relationsDemand.contains("order_status")) {
                            getRelationValues(ctx, p1, "order_status",
                                            OrderStatus.class)
                                    .forEach(el -> pb.addOrderStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set primary_shipment to head entity                        
                        if(relationsDemand.contains("primary_shipment")) {
                            getRelationValues(ctx, p1, "primary_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addPrimaryShipment(
                                             el.toHeadBuilder().build()));
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

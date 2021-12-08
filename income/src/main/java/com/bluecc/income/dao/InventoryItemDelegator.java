package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.InventoryItemData;

public class InventoryItemDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = InventoryItem.class)
    public interface InventoryItemDao {
        @SqlQuery("select * from inventory_item")
        List<InventoryItem> listInventoryItem();
        @SqlQuery("select * from inventory_item where inventory_item_id=:id")
        InventoryItem getInventoryItem(@Bind("id") String id);

        @SqlQuery("select count(*) from inventory_item")
        int countInventoryItem();
    }

         
    public static final String PRODUCT="product";
         
    public static final String PARTY="party";
         
    public static final String OWNER_PARTY="owner_party";
         
    public static final String PRODUCT_FACILITY="product_facility";
         
    public static final String FACILITY_LOCATION="facility_location";
         
    public static final String PRODUCT_FACILITY_LOCATION="product_facility_location";
         
    public static final String FIXED_ASSET_FIXED_ASSET="fixed_asset_fixed_asset";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String ACCTG_TRANS_ENTRY="acctg_trans_entry";
         
    public static final String INVENTORY_ITEM_DETAIL="inventory_item_detail";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String FROM_ORDER_ITEM="from_order_item";
         
    public static final String ORDER_ITEM_SHIP_GRP_INV_RES="order_item_ship_grp_inv_res";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryInventoryItemRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            InventoryItemData p = InventoryItemData.newBuilder()
                    .setInventoryItemId(key)
                    .build();
            List<InventoryItemData.Builder> ds = find(ctx, p, InventoryItem.class).stream()
                    .map(e -> {
                        InventoryItemData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set owner_party to head entity                        
                        if(relationsDemand.contains("owner_party")) {
                            getRelationValues(ctx, p1, "owner_party",
                                            Party.class)
                                    .forEach(el -> pb.setOwnerParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_facility to head entity                        
                        if(relationsDemand.contains("product_facility")) {
                            getRelationValues(ctx, p1, "product_facility",
                                            ProductFacility.class)
                                    .forEach(el -> pb.setProductFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set facility_location to head entity                        
                        if(relationsDemand.contains("facility_location")) {
                            getRelationValues(ctx, p1, "facility_location",
                                            FacilityLocation.class)
                                    .forEach(el -> pb.setFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility_location to head entity                        
                        if(relationsDemand.contains("product_facility_location")) {
                            getRelationValues(ctx, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.setProductFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_fixed_asset to head entity                        
                        if(relationsDemand.contains("fixed_asset_fixed_asset")) {
                            getRelationValues(ctx, p1, "fixed_asset_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.setFixedAssetFixedAsset(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans_entry to head entity                        
                        if(relationsDemand.contains("acctg_trans_entry")) {
                            getRelationValues(ctx, p1, "acctg_trans_entry",
                                            AcctgTransEntry.class)
                                    .forEach(el -> pb.addAcctgTransEntry(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item_detail to head entity                        
                        if(relationsDemand.contains("inventory_item_detail")) {
                            getRelationValues(ctx, p1, "inventory_item_detail",
                                            InventoryItemDetail.class)
                                    .forEach(el -> pb.addInventoryItemDetail(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set item_issuance to head entity                        
                        if(relationsDemand.contains("item_issuance")) {
                            getRelationValues(ctx, p1, "item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_order_item to head entity                        
                        if(relationsDemand.contains("from_order_item")) {
                            getRelationValues(ctx, p1, "from_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addFromOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_grp_inv_res to head entity                        
                        if(relationsDemand.contains("order_item_ship_grp_inv_res")) {
                            getRelationValues(ctx, p1, "order_item_ship_grp_inv_res",
                                            OrderItemShipGrpInvRes.class)
                                    .forEach(el -> pb.addOrderItemShipGrpInvRes(
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
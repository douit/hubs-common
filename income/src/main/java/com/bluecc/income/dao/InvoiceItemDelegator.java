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
import com.bluecc.hubs.stub.InvoiceItemData;

public class InvoiceItemDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = InvoiceItem.class)
    public interface InvoiceItemDao {
        @SqlQuery("select * from invoice_item")
        List<InvoiceItem> listInvoiceItem();
        @SqlQuery("select * from invoice_item where id=:id")
        InvoiceItem getInvoiceItem(@Bind("id") String id);

        @SqlQuery("select count(*) from invoice_item")
        int countInvoiceItem();
    }

         
    public static final String INVOICE="invoice";
         
    public static final String INVENTORY_ITEM="inventory_item";
         
    public static final String PRODUCT="product";
         
    public static final String PRODUCT_FEATURE="product_feature";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String CHILDREN_INVOICE_ITEM="children_invoice_item";
         
    public static final String TAX_AUTHORITY_PARTY="tax_authority_party";
         
    public static final String TAX_AUTHORITY_RATE_PRODUCT="tax_authority_rate_product";
         
    public static final String OVERRIDE_ORG_PARTY="override_org_party";
         
    public static final String ORDER_ADJUSTMENT_BILLING="order_adjustment_billing";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String PAYMENT_APPLICATION="payment_application";
         
    public static final String SHIPMENT_ITEM_BILLING="shipment_item_billing";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryInvoiceItemRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            InvoiceItemData p = InvoiceItemData.newBuilder()
                    .setId(key)
                    .build();
            List<InvoiceItemData.Builder> ds = find(ctx, p, InvoiceItem.class).stream()
                    .map(e -> {
                        InvoiceItemData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set invoice to head entity                        
                        if(relationsDemand.contains("invoice")) {
                            getRelationValues(ctx, p1, "invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.setInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set inventory_item to head entity                        
                        if(relationsDemand.contains("inventory_item")) {
                            getRelationValues(ctx, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.setInventoryItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_feature to head entity                        
                        if(relationsDemand.contains("product_feature")) {
                            getRelationValues(ctx, p1, "product_feature",
                                            ProductFeature.class)
                                    .forEach(el -> pb.setProductFeature(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.setInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set children_invoice_item to head entity                        
                        if(relationsDemand.contains("children_invoice_item")) {
                            getRelationValues(ctx, p1, "children_invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addChildrenInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_party to head entity                        
                        if(relationsDemand.contains("tax_authority_party")) {
                            getRelationValues(ctx, p1, "tax_authority_party",
                                            Party.class)
                                    .forEach(el -> pb.setTaxAuthorityParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_rate_product to head entity                        
                        if(relationsDemand.contains("tax_authority_rate_product")) {
                            getRelationValues(ctx, p1, "tax_authority_rate_product",
                                            TaxAuthorityRateProduct.class)
                                    .forEach(el -> pb.setTaxAuthorityRateProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set override_org_party to head entity                        
                        if(relationsDemand.contains("override_org_party")) {
                            getRelationValues(ctx, p1, "override_org_party",
                                            Party.class)
                                    .forEach(el -> pb.setOverrideOrgParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_adjustment_billing to head entity                        
                        if(relationsDemand.contains("order_adjustment_billing")) {
                            getRelationValues(ctx, p1, "order_adjustment_billing",
                                            OrderAdjustmentBilling.class)
                                    .forEach(el -> pb.addOrderAdjustmentBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_billing to head entity                        
                        if(relationsDemand.contains("order_item_billing")) {
                            getRelationValues(ctx, p1, "order_item_billing",
                                            OrderItemBilling.class)
                                    .forEach(el -> pb.addOrderItemBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_application to head entity                        
                        if(relationsDemand.contains("payment_application")) {
                            getRelationValues(ctx, p1, "payment_application",
                                            PaymentApplication.class)
                                    .forEach(el -> pb.addPaymentApplication(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_item_billing to head entity                        
                        if(relationsDemand.contains("shipment_item_billing")) {
                            getRelationValues(ctx, p1, "shipment_item_billing",
                                            ShipmentItemBilling.class)
                                    .forEach(el -> pb.addShipmentItemBilling(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

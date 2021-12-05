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
import com.bluecc.hubs.stub.PartyData;

public class PartyDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Party.class)
    public interface PartyDao {
        @SqlQuery("select * from party")
        List<Party> listParty();
        @SqlQuery("select * from party where party_id=:id")
        Party getParty(@Bind("id") String id);

        @SqlQuery("select count(*) from party")
        int countParty();
    }

         
    public static final String CREATED_BY_USER_LOGIN="created_by_user_login";
         
    public static final String LAST_MODIFIED_BY_USER_LOGIN="last_modified_by_user_login";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String ACCTG_TRANS_ENTRY="acctg_trans_entry";
         
    public static final String FROM_AGREEMENT="from_agreement";
         
    public static final String TO_AGREEMENT="to_agreement";
         
    public static final String BILLING_ACCOUNT_ROLE="billing_account_role";
         
    public static final String CARRIER_SHIPMENT_BOX_TYPE="carrier_shipment_box_type";
         
    public static final String CARRIER_SHIPMENT_METHOD="carrier_shipment_method";
         
    public static final String FROM_CUST_REQUEST="from_cust_request";
         
    public static final String CUST_REQUEST_TYPE="cust_request_type";
         
    public static final String FIXED_ASSET="fixed_asset";
         
    public static final String INVENTORY_ITEM="inventory_item";
         
    public static final String OWNER_INVENTORY_ITEM="owner_inventory_item";
         
    public static final String FROM_INVOICE="from_invoice";
         
    public static final String INVOICE="invoice";
         
    public static final String TAX_AUTHORITY_INVOICE_ITEM="tax_authority_invoice_item";
         
    public static final String OVERRIDE_ORG_INVOICE_ITEM="override_org_invoice_item";
         
    public static final String SUPPLIER_ORDER_ITEM_SHIP_GROUP="supplier_order_item_ship_group";
         
    public static final String VENDOR_ORDER_ITEM_SHIP_GROUP="vendor_order_item_ship_group";
         
    public static final String CARRIER_ORDER_ITEM_SHIP_GROUP="carrier_order_item_ship_group";
         
    public static final String ORDER_ROLE="order_role";
         
    public static final String PARTY_CONTACT_MECH="party_contact_mech";
         
    public static final String PARTY_CONTACT_MECH_PURPOSE="party_contact_mech_purpose";
         
    public static final String PARTY_GEO_POINT="party_geo_point";
         
    public static final String PARTY_GROUP="party_group";
         
    public static final String FROM_PARTY_RELATIONSHIP="from_party_relationship";
         
    public static final String TO_PARTY_RELATIONSHIP="to_party_relationship";
         
    public static final String PARTY_ROLE="party_role";
         
    public static final String PARTY_STATUS="party_status";
         
    public static final String PARTY_TAX_AUTH_INFO="party_tax_auth_info";
         
    public static final String FROM_PAYMENT="from_payment";
         
    public static final String TO_PAYMENT="to_payment";
         
    public static final String PAYMENT_METHOD="payment_method";
         
    public static final String PERSON="person";
         
    public static final String PRODUCT_CATEGORY_ROLE="product_category_role";
         
    public static final String TAX_AUTHORITY_PRODUCT_PRICE="tax_authority_product_price";
         
    public static final String PRODUCT_PROMO="product_promo";
         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String PRODUCT_STORE_ROLE="product_store_role";
         
    public static final String PRODUCT_STORE_SHIPMENT_METH="product_store_shipment_meth";
         
    public static final String QUOTE="quote";
         
    public static final String QUOTE_ROLE="quote_role";
         
    public static final String TO_SHIPMENT="to_shipment";
         
    public static final String FROM_SHIPMENT="from_shipment";
         
    public static final String SHIPMENT_COST_ESTIMATE="shipment_cost_estimate";
         
    public static final String CARRIER_SHIPMENT_ROUTE_SEGMENT="carrier_shipment_route_segment";
         
    public static final String SUPPLIER_PRODUCT="supplier_product";
         
    public static final String SUPPLIER_PRODUCT_FEATURE="supplier_product_feature";
         
    public static final String USER_LOGIN="user_login";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryPartyRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            PartyData p = PartyData.newBuilder()
                    .setPartyId(key)
                    .build();
            List<PartyData.Builder> ds = find(ctx, p, Party.class).stream()
                    .map(e -> {
                        PartyData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set created_by_user_login to head entity                        
                        if(relationsDemand.contains("created_by_user_login")) {
                            getRelationValues(ctx, p1, "created_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setCreatedByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_user_login to head entity                        
                        if(relationsDemand.contains("last_modified_by_user_login")) {
                            getRelationValues(ctx, p1, "last_modified_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setLastModifiedByUserLogin(
                                             el.toHeadBuilder().build()));
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
                                               
                        // add/set from_agreement to head entity                        
                        if(relationsDemand.contains("from_agreement")) {
                            getRelationValues(ctx, p1, "from_agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addFromAgreement(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_agreement to head entity                        
                        if(relationsDemand.contains("to_agreement")) {
                            getRelationValues(ctx, p1, "to_agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addToAgreement(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set billing_account_role to head entity                        
                        if(relationsDemand.contains("billing_account_role")) {
                            getRelationValues(ctx, p1, "billing_account_role",
                                            BillingAccountRole.class)
                                    .forEach(el -> pb.addBillingAccountRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_box_type to head entity                        
                        if(relationsDemand.contains("carrier_shipment_box_type")) {
                            getRelationValues(ctx, p1, "carrier_shipment_box_type",
                                            CarrierShipmentBoxType.class)
                                    .forEach(el -> pb.addCarrierShipmentBoxType(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_method to head entity                        
                        if(relationsDemand.contains("carrier_shipment_method")) {
                            getRelationValues(ctx, p1, "carrier_shipment_method",
                                            CarrierShipmentMethod.class)
                                    .forEach(el -> pb.addCarrierShipmentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_cust_request to head entity                        
                        if(relationsDemand.contains("from_cust_request")) {
                            getRelationValues(ctx, p1, "from_cust_request",
                                            CustRequest.class)
                                    .forEach(el -> pb.addFromCustRequest(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set cust_request_type to head entity                        
                        if(relationsDemand.contains("cust_request_type")) {
                            getRelationValues(ctx, p1, "cust_request_type",
                                            CustRequestType.class)
                                    .forEach(el -> pb.addCustRequestType(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset to head entity                        
                        if(relationsDemand.contains("fixed_asset")) {
                            getRelationValues(ctx, p1, "fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addFixedAsset(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item to head entity                        
                        if(relationsDemand.contains("inventory_item")) {
                            getRelationValues(ctx, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addInventoryItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set owner_inventory_item to head entity                        
                        if(relationsDemand.contains("owner_inventory_item")) {
                            getRelationValues(ctx, p1, "owner_inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addOwnerInventoryItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_invoice to head entity                        
                        if(relationsDemand.contains("from_invoice")) {
                            getRelationValues(ctx, p1, "from_invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.addFromInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set invoice to head entity                        
                        if(relationsDemand.contains("invoice")) {
                            getRelationValues(ctx, p1, "invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.addInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_invoice_item to head entity                        
                        if(relationsDemand.contains("tax_authority_invoice_item")) {
                            getRelationValues(ctx, p1, "tax_authority_invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addTaxAuthorityInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set override_org_invoice_item to head entity                        
                        if(relationsDemand.contains("override_org_invoice_item")) {
                            getRelationValues(ctx, p1, "override_org_invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addOverrideOrgInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set supplier_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("supplier_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "supplier_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addSupplierOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set vendor_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("vendor_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "vendor_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addVendorOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("carrier_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "carrier_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addCarrierOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_role to head entity                        
                        if(relationsDemand.contains("order_role")) {
                            getRelationValues(ctx, p1, "order_role",
                                            OrderRole.class)
                                    .forEach(el -> pb.addOrderRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_contact_mech to head entity                        
                        if(relationsDemand.contains("party_contact_mech")) {
                            getRelationValues(ctx, p1, "party_contact_mech",
                                            PartyContactMech.class)
                                    .forEach(el -> pb.addPartyContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_contact_mech_purpose to head entity                        
                        if(relationsDemand.contains("party_contact_mech_purpose")) {
                            getRelationValues(ctx, p1, "party_contact_mech_purpose",
                                            PartyContactMechPurpose.class)
                                    .forEach(el -> pb.addPartyContactMechPurpose(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_geo_point to head entity                        
                        if(relationsDemand.contains("party_geo_point")) {
                            getRelationValues(ctx, p1, "party_geo_point",
                                            PartyGeoPoint.class)
                                    .forEach(el -> pb.addPartyGeoPoint(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_group to head entity                        
                        if(relationsDemand.contains("party_group")) {
                            getRelationValues(ctx, p1, "party_group",
                                            PartyGroup.class)
                                    .forEach(el -> pb.setPartyGroup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_party_relationship to head entity                        
                        if(relationsDemand.contains("from_party_relationship")) {
                            getRelationValues(ctx, p1, "from_party_relationship",
                                            PartyRelationship.class)
                                    .forEach(el -> pb.addFromPartyRelationship(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_party_relationship to head entity                        
                        if(relationsDemand.contains("to_party_relationship")) {
                            getRelationValues(ctx, p1, "to_party_relationship",
                                            PartyRelationship.class)
                                    .forEach(el -> pb.addToPartyRelationship(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_role to head entity                        
                        if(relationsDemand.contains("party_role")) {
                            getRelationValues(ctx, p1, "party_role",
                                            PartyRole.class)
                                    .forEach(el -> pb.addPartyRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_status to head entity                        
                        if(relationsDemand.contains("party_status")) {
                            getRelationValues(ctx, p1, "party_status",
                                            PartyStatus.class)
                                    .forEach(el -> pb.addPartyStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_tax_auth_info to head entity                        
                        if(relationsDemand.contains("party_tax_auth_info")) {
                            getRelationValues(ctx, p1, "party_tax_auth_info",
                                            PartyTaxAuthInfo.class)
                                    .forEach(el -> pb.addPartyTaxAuthInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_payment to head entity                        
                        if(relationsDemand.contains("from_payment")) {
                            getRelationValues(ctx, p1, "from_payment",
                                            Payment.class)
                                    .forEach(el -> pb.addFromPayment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set to_payment to head entity                        
                        if(relationsDemand.contains("to_payment")) {
                            getRelationValues(ctx, p1, "to_payment",
                                            Payment.class)
                                    .forEach(el -> pb.addToPayment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set payment_method to head entity                        
                        if(relationsDemand.contains("payment_method")) {
                            getRelationValues(ctx, p1, "payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.addPaymentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set person to head entity                        
                        if(relationsDemand.contains("person")) {
                            getRelationValues(ctx, p1, "person",
                                            Person.class)
                                    .forEach(el -> pb.setPerson(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_category_role to head entity                        
                        if(relationsDemand.contains("product_category_role")) {
                            getRelationValues(ctx, p1, "product_category_role",
                                            ProductCategoryRole.class)
                                    .forEach(el -> pb.addProductCategoryRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tax_authority_product_price to head entity                        
                        if(relationsDemand.contains("tax_authority_product_price")) {
                            getRelationValues(ctx, p1, "tax_authority_product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addTaxAuthorityProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_promo to head entity                        
                        if(relationsDemand.contains("product_promo")) {
                            getRelationValues(ctx, p1, "product_promo",
                                            ProductPromo.class)
                                    .forEach(el -> pb.addProductPromo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.addProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_role to head entity                        
                        if(relationsDemand.contains("product_store_role")) {
                            getRelationValues(ctx, p1, "product_store_role",
                                            ProductStoreRole.class)
                                    .forEach(el -> pb.addProductStoreRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_shipment_meth to head entity                        
                        if(relationsDemand.contains("product_store_shipment_meth")) {
                            getRelationValues(ctx, p1, "product_store_shipment_meth",
                                            ProductStoreShipmentMeth.class)
                                    .forEach(el -> pb.addProductStoreShipmentMeth(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote to head entity                        
                        if(relationsDemand.contains("quote")) {
                            getRelationValues(ctx, p1, "quote",
                                            Quote.class)
                                    .forEach(el -> pb.addQuote(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote_role to head entity                        
                        if(relationsDemand.contains("quote_role")) {
                            getRelationValues(ctx, p1, "quote_role",
                                            QuoteRole.class)
                                    .forEach(el -> pb.addQuoteRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_shipment to head entity                        
                        if(relationsDemand.contains("to_shipment")) {
                            getRelationValues(ctx, p1, "to_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addToShipment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_shipment to head entity                        
                        if(relationsDemand.contains("from_shipment")) {
                            getRelationValues(ctx, p1, "from_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addFromShipment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set shipment_cost_estimate to head entity                        
                        if(relationsDemand.contains("shipment_cost_estimate")) {
                            getRelationValues(ctx, p1, "shipment_cost_estimate",
                                            ShipmentCostEstimate.class)
                                    .forEach(el -> pb.addShipmentCostEstimate(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_route_segment to head entity                        
                        if(relationsDemand.contains("carrier_shipment_route_segment")) {
                            getRelationValues(ctx, p1, "carrier_shipment_route_segment",
                                            ShipmentRouteSegment.class)
                                    .forEach(el -> pb.addCarrierShipmentRouteSegment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_product to head entity                        
                        if(relationsDemand.contains("supplier_product")) {
                            getRelationValues(ctx, p1, "supplier_product",
                                            SupplierProduct.class)
                                    .forEach(el -> pb.addSupplierProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_product_feature to head entity                        
                        if(relationsDemand.contains("supplier_product_feature")) {
                            getRelationValues(ctx, p1, "supplier_product_feature",
                                            SupplierProductFeature.class)
                                    .forEach(el -> pb.addSupplierProductFeature(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set user_login to head entity                        
                        if(relationsDemand.contains("user_login")) {
                            getRelationValues(ctx, p1, "user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.addUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

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
import com.bluecc.hubs.stub.UserLoginData;

public class UserLoginDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = UserLogin.class)
    public interface UserLoginDao {
        @SqlQuery("select * from user_login")
        List<UserLogin> listUserLogin();
        @SqlQuery("select * from user_login where user_login_id=:id")
        UserLogin getUserLogin(@Bind("id") String id);

        @SqlQuery("select count(*) from user_login")
        int countUserLogin();
    }

         
    public static final String PARTY="party";
         
    public static final String PERSON="person";
         
    public static final String PARTY_GROUP="party_group";
         
    public static final String CREATED_BY_CONTENT="created_by_content";
         
    public static final String LAST_MODIFIED_BY_CONTENT="last_modified_by_content";
         
    public static final String CREATED_BY_CONTENT_ASSOC="created_by_content_assoc";
         
    public static final String LAST_MODIFIED_BY_CONTENT_ASSOC="last_modified_by_content_assoc";
         
    public static final String CREATED_BY_DATA_RESOURCE="created_by_data_resource";
         
    public static final String LAST_MODIFIED_BY_DATA_RESOURCE="last_modified_by_data_resource";
         
    public static final String FIN_ACCOUNT_STATUS="fin_account_status";
         
    public static final String CHANGE_BY_INVOICE_STATUS="change_by_invoice_status";
         
    public static final String ISSUED_BY_ITEM_ISSUANCE="issued_by_item_issuance";
         
    public static final String ORDER_ADJUSTMENT="order_adjustment";
         
    public static final String CREATED_BY_ORDER_HEADER="created_by_order_header";
         
    public static final String DONT_CANCEL_SET_ORDER_ITEM="dont_cancel_set_order_item";
         
    public static final String CHANGE_BY_ORDER_ITEM="change_by_order_item";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String ORDER_STATUS="order_status";
         
    public static final String CREATED_BY_PARTY="created_by_party";
         
    public static final String LAST_MODIFIED_BY_PARTY="last_modified_by_party";
         
    public static final String CHANGE_BY_PARTY_STATUS="change_by_party_status";
         
    public static final String CREATED_BY_PRODUCT="created_by_product";
         
    public static final String LAST_MODIFIED_BY_PRODUCT="last_modified_by_product";
         
    public static final String CREATED_BY_PRODUCT_FEATURE_PRICE="created_by_product_feature_price";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_FEATURE_PRICE="last_modified_by_product_feature_price";
         
    public static final String CREATED_BY_PRODUCT_PRICE="created_by_product_price";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_PRICE="last_modified_by_product_price";
         
    public static final String CREATED_BY_PRODUCT_PROMO="created_by_product_promo";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_PROMO="last_modified_by_product_promo";
         
    public static final String CREATED_BY_PRODUCT_PROMO_CODE="created_by_product_promo_code";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_PROMO_CODE="last_modified_by_product_promo_code";
         
    public static final String PRODUCT_REVIEW="product_review";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String CHANGE_BY_SHIPMENT_STATUS="change_by_shipment_status";
         
    public static final String USER_LOGIN_SECURITY_GROUP="user_login_security_group";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryUserLoginRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            UserLoginData p = UserLoginData.newBuilder()
                    .setUserLoginId(key)
                    .build();
            List<UserLoginData.Builder> ds = find(ctx, p, UserLogin.class).stream()
                    .map(e -> {
                        UserLoginData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set person to head entity                        
                        if(relationsDemand.contains("person")) {
                            getRelationValues(ctx, p1, "person",
                                            Person.class)
                                    .forEach(el -> pb.setPerson(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party_group to head entity                        
                        if(relationsDemand.contains("party_group")) {
                            getRelationValues(ctx, p1, "party_group",
                                            PartyGroup.class)
                                    .forEach(el -> pb.setPartyGroup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set created_by_content to head entity                        
                        if(relationsDemand.contains("created_by_content")) {
                            getRelationValues(ctx, p1, "created_by_content",
                                            Content.class)
                                    .forEach(el -> pb.addCreatedByContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_content to head entity                        
                        if(relationsDemand.contains("last_modified_by_content")) {
                            getRelationValues(ctx, p1, "last_modified_by_content",
                                            Content.class)
                                    .forEach(el -> pb.addLastModifiedByContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_content_assoc to head entity                        
                        if(relationsDemand.contains("created_by_content_assoc")) {
                            getRelationValues(ctx, p1, "created_by_content_assoc",
                                            ContentAssoc.class)
                                    .forEach(el -> pb.addCreatedByContentAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_content_assoc to head entity                        
                        if(relationsDemand.contains("last_modified_by_content_assoc")) {
                            getRelationValues(ctx, p1, "last_modified_by_content_assoc",
                                            ContentAssoc.class)
                                    .forEach(el -> pb.addLastModifiedByContentAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_data_resource to head entity                        
                        if(relationsDemand.contains("created_by_data_resource")) {
                            getRelationValues(ctx, p1, "created_by_data_resource",
                                            DataResource.class)
                                    .forEach(el -> pb.addCreatedByDataResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_data_resource to head entity                        
                        if(relationsDemand.contains("last_modified_by_data_resource")) {
                            getRelationValues(ctx, p1, "last_modified_by_data_resource",
                                            DataResource.class)
                                    .forEach(el -> pb.addLastModifiedByDataResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_status to head entity                        
                        if(relationsDemand.contains("fin_account_status")) {
                            getRelationValues(ctx, p1, "fin_account_status",
                                            FinAccountStatus.class)
                                    .forEach(el -> pb.addFinAccountStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set change_by_invoice_status to head entity                        
                        if(relationsDemand.contains("change_by_invoice_status")) {
                            getRelationValues(ctx, p1, "change_by_invoice_status",
                                            InvoiceStatus.class)
                                    .forEach(el -> pb.addChangeByInvoiceStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set issued_by_item_issuance to head entity                        
                        if(relationsDemand.contains("issued_by_item_issuance")) {
                            getRelationValues(ctx, p1, "issued_by_item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addIssuedByItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_adjustment to head entity                        
                        if(relationsDemand.contains("order_adjustment")) {
                            getRelationValues(ctx, p1, "order_adjustment",
                                            OrderAdjustment.class)
                                    .forEach(el -> pb.addOrderAdjustment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_order_header to head entity                        
                        if(relationsDemand.contains("created_by_order_header")) {
                            getRelationValues(ctx, p1, "created_by_order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addCreatedByOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set dont_cancel_set_order_item to head entity                        
                        if(relationsDemand.contains("dont_cancel_set_order_item")) {
                            getRelationValues(ctx, p1, "dont_cancel_set_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addDontCancelSetOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set change_by_order_item to head entity                        
                        if(relationsDemand.contains("change_by_order_item")) {
                            getRelationValues(ctx, p1, "change_by_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addChangeByOrderItem(
                                             el.toHeadBuilder().build()));
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
                                               
                        // add/set created_by_party to head entity                        
                        if(relationsDemand.contains("created_by_party")) {
                            getRelationValues(ctx, p1, "created_by_party",
                                            Party.class)
                                    .forEach(el -> pb.addCreatedByParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_party to head entity                        
                        if(relationsDemand.contains("last_modified_by_party")) {
                            getRelationValues(ctx, p1, "last_modified_by_party",
                                            Party.class)
                                    .forEach(el -> pb.addLastModifiedByParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set change_by_party_status to head entity                        
                        if(relationsDemand.contains("change_by_party_status")) {
                            getRelationValues(ctx, p1, "change_by_party_status",
                                            PartyStatus.class)
                                    .forEach(el -> pb.addChangeByPartyStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product to head entity                        
                        if(relationsDemand.contains("created_by_product")) {
                            getRelationValues(ctx, p1, "created_by_product",
                                            Product.class)
                                    .forEach(el -> pb.addCreatedByProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product to head entity                        
                        if(relationsDemand.contains("last_modified_by_product")) {
                            getRelationValues(ctx, p1, "last_modified_by_product",
                                            Product.class)
                                    .forEach(el -> pb.addLastModifiedByProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set created_by_product_feature_price to head entity                        
                        if(relationsDemand.contains("created_by_product_feature_price")) {
                            getRelationValues(ctx, p1, "created_by_product_feature_price",
                                            ProductFeaturePrice.class)
                                    .forEach(el -> pb.addCreatedByProductFeaturePrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_feature_price to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_feature_price")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_feature_price",
                                            ProductFeaturePrice.class)
                                    .forEach(el -> pb.addLastModifiedByProductFeaturePrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product_price to head entity                        
                        if(relationsDemand.contains("created_by_product_price")) {
                            getRelationValues(ctx, p1, "created_by_product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addCreatedByProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_price to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_price")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addLastModifiedByProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product_promo to head entity                        
                        if(relationsDemand.contains("created_by_product_promo")) {
                            getRelationValues(ctx, p1, "created_by_product_promo",
                                            ProductPromo.class)
                                    .forEach(el -> pb.addCreatedByProductPromo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_promo to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_promo")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_promo",
                                            ProductPromo.class)
                                    .forEach(el -> pb.addLastModifiedByProductPromo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product_promo_code to head entity                        
                        if(relationsDemand.contains("created_by_product_promo_code")) {
                            getRelationValues(ctx, p1, "created_by_product_promo_code",
                                            ProductPromoCode.class)
                                    .forEach(el -> pb.addCreatedByProductPromoCode(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_promo_code to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_promo_code")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_promo_code",
                                            ProductPromoCode.class)
                                    .forEach(el -> pb.addLastModifiedByProductPromoCode(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_review to head entity                        
                        if(relationsDemand.contains("product_review")) {
                            getRelationValues(ctx, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set change_by_shipment_status to head entity                        
                        if(relationsDemand.contains("change_by_shipment_status")) {
                            getRelationValues(ctx, p1, "change_by_shipment_status",
                                            ShipmentStatus.class)
                                    .forEach(el -> pb.addChangeByShipmentStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set user_login_security_group to head entity                        
                        if(relationsDemand.contains("user_login_security_group")) {
                            getRelationValues(ctx, p1, "user_login_security_group",
                                            UserLoginSecurityGroup.class)
                                    .forEach(el -> pb.addUserLoginSecurityGroup(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

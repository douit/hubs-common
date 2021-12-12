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
import com.bluecc.hubs.stub.UserLoginData;

public class UserLoginDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(UserLogin.class)
    public interface Dao {
        @SqlQuery("select * from user_login")
        List<UserLogin> listUserLogin();
        @SqlQuery("select * from user_login where user_login_id=:id")
        UserLogin getUserLogin(@Bind("id") String id);

        @SqlQuery("select count(*) from user_login")
        int countUserLogin();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final UserLogin rec;
        final Message p1;
        UserLogin persistObject;

        Agent(IProc.ProcContext ctx, UserLogin rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public UserLogin getRecord(){
            return rec;
        }

        public UserLogin merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Party> getParty(){
            return getRelationValues(ctx, p1, "party", Party.class);
        }

        public List<Party> mergeParty(){
            return getParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Person> getPerson(){
            return getRelationValues(ctx, p1, "person", Person.class);
        }

        public List<Person> mergePerson(){
            return getPerson().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPerson().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyGroup> getPartyGroup(){
            return getRelationValues(ctx, p1, "party_group", PartyGroup.class);
        }

        public List<PartyGroup> mergePartyGroup(){
            return getPartyGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Content> getCreatedByContent(){
            return getRelationValues(ctx, p1, "created_by_content", Content.class);
        }

        public List<Content> mergeCreatedByContent(){
            return getCreatedByContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Content> getLastModifiedByContent(){
            return getRelationValues(ctx, p1, "last_modified_by_content", Content.class);
        }

        public List<Content> mergeLastModifiedByContent(){
            return getLastModifiedByContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContentAssoc> getCreatedByContentAssoc(){
            return getRelationValues(ctx, p1, "created_by_content_assoc", ContentAssoc.class);
        }

        public List<ContentAssoc> mergeCreatedByContentAssoc(){
            return getCreatedByContentAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByContentAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContentAssoc> getLastModifiedByContentAssoc(){
            return getRelationValues(ctx, p1, "last_modified_by_content_assoc", ContentAssoc.class);
        }

        public List<ContentAssoc> mergeLastModifiedByContentAssoc(){
            return getLastModifiedByContentAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByContentAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<DataResource> getCreatedByDataResource(){
            return getRelationValues(ctx, p1, "created_by_data_resource", DataResource.class);
        }

        public List<DataResource> mergeCreatedByDataResource(){
            return getCreatedByDataResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByDataResource().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<DataResource> getLastModifiedByDataResource(){
            return getRelationValues(ctx, p1, "last_modified_by_data_resource", DataResource.class);
        }

        public List<DataResource> mergeLastModifiedByDataResource(){
            return getLastModifiedByDataResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByDataResource().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountStatus> getFinAccountStatus(){
            return getRelationValues(ctx, p1, "fin_account_status", FinAccountStatus.class);
        }

        public List<FinAccountStatus> mergeFinAccountStatus(){
            return getFinAccountStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceStatus> getChangeByInvoiceStatus(){
            return getRelationValues(ctx, p1, "change_by_invoice_status", InvoiceStatus.class);
        }

        public List<InvoiceStatus> mergeChangeByInvoiceStatus(){
            return getChangeByInvoiceStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByInvoiceStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ItemIssuance> getIssuedByItemIssuance(){
            return getRelationValues(ctx, p1, "issued_by_item_issuance", ItemIssuance.class);
        }

        public List<ItemIssuance> mergeIssuedByItemIssuance(){
            return getIssuedByItemIssuance().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelIssuedByItemIssuance().add(c))
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
         
        public List<OrderHeader> getCreatedByOrderHeader(){
            return getRelationValues(ctx, p1, "created_by_order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeCreatedByOrderHeader(){
            return getCreatedByOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getDontCancelSetOrderItem(){
            return getRelationValues(ctx, p1, "dont_cancel_set_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeDontCancelSetOrderItem(){
            return getDontCancelSetOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDontCancelSetOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getChangeByOrderItem(){
            return getRelationValues(ctx, p1, "change_by_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeChangeByOrderItem(){
            return getChangeByOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByOrderItem().add(c))
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
         
        public List<Party> getCreatedByParty(){
            return getRelationValues(ctx, p1, "created_by_party", Party.class);
        }

        public List<Party> mergeCreatedByParty(){
            return getCreatedByParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getLastModifiedByParty(){
            return getRelationValues(ctx, p1, "last_modified_by_party", Party.class);
        }

        public List<Party> mergeLastModifiedByParty(){
            return getLastModifiedByParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyStatus> getChangeByPartyStatus(){
            return getRelationValues(ctx, p1, "change_by_party_status", PartyStatus.class);
        }

        public List<PartyStatus> mergeChangeByPartyStatus(){
            return getChangeByPartyStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByPartyStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getCreatedByProduct(){
            return getRelationValues(ctx, p1, "created_by_product", Product.class);
        }

        public List<Product> mergeCreatedByProduct(){
            return getCreatedByProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getLastModifiedByProduct(){
            return getRelationValues(ctx, p1, "last_modified_by_product", Product.class);
        }

        public List<Product> mergeLastModifiedByProduct(){
            return getLastModifiedByProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFeaturePrice> getCreatedByProductFeaturePrice(){
            return getRelationValues(ctx, p1, "created_by_product_feature_price", ProductFeaturePrice.class);
        }

        public List<ProductFeaturePrice> mergeCreatedByProductFeaturePrice(){
            return getCreatedByProductFeaturePrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductFeaturePrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFeaturePrice> getLastModifiedByProductFeaturePrice(){
            return getRelationValues(ctx, p1, "last_modified_by_product_feature_price", ProductFeaturePrice.class);
        }

        public List<ProductFeaturePrice> mergeLastModifiedByProductFeaturePrice(){
            return getLastModifiedByProductFeaturePrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductFeaturePrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getCreatedByProductPrice(){
            return getRelationValues(ctx, p1, "created_by_product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeCreatedByProductPrice(){
            return getCreatedByProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getLastModifiedByProductPrice(){
            return getRelationValues(ctx, p1, "last_modified_by_product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeLastModifiedByProductPrice(){
            return getLastModifiedByProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromo> getCreatedByProductPromo(){
            return getRelationValues(ctx, p1, "created_by_product_promo", ProductPromo.class);
        }

        public List<ProductPromo> mergeCreatedByProductPromo(){
            return getCreatedByProductPromo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductPromo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromo> getLastModifiedByProductPromo(){
            return getRelationValues(ctx, p1, "last_modified_by_product_promo", ProductPromo.class);
        }

        public List<ProductPromo> mergeLastModifiedByProductPromo(){
            return getLastModifiedByProductPromo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductPromo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoCode> getCreatedByProductPromoCode(){
            return getRelationValues(ctx, p1, "created_by_product_promo_code", ProductPromoCode.class);
        }

        public List<ProductPromoCode> mergeCreatedByProductPromoCode(){
            return getCreatedByProductPromoCode().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductPromoCode().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoCode> getLastModifiedByProductPromoCode(){
            return getRelationValues(ctx, p1, "last_modified_by_product_promo_code", ProductPromoCode.class);
        }

        public List<ProductPromoCode> mergeLastModifiedByProductPromoCode(){
            return getLastModifiedByProductPromoCode().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductPromoCode().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductReview> getProductReview(){
            return getRelationValues(ctx, p1, "product_review", ProductReview.class);
        }

        public List<ProductReview> mergeProductReview(){
            return getProductReview().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductReview().add(c))
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
         
        public List<ShipmentStatus> getChangeByShipmentStatus(){
            return getRelationValues(ctx, p1, "change_by_shipment_status", ShipmentStatus.class);
        }

        public List<ShipmentStatus> mergeChangeByShipmentStatus(){
            return getChangeByShipmentStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByShipmentStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLoginSecurityGroup> getUserLoginSecurityGroup(){
            return getRelationValues(ctx, p1, "user_login_security_group", UserLoginSecurityGroup.class);
        }

        public List<UserLoginSecurityGroup> mergeUserLoginSecurityGroup(){
            return getUserLoginSecurityGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelUserLoginSecurityGroup().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        UserLoginData p = UserLoginData.newBuilder()
                .setUserLoginId(key)
                .build();
        UserLogin rec = findOne(ctx, p, UserLogin.class);
        return new Agent(ctx, rec);
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

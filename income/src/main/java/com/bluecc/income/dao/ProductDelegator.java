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
import com.bluecc.hubs.stub.ProductData;

public class ProductDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Product.class)
    public interface Dao {
        @SqlQuery("select * from product")
        List<Product> listProduct();
        @SqlQuery("select * from product where product_id=:id")
        Product getProduct(@Bind("id") String id);

        @SqlQuery("select count(*) from product")
        int countProduct();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Product rec;
        final Message p1;
        Product persistObject;

        Agent(IProc.ProcContext ctx, Product rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Product getRecord(){
            return rec;
        }

        public Product merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProductCategory> getPrimaryProductCategory(){
            return getRelationValues(ctx, p1, "primary_product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergePrimaryProductCategory(){
            return getPrimaryProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryProductCategory().add(c))
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
         
        public List<UserLogin> getLastModifiedByUserLogin(){
            return getRelationValues(ctx, p1, "last_modified_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeLastModifiedByUserLogin(){
            return getLastModifiedByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentBoxType> getDefaultShipmentBoxType(){
            return getRelationValues(ctx, p1, "default_shipment_box_type", ShipmentBoxType.class);
        }

        public List<ShipmentBoxType> mergeDefaultShipmentBoxType(){
            return getDefaultShipmentBoxType().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDefaultShipmentBoxType().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Agreement> getAgreement(){
            return getRelationValues(ctx, p1, "agreement", Agreement.class);
        }

        public List<Agreement> mergeAgreement(){
            return getAgreement().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAgreement().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AgreementProductAppl> getAgreementProductAppl(){
            return getRelationValues(ctx, p1, "agreement_product_appl", AgreementProductAppl.class);
        }

        public List<AgreementProductAppl> mergeAgreementProductAppl(){
            return getAgreementProductAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAgreementProductAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustRequestItem> getCustRequestItem(){
            return getRelationValues(ctx, p1, "cust_request_item", CustRequestItem.class);
        }

        public List<CustRequestItem> mergeCustRequestItem(){
            return getCustRequestItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCustRequestItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getInstanceOfFixedAsset(){
            return getRelationValues(ctx, p1, "instance_of_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeInstanceOfFixedAsset(){
            return getInstanceOfFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInstanceOfFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAssetProduct> getFixedAssetProduct(){
            return getRelationValues(ctx, p1, "fixed_asset_product", FixedAssetProduct.class);
        }

        public List<FixedAssetProduct> mergeFixedAssetProduct(){
            return getFixedAssetProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InventoryItem> getInventoryItem(){
            return getRelationValues(ctx, p1, "inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeInventoryItem(){
            return getInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceItem> getInvoiceItem(){
            return getRelationValues(ctx, p1, "invoice_item", InvoiceItem.class);
        }

        public List<InvoiceItem> mergeInvoiceItem(){
            return getInvoiceItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoiceItem().add(c))
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
         
        public List<ProductAssoc> getMainProductAssoc(){
            return getRelationValues(ctx, p1, "main_product_assoc", ProductAssoc.class);
        }

        public List<ProductAssoc> mergeMainProductAssoc(){
            return getMainProductAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelMainProductAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductAssoc> getAssocProductAssoc(){
            return getRelationValues(ctx, p1, "assoc_product_assoc", ProductAssoc.class);
        }

        public List<ProductAssoc> mergeAssocProductAssoc(){
            return getAssocProductAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAssocProductAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryMember> getProductCategoryMember(){
            return getRelationValues(ctx, p1, "product_category_member", ProductCategoryMember.class);
        }

        public List<ProductCategoryMember> mergeProductCategoryMember(){
            return getProductCategoryMember().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryMember().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductConfig> getProductProductConfig(){
            return getRelationValues(ctx, p1, "product_product_config", ProductConfig.class);
        }

        public List<ProductConfig> mergeProductProductConfig(){
            return getProductProductConfig().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductProductConfig().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductConfigProduct> getProductProductConfigProduct(){
            return getRelationValues(ctx, p1, "product_product_config_product", ProductConfigProduct.class);
        }

        public List<ProductConfigProduct> mergeProductProductConfigProduct(){
            return getProductProductConfigProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductProductConfigProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductContent> getProductContent(){
            return getRelationValues(ctx, p1, "product_content", ProductContent.class);
        }

        public List<ProductContent> mergeProductContent(){
            return getProductContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacility> getProductFacility(){
            return getRelationValues(ctx, p1, "product_facility", ProductFacility.class);
        }

        public List<ProductFacility> mergeProductFacility(){
            return getProductFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacilityAssoc> getProductFacilityAssoc(){
            return getRelationValues(ctx, p1, "product_facility_assoc", ProductFacilityAssoc.class);
        }

        public List<ProductFacilityAssoc> mergeProductFacilityAssoc(){
            return getProductFacilityAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacilityAssoc().add(c))
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
         
        public List<ProductFeatureAppl> getProductFeatureAppl(){
            return getRelationValues(ctx, p1, "product_feature_appl", ProductFeatureAppl.class);
        }

        public List<ProductFeatureAppl> mergeProductFeatureAppl(){
            return getProductFeatureAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFeatureAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductKeyword> getProductKeyword(){
            return getRelationValues(ctx, p1, "product_keyword", ProductKeyword.class);
        }

        public List<ProductKeyword> mergeProductKeyword(){
            return getProductKeyword().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductKeyword().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getProductPrice(){
            return getRelationValues(ctx, p1, "product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeProductPrice(){
            return getProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoProduct> getProductPromoProduct(){
            return getRelationValues(ctx, p1, "product_promo_product", ProductPromoProduct.class);
        }

        public List<ProductPromoProduct> mergeProductPromoProduct(){
            return getProductPromoProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPromoProduct().add(c))
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
         
        public List<ProductStoreSurveyAppl> getProductStoreSurveyAppl(){
            return getRelationValues(ctx, p1, "product_store_survey_appl", ProductStoreSurveyAppl.class);
        }

        public List<ProductStoreSurveyAppl> mergeProductStoreSurveyAppl(){
            return getProductStoreSurveyAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreSurveyAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductSubscriptionResource> getProductSubscriptionResource(){
            return getRelationValues(ctx, p1, "product_subscription_resource", ProductSubscriptionResource.class);
        }

        public List<ProductSubscriptionResource> mergeProductSubscriptionResource(){
            return getProductSubscriptionResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductSubscriptionResource().add(c))
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
         
        public List<ShipmentItem> getShipmentItem(){
            return getRelationValues(ctx, p1, "shipment_item", ShipmentItem.class);
        }

        public List<ShipmentItem> mergeShipmentItem(){
            return getShipmentItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentPackageContent> getSubShipmentPackageContent(){
            return getRelationValues(ctx, p1, "sub_shipment_package_content", ShipmentPackageContent.class);
        }

        public List<ShipmentPackageContent> mergeSubShipmentPackageContent(){
            return getSubShipmentPackageContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSubShipmentPackageContent().add(c))
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
         
        public List<SupplierProduct> getSupplierProduct(){
            return getRelationValues(ctx, p1, "supplier_product", SupplierProduct.class);
        }

        public List<SupplierProduct> mergeSupplierProduct(){
            return getSupplierProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSupplierProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortGoodStandard> getWorkEffortGoodStandard(){
            return getRelationValues(ctx, p1, "work_effort_good_standard", WorkEffortGoodStandard.class);
        }

        public List<WorkEffortGoodStandard> mergeWorkEffortGoodStandard(){
            return getWorkEffortGoodStandard().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffortGoodStandard().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductData p = ProductData.newBuilder()
                .setProductId(key)
                .build();
        Product rec = findOne(ctx, p, Product.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PRIMARY_PRODUCT_CATEGORY="primary_product_category";
         
    public static final String CREATED_BY_USER_LOGIN="created_by_user_login";
         
    public static final String LAST_MODIFIED_BY_USER_LOGIN="last_modified_by_user_login";
         
    public static final String DEFAULT_SHIPMENT_BOX_TYPE="default_shipment_box_type";
         
    public static final String AGREEMENT="agreement";
         
    public static final String AGREEMENT_PRODUCT_APPL="agreement_product_appl";
         
    public static final String CUST_REQUEST_ITEM="cust_request_item";
         
    public static final String INSTANCE_OF_FIXED_ASSET="instance_of_fixed_asset";
         
    public static final String FIXED_ASSET_PRODUCT="fixed_asset_product";
         
    public static final String INVENTORY_ITEM="inventory_item";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String ORDER_ITEM="order_item";
         
    public static final String MAIN_PRODUCT_ASSOC="main_product_assoc";
         
    public static final String ASSOC_PRODUCT_ASSOC="assoc_product_assoc";
         
    public static final String PRODUCT_CATEGORY_MEMBER="product_category_member";
         
    public static final String PRODUCT_PRODUCT_CONFIG="product_product_config";
         
    public static final String PRODUCT_PRODUCT_CONFIG_PRODUCT="product_product_config_product";
         
    public static final String PRODUCT_CONTENT="product_content";
         
    public static final String PRODUCT_FACILITY="product_facility";
         
    public static final String PRODUCT_FACILITY_ASSOC="product_facility_assoc";
         
    public static final String PRODUCT_FACILITY_LOCATION="product_facility_location";
         
    public static final String PRODUCT_FEATURE_APPL="product_feature_appl";
         
    public static final String PRODUCT_KEYWORD="product_keyword";
         
    public static final String PRODUCT_PRICE="product_price";
         
    public static final String PRODUCT_PROMO_PRODUCT="product_promo_product";
         
    public static final String PRODUCT_REVIEW="product_review";
         
    public static final String PRODUCT_STORE_SURVEY_APPL="product_store_survey_appl";
         
    public static final String PRODUCT_SUBSCRIPTION_RESOURCE="product_subscription_resource";
         
    public static final String QUOTE_ITEM="quote_item";
         
    public static final String SHIPMENT_ITEM="shipment_item";
         
    public static final String SUB_SHIPMENT_PACKAGE_CONTENT="sub_shipment_package_content";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String SUPPLIER_PRODUCT="supplier_product";
         
    public static final String WORK_EFFORT_GOOD_STANDARD="work_effort_good_standard";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductData p = ProductData.newBuilder()
                    .setProductId(key)
                    .build();
            List<ProductData.Builder> ds = find(ctx, p, Product.class).stream()
                    .map(e -> {
                        ProductData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set primary_product_category to head entity                        
                        if(relationsDemand.contains("primary_product_category")) {
                            getRelationValues(ctx, p1, "primary_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setPrimaryProductCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
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
                                               
                        // add/set default_shipment_box_type to head entity                        
                        if(relationsDemand.contains("default_shipment_box_type")) {
                            getRelationValues(ctx, p1, "default_shipment_box_type",
                                            ShipmentBoxType.class)
                                    .forEach(el -> pb.setDefaultShipmentBoxType(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set agreement to head entity                        
                        if(relationsDemand.contains("agreement")) {
                            getRelationValues(ctx, p1, "agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addAgreement(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set agreement_product_appl to head entity                        
                        if(relationsDemand.contains("agreement_product_appl")) {
                            getRelationValues(ctx, p1, "agreement_product_appl",
                                            AgreementProductAppl.class)
                                    .forEach(el -> pb.addAgreementProductAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set cust_request_item to head entity                        
                        if(relationsDemand.contains("cust_request_item")) {
                            getRelationValues(ctx, p1, "cust_request_item",
                                            CustRequestItem.class)
                                    .forEach(el -> pb.addCustRequestItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set instance_of_fixed_asset to head entity                        
                        if(relationsDemand.contains("instance_of_fixed_asset")) {
                            getRelationValues(ctx, p1, "instance_of_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addInstanceOfFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_product to head entity                        
                        if(relationsDemand.contains("fixed_asset_product")) {
                            getRelationValues(ctx, p1, "fixed_asset_product",
                                            FixedAssetProduct.class)
                                    .forEach(el -> pb.addFixedAssetProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item to head entity                        
                        if(relationsDemand.contains("inventory_item")) {
                            getRelationValues(ctx, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_item to head entity                        
                        if(relationsDemand.contains("order_item")) {
                            getRelationValues(ctx, p1, "order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set main_product_assoc to head entity                        
                        if(relationsDemand.contains("main_product_assoc")) {
                            getRelationValues(ctx, p1, "main_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addMainProductAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set assoc_product_assoc to head entity                        
                        if(relationsDemand.contains("assoc_product_assoc")) {
                            getRelationValues(ctx, p1, "assoc_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addAssocProductAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_category_member to head entity                        
                        if(relationsDemand.contains("product_category_member")) {
                            getRelationValues(ctx, p1, "product_category_member",
                                            ProductCategoryMember.class)
                                    .forEach(el -> pb.addProductCategoryMember(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_product_config to head entity                        
                        if(relationsDemand.contains("product_product_config")) {
                            getRelationValues(ctx, p1, "product_product_config",
                                            ProductConfig.class)
                                    .forEach(el -> pb.addProductProductConfig(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_product_config_product to head entity                        
                        if(relationsDemand.contains("product_product_config_product")) {
                            getRelationValues(ctx, p1, "product_product_config_product",
                                            ProductConfigProduct.class)
                                    .forEach(el -> pb.addProductProductConfigProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_content to head entity                        
                        if(relationsDemand.contains("product_content")) {
                            getRelationValues(ctx, p1, "product_content",
                                            ProductContent.class)
                                    .forEach(el -> pb.addProductContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility to head entity                        
                        if(relationsDemand.contains("product_facility")) {
                            getRelationValues(ctx, p1, "product_facility",
                                            ProductFacility.class)
                                    .forEach(el -> pb.addProductFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility_assoc to head entity                        
                        if(relationsDemand.contains("product_facility_assoc")) {
                            getRelationValues(ctx, p1, "product_facility_assoc",
                                            ProductFacilityAssoc.class)
                                    .forEach(el -> pb.addProductFacilityAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility_location to head entity                        
                        if(relationsDemand.contains("product_facility_location")) {
                            getRelationValues(ctx, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.addProductFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_feature_appl to head entity                        
                        if(relationsDemand.contains("product_feature_appl")) {
                            getRelationValues(ctx, p1, "product_feature_appl",
                                            ProductFeatureAppl.class)
                                    .forEach(el -> pb.addProductFeatureAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_keyword to head entity                        
                        if(relationsDemand.contains("product_keyword")) {
                            getRelationValues(ctx, p1, "product_keyword",
                                            ProductKeyword.class)
                                    .forEach(el -> pb.addProductKeyword(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_price to head entity                        
                        if(relationsDemand.contains("product_price")) {
                            getRelationValues(ctx, p1, "product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_promo_product to head entity                        
                        if(relationsDemand.contains("product_promo_product")) {
                            getRelationValues(ctx, p1, "product_promo_product",
                                            ProductPromoProduct.class)
                                    .forEach(el -> pb.addProductPromoProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_review to head entity                        
                        if(relationsDemand.contains("product_review")) {
                            getRelationValues(ctx, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_survey_appl to head entity                        
                        if(relationsDemand.contains("product_store_survey_appl")) {
                            getRelationValues(ctx, p1, "product_store_survey_appl",
                                            ProductStoreSurveyAppl.class)
                                    .forEach(el -> pb.addProductStoreSurveyAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_subscription_resource to head entity                        
                        if(relationsDemand.contains("product_subscription_resource")) {
                            getRelationValues(ctx, p1, "product_subscription_resource",
                                            ProductSubscriptionResource.class)
                                    .forEach(el -> pb.addProductSubscriptionResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote_item to head entity                        
                        if(relationsDemand.contains("quote_item")) {
                            getRelationValues(ctx, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.addQuoteItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_item to head entity                        
                        if(relationsDemand.contains("shipment_item")) {
                            getRelationValues(ctx, p1, "shipment_item",
                                            ShipmentItem.class)
                                    .forEach(el -> pb.addShipmentItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set sub_shipment_package_content to head entity                        
                        if(relationsDemand.contains("sub_shipment_package_content")) {
                            getRelationValues(ctx, p1, "sub_shipment_package_content",
                                            ShipmentPackageContent.class)
                                    .forEach(el -> pb.addSubShipmentPackageContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_product to head entity                        
                        if(relationsDemand.contains("supplier_product")) {
                            getRelationValues(ctx, p1, "supplier_product",
                                            SupplierProduct.class)
                                    .forEach(el -> pb.addSupplierProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set work_effort_good_standard to head entity                        
                        if(relationsDemand.contains("work_effort_good_standard")) {
                            getRelationValues(ctx, p1, "work_effort_good_standard",
                                            WorkEffortGoodStandard.class)
                                    .forEach(el -> pb.addWorkEffortGoodStandard(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

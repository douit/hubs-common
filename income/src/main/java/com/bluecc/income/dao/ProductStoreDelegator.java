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
import com.bluecc.hubs.stub.ProductStoreData;

public class ProductStoreDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductStore.class)
    public interface Dao {
        @SqlQuery("select * from product_store")
        List<ProductStore> listProductStore();
        @SqlQuery("select * from product_store where product_store_id=:id")
        ProductStore getProductStore(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store")
        int countProductStore();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductStore rec;
        final Message p1;
        ProductStore persistObject;

        Agent(IProc.ProcContext ctx, ProductStore rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductStore getRecord(){
            return rec;
        }

        public ProductStore merge(){
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
         
        public List<TaxAuthority> getVatTaxAuthority(){
            return getRelationValues(ctx, p1, "vat_tax_authority", TaxAuthority.class);
        }

        public List<TaxAuthority> mergeVatTaxAuthority(){
            return getVatTaxAuthority().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelVatTaxAuthority().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustRequest> getCustRequest(){
            return getRelationValues(ctx, p1, "cust_request", CustRequest.class);
        }

        public List<CustRequest> mergeCustRequest(){
            return getCustRequest().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCustRequest().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<EbayConfig> getEbayConfig(){
            return getRelationValues(ctx, p1, "ebay_config", EbayConfig.class);
        }

        public List<EbayConfig> mergeEbayConfig(){
            return getEbayConfig().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEbayConfig().add(c))
                    .collect(Collectors.toList());
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
         
        public List<ProductReview> getProductReview(){
            return getRelationValues(ctx, p1, "product_review", ProductReview.class);
        }

        public List<ProductReview> mergeProductReview(){
            return getProductReview().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductReview().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreCatalog> getProductStoreCatalog(){
            return getRelationValues(ctx, p1, "product_store_catalog", ProductStoreCatalog.class);
        }

        public List<ProductStoreCatalog> mergeProductStoreCatalog(){
            return getProductStoreCatalog().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreCatalog().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreEmailSetting> getProductStoreEmailSetting(){
            return getRelationValues(ctx, p1, "product_store_email_setting", ProductStoreEmailSetting.class);
        }

        public List<ProductStoreEmailSetting> mergeProductStoreEmailSetting(){
            return getProductStoreEmailSetting().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreEmailSetting().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreFacility> getProductStoreFacility(){
            return getRelationValues(ctx, p1, "product_store_facility", ProductStoreFacility.class);
        }

        public List<ProductStoreFacility> mergeProductStoreFacility(){
            return getProductStoreFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreFinActSetting> getProductStoreFinActSetting(){
            return getRelationValues(ctx, p1, "product_store_fin_act_setting", ProductStoreFinActSetting.class);
        }

        public List<ProductStoreFinActSetting> mergeProductStoreFinActSetting(){
            return getProductStoreFinActSetting().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreFinActSetting().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreKeywordOvrd> getProductStoreKeywordOvrd(){
            return getRelationValues(ctx, p1, "product_store_keyword_ovrd", ProductStoreKeywordOvrd.class);
        }

        public List<ProductStoreKeywordOvrd> mergeProductStoreKeywordOvrd(){
            return getProductStoreKeywordOvrd().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreKeywordOvrd().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStorePaymentSetting> getProductStorePaymentSetting(){
            return getRelationValues(ctx, p1, "product_store_payment_setting", ProductStorePaymentSetting.class);
        }

        public List<ProductStorePaymentSetting> mergeProductStorePaymentSetting(){
            return getProductStorePaymentSetting().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStorePaymentSetting().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStorePromoAppl> getProductStorePromoAppl(){
            return getRelationValues(ctx, p1, "product_store_promo_appl", ProductStorePromoAppl.class);
        }

        public List<ProductStorePromoAppl> mergeProductStorePromoAppl(){
            return getProductStorePromoAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStorePromoAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreRole> getProductStoreRole(){
            return getRelationValues(ctx, p1, "product_store_role", ProductStoreRole.class);
        }

        public List<ProductStoreRole> mergeProductStoreRole(){
            return getProductStoreRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreRole().add(c))
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
         
        public List<Quote> getQuote(){
            return getRelationValues(ctx, p1, "quote", Quote.class);
        }

        public List<Quote> mergeQuote(){
            return getQuote().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuote().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TaxAuthorityRateProduct> getTaxAuthorityRateProduct(){
            return getRelationValues(ctx, p1, "tax_authority_rate_product", TaxAuthorityRateProduct.class);
        }

        public List<TaxAuthorityRateProduct> mergeTaxAuthorityRateProduct(){
            return getTaxAuthorityRateProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthorityRateProduct().add(c))
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
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductStoreData p = ProductStoreData.newBuilder()
                .setProductStoreId(key)
                .build();
        ProductStore rec = findOne(ctx, p, ProductStore.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PARTY="party";
         
    public static final String VAT_TAX_AUTHORITY="vat_tax_authority";
         
    public static final String CUST_REQUEST="cust_request";
         
    public static final String EBAY_CONFIG="ebay_config";
         
    public static final String ORDER_HEADER="order_header";
         
    public static final String PRODUCT_REVIEW="product_review";
         
    public static final String PRODUCT_STORE_CATALOG="product_store_catalog";
         
    public static final String PRODUCT_STORE_EMAIL_SETTING="product_store_email_setting";
         
    public static final String PRODUCT_STORE_FACILITY="product_store_facility";
         
    public static final String PRODUCT_STORE_FIN_ACT_SETTING="product_store_fin_act_setting";
         
    public static final String PRODUCT_STORE_KEYWORD_OVRD="product_store_keyword_ovrd";
         
    public static final String PRODUCT_STORE_PAYMENT_SETTING="product_store_payment_setting";
         
    public static final String PRODUCT_STORE_PROMO_APPL="product_store_promo_appl";
         
    public static final String PRODUCT_STORE_ROLE="product_store_role";
         
    public static final String PRODUCT_STORE_SURVEY_APPL="product_store_survey_appl";
         
    public static final String QUOTE="quote";
         
    public static final String TAX_AUTHORITY_RATE_PRODUCT="tax_authority_rate_product";
         
    public static final String WEB_SITE="web_site";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductStoreRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductStoreData p = ProductStoreData.newBuilder()
                    .setProductStoreId(key)
                    .build();
            List<ProductStoreData.Builder> ds = find(ctx, p, ProductStore.class).stream()
                    .map(e -> {
                        ProductStoreData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set vat_tax_authority to head entity                        
                        if(relationsDemand.contains("vat_tax_authority")) {
                            getRelationValues(ctx, p1, "vat_tax_authority",
                                            TaxAuthority.class)
                                    .forEach(el -> pb.setVatTaxAuthority(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set cust_request to head entity                        
                        if(relationsDemand.contains("cust_request")) {
                            getRelationValues(ctx, p1, "cust_request",
                                            CustRequest.class)
                                    .forEach(el -> pb.addCustRequest(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set ebay_config to head entity                        
                        if(relationsDemand.contains("ebay_config")) {
                            getRelationValues(ctx, p1, "ebay_config",
                                            EbayConfig.class)
                                    .forEach(el -> pb.setEbayConfig(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_header to head entity                        
                        if(relationsDemand.contains("order_header")) {
                            getRelationValues(ctx, p1, "order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_review to head entity                        
                        if(relationsDemand.contains("product_review")) {
                            getRelationValues(ctx, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_catalog to head entity                        
                        if(relationsDemand.contains("product_store_catalog")) {
                            getRelationValues(ctx, p1, "product_store_catalog",
                                            ProductStoreCatalog.class)
                                    .forEach(el -> pb.addProductStoreCatalog(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_email_setting to head entity                        
                        if(relationsDemand.contains("product_store_email_setting")) {
                            getRelationValues(ctx, p1, "product_store_email_setting",
                                            ProductStoreEmailSetting.class)
                                    .forEach(el -> pb.addProductStoreEmailSetting(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_facility to head entity                        
                        if(relationsDemand.contains("product_store_facility")) {
                            getRelationValues(ctx, p1, "product_store_facility",
                                            ProductStoreFacility.class)
                                    .forEach(el -> pb.addProductStoreFacility(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_fin_act_setting to head entity                        
                        if(relationsDemand.contains("product_store_fin_act_setting")) {
                            getRelationValues(ctx, p1, "product_store_fin_act_setting",
                                            ProductStoreFinActSetting.class)
                                    .forEach(el -> pb.addProductStoreFinActSetting(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_keyword_ovrd to head entity                        
                        if(relationsDemand.contains("product_store_keyword_ovrd")) {
                            getRelationValues(ctx, p1, "product_store_keyword_ovrd",
                                            ProductStoreKeywordOvrd.class)
                                    .forEach(el -> pb.addProductStoreKeywordOvrd(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_payment_setting to head entity                        
                        if(relationsDemand.contains("product_store_payment_setting")) {
                            getRelationValues(ctx, p1, "product_store_payment_setting",
                                            ProductStorePaymentSetting.class)
                                    .forEach(el -> pb.addProductStorePaymentSetting(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_promo_appl to head entity                        
                        if(relationsDemand.contains("product_store_promo_appl")) {
                            getRelationValues(ctx, p1, "product_store_promo_appl",
                                            ProductStorePromoAppl.class)
                                    .forEach(el -> pb.addProductStorePromoAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_role to head entity                        
                        if(relationsDemand.contains("product_store_role")) {
                            getRelationValues(ctx, p1, "product_store_role",
                                            ProductStoreRole.class)
                                    .forEach(el -> pb.addProductStoreRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_survey_appl to head entity                        
                        if(relationsDemand.contains("product_store_survey_appl")) {
                            getRelationValues(ctx, p1, "product_store_survey_appl",
                                            ProductStoreSurveyAppl.class)
                                    .forEach(el -> pb.addProductStoreSurveyAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote to head entity                        
                        if(relationsDemand.contains("quote")) {
                            getRelationValues(ctx, p1, "quote",
                                            Quote.class)
                                    .forEach(el -> pb.addQuote(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_rate_product to head entity                        
                        if(relationsDemand.contains("tax_authority_rate_product")) {
                            getRelationValues(ctx, p1, "tax_authority_rate_product",
                                            TaxAuthorityRateProduct.class)
                                    .forEach(el -> pb.addTaxAuthorityRateProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set web_site to head entity                        
                        if(relationsDemand.contains("web_site")) {
                            getRelationValues(ctx, p1, "web_site",
                                            WebSite.class)
                                    .forEach(el -> pb.addWebSite(
                                             el.toHeadBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

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
import com.bluecc.hubs.stub.QuoteData;

public class QuoteDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Quote.class)
    public interface Dao {
        @SqlQuery("select * from quote")
        List<Quote> listQuote();
        @SqlQuery("select * from quote where quote_id=:id")
        Quote getQuote(@Bind("id") String id);

        @SqlQuery("select count(*) from quote")
        int countQuote();
    }

    public Quote get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getQuote(id);
    }

    public List<Quote> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listQuote();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countQuote();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Quote rec;
        final Message p1;
        Quote persistObject;

        Agent(IProc.ProcContext ctx, Quote rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Quote getRecord(){
            return rec;
        }

        public Quote merge(){
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
         
        public List<ProductStore> getProductStore(){
            return getRelationValues(ctx, p1, "product_store", ProductStore.class);
        }

        public List<ProductStore> mergeProductStore(){
            return getProductStore().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStore().add(c))
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
         
        public List<QuoteRole> getQuoteRole(){
            return getRelationValues(ctx, p1, "quote_role", QuoteRole.class);
        }

        public List<QuoteRole> mergeQuoteRole(){
            return getQuoteRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuoteRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<QuoteTerm> getQuoteTerm(){
            return getRelationValues(ctx, p1, "quote_term", QuoteTerm.class);
        }

        public List<QuoteTerm> mergeQuoteTerm(){
            return getQuoteTerm().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuoteTerm().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        QuoteData p = QuoteData.newBuilder()
                .setQuoteId(key)
                .build();
        Quote rec = findOne(ctx, p, Quote.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PARTY="party";
         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String QUOTE_ITEM="quote_item";
         
    public static final String QUOTE_ROLE="quote_role";
         
    public static final String QUOTE_TERM="quote_term";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryQuoteRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            QuoteData p = QuoteData.newBuilder()
                    .setQuoteId(key)
                    .build();
            List<QuoteData.Builder> ds = find(ctx, p, Quote.class).stream()
                    .map(e -> {
                        QuoteData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set quote_item to head entity                        
                        if(relationsDemand.contains("quote_item")) {
                            getRelationValues(ctx, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.addQuoteItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote_role to head entity                        
                        if(relationsDemand.contains("quote_role")) {
                            getRelationValues(ctx, p1, "quote_role",
                                            QuoteRole.class)
                                    .forEach(el -> pb.addQuoteRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote_term to head entity                        
                        if(relationsDemand.contains("quote_term")) {
                            getRelationValues(ctx, p1, "quote_term",
                                            QuoteTerm.class)
                                    .forEach(el -> pb.addQuoteTerm(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

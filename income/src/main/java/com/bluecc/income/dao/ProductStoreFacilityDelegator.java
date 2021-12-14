package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.function.Consumer;
import com.google.common.collect.Maps;

import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.exchange.IProc;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SqlMeta;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.ProductStoreFacilityData;

public class ProductStoreFacilityDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductStoreFacility.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_store_facility")
        List<ProductStoreFacility> listProductStoreFacility();
        @SqlQuery("select * from product_store_facility where id=:id")
        ProductStoreFacility getProductStoreFacility(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store_facility")
        int countProductStoreFacility();

        // for relations
         
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        default Map<String, ProductStoreFacility> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        default Map<String, ProductStoreFacility> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreFacility", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreFacility p = map.computeIfAbsent(rr.getColumn("psf_id", String.class),
                                id -> rr.getRow(ProductStoreFacility.class));
                        if (rr.getColumn("ps_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
        
    }

     
    Consumer<Map<String, ProductStoreFacility>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductStoreFacility>> productStore(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
    

    public ProductStoreFacility get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductStoreFacility(id);
    }

    public List<ProductStoreFacility> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductStoreFacility();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductStoreFacility();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductStoreFacility rec;
        final Message p1;
        ProductStoreFacility persistObject;

        Agent(IProc.ProcContext ctx, ProductStoreFacility rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductStoreFacility getRecord(){
            return rec;
        }

        public ProductStoreFacility merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductStoreFacilityData p = ProductStoreFacilityData.newBuilder()
                .setId(key)
                .build();
        ProductStoreFacility rec = findOne(ctx, p, ProductStoreFacility.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProductStoreFacility rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRODUCT_STORE="product_store";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductStoreFacilityRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductStoreFacilityData p = ProductStoreFacilityData.newBuilder()
                    .setId(key)
                    .build();
            List<ProductStoreFacilityData.Builder> ds = find(ctx, p, ProductStoreFacility.class).stream()
                    .map(e -> {
                        ProductStoreFacilityData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
    public ProductStoreFacility.ProductStoreFacilityBuilder seed(){
        return ProductStoreFacility.builder()
                .id(sequence.nextStringId());
    }
}

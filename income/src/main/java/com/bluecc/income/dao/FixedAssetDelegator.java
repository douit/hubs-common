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
import com.bluecc.hubs.stub.FixedAssetData;

public class FixedAssetDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(value = FixedAsset.class)
    public interface FixedAssetDao {
        @SqlQuery("select * from fixed_asset")
        List<FixedAsset> listFixedAsset();
        @SqlQuery("select * from fixed_asset where fixed_asset_id=:id")
        FixedAsset getFixedAsset(@Bind("id") String id);

        @SqlQuery("select count(*) from fixed_asset")
        int countFixedAsset();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final FixedAsset rec;
        final Message p1;
        FixedAsset persistObject;

        Agent(IProc.ProcContext ctx, FixedAsset rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public FixedAsset getRecord(){
            return rec;
        }

        public FixedAsset merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<FixedAsset> getParentFixedAsset(){
            return getRelationValues(ctx, p1, "parent_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeParentFixedAsset(){
            return getParentFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getInstanceOfProduct(){
            return getRelationValues(ctx, p1, "instance_of_product", Product.class);
        }

        public List<Product> mergeInstanceOfProduct(){
            return getInstanceOfProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInstanceOfProduct().add(c))
                    .collect(Collectors.toList());
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
         
        public List<PartyRole> getPartyRole(){
            return getRelationValues(ctx, p1, "party_role", PartyRole.class);
        }

        public List<PartyRole> mergePartyRole(){
            return getPartyRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderHeader> getAcquireOrderHeader(){
            return getRelationValues(ctx, p1, "acquire_order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeAcquireOrderHeader(){
            return getAcquireOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcquireOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getAcquireOrderItem(){
            return getRelationValues(ctx, p1, "acquire_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeAcquireOrderItem(){
            return getAcquireOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcquireOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FacilityLocation> getLocatedAtFacilityLocation(){
            return getRelationValues(ctx, p1, "located_at_facility_location", FacilityLocation.class);
        }

        public List<FacilityLocation> mergeLocatedAtFacilityLocation(){
            return getLocatedAtFacilityLocation().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLocatedAtFacilityLocation().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AcctgTrans> getAcctgTrans(){
            return getRelationValues(ctx, p1, "acctg_trans", AcctgTrans.class);
        }

        public List<AcctgTrans> mergeAcctgTrans(){
            return getAcctgTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTrans().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getChildFixedAsset(){
            return getRelationValues(ctx, p1, "child_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeChildFixedAsset(){
            return getChildFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChildFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAssetGeoPoint> getFixedAssetGeoPoint(){
            return getRelationValues(ctx, p1, "fixed_asset_geo_point", FixedAssetGeoPoint.class);
        }

        public List<FixedAssetGeoPoint> mergeFixedAssetGeoPoint(){
            return getFixedAssetGeoPoint().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetGeoPoint().add(c))
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
         
        public List<InventoryItem> getFixedAssetInventoryItem(){
            return getRelationValues(ctx, p1, "fixed_asset_inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeFixedAssetInventoryItem(){
            return getFixedAssetInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffort> getWorkEffort(){
            return getRelationValues(ctx, p1, "work_effort", WorkEffort.class);
        }

        public List<WorkEffort> mergeWorkEffort(){
            return getWorkEffort().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffort().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        FixedAssetData p = FixedAssetData.newBuilder()
                .setFixedAssetId(key)
                .build();
        FixedAsset rec = findOne(ctx, p, FixedAsset.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PARENT_FIXED_ASSET="parent_fixed_asset";
         
    public static final String INSTANCE_OF_PRODUCT="instance_of_product";
         
    public static final String PARTY="party";
         
    public static final String PARTY_ROLE="party_role";
         
    public static final String ACQUIRE_ORDER_HEADER="acquire_order_header";
         
    public static final String ACQUIRE_ORDER_ITEM="acquire_order_item";
         
    public static final String LOCATED_AT_FACILITY_LOCATION="located_at_facility_location";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String CHILD_FIXED_ASSET="child_fixed_asset";
         
    public static final String FIXED_ASSET_GEO_POINT="fixed_asset_geo_point";
         
    public static final String FIXED_ASSET_PRODUCT="fixed_asset_product";
         
    public static final String FIXED_ASSET_INVENTORY_ITEM="fixed_asset_inventory_item";
         
    public static final String WORK_EFFORT="work_effort";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryFixedAssetRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            FixedAssetData p = FixedAssetData.newBuilder()
                    .setFixedAssetId(key)
                    .build();
            List<FixedAssetData.Builder> ds = find(ctx, p, FixedAsset.class).stream()
                    .map(e -> {
                        FixedAssetData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set parent_fixed_asset to head entity                        
                        if(relationsDemand.contains("parent_fixed_asset")) {
                            getRelationValues(ctx, p1, "parent_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.setParentFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set instance_of_product to head entity                        
                        if(relationsDemand.contains("instance_of_product")) {
                            getRelationValues(ctx, p1, "instance_of_product",
                                            Product.class)
                                    .forEach(el -> pb.setInstanceOfProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party_role to head entity                        
                        if(relationsDemand.contains("party_role")) {
                            getRelationValues(ctx, p1, "party_role",
                                            PartyRole.class)
                                    .forEach(el -> pb.setPartyRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acquire_order_header to head entity                        
                        if(relationsDemand.contains("acquire_order_header")) {
                            getRelationValues(ctx, p1, "acquire_order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.setAcquireOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set acquire_order_item to head entity                        
                        if(relationsDemand.contains("acquire_order_item")) {
                            getRelationValues(ctx, p1, "acquire_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.setAcquireOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set located_at_facility_location to head entity                        
                        if(relationsDemand.contains("located_at_facility_location")) {
                            getRelationValues(ctx, p1, "located_at_facility_location",
                                            FacilityLocation.class)
                                    .forEach(el -> pb.setLocatedAtFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set child_fixed_asset to head entity                        
                        if(relationsDemand.contains("child_fixed_asset")) {
                            getRelationValues(ctx, p1, "child_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addChildFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_geo_point to head entity                        
                        if(relationsDemand.contains("fixed_asset_geo_point")) {
                            getRelationValues(ctx, p1, "fixed_asset_geo_point",
                                            FixedAssetGeoPoint.class)
                                    .forEach(el -> pb.addFixedAssetGeoPoint(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_product to head entity                        
                        if(relationsDemand.contains("fixed_asset_product")) {
                            getRelationValues(ctx, p1, "fixed_asset_product",
                                            FixedAssetProduct.class)
                                    .forEach(el -> pb.addFixedAssetProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_inventory_item to head entity                        
                        if(relationsDemand.contains("fixed_asset_inventory_item")) {
                            getRelationValues(ctx, p1, "fixed_asset_inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addFixedAssetInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set work_effort to head entity                        
                        if(relationsDemand.contains("work_effort")) {
                            getRelationValues(ctx, p1, "work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.addWorkEffort(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

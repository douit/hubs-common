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
import com.bluecc.hubs.stub.PartyGroupData;

public class PartyGroupDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(PartyGroup.class)
    public interface Dao {
        @SqlQuery("select * from party_group")
        List<PartyGroup> listPartyGroup();
        @SqlQuery("select * from party_group where party_id=:id")
        PartyGroup getPartyGroup(@Bind("id") String id);

        @SqlQuery("select count(*) from party_group")
        int countPartyGroup();
    }

    public PartyGroup get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getPartyGroup(id);
    }

    public List<PartyGroup> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listPartyGroup();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countPartyGroup();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final PartyGroup rec;
        final Message p1;
        PartyGroup persistObject;

        Agent(IProc.ProcContext ctx, PartyGroup rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public PartyGroup getRecord(){
            return rec;
        }

        public PartyGroup merge(){
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
         
        public List<PartyContactMech> getPartyContactMech(){
            return getRelationValues(ctx, p1, "party_contact_mech", PartyContactMech.class);
        }

        public List<PartyContactMech> mergePartyContactMech(){
            return getPartyContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyContactMech().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyContactMechPurpose> getPartyContactMechPurpose(){
            return getRelationValues(ctx, p1, "party_contact_mech_purpose", PartyContactMechPurpose.class);
        }

        public List<PartyContactMechPurpose> mergePartyContactMechPurpose(){
            return getPartyContactMechPurpose().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyContactMechPurpose().add(c))
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
         
        public List<Shipment> getToShipment(){
            return getRelationValues(ctx, p1, "to_shipment", Shipment.class);
        }

        public List<Shipment> mergeToShipment(){
            return getToShipment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToShipment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Shipment> getFromShipment(){
            return getRelationValues(ctx, p1, "from_shipment", Shipment.class);
        }

        public List<Shipment> mergeFromShipment(){
            return getFromShipment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromShipment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentRouteSegment> getCarrierShipmentRouteSegment(){
            return getRelationValues(ctx, p1, "carrier_shipment_route_segment", ShipmentRouteSegment.class);
        }

        public List<ShipmentRouteSegment> mergeCarrierShipmentRouteSegment(){
            return getCarrierShipmentRouteSegment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCarrierShipmentRouteSegment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getUserLogin(){
            return getRelationValues(ctx, p1, "user_login", UserLogin.class);
        }

        public List<UserLogin> mergeUserLogin(){
            return getUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelUserLogin().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        PartyGroupData p = PartyGroupData.newBuilder()
                .setPartyId(key)
                .build();
        PartyGroup rec = findOne(ctx, p, PartyGroup.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PARTY="party";
         
    public static final String PARTY_CONTACT_MECH="party_contact_mech";
         
    public static final String PARTY_CONTACT_MECH_PURPOSE="party_contact_mech_purpose";
         
    public static final String PRODUCT_STORE_ROLE="product_store_role";
         
    public static final String TO_SHIPMENT="to_shipment";
         
    public static final String FROM_SHIPMENT="from_shipment";
         
    public static final String CARRIER_SHIPMENT_ROUTE_SEGMENT="carrier_shipment_route_segment";
         
    public static final String USER_LOGIN="user_login";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryPartyGroupRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            PartyGroupData p = PartyGroupData.newBuilder()
                    .setPartyId(key)
                    .build();
            List<PartyGroupData.Builder> ds = find(ctx, p, PartyGroup.class).stream()
                    .map(e -> {
                        PartyGroupData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
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
                                               
                        // add/set product_store_role to head entity                        
                        if(relationsDemand.contains("product_store_role")) {
                            getRelationValues(ctx, p1, "product_store_role",
                                            ProductStoreRole.class)
                                    .forEach(el -> pb.addProductStoreRole(
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
                                               
                        // add/set carrier_shipment_route_segment to head entity                        
                        if(relationsDemand.contains("carrier_shipment_route_segment")) {
                            getRelationValues(ctx, p1, "carrier_shipment_route_segment",
                                            ShipmentRouteSegment.class)
                                    .forEach(el -> pb.addCarrierShipmentRouteSegment(
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


    
    public PartyGroup.PartyGroupBuilder seed(){
        return PartyGroup.builder()
                .partyId(sequence.nextStringId());
    }
}

package com.bluecc.income.dao;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.procs.Buckets;
import com.bluecc.income.procs.SelectorBindings;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import com.bluecc.income.exchange.GsonConverters;
import com.linecorp.armeria.server.annotation.*;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.function.Consumer;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;
import com.bluecc.income.procs.Buckets;

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
import io.grpc.stub.StreamObserver;
import com.bluecc.income.exchange.IChainQuery;

import com.bluecc.hubs.stub.PartyGroupData;

public class PartyGroupDelegator extends AbstractProcs implements IChainQuery<PartyGroup>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(PartyGroup.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from party_group")
        List<PartyGroup> listPartyGroup();
        @SqlQuery("select * from party_group where party_id=:id")
        PartyGroup getPartyGroup(@Bind("id") String id);

        @SqlQuery("select count(*) from party_group")
        int countPartyGroup();

        // for relations
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, PartyGroup> chainParty(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, PartyGroup> chainParty(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("pao_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcmm")
        default Map<String, PartyGroup> chainPartyContactMech(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainPartyContactMech(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcmm")
        default Map<String, PartyGroup> chainPartyContactMech(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("pcmm_party_id", String.class) != null) {
                            p.getRelPartyContactMech()
                                    .add(rr.getRow(PartyContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = PartyContactMechPurpose.class, prefix = "pcmpm")
        default Map<String, PartyGroup> chainPartyContactMechPurpose(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainPartyContactMechPurpose(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = PartyContactMechPurpose.class, prefix = "pcmpm")
        default Map<String, PartyGroup> chainPartyContactMechPurpose(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH_PURPOSE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("pcmpm_party_id", String.class) != null) {
                            p.getRelPartyContactMechPurpose()
                                    .add(rr.getRow(PartyContactMechPurpose.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psrm")
        default Map<String, PartyGroup> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainProductStoreRole(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psrm")
        default Map<String, PartyGroup> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_ROLE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("psrm_party_id", String.class) != null) {
                            p.getRelProductStoreRole()
                                    .add(rr.getRow(ProductStoreRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Shipment.class, prefix = "tsm")
        default Map<String, PartyGroup> chainToShipment(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainToShipment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Shipment.class, prefix = "tsm")
        default Map<String, PartyGroup> chainToShipment(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_SHIPMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("tsm_party_id_to", String.class) != null) {
                            p.getRelToShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Shipment.class, prefix = "fsm")
        default Map<String, PartyGroup> chainFromShipment(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainFromShipment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Shipment.class, prefix = "fsm")
        default Map<String, PartyGroup> chainFromShipment(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_SHIPMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("fsm_party_id_from", String.class) != null) {
                            p.getRelFromShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "csrsm")
        default Map<String, PartyGroup> chainCarrierShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainCarrierShipmentRouteSegment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "csrsm")
        default Map<String, PartyGroup> chainCarrierShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_SHIPMENT_ROUTE_SEGMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("csrsm_carrier_party_id", String.class) != null) {
                            p.getRelCarrierShipmentRouteSegment()
                                    .add(rr.getRow(ShipmentRouteSegment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ulm")
        default Map<String, PartyGroup> chainUserLogin(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainUserLogin(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ulm")
        default Map<String, PartyGroup> chainUserLogin(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(USER_LOGIN);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("ulm_party_id", String.class) != null) {
                            p.getRelUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, PartyGroup> chainTenant(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, PartyGroup> chainTenant(ProtoMeta protoMeta,
                                               Map<String, PartyGroup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("PartyGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        PartyGroup p = map.computeIfAbsent(rr.getColumn("pg_party_id", String.class),
                                id -> rr.getRow(PartyGroup.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, PartyGroup>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> party(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> partyContactMech(Dao dao, boolean succ) {
        return e -> dao.chainPartyContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> partyContactMech(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPartyContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> partyContactMechPurpose(Dao dao, boolean succ) {
        return e -> dao.chainPartyContactMechPurpose(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> partyContactMechPurpose(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPartyContactMechPurpose(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> productStoreRole(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> productStoreRole(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> toShipment(Dao dao, boolean succ) {
        return e -> dao.chainToShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> toShipment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainToShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> fromShipment(Dao dao, boolean succ) {
        return e -> dao.chainFromShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> fromShipment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFromShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> carrierShipmentRouteSegment(Dao dao, boolean succ) {
        return e -> dao.chainCarrierShipmentRouteSegment(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> carrierShipmentRouteSegment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCarrierShipmentRouteSegment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> userLogin(Dao dao, boolean succ) {
        return e -> dao.chainUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> userLogin(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, PartyGroup>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, PartyGroup>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, PartyGroup> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, PartyGroup> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, PartyGroup> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, PartyGroup> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, PartyGroup>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARTY_CONTACT_MECH)) {
            chain = chain.andThen(partyContactMech(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARTY_CONTACT_MECH_PURPOSE)) {
            chain = chain.andThen(partyContactMechPurpose(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_ROLE)) {
            chain = chain.andThen(productStoreRole(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TO_SHIPMENT)) {
            chain = chain.andThen(toShipment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FROM_SHIPMENT)) {
            chain = chain.andThen(fromShipment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CARRIER_SHIPMENT_ROUTE_SEGMENT)) {
            chain = chain.andThen(carrierShipmentRouteSegment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(USER_LOGIN)) {
            chain = chain.andThen(userLogin(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<PartyGroupData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<PartyGroupData> responseObserver) {

        Map<String, PartyGroup> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            PartyGroupData.Builder partyGroupData = data.toHeadBuilder();
             
            data.getRelParty().forEach(e -> 
                partyGroupData.setParty(e.toHeadBuilder())); 
            data.getRelPartyContactMech().forEach(e -> 
                partyGroupData.addPartyContactMech(e.toDataBuilder())); 
            data.getRelPartyContactMechPurpose().forEach(e -> 
                partyGroupData.addPartyContactMechPurpose(e.toDataBuilder())); 
            data.getRelProductStoreRole().forEach(e -> 
                partyGroupData.addProductStoreRole(e.toDataBuilder())); 
            data.getRelToShipment().forEach(e -> 
                partyGroupData.addToShipment(e.toHeadBuilder())); 
            data.getRelFromShipment().forEach(e -> 
                partyGroupData.addFromShipment(e.toHeadBuilder())); 
            data.getRelCarrierShipmentRouteSegment().forEach(e -> 
                partyGroupData.addCarrierShipmentRouteSegment(e.toDataBuilder())); 
            data.getRelUserLogin().forEach(e -> 
                partyGroupData.addUserLogin(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                partyGroupData.setTenant(e.toDataBuilder()));
            return partyGroupData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public PartyGroup get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getPartyGroup(id);
    }

    @Get("/party_groups/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public PartyGroup get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<PartyGroup> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listPartyGroup();
    }

    @Get("/party_groups")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<PartyGroup> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countPartyGroup();
    }

    @Get("/party_groups/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/party_groups")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(PartyGroup partyGroup){
        return store(partyGroup, true);
    }

    @Put("/party_groups")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(PartyGroup partyGroup){
        return store(partyGroup, false);
    }

    public String store(PartyGroup partyGroup, boolean genId){
        process(c ->{
            if(genId){
                partyGroup.setPartyId(sequence.nextStringId());
            }
            storeOrUpdate(c, partyGroup.toData());
        });
        return partyGroup.getPartyId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "PartyGroup", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
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
         
        public List<Tenant> getTenant(){
            return getRelationValues(ctx, p1, "tenant", Tenant.class);
        }

        public List<Tenant> mergeTenant(){
            return getTenant().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTenant().add(c))
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

    public Agent getAgent(IProc.ProcContext ctx, PartyGroup rec) {
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
         
    public static final String TENANT="tenant";
    

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
                                               
                        // add/set tenant to head entity                        
                        if(relationsDemand.contains("tenant")) {
                            getRelationValues(ctx, p1, "tenant",
                                            Tenant.class)
                                    .forEach(el -> pb.setTenant(
                                             el.toDataBuilder().build()));
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

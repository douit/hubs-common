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
import com.google.common.collect.Sets;

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
import io.grpc.stub.StreamObserver;

import com.bluecc.hubs.stub.PersonData;

public class PersonDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Person.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from person")
        List<Person> listPerson();
        @SqlQuery("select * from person where party_id=:id")
        Person getPerson(@Bind("id") String id);

        @SqlQuery("select count(*) from person")
        int countPerson();

        // for relations
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, Person> chainParty(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, Person> chainParty(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("pa_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcm")
        default Map<String, Person> chainPartyContactMech(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainPartyContactMech(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcm")
        default Map<String, Person> chainPartyContactMech(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("pcm_party_id", String.class) != null) {
                            p.getRelPartyContactMech()
                                    .add(rr.getRow(PartyContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = PartyContactMechPurpose.class, prefix = "pcmp")
        default Map<String, Person> chainPartyContactMechPurpose(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainPartyContactMechPurpose(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = PartyContactMechPurpose.class, prefix = "pcmp")
        default Map<String, Person> chainPartyContactMechPurpose(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH_PURPOSE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("pcmp_party_id", String.class) != null) {
                            p.getRelPartyContactMechPurpose()
                                    .add(rr.getRow(PartyContactMechPurpose.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psr")
        default Map<String, Person> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainProductStoreRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psr")
        default Map<String, Person> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("psr_party_id", String.class) != null) {
                            p.getRelProductStoreRole()
                                    .add(rr.getRow(ProductStoreRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Shipment.class, prefix = "ts")
        default Map<String, Person> chainToShipment(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainToShipment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Shipment.class, prefix = "ts")
        default Map<String, Person> chainToShipment(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_SHIPMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("ts_party_id_to", String.class) != null) {
                            p.getRelToShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Shipment.class, prefix = "fs")
        default Map<String, Person> chainFromShipment(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainFromShipment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Shipment.class, prefix = "fs")
        default Map<String, Person> chainFromShipment(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_SHIPMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("fs_party_id_from", String.class) != null) {
                            p.getRelFromShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "csrs")
        default Map<String, Person> chainCarrierShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainCarrierShipmentRouteSegment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "csrs")
        default Map<String, Person> chainCarrierShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_SHIPMENT_ROUTE_SEGMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("csrs_carrier_party_id", String.class) != null) {
                            p.getRelCarrierShipmentRouteSegment()
                                    .add(rr.getRow(ShipmentRouteSegment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        default Map<String, Person> chainUserLogin(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainUserLogin(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        default Map<String, Person> chainUserLogin(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(USER_LOGIN);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("ul_party_id", String.class) != null) {
                            p.getRelUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, Person> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, Person> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Person> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Person", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Person p = map.computeIfAbsent(rr.getColumn("pe_party_id", String.class),
                                id -> rr.getRow(Person.class));
                        if (rr.getColumn("te_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, Person>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> party(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> partyContactMech(Dao dao, boolean succ) {
        return e -> dao.chainPartyContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> partyContactMech(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> partyContactMechPurpose(Dao dao, boolean succ) {
        return e -> dao.chainPartyContactMechPurpose(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> partyContactMechPurpose(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyContactMechPurpose(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> productStoreRole(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> productStoreRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> toShipment(Dao dao, boolean succ) {
        return e -> dao.chainToShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> toShipment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> fromShipment(Dao dao, boolean succ) {
        return e -> dao.chainFromShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> fromShipment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> carrierShipmentRouteSegment(Dao dao, boolean succ) {
        return e -> dao.chainCarrierShipmentRouteSegment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> carrierShipmentRouteSegment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCarrierShipmentRouteSegment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> userLogin(Dao dao, boolean succ) {
        return e -> dao.chainUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> userLogin(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Person>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, Person>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, Person> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, Person> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, Person> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, Person>> chain = tenant(dao, false);
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, true));
        }
         
        if (incls.contains(PARTY_CONTACT_MECH)) {
            chain = chain.andThen(partyContactMech(dao, true));
        }
         
        if (incls.contains(PARTY_CONTACT_MECH_PURPOSE)) {
            chain = chain.andThen(partyContactMechPurpose(dao, true));
        }
         
        if (incls.contains(PRODUCT_STORE_ROLE)) {
            chain = chain.andThen(productStoreRole(dao, true));
        }
         
        if (incls.contains(TO_SHIPMENT)) {
            chain = chain.andThen(toShipment(dao, true));
        }
         
        if (incls.contains(FROM_SHIPMENT)) {
            chain = chain.andThen(fromShipment(dao, true));
        }
         
        if (incls.contains(CARRIER_SHIPMENT_ROUTE_SEGMENT)) {
            chain = chain.andThen(carrierShipmentRouteSegment(dao, true));
        }
         
        if (incls.contains(USER_LOGIN)) {
            chain = chain.andThen(userLogin(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<PersonData> responseObserver) {
        Map<String, Person> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            PersonData.Builder personData = data.toHeadBuilder();
             
            data.getRelParty().forEach(e -> 
                personData.setParty(e.toHeadBuilder())); 
            data.getRelPartyContactMech().forEach(e -> 
                personData.addPartyContactMech(e.toDataBuilder())); 
            data.getRelPartyContactMechPurpose().forEach(e -> 
                personData.addPartyContactMechPurpose(e.toDataBuilder())); 
            data.getRelProductStoreRole().forEach(e -> 
                personData.addProductStoreRole(e.toDataBuilder())); 
            data.getRelToShipment().forEach(e -> 
                personData.addToShipment(e.toHeadBuilder())); 
            data.getRelFromShipment().forEach(e -> 
                personData.addFromShipment(e.toHeadBuilder())); 
            data.getRelCarrierShipmentRouteSegment().forEach(e -> 
                personData.addCarrierShipmentRouteSegment(e.toDataBuilder())); 
            data.getRelUserLogin().forEach(e -> 
                personData.addUserLogin(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                personData.setTenant(e.toDataBuilder()));
            return personData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public Person get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getPerson(id);
    }

    public List<Person> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listPerson();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countPerson();
    }


    public void store(Person person){
        store(person, true);
    }

    public void store(Person person, boolean genId){
        process(c ->{
            if(genId){
                person.setPartyId(sequence.nextStringId());
            }
            storeOrUpdate(c, person.toData());
        });
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Person rec;
        final Message p1;
        Person persistObject;

        Agent(IProc.ProcContext ctx, Person rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Person getRecord(){
            return rec;
        }

        public Person merge(){
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
        PersonData p = PersonData.newBuilder()
                .setPartyId(key)
                .build();
        Person rec = findOne(ctx, p, Person.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, Person rec) {
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
    public Function<String, Flux<IModel<?>>> queryPersonRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            PersonData p = PersonData.newBuilder()
                    .setPartyId(key)
                    .build();
            List<PersonData.Builder> ds = find(ctx, p, Person.class).stream()
                    .map(e -> {
                        PersonData.Builder pb = e.toHeadBuilder();
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


    
    public Person.PersonBuilder seed(){
        return Person.builder()
                .partyId(sequence.nextStringId());
    }
}

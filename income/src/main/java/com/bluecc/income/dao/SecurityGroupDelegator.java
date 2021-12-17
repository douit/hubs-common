package com.bluecc.income.dao;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.procs.Buckets;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
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

import com.bluecc.hubs.stub.SecurityGroupData;

public class SecurityGroupDelegator extends AbstractProcs implements IChainQuery<SecurityGroup>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(SecurityGroup.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from security_group")
        List<SecurityGroup> listSecurityGroup();
        @SqlQuery("select * from security_group where group_id=:id")
        SecurityGroup getSecurityGroup(@Bind("id") String id);

        @SqlQuery("select count(*) from security_group")
        int countSecurityGroup();

        // for relations
         
        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = PartyRelationship.class, prefix = "prm")
        default Map<String, SecurityGroup> chainPartyRelationship(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               boolean succInvoke) {
            return chainPartyRelationship(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = PartyRelationship.class, prefix = "prm")
        default Map<String, SecurityGroup> chainPartyRelationship(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("SecurityGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_RELATIONSHIP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        SecurityGroup p = map.computeIfAbsent(rr.getColumn("sg_group_id", String.class),
                                id -> rr.getRow(SecurityGroup.class));
                        if (rr.getColumn("prm_security_group_id", String.class) != null) {
                            p.getRelPartyRelationship()
                                    .add(rr.getRow(PartyRelationship.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = SecurityGroupPermission.class, prefix = "sgpm")
        default Map<String, SecurityGroup> chainSecurityGroupPermission(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               boolean succInvoke) {
            return chainSecurityGroupPermission(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = SecurityGroupPermission.class, prefix = "sgpm")
        default Map<String, SecurityGroup> chainSecurityGroupPermission(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("SecurityGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SECURITY_GROUP_PERMISSION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        SecurityGroup p = map.computeIfAbsent(rr.getColumn("sg_group_id", String.class),
                                id -> rr.getRow(SecurityGroup.class));
                        if (rr.getColumn("sgpm_group_id", String.class) != null) {
                            p.getRelSecurityGroupPermission()
                                    .add(rr.getRow(SecurityGroupPermission.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = UserLoginSecurityGroup.class, prefix = "ulsgm")
        default Map<String, SecurityGroup> chainUserLoginSecurityGroup(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               boolean succInvoke) {
            return chainUserLoginSecurityGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = UserLoginSecurityGroup.class, prefix = "ulsgm")
        default Map<String, SecurityGroup> chainUserLoginSecurityGroup(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("SecurityGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(USER_LOGIN_SECURITY_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        SecurityGroup p = map.computeIfAbsent(rr.getColumn("sg_group_id", String.class),
                                id -> rr.getRow(SecurityGroup.class));
                        if (rr.getColumn("ulsgm_group_id", String.class) != null) {
                            p.getRelUserLoginSecurityGroup()
                                    .add(rr.getRow(UserLoginSecurityGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, SecurityGroup> chainTenant(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = SecurityGroup.class, prefix = "sg")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, SecurityGroup> chainTenant(ProtoMeta protoMeta,
                                               Map<String, SecurityGroup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("SecurityGroup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        SecurityGroup p = map.computeIfAbsent(rr.getColumn("sg_group_id", String.class),
                                id -> rr.getRow(SecurityGroup.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, SecurityGroup>> partyRelationship(Dao dao, boolean succ) {
        return e -> dao.chainPartyRelationship(protoMeta, e, succ);
    }

    public Consumer<Map<String, SecurityGroup>> partyRelationship(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyRelationship(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, SecurityGroup>> securityGroupPermission(Dao dao, boolean succ) {
        return e -> dao.chainSecurityGroupPermission(protoMeta, e, succ);
    }

    public Consumer<Map<String, SecurityGroup>> securityGroupPermission(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSecurityGroupPermission(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, SecurityGroup>> userLoginSecurityGroup(Dao dao, boolean succ) {
        return e -> dao.chainUserLoginSecurityGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, SecurityGroup>> userLoginSecurityGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainUserLoginSecurityGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, SecurityGroup>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, SecurityGroup>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, SecurityGroup> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, SecurityGroup> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, SecurityGroup> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, SecurityGroup>> chain = tenant(dao, false);
         
        if (incls.contains(PARTY_RELATIONSHIP)) {
            chain = chain.andThen(partyRelationship(dao, true));
        }
         
        if (incls.contains(SECURITY_GROUP_PERMISSION)) {
            chain = chain.andThen(securityGroupPermission(dao, true));
        }
         
        if (incls.contains(USER_LOGIN_SECURITY_GROUP)) {
            chain = chain.andThen(userLoginSecurityGroup(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<SecurityGroupData> responseObserver) {
        Map<String, SecurityGroup> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            SecurityGroupData.Builder securityGroupData = data.toHeadBuilder();
             
            data.getRelPartyRelationship().forEach(e -> 
                securityGroupData.addPartyRelationship(e.toDataBuilder())); 
            data.getRelSecurityGroupPermission().forEach(e -> 
                securityGroupData.addSecurityGroupPermission(e.toDataBuilder())); 
            data.getRelUserLoginSecurityGroup().forEach(e -> 
                securityGroupData.addUserLoginSecurityGroup(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                securityGroupData.setTenant(e.toDataBuilder()));
            return securityGroupData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public SecurityGroup get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getSecurityGroup(id);
    }

    public List<SecurityGroup> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listSecurityGroup();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countSecurityGroup();
    }


    public void store(SecurityGroup securityGroup){
        store(securityGroup, true);
    }

    public void store(SecurityGroup securityGroup, boolean genId){
        process(c ->{
            if(genId){
                securityGroup.setGroupId(sequence.nextStringId());
            }
            storeOrUpdate(c, securityGroup.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "SecurityGroup", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final SecurityGroup rec;
        final Message p1;
        SecurityGroup persistObject;

        Agent(IProc.ProcContext ctx, SecurityGroup rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public SecurityGroup getRecord(){
            return rec;
        }

        public SecurityGroup merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<PartyRelationship> getPartyRelationship(){
            return getRelationValues(ctx, p1, "party_relationship", PartyRelationship.class);
        }

        public List<PartyRelationship> mergePartyRelationship(){
            return getPartyRelationship().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyRelationship().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<SecurityGroupPermission> getSecurityGroupPermission(){
            return getRelationValues(ctx, p1, "security_group_permission", SecurityGroupPermission.class);
        }

        public List<SecurityGroupPermission> mergeSecurityGroupPermission(){
            return getSecurityGroupPermission().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSecurityGroupPermission().add(c))
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
        SecurityGroupData p = SecurityGroupData.newBuilder()
                .setGroupId(key)
                .build();
        SecurityGroup rec = findOne(ctx, p, SecurityGroup.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, SecurityGroup rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PARTY_RELATIONSHIP="party_relationship";
         
    public static final String SECURITY_GROUP_PERMISSION="security_group_permission";
         
    public static final String USER_LOGIN_SECURITY_GROUP="user_login_security_group";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> querySecurityGroupRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            SecurityGroupData p = SecurityGroupData.newBuilder()
                    .setGroupId(key)
                    .build();
            List<SecurityGroupData.Builder> ds = find(ctx, p, SecurityGroup.class).stream()
                    .map(e -> {
                        SecurityGroupData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set party_relationship to head entity                        
                        if(relationsDemand.contains("party_relationship")) {
                            getRelationValues(ctx, p1, "party_relationship",
                                            PartyRelationship.class)
                                    .forEach(el -> pb.addPartyRelationship(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set security_group_permission to head entity                        
                        if(relationsDemand.contains("security_group_permission")) {
                            getRelationValues(ctx, p1, "security_group_permission",
                                            SecurityGroupPermission.class)
                                    .forEach(el -> pb.addSecurityGroupPermission(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set user_login_security_group to head entity                        
                        if(relationsDemand.contains("user_login_security_group")) {
                            getRelationValues(ctx, p1, "user_login_security_group",
                                            UserLoginSecurityGroup.class)
                                    .forEach(el -> pb.addUserLoginSecurityGroup(
                                             el.toDataBuilder().build()));
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


    
    public SecurityGroup.SecurityGroupBuilder seed(){
        return SecurityGroup.builder()
                .groupId(sequence.nextStringId());
    }
}

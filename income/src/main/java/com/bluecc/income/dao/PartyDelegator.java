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

import com.bluecc.hubs.stub.PartyData;

public class PartyDelegator extends AbstractProcs implements IChainQuery<Party>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(Party.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from party")
        List<Party> listParty();
        @SqlQuery("select * from party where party_id=:id")
        Party getParty(@Bind("id") String id);

        @SqlQuery("select count(*) from party")
        int countParty();

        // for relations
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbulo")
        default Map<String, Party> chainCreatedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCreatedByUserLogin(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbulo")
        default Map<String, Party> chainCreatedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_USER_LOGIN);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("cbulo_user_login_id", String.class) != null) {
                            p.getRelCreatedByUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "lmbulo")
        default Map<String, Party> chainLastModifiedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByUserLogin(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "lmbulo")
        default Map<String, Party> chainLastModifiedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_USER_LOGIN);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("lmbulo_user_login_id", String.class) != null) {
                            p.getRelLastModifiedByUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Party> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Party> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("atm_party_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTransEntry.class, prefix = "atem")
        default Map<String, Party> chainAcctgTransEntry(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainAcctgTransEntry(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTransEntry.class, prefix = "atem")
        default Map<String, Party> chainAcctgTransEntry(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS_ENTRY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("atem_party_id", String.class) != null) {
                            p.getRelAcctgTransEntry()
                                    .add(rr.getRow(AcctgTransEntry.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Agreement.class, prefix = "fam")
        default Map<String, Party> chainFromAgreement(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromAgreement(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Agreement.class, prefix = "fam")
        default Map<String, Party> chainFromAgreement(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_AGREEMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fam_party_id_from", String.class) != null) {
                            p.getRelFromAgreement()
                                    .add(rr.getRow(Agreement.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Agreement.class, prefix = "tam")
        default Map<String, Party> chainToAgreement(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainToAgreement(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Agreement.class, prefix = "tam")
        default Map<String, Party> chainToAgreement(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_AGREEMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tam_party_id_to", String.class) != null) {
                            p.getRelToAgreement()
                                    .add(rr.getRow(Agreement.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = BillingAccountRole.class, prefix = "barm")
        default Map<String, Party> chainBillingAccountRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainBillingAccountRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = BillingAccountRole.class, prefix = "barm")
        default Map<String, Party> chainBillingAccountRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(BILLING_ACCOUNT_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("barm_party_id", String.class) != null) {
                            p.getRelBillingAccountRole()
                                    .add(rr.getRow(BillingAccountRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CarrierShipmentBoxType.class, prefix = "csbtm")
        default Map<String, Party> chainCarrierShipmentBoxType(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCarrierShipmentBoxType(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CarrierShipmentBoxType.class, prefix = "csbtm")
        default Map<String, Party> chainCarrierShipmentBoxType(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_SHIPMENT_BOX_TYPE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("csbtm_party_id", String.class) != null) {
                            p.getRelCarrierShipmentBoxType()
                                    .add(rr.getRow(CarrierShipmentBoxType.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CarrierShipmentMethod.class, prefix = "csmm")
        default Map<String, Party> chainCarrierShipmentMethod(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCarrierShipmentMethod(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CarrierShipmentMethod.class, prefix = "csmm")
        default Map<String, Party> chainCarrierShipmentMethod(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_SHIPMENT_METHOD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("csmm_party_id", String.class) != null) {
                            p.getRelCarrierShipmentMethod()
                                    .add(rr.getRow(CarrierShipmentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CommunicationEvent.class, prefix = "tcem")
        default Map<String, Party> chainToCommunicationEvent(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainToCommunicationEvent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CommunicationEvent.class, prefix = "tcem")
        default Map<String, Party> chainToCommunicationEvent(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_COMMUNICATION_EVENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tcem_party_id_to", String.class) != null) {
                            p.getRelToCommunicationEvent()
                                    .add(rr.getRow(CommunicationEvent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CommunicationEvent.class, prefix = "fcem")
        default Map<String, Party> chainFromCommunicationEvent(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromCommunicationEvent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CommunicationEvent.class, prefix = "fcem")
        default Map<String, Party> chainFromCommunicationEvent(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_COMMUNICATION_EVENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fcem_party_id_from", String.class) != null) {
                            p.getRelFromCommunicationEvent()
                                    .add(rr.getRow(CommunicationEvent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CommunicationEventRole.class, prefix = "cerm")
        default Map<String, Party> chainCommunicationEventRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCommunicationEventRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CommunicationEventRole.class, prefix = "cerm")
        default Map<String, Party> chainCommunicationEventRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(COMMUNICATION_EVENT_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("cerm_party_id", String.class) != null) {
                            p.getRelCommunicationEventRole()
                                    .add(rr.getRow(CommunicationEventRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ContentRole.class, prefix = "crm")
        default Map<String, Party> chainContentRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainContentRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ContentRole.class, prefix = "crm")
        default Map<String, Party> chainContentRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CONTENT_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("crm_party_id", String.class) != null) {
                            p.getRelContentRole()
                                    .add(rr.getRow(ContentRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CustRequest.class, prefix = "fcrm")
        default Map<String, Party> chainFromCustRequest(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromCustRequest(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CustRequest.class, prefix = "fcrm")
        default Map<String, Party> chainFromCustRequest(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_CUST_REQUEST);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fcrm_from_party_id", String.class) != null) {
                            p.getRelFromCustRequest()
                                    .add(rr.getRow(CustRequest.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CustRequestType.class, prefix = "crtm")
        default Map<String, Party> chainCustRequestType(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCustRequestType(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = CustRequestType.class, prefix = "crtm")
        default Map<String, Party> chainCustRequestType(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CUST_REQUEST_TYPE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("crtm_party_id", String.class) != null) {
                            p.getRelCustRequestType()
                                    .add(rr.getRow(CustRequestType.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Facility.class, prefix = "ofzm")
        default Map<String, Party> chainOwnerFacility(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOwnerFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Facility.class, prefix = "ofzm")
        default Map<String, Party> chainOwnerFacility(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OWNER_FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ofzm_owner_party_id", String.class) != null) {
                            p.getRelOwnerFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccount.class, prefix = "ofam")
        default Map<String, Party> chainOrganizationFinAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOrganizationFinAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccount.class, prefix = "ofam")
        default Map<String, Party> chainOrganizationFinAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORGANIZATION_FIN_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ofam_organization_party_id", String.class) != null) {
                            p.getRelOrganizationFinAccount()
                                    .add(rr.getRow(FinAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccount.class, prefix = "ofam")
        default Map<String, Party> chainOwnerFinAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOwnerFinAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccount.class, prefix = "ofam")
        default Map<String, Party> chainOwnerFinAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OWNER_FIN_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ofam_owner_party_id", String.class) != null) {
                            p.getRelOwnerFinAccount()
                                    .add(rr.getRow(FinAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountRole.class, prefix = "farm")
        default Map<String, Party> chainFinAccountRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFinAccountRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountRole.class, prefix = "farm")
        default Map<String, Party> chainFinAccountRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("farm_party_id", String.class) != null) {
                            p.getRelFinAccountRole()
                                    .add(rr.getRow(FinAccountRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fatm")
        default Map<String, Party> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFinAccountTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fatm")
        default Map<String, Party> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fatm_party_id", String.class) != null) {
                            p.getRelFinAccountTrans()
                                    .add(rr.getRow(FinAccountTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "pbfatm")
        default Map<String, Party> chainPerformedByFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPerformedByFinAccountTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "pbfatm")
        default Map<String, Party> chainPerformedByFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PERFORMED_BY_FIN_ACCOUNT_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pbfatm_performed_by_party_id", String.class) != null) {
                            p.getRelPerformedByFinAccountTrans()
                                    .add(rr.getRow(FinAccountTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fam")
        default Map<String, Party> chainFixedAsset(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFixedAsset(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fam")
        default Map<String, Party> chainFixedAsset(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fam_party_id", String.class) != null) {
                            p.getRelFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FixedAssetRegistration.class, prefix = "gafarm")
        default Map<String, Party> chainGovAgencyFixedAssetRegistration(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainGovAgencyFixedAssetRegistration(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = FixedAssetRegistration.class, prefix = "gafarm")
        default Map<String, Party> chainGovAgencyFixedAssetRegistration(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(GOV_AGENCY_FIXED_ASSET_REGISTRATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("gafarm_gov_agency_party_id", String.class) != null) {
                            p.getRelGovAgencyFixedAssetRegistration()
                                    .add(rr.getRow(FixedAssetRegistration.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = GlAccountTypeDefault.class, prefix = "ogatdm")
        default Map<String, Party> chainOrganizationGlAccountTypeDefault(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOrganizationGlAccountTypeDefault(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = GlAccountTypeDefault.class, prefix = "ogatdm")
        default Map<String, Party> chainOrganizationGlAccountTypeDefault(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORGANIZATION_GL_ACCOUNT_TYPE_DEFAULT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ogatdm_organization_party_id", String.class) != null) {
                            p.getRelOrganizationGlAccountTypeDefault()
                                    .add(rr.getRow(GlAccountTypeDefault.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "iim")
        default Map<String, Party> chainInventoryItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainInventoryItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "iim")
        default Map<String, Party> chainInventoryItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVENTORY_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("iim_party_id", String.class) != null) {
                            p.getRelInventoryItem()
                                    .add(rr.getRow(InventoryItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "oiim")
        default Map<String, Party> chainOwnerInventoryItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOwnerInventoryItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "oiim")
        default Map<String, Party> chainOwnerInventoryItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OWNER_INVENTORY_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("oiim_owner_party_id", String.class) != null) {
                            p.getRelOwnerInventoryItem()
                                    .add(rr.getRow(InventoryItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Invoice.class, prefix = "fim")
        default Map<String, Party> chainFromInvoice(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromInvoice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Invoice.class, prefix = "fim")
        default Map<String, Party> chainFromInvoice(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_INVOICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fim_party_id_from", String.class) != null) {
                            p.getRelFromInvoice()
                                    .add(rr.getRow(Invoice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Invoice.class, prefix = "inzm")
        default Map<String, Party> chainInvoice(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainInvoice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Invoice.class, prefix = "inzm")
        default Map<String, Party> chainInvoice(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("inzm_party_id", String.class) != null) {
                            p.getRelInvoice()
                                    .add(rr.getRow(Invoice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "taiim")
        default Map<String, Party> chainTaxAuthorityInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "taiim")
        default Map<String, Party> chainTaxAuthorityInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_INVOICE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("taiim_tax_auth_party_id", String.class) != null) {
                            p.getRelTaxAuthorityInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ooiim")
        default Map<String, Party> chainOverrideOrgInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOverrideOrgInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ooiim")
        default Map<String, Party> chainOverrideOrgInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OVERRIDE_ORG_INVOICE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ooiim_override_org_party_id", String.class) != null) {
                            p.getRelOverrideOrgInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceItemTypeGlAccount.class, prefix = "oiitgam")
        default Map<String, Party> chainOrganizationInvoiceItemTypeGlAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOrganizationInvoiceItemTypeGlAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceItemTypeGlAccount.class, prefix = "oiitgam")
        default Map<String, Party> chainOrganizationInvoiceItemTypeGlAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORGANIZATION_INVOICE_ITEM_TYPE_GL_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("oiitgam_organization_party_id", String.class) != null) {
                            p.getRelOrganizationInvoiceItemTypeGlAccount()
                                    .add(rr.getRow(InvoiceItemTypeGlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceRole.class, prefix = "irm")
        default Map<String, Party> chainInvoiceRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainInvoiceRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = InvoiceRole.class, prefix = "irm")
        default Map<String, Party> chainInvoiceRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("irm_party_id", String.class) != null) {
                            p.getRelInvoiceRole()
                                    .add(rr.getRow(InvoiceRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "soisgm")
        default Map<String, Party> chainSupplierOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainSupplierOrderItemShipGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "soisgm")
        default Map<String, Party> chainSupplierOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUPPLIER_ORDER_ITEM_SHIP_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("soisgm_supplier_party_id", String.class) != null) {
                            p.getRelSupplierOrderItemShipGroup()
                                    .add(rr.getRow(OrderItemShipGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "voisgm")
        default Map<String, Party> chainVendorOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainVendorOrderItemShipGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "voisgm")
        default Map<String, Party> chainVendorOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(VENDOR_ORDER_ITEM_SHIP_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("voisgm_vendor_party_id", String.class) != null) {
                            p.getRelVendorOrderItemShipGroup()
                                    .add(rr.getRow(OrderItemShipGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "coisgm")
        default Map<String, Party> chainCarrierOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCarrierOrderItemShipGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "coisgm")
        default Map<String, Party> chainCarrierOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_ORDER_ITEM_SHIP_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("coisgm_carrier_party_id", String.class) != null) {
                            p.getRelCarrierOrderItemShipGroup()
                                    .add(rr.getRow(OrderItemShipGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderRole.class, prefix = "orzm")
        default Map<String, Party> chainOrderRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOrderRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderRole.class, prefix = "orzm")
        default Map<String, Party> chainOrderRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("orzm_party_id", String.class) != null) {
                            p.getRelOrderRole()
                                    .add(rr.getRow(OrderRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyAcctgPreference.class, prefix = "papo")
        default Map<String, Party> chainPartyAcctgPreference(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyAcctgPreference(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyAcctgPreference.class, prefix = "papo")
        default Map<String, Party> chainPartyAcctgPreference(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_ACCTG_PREFERENCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("papo_party_id", String.class) != null) {
                            p.getRelPartyAcctgPreference()
                                    .add(rr.getRow(PartyAcctgPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcmm")
        default Map<String, Party> chainPartyContactMech(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyContactMech(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcmm")
        default Map<String, Party> chainPartyContactMech(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pcmm_party_id", String.class) != null) {
                            p.getRelPartyContactMech()
                                    .add(rr.getRow(PartyContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMechPurpose.class, prefix = "pcmpm")
        default Map<String, Party> chainPartyContactMechPurpose(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyContactMechPurpose(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMechPurpose.class, prefix = "pcmpm")
        default Map<String, Party> chainPartyContactMechPurpose(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH_PURPOSE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pcmpm_party_id", String.class) != null) {
                            p.getRelPartyContactMechPurpose()
                                    .add(rr.getRow(PartyContactMechPurpose.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyGeoPoint.class, prefix = "pgpm")
        default Map<String, Party> chainPartyGeoPoint(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyGeoPoint(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyGeoPoint.class, prefix = "pgpm")
        default Map<String, Party> chainPartyGeoPoint(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_GEO_POINT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pgpm_party_id", String.class) != null) {
                            p.getRelPartyGeoPoint()
                                    .add(rr.getRow(PartyGeoPoint.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pgo")
        default Map<String, Party> chainPartyGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pgo")
        default Map<String, Party> chainPartyGroup(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pgo_party_id", String.class) != null) {
                            p.getRelPartyGroup()
                                    .add(rr.getRow(PartyGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyIdentification.class, prefix = "pim")
        default Map<String, Party> chainPartyIdentification(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyIdentification(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyIdentification.class, prefix = "pim")
        default Map<String, Party> chainPartyIdentification(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_IDENTIFICATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pim_party_id", String.class) != null) {
                            p.getRelPartyIdentification()
                                    .add(rr.getRow(PartyIdentification.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRate.class, prefix = "prm")
        default Map<String, Party> chainPartyRate(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyRate(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRate.class, prefix = "prm")
        default Map<String, Party> chainPartyRate(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_RATE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("prm_party_id", String.class) != null) {
                            p.getRelPartyRate()
                                    .add(rr.getRow(PartyRate.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRelationship.class, prefix = "fprm")
        default Map<String, Party> chainFromPartyRelationship(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromPartyRelationship(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRelationship.class, prefix = "fprm")
        default Map<String, Party> chainFromPartyRelationship(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PARTY_RELATIONSHIP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fprm_party_id_from", String.class) != null) {
                            p.getRelFromPartyRelationship()
                                    .add(rr.getRow(PartyRelationship.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRelationship.class, prefix = "tprm")
        default Map<String, Party> chainToPartyRelationship(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainToPartyRelationship(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRelationship.class, prefix = "tprm")
        default Map<String, Party> chainToPartyRelationship(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY_RELATIONSHIP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tprm_party_id_to", String.class) != null) {
                            p.getRelToPartyRelationship()
                                    .add(rr.getRow(PartyRelationship.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "prm")
        default Map<String, Party> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "prm")
        default Map<String, Party> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("prm_party_id", String.class) != null) {
                            p.getRelPartyRole()
                                    .add(rr.getRow(PartyRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyStatus.class, prefix = "psm")
        default Map<String, Party> chainPartyStatus(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyStatus.class, prefix = "psm")
        default Map<String, Party> chainPartyStatus(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("psm_party_id", String.class) != null) {
                            p.getRelPartyStatus()
                                    .add(rr.getRow(PartyStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyTaxAuthInfo.class, prefix = "ptaim")
        default Map<String, Party> chainPartyTaxAuthInfo(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPartyTaxAuthInfo(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyTaxAuthInfo.class, prefix = "ptaim")
        default Map<String, Party> chainPartyTaxAuthInfo(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_TAX_AUTH_INFO);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ptaim_party_id", String.class) != null) {
                            p.getRelPartyTaxAuthInfo()
                                    .add(rr.getRow(PartyTaxAuthInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Payment.class, prefix = "fpm")
        default Map<String, Party> chainFromPayment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromPayment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Payment.class, prefix = "fpm")
        default Map<String, Party> chainFromPayment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PAYMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fpm_party_id_from", String.class) != null) {
                            p.getRelFromPayment()
                                    .add(rr.getRow(Payment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Payment.class, prefix = "tpm")
        default Map<String, Party> chainToPayment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainToPayment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Payment.class, prefix = "tpm")
        default Map<String, Party> chainToPayment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PAYMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tpm_party_id_to", String.class) != null) {
                            p.getRelToPayment()
                                    .add(rr.getRow(Payment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentGlAccountTypeMap.class, prefix = "pgatmm")
        default Map<String, Party> chainPaymentGlAccountTypeMap(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPaymentGlAccountTypeMap(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentGlAccountTypeMap.class, prefix = "pgatmm")
        default Map<String, Party> chainPaymentGlAccountTypeMap(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_GL_ACCOUNT_TYPE_MAP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pgatmm_organization_party_id", String.class) != null) {
                            p.getRelPaymentGlAccountTypeMap()
                                    .add(rr.getRow(PaymentGlAccountTypeMap.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmm")
        default Map<String, Party> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPaymentMethod(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmm")
        default Map<String, Party> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_METHOD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pmm_party_id", String.class) != null) {
                            p.getRelPaymentMethod()
                                    .add(rr.getRow(PaymentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethodTypeGlAccount.class, prefix = "opmtgam")
        default Map<String, Party> chainOrganizationPaymentMethodTypeGlAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOrganizationPaymentMethodTypeGlAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethodTypeGlAccount.class, prefix = "opmtgam")
        default Map<String, Party> chainOrganizationPaymentMethodTypeGlAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORGANIZATION_PAYMENT_METHOD_TYPE_GL_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("opmtgam_organization_party_id", String.class) != null) {
                            p.getRelOrganizationPaymentMethodTypeGlAccount()
                                    .add(rr.getRow(PaymentMethodTypeGlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Person.class, prefix = "peo")
        default Map<String, Party> chainPerson(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPerson(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Person.class, prefix = "peo")
        default Map<String, Party> chainPerson(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PERSON);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("peo_party_id", String.class) != null) {
                            p.getRelPerson()
                                    .add(rr.getRow(Person.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductCategoryRole.class, prefix = "pcrm")
        default Map<String, Party> chainProductCategoryRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainProductCategoryRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductCategoryRole.class, prefix = "pcrm")
        default Map<String, Party> chainProductCategoryRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pcrm_party_id", String.class) != null) {
                            p.getRelProductCategoryRole()
                                    .add(rr.getRow(ProductCategoryRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "tappm")
        default Map<String, Party> chainTaxAuthorityProductPrice(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityProductPrice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "tappm")
        default Map<String, Party> chainTaxAuthorityProductPrice(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_PRODUCT_PRICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tappm_tax_auth_party_id", String.class) != null) {
                            p.getRelTaxAuthorityProductPrice()
                                    .add(rr.getRow(ProductPrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "ppm")
        default Map<String, Party> chainProductPromo(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainProductPromo(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "ppm")
        default Map<String, Party> chainProductPromo(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PROMO);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ppm_override_org_party_id", String.class) != null) {
                            p.getRelProductPromo()
                                    .add(rr.getRow(ProductPromo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "psm")
        default Map<String, Party> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "psm")
        default Map<String, Party> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("psm_pay_to_party_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psrm")
        default Map<String, Party> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainProductStoreRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psrm")
        default Map<String, Party> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("psrm_party_id", String.class) != null) {
                            p.getRelProductStoreRole()
                                    .add(rr.getRow(ProductStoreRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductStoreShipmentMeth.class, prefix = "pssmm")
        default Map<String, Party> chainProductStoreShipmentMeth(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainProductStoreShipmentMeth(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ProductStoreShipmentMeth.class, prefix = "pssmm")
        default Map<String, Party> chainProductStoreShipmentMeth(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_SHIPMENT_METH);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pssmm_company_party_id", String.class) != null) {
                            p.getRelProductStoreShipmentMeth()
                                    .add(rr.getRow(ProductStoreShipmentMeth.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Quote.class, prefix = "qum")
        default Map<String, Party> chainQuote(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainQuote(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Quote.class, prefix = "qum")
        default Map<String, Party> chainQuote(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("qum_party_id", String.class) != null) {
                            p.getRelQuote()
                                    .add(rr.getRow(Quote.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = QuoteRole.class, prefix = "qrm")
        default Map<String, Party> chainQuoteRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainQuoteRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = QuoteRole.class, prefix = "qrm")
        default Map<String, Party> chainQuoteRole(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("qrm_party_id", String.class) != null) {
                            p.getRelQuoteRole()
                                    .add(rr.getRow(QuoteRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = RateAmount.class, prefix = "ram")
        default Map<String, Party> chainRateAmount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainRateAmount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = RateAmount.class, prefix = "ram")
        default Map<String, Party> chainRateAmount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RATE_AMOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ram_party_id", String.class) != null) {
                            p.getRelRateAmount()
                                    .add(rr.getRow(RateAmount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Shipment.class, prefix = "tsm")
        default Map<String, Party> chainToShipment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainToShipment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Shipment.class, prefix = "tsm")
        default Map<String, Party> chainToShipment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_SHIPMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tsm_party_id_to", String.class) != null) {
                            p.getRelToShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Shipment.class, prefix = "fsm")
        default Map<String, Party> chainFromShipment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainFromShipment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Shipment.class, prefix = "fsm")
        default Map<String, Party> chainFromShipment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_SHIPMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("fsm_party_id_from", String.class) != null) {
                            p.getRelFromShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ShipmentCostEstimate.class, prefix = "scem")
        default Map<String, Party> chainShipmentCostEstimate(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainShipmentCostEstimate(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ShipmentCostEstimate.class, prefix = "scem")
        default Map<String, Party> chainShipmentCostEstimate(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_COST_ESTIMATE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("scem_party_id", String.class) != null) {
                            p.getRelShipmentCostEstimate()
                                    .add(rr.getRow(ShipmentCostEstimate.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "csrsm")
        default Map<String, Party> chainCarrierShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainCarrierShipmentRouteSegment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "csrsm")
        default Map<String, Party> chainCarrierShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_SHIPMENT_ROUTE_SEGMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("csrsm_carrier_party_id", String.class) != null) {
                            p.getRelCarrierShipmentRouteSegment()
                                    .add(rr.getRow(ShipmentRouteSegment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = SupplierProduct.class, prefix = "spm")
        default Map<String, Party> chainSupplierProduct(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainSupplierProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = SupplierProduct.class, prefix = "spm")
        default Map<String, Party> chainSupplierProduct(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUPPLIER_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("spm_party_id", String.class) != null) {
                            p.getRelSupplierProduct()
                                    .add(rr.getRow(SupplierProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = SupplierProductFeature.class, prefix = "spfm")
        default Map<String, Party> chainSupplierProductFeature(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainSupplierProductFeature(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = SupplierProductFeature.class, prefix = "spfm")
        default Map<String, Party> chainSupplierProductFeature(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUPPLIER_PRODUCT_FEATURE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("spfm_party_id", String.class) != null) {
                            p.getRelSupplierProductFeature()
                                    .add(rr.getRow(SupplierProductFeature.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = TaxAuthority.class, prefix = "tatam")
        default Map<String, Party> chainTaxAuthTaxAuthority(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthTaxAuthority(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = TaxAuthority.class, prefix = "tatam")
        default Map<String, Party> chainTaxAuthTaxAuthority(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTH_TAX_AUTHORITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("tatam_tax_auth_party_id", String.class) != null) {
                            p.getRelTaxAuthTaxAuthority()
                                    .add(rr.getRow(TaxAuthority.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = TaxAuthorityGlAccount.class, prefix = "otagam")
        default Map<String, Party> chainOrganizationTaxAuthorityGlAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainOrganizationTaxAuthorityGlAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = TaxAuthorityGlAccount.class, prefix = "otagam")
        default Map<String, Party> chainOrganizationTaxAuthorityGlAccount(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORGANIZATION_TAX_AUTHORITY_GL_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("otagam_organization_party_id", String.class) != null) {
                            p.getRelOrganizationTaxAuthorityGlAccount()
                                    .add(rr.getRow(TaxAuthorityGlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ulm")
        default Map<String, Party> chainUserLogin(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainUserLogin(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ulm")
        default Map<String, Party> chainUserLogin(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(USER_LOGIN);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("ulm_party_id", String.class) != null) {
                            p.getRelUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = WorkEffortPartyAssignment.class, prefix = "wepam")
        default Map<String, Party> chainWorkEffortPartyAssignment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainWorkEffortPartyAssignment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = WorkEffortPartyAssignment.class, prefix = "wepam")
        default Map<String, Party> chainWorkEffortPartyAssignment(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT_PARTY_ASSIGNMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("wepam_party_id", String.class) != null) {
                            p.getRelWorkEffortPartyAssignment()
                                    .add(rr.getRow(WorkEffortPartyAssignment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Party> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Party> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, Party>> createdByUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> createdByUserLogin(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> lastModifiedByUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> lastModifiedByUserLogin(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> acctgTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> acctgTransEntry(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTransEntry(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> acctgTransEntry(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTransEntry(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromAgreement(Dao dao, boolean succ) {
        return e -> dao.chainFromAgreement(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromAgreement(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromAgreement(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> toAgreement(Dao dao, boolean succ) {
        return e -> dao.chainToAgreement(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> toAgreement(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToAgreement(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> billingAccountRole(Dao dao, boolean succ) {
        return e -> dao.chainBillingAccountRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> billingAccountRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainBillingAccountRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> carrierShipmentBoxType(Dao dao, boolean succ) {
        return e -> dao.chainCarrierShipmentBoxType(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> carrierShipmentBoxType(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCarrierShipmentBoxType(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> carrierShipmentMethod(Dao dao, boolean succ) {
        return e -> dao.chainCarrierShipmentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> carrierShipmentMethod(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCarrierShipmentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> toCommunicationEvent(Dao dao, boolean succ) {
        return e -> dao.chainToCommunicationEvent(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> toCommunicationEvent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToCommunicationEvent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromCommunicationEvent(Dao dao, boolean succ) {
        return e -> dao.chainFromCommunicationEvent(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromCommunicationEvent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromCommunicationEvent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> communicationEventRole(Dao dao, boolean succ) {
        return e -> dao.chainCommunicationEventRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> communicationEventRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCommunicationEventRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> contentRole(Dao dao, boolean succ) {
        return e -> dao.chainContentRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> contentRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainContentRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromCustRequest(Dao dao, boolean succ) {
        return e -> dao.chainFromCustRequest(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromCustRequest(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromCustRequest(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> custRequestType(Dao dao, boolean succ) {
        return e -> dao.chainCustRequestType(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> custRequestType(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCustRequestType(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> ownerFacility(Dao dao, boolean succ) {
        return e -> dao.chainOwnerFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> ownerFacility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOwnerFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> organizationFinAccount(Dao dao, boolean succ) {
        return e -> dao.chainOrganizationFinAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> organizationFinAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrganizationFinAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> ownerFinAccount(Dao dao, boolean succ) {
        return e -> dao.chainOwnerFinAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> ownerFinAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOwnerFinAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> finAccountRole(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> finAccountRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> finAccountTrans(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> finAccountTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> performedByFinAccountTrans(Dao dao, boolean succ) {
        return e -> dao.chainPerformedByFinAccountTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> performedByFinAccountTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPerformedByFinAccountTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fixedAsset(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> govAgencyFixedAssetRegistration(Dao dao, boolean succ) {
        return e -> dao.chainGovAgencyFixedAssetRegistration(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> govAgencyFixedAssetRegistration(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainGovAgencyFixedAssetRegistration(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> organizationGlAccountTypeDefault(Dao dao, boolean succ) {
        return e -> dao.chainOrganizationGlAccountTypeDefault(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> organizationGlAccountTypeDefault(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrganizationGlAccountTypeDefault(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> inventoryItem(Dao dao, boolean succ) {
        return e -> dao.chainInventoryItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> inventoryItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInventoryItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> ownerInventoryItem(Dao dao, boolean succ) {
        return e -> dao.chainOwnerInventoryItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> ownerInventoryItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOwnerInventoryItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromInvoice(Dao dao, boolean succ) {
        return e -> dao.chainFromInvoice(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromInvoice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromInvoice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> invoice(Dao dao, boolean succ) {
        return e -> dao.chainInvoice(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> invoice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> taxAuthorityInvoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> taxAuthorityInvoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> overrideOrgInvoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainOverrideOrgInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> overrideOrgInvoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOverrideOrgInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> organizationInvoiceItemTypeGlAccount(Dao dao, boolean succ) {
        return e -> dao.chainOrganizationInvoiceItemTypeGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> organizationInvoiceItemTypeGlAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrganizationInvoiceItemTypeGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> invoiceRole(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> invoiceRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> supplierOrderItemShipGroup(Dao dao, boolean succ) {
        return e -> dao.chainSupplierOrderItemShipGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> supplierOrderItemShipGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSupplierOrderItemShipGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> vendorOrderItemShipGroup(Dao dao, boolean succ) {
        return e -> dao.chainVendorOrderItemShipGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> vendorOrderItemShipGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainVendorOrderItemShipGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> carrierOrderItemShipGroup(Dao dao, boolean succ) {
        return e -> dao.chainCarrierOrderItemShipGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> carrierOrderItemShipGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCarrierOrderItemShipGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> orderRole(Dao dao, boolean succ) {
        return e -> dao.chainOrderRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> orderRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyAcctgPreference(Dao dao, boolean succ) {
        return e -> dao.chainPartyAcctgPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyAcctgPreference(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyAcctgPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyContactMech(Dao dao, boolean succ) {
        return e -> dao.chainPartyContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyContactMech(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyContactMechPurpose(Dao dao, boolean succ) {
        return e -> dao.chainPartyContactMechPurpose(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyContactMechPurpose(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyContactMechPurpose(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyGeoPoint(Dao dao, boolean succ) {
        return e -> dao.chainPartyGeoPoint(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyGeoPoint(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyGeoPoint(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyGroup(Dao dao, boolean succ) {
        return e -> dao.chainPartyGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyIdentification(Dao dao, boolean succ) {
        return e -> dao.chainPartyIdentification(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyIdentification(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyIdentification(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyRate(Dao dao, boolean succ) {
        return e -> dao.chainPartyRate(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyRate(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyRate(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromPartyRelationship(Dao dao, boolean succ) {
        return e -> dao.chainFromPartyRelationship(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromPartyRelationship(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromPartyRelationship(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> toPartyRelationship(Dao dao, boolean succ) {
        return e -> dao.chainToPartyRelationship(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> toPartyRelationship(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToPartyRelationship(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyRole(Dao dao, boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyStatus(Dao dao, boolean succ) {
        return e -> dao.chainPartyStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> partyTaxAuthInfo(Dao dao, boolean succ) {
        return e -> dao.chainPartyTaxAuthInfo(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> partyTaxAuthInfo(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyTaxAuthInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromPayment(Dao dao, boolean succ) {
        return e -> dao.chainFromPayment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromPayment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromPayment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> toPayment(Dao dao, boolean succ) {
        return e -> dao.chainToPayment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> toPayment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToPayment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> paymentGlAccountTypeMap(Dao dao, boolean succ) {
        return e -> dao.chainPaymentGlAccountTypeMap(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> paymentGlAccountTypeMap(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentGlAccountTypeMap(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> paymentMethod(Dao dao, boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> paymentMethod(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> organizationPaymentMethodTypeGlAccount(Dao dao, boolean succ) {
        return e -> dao.chainOrganizationPaymentMethodTypeGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> organizationPaymentMethodTypeGlAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrganizationPaymentMethodTypeGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> person(Dao dao, boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> person(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> productCategoryRole(Dao dao, boolean succ) {
        return e -> dao.chainProductCategoryRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> productCategoryRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategoryRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> taxAuthorityProductPrice(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityProductPrice(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> taxAuthorityProductPrice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityProductPrice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> productPromo(Dao dao, boolean succ) {
        return e -> dao.chainProductPromo(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> productPromo(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductPromo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> productStore(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> productStoreRole(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> productStoreRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> productStoreShipmentMeth(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreShipmentMeth(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> productStoreShipmentMeth(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreShipmentMeth(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> quote(Dao dao, boolean succ) {
        return e -> dao.chainQuote(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> quote(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainQuote(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> quoteRole(Dao dao, boolean succ) {
        return e -> dao.chainQuoteRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> quoteRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainQuoteRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> rateAmount(Dao dao, boolean succ) {
        return e -> dao.chainRateAmount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> rateAmount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainRateAmount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> toShipment(Dao dao, boolean succ) {
        return e -> dao.chainToShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> toShipment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> fromShipment(Dao dao, boolean succ) {
        return e -> dao.chainFromShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> fromShipment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> shipmentCostEstimate(Dao dao, boolean succ) {
        return e -> dao.chainShipmentCostEstimate(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> shipmentCostEstimate(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentCostEstimate(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> carrierShipmentRouteSegment(Dao dao, boolean succ) {
        return e -> dao.chainCarrierShipmentRouteSegment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> carrierShipmentRouteSegment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCarrierShipmentRouteSegment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> supplierProduct(Dao dao, boolean succ) {
        return e -> dao.chainSupplierProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> supplierProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSupplierProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> supplierProductFeature(Dao dao, boolean succ) {
        return e -> dao.chainSupplierProductFeature(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> supplierProductFeature(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSupplierProductFeature(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> taxAuthTaxAuthority(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthTaxAuthority(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> taxAuthTaxAuthority(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthTaxAuthority(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> organizationTaxAuthorityGlAccount(Dao dao, boolean succ) {
        return e -> dao.chainOrganizationTaxAuthorityGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> organizationTaxAuthorityGlAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrganizationTaxAuthorityGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> userLogin(Dao dao, boolean succ) {
        return e -> dao.chainUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> userLogin(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> workEffortPartyAssignment(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffortPartyAssignment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> workEffortPartyAssignment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffortPartyAssignment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Party>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, Party>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, Party> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, Party> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, Party> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, Party>> chain = tenant(dao, false);
         
        if (incls.contains(CREATED_BY_USER_LOGIN)) {
            chain = chain.andThen(createdByUserLogin(dao, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_USER_LOGIN)) {
            chain = chain.andThen(lastModifiedByUserLogin(dao, true));
        }
         
        if (incls.contains(ACCTG_TRANS)) {
            chain = chain.andThen(acctgTrans(dao, true));
        }
         
        if (incls.contains(ACCTG_TRANS_ENTRY)) {
            chain = chain.andThen(acctgTransEntry(dao, true));
        }
         
        if (incls.contains(FROM_AGREEMENT)) {
            chain = chain.andThen(fromAgreement(dao, true));
        }
         
        if (incls.contains(TO_AGREEMENT)) {
            chain = chain.andThen(toAgreement(dao, true));
        }
         
        if (incls.contains(BILLING_ACCOUNT_ROLE)) {
            chain = chain.andThen(billingAccountRole(dao, true));
        }
         
        if (incls.contains(CARRIER_SHIPMENT_BOX_TYPE)) {
            chain = chain.andThen(carrierShipmentBoxType(dao, true));
        }
         
        if (incls.contains(CARRIER_SHIPMENT_METHOD)) {
            chain = chain.andThen(carrierShipmentMethod(dao, true));
        }
         
        if (incls.contains(TO_COMMUNICATION_EVENT)) {
            chain = chain.andThen(toCommunicationEvent(dao, true));
        }
         
        if (incls.contains(FROM_COMMUNICATION_EVENT)) {
            chain = chain.andThen(fromCommunicationEvent(dao, true));
        }
         
        if (incls.contains(COMMUNICATION_EVENT_ROLE)) {
            chain = chain.andThen(communicationEventRole(dao, true));
        }
         
        if (incls.contains(CONTENT_ROLE)) {
            chain = chain.andThen(contentRole(dao, true));
        }
         
        if (incls.contains(FROM_CUST_REQUEST)) {
            chain = chain.andThen(fromCustRequest(dao, true));
        }
         
        if (incls.contains(CUST_REQUEST_TYPE)) {
            chain = chain.andThen(custRequestType(dao, true));
        }
         
        if (incls.contains(OWNER_FACILITY)) {
            chain = chain.andThen(ownerFacility(dao, true));
        }
         
        if (incls.contains(ORGANIZATION_FIN_ACCOUNT)) {
            chain = chain.andThen(organizationFinAccount(dao, true));
        }
         
        if (incls.contains(OWNER_FIN_ACCOUNT)) {
            chain = chain.andThen(ownerFinAccount(dao, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_ROLE)) {
            chain = chain.andThen(finAccountRole(dao, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_TRANS)) {
            chain = chain.andThen(finAccountTrans(dao, true));
        }
         
        if (incls.contains(PERFORMED_BY_FIN_ACCOUNT_TRANS)) {
            chain = chain.andThen(performedByFinAccountTrans(dao, true));
        }
         
        if (incls.contains(FIXED_ASSET)) {
            chain = chain.andThen(fixedAsset(dao, true));
        }
         
        if (incls.contains(GOV_AGENCY_FIXED_ASSET_REGISTRATION)) {
            chain = chain.andThen(govAgencyFixedAssetRegistration(dao, true));
        }
         
        if (incls.contains(ORGANIZATION_GL_ACCOUNT_TYPE_DEFAULT)) {
            chain = chain.andThen(organizationGlAccountTypeDefault(dao, true));
        }
         
        if (incls.contains(INVENTORY_ITEM)) {
            chain = chain.andThen(inventoryItem(dao, true));
        }
         
        if (incls.contains(OWNER_INVENTORY_ITEM)) {
            chain = chain.andThen(ownerInventoryItem(dao, true));
        }
         
        if (incls.contains(FROM_INVOICE)) {
            chain = chain.andThen(fromInvoice(dao, true));
        }
         
        if (incls.contains(INVOICE)) {
            chain = chain.andThen(invoice(dao, true));
        }
         
        if (incls.contains(TAX_AUTHORITY_INVOICE_ITEM)) {
            chain = chain.andThen(taxAuthorityInvoiceItem(dao, true));
        }
         
        if (incls.contains(OVERRIDE_ORG_INVOICE_ITEM)) {
            chain = chain.andThen(overrideOrgInvoiceItem(dao, true));
        }
         
        if (incls.contains(ORGANIZATION_INVOICE_ITEM_TYPE_GL_ACCOUNT)) {
            chain = chain.andThen(organizationInvoiceItemTypeGlAccount(dao, true));
        }
         
        if (incls.contains(INVOICE_ROLE)) {
            chain = chain.andThen(invoiceRole(dao, true));
        }
         
        if (incls.contains(SUPPLIER_ORDER_ITEM_SHIP_GROUP)) {
            chain = chain.andThen(supplierOrderItemShipGroup(dao, true));
        }
         
        if (incls.contains(VENDOR_ORDER_ITEM_SHIP_GROUP)) {
            chain = chain.andThen(vendorOrderItemShipGroup(dao, true));
        }
         
        if (incls.contains(CARRIER_ORDER_ITEM_SHIP_GROUP)) {
            chain = chain.andThen(carrierOrderItemShipGroup(dao, true));
        }
         
        if (incls.contains(ORDER_ROLE)) {
            chain = chain.andThen(orderRole(dao, true));
        }
         
        if (incls.contains(PARTY_ACCTG_PREFERENCE)) {
            chain = chain.andThen(partyAcctgPreference(dao, true));
        }
         
        if (incls.contains(PARTY_CONTACT_MECH)) {
            chain = chain.andThen(partyContactMech(dao, true));
        }
         
        if (incls.contains(PARTY_CONTACT_MECH_PURPOSE)) {
            chain = chain.andThen(partyContactMechPurpose(dao, true));
        }
         
        if (incls.contains(PARTY_GEO_POINT)) {
            chain = chain.andThen(partyGeoPoint(dao, true));
        }
         
        if (incls.contains(PARTY_GROUP)) {
            chain = chain.andThen(partyGroup(dao, true));
        }
         
        if (incls.contains(PARTY_IDENTIFICATION)) {
            chain = chain.andThen(partyIdentification(dao, true));
        }
         
        if (incls.contains(PARTY_RATE)) {
            chain = chain.andThen(partyRate(dao, true));
        }
         
        if (incls.contains(FROM_PARTY_RELATIONSHIP)) {
            chain = chain.andThen(fromPartyRelationship(dao, true));
        }
         
        if (incls.contains(TO_PARTY_RELATIONSHIP)) {
            chain = chain.andThen(toPartyRelationship(dao, true));
        }
         
        if (incls.contains(PARTY_ROLE)) {
            chain = chain.andThen(partyRole(dao, true));
        }
         
        if (incls.contains(PARTY_STATUS)) {
            chain = chain.andThen(partyStatus(dao, true));
        }
         
        if (incls.contains(PARTY_TAX_AUTH_INFO)) {
            chain = chain.andThen(partyTaxAuthInfo(dao, true));
        }
         
        if (incls.contains(FROM_PAYMENT)) {
            chain = chain.andThen(fromPayment(dao, true));
        }
         
        if (incls.contains(TO_PAYMENT)) {
            chain = chain.andThen(toPayment(dao, true));
        }
         
        if (incls.contains(PAYMENT_GL_ACCOUNT_TYPE_MAP)) {
            chain = chain.andThen(paymentGlAccountTypeMap(dao, true));
        }
         
        if (incls.contains(PAYMENT_METHOD)) {
            chain = chain.andThen(paymentMethod(dao, true));
        }
         
        if (incls.contains(ORGANIZATION_PAYMENT_METHOD_TYPE_GL_ACCOUNT)) {
            chain = chain.andThen(organizationPaymentMethodTypeGlAccount(dao, true));
        }
         
        if (incls.contains(PERSON)) {
            chain = chain.andThen(person(dao, true));
        }
         
        if (incls.contains(PRODUCT_CATEGORY_ROLE)) {
            chain = chain.andThen(productCategoryRole(dao, true));
        }
         
        if (incls.contains(TAX_AUTHORITY_PRODUCT_PRICE)) {
            chain = chain.andThen(taxAuthorityProductPrice(dao, true));
        }
         
        if (incls.contains(PRODUCT_PROMO)) {
            chain = chain.andThen(productPromo(dao, true));
        }
         
        if (incls.contains(PRODUCT_STORE)) {
            chain = chain.andThen(productStore(dao, true));
        }
         
        if (incls.contains(PRODUCT_STORE_ROLE)) {
            chain = chain.andThen(productStoreRole(dao, true));
        }
         
        if (incls.contains(PRODUCT_STORE_SHIPMENT_METH)) {
            chain = chain.andThen(productStoreShipmentMeth(dao, true));
        }
         
        if (incls.contains(QUOTE)) {
            chain = chain.andThen(quote(dao, true));
        }
         
        if (incls.contains(QUOTE_ROLE)) {
            chain = chain.andThen(quoteRole(dao, true));
        }
         
        if (incls.contains(RATE_AMOUNT)) {
            chain = chain.andThen(rateAmount(dao, true));
        }
         
        if (incls.contains(TO_SHIPMENT)) {
            chain = chain.andThen(toShipment(dao, true));
        }
         
        if (incls.contains(FROM_SHIPMENT)) {
            chain = chain.andThen(fromShipment(dao, true));
        }
         
        if (incls.contains(SHIPMENT_COST_ESTIMATE)) {
            chain = chain.andThen(shipmentCostEstimate(dao, true));
        }
         
        if (incls.contains(CARRIER_SHIPMENT_ROUTE_SEGMENT)) {
            chain = chain.andThen(carrierShipmentRouteSegment(dao, true));
        }
         
        if (incls.contains(SUPPLIER_PRODUCT)) {
            chain = chain.andThen(supplierProduct(dao, true));
        }
         
        if (incls.contains(SUPPLIER_PRODUCT_FEATURE)) {
            chain = chain.andThen(supplierProductFeature(dao, true));
        }
         
        if (incls.contains(TAX_AUTH_TAX_AUTHORITY)) {
            chain = chain.andThen(taxAuthTaxAuthority(dao, true));
        }
         
        if (incls.contains(ORGANIZATION_TAX_AUTHORITY_GL_ACCOUNT)) {
            chain = chain.andThen(organizationTaxAuthorityGlAccount(dao, true));
        }
         
        if (incls.contains(USER_LOGIN)) {
            chain = chain.andThen(userLogin(dao, true));
        }
         
        if (incls.contains(WORK_EFFORT_PARTY_ASSIGNMENT)) {
            chain = chain.andThen(workEffortPartyAssignment(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<PartyData> responseObserver) {
        Map<String, Party> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            PartyData.Builder partyData = data.toHeadBuilder();
             
            data.getRelCreatedByUserLogin().forEach(e -> 
                partyData.setCreatedByUserLogin(e.toHeadBuilder())); 
            data.getRelLastModifiedByUserLogin().forEach(e -> 
                partyData.setLastModifiedByUserLogin(e.toHeadBuilder())); 
            data.getRelAcctgTrans().forEach(e -> 
                partyData.addAcctgTrans(e.toDataBuilder())); 
            data.getRelAcctgTransEntry().forEach(e -> 
                partyData.addAcctgTransEntry(e.toDataBuilder())); 
            data.getRelFromAgreement().forEach(e -> 
                partyData.addFromAgreement(e.toDataBuilder())); 
            data.getRelToAgreement().forEach(e -> 
                partyData.addToAgreement(e.toDataBuilder())); 
            data.getRelBillingAccountRole().forEach(e -> 
                partyData.addBillingAccountRole(e.toDataBuilder())); 
            data.getRelCarrierShipmentBoxType().forEach(e -> 
                partyData.addCarrierShipmentBoxType(e.toDataBuilder())); 
            data.getRelCarrierShipmentMethod().forEach(e -> 
                partyData.addCarrierShipmentMethod(e.toDataBuilder())); 
            data.getRelToCommunicationEvent().forEach(e -> 
                partyData.addToCommunicationEvent(e.toDataBuilder())); 
            data.getRelFromCommunicationEvent().forEach(e -> 
                partyData.addFromCommunicationEvent(e.toDataBuilder())); 
            data.getRelCommunicationEventRole().forEach(e -> 
                partyData.addCommunicationEventRole(e.toDataBuilder())); 
            data.getRelContentRole().forEach(e -> 
                partyData.addContentRole(e.toDataBuilder())); 
            data.getRelFromCustRequest().forEach(e -> 
                partyData.addFromCustRequest(e.toDataBuilder())); 
            data.getRelCustRequestType().forEach(e -> 
                partyData.addCustRequestType(e.toDataBuilder())); 
            data.getRelOwnerFacility().forEach(e -> 
                partyData.addOwnerFacility(e.toDataBuilder())); 
            data.getRelOrganizationFinAccount().forEach(e -> 
                partyData.addOrganizationFinAccount(e.toHeadBuilder())); 
            data.getRelOwnerFinAccount().forEach(e -> 
                partyData.addOwnerFinAccount(e.toHeadBuilder())); 
            data.getRelFinAccountRole().forEach(e -> 
                partyData.addFinAccountRole(e.toDataBuilder())); 
            data.getRelFinAccountTrans().forEach(e -> 
                partyData.addFinAccountTrans(e.toDataBuilder())); 
            data.getRelPerformedByFinAccountTrans().forEach(e -> 
                partyData.addPerformedByFinAccountTrans(e.toDataBuilder())); 
            data.getRelFixedAsset().forEach(e -> 
                partyData.addFixedAsset(e.toHeadBuilder())); 
            data.getRelGovAgencyFixedAssetRegistration().forEach(e -> 
                partyData.addGovAgencyFixedAssetRegistration(e.toDataBuilder())); 
            data.getRelOrganizationGlAccountTypeDefault().forEach(e -> 
                partyData.addOrganizationGlAccountTypeDefault(e.toDataBuilder())); 
            data.getRelInventoryItem().forEach(e -> 
                partyData.addInventoryItem(e.toHeadBuilder())); 
            data.getRelOwnerInventoryItem().forEach(e -> 
                partyData.addOwnerInventoryItem(e.toHeadBuilder())); 
            data.getRelFromInvoice().forEach(e -> 
                partyData.addFromInvoice(e.toHeadBuilder())); 
            data.getRelInvoice().forEach(e -> 
                partyData.addInvoice(e.toHeadBuilder())); 
            data.getRelTaxAuthorityInvoiceItem().forEach(e -> 
                partyData.addTaxAuthorityInvoiceItem(e.toHeadBuilder())); 
            data.getRelOverrideOrgInvoiceItem().forEach(e -> 
                partyData.addOverrideOrgInvoiceItem(e.toHeadBuilder())); 
            data.getRelOrganizationInvoiceItemTypeGlAccount().forEach(e -> 
                partyData.addOrganizationInvoiceItemTypeGlAccount(e.toDataBuilder())); 
            data.getRelInvoiceRole().forEach(e -> 
                partyData.addInvoiceRole(e.toDataBuilder())); 
            data.getRelSupplierOrderItemShipGroup().forEach(e -> 
                partyData.addSupplierOrderItemShipGroup(e.toDataBuilder())); 
            data.getRelVendorOrderItemShipGroup().forEach(e -> 
                partyData.addVendorOrderItemShipGroup(e.toDataBuilder())); 
            data.getRelCarrierOrderItemShipGroup().forEach(e -> 
                partyData.addCarrierOrderItemShipGroup(e.toDataBuilder())); 
            data.getRelOrderRole().forEach(e -> 
                partyData.addOrderRole(e.toDataBuilder())); 
            data.getRelPartyAcctgPreference().forEach(e -> 
                partyData.setPartyAcctgPreference(e.toDataBuilder())); 
            data.getRelPartyContactMech().forEach(e -> 
                partyData.addPartyContactMech(e.toDataBuilder())); 
            data.getRelPartyContactMechPurpose().forEach(e -> 
                partyData.addPartyContactMechPurpose(e.toDataBuilder())); 
            data.getRelPartyGeoPoint().forEach(e -> 
                partyData.addPartyGeoPoint(e.toDataBuilder())); 
            data.getRelPartyGroup().forEach(e -> 
                partyData.setPartyGroup(e.toHeadBuilder())); 
            data.getRelPartyIdentification().forEach(e -> 
                partyData.addPartyIdentification(e.toDataBuilder())); 
            data.getRelPartyRate().forEach(e -> 
                partyData.addPartyRate(e.toDataBuilder())); 
            data.getRelFromPartyRelationship().forEach(e -> 
                partyData.addFromPartyRelationship(e.toDataBuilder())); 
            data.getRelToPartyRelationship().forEach(e -> 
                partyData.addToPartyRelationship(e.toDataBuilder())); 
            data.getRelPartyRole().forEach(e -> 
                partyData.addPartyRole(e.toDataBuilder())); 
            data.getRelPartyStatus().forEach(e -> 
                partyData.addPartyStatus(e.toDataBuilder())); 
            data.getRelPartyTaxAuthInfo().forEach(e -> 
                partyData.addPartyTaxAuthInfo(e.toDataBuilder())); 
            data.getRelFromPayment().forEach(e -> 
                partyData.addFromPayment(e.toHeadBuilder())); 
            data.getRelToPayment().forEach(e -> 
                partyData.addToPayment(e.toHeadBuilder())); 
            data.getRelPaymentGlAccountTypeMap().forEach(e -> 
                partyData.addPaymentGlAccountTypeMap(e.toDataBuilder())); 
            data.getRelPaymentMethod().forEach(e -> 
                partyData.addPaymentMethod(e.toDataBuilder())); 
            data.getRelOrganizationPaymentMethodTypeGlAccount().forEach(e -> 
                partyData.addOrganizationPaymentMethodTypeGlAccount(e.toDataBuilder())); 
            data.getRelPerson().forEach(e -> 
                partyData.setPerson(e.toHeadBuilder())); 
            data.getRelProductCategoryRole().forEach(e -> 
                partyData.addProductCategoryRole(e.toDataBuilder())); 
            data.getRelTaxAuthorityProductPrice().forEach(e -> 
                partyData.addTaxAuthorityProductPrice(e.toDataBuilder())); 
            data.getRelProductPromo().forEach(e -> 
                partyData.addProductPromo(e.toDataBuilder())); 
            data.getRelProductStore().forEach(e -> 
                partyData.addProductStore(e.toHeadBuilder())); 
            data.getRelProductStoreRole().forEach(e -> 
                partyData.addProductStoreRole(e.toDataBuilder())); 
            data.getRelProductStoreShipmentMeth().forEach(e -> 
                partyData.addProductStoreShipmentMeth(e.toDataBuilder())); 
            data.getRelQuote().forEach(e -> 
                partyData.addQuote(e.toHeadBuilder())); 
            data.getRelQuoteRole().forEach(e -> 
                partyData.addQuoteRole(e.toDataBuilder())); 
            data.getRelRateAmount().forEach(e -> 
                partyData.addRateAmount(e.toDataBuilder())); 
            data.getRelToShipment().forEach(e -> 
                partyData.addToShipment(e.toHeadBuilder())); 
            data.getRelFromShipment().forEach(e -> 
                partyData.addFromShipment(e.toHeadBuilder())); 
            data.getRelShipmentCostEstimate().forEach(e -> 
                partyData.addShipmentCostEstimate(e.toDataBuilder())); 
            data.getRelCarrierShipmentRouteSegment().forEach(e -> 
                partyData.addCarrierShipmentRouteSegment(e.toDataBuilder())); 
            data.getRelSupplierProduct().forEach(e -> 
                partyData.addSupplierProduct(e.toDataBuilder())); 
            data.getRelSupplierProductFeature().forEach(e -> 
                partyData.addSupplierProductFeature(e.toDataBuilder())); 
            data.getRelTaxAuthTaxAuthority().forEach(e -> 
                partyData.addTaxAuthTaxAuthority(e.toDataBuilder())); 
            data.getRelOrganizationTaxAuthorityGlAccount().forEach(e -> 
                partyData.addOrganizationTaxAuthorityGlAccount(e.toDataBuilder())); 
            data.getRelUserLogin().forEach(e -> 
                partyData.addUserLogin(e.toHeadBuilder())); 
            data.getRelWorkEffortPartyAssignment().forEach(e -> 
                partyData.addWorkEffortPartyAssignment(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                partyData.setTenant(e.toDataBuilder()));
            return partyData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public Party get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getParty(id);
    }

    public List<Party> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listParty();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countParty();
    }


    public void store(Party party){
        store(party, true);
    }

    public void store(Party party, boolean genId){
        process(c ->{
            if(genId){
                party.setPartyId(sequence.nextStringId());
            }
            storeOrUpdate(c, party.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "Party", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Party rec;
        final Message p1;
        Party persistObject;

        Agent(IProc.ProcContext ctx, Party rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Party getRecord(){
            return rec;
        }

        public Party merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
         
        public List<AcctgTrans> getAcctgTrans(){
            return getRelationValues(ctx, p1, "acctg_trans", AcctgTrans.class);
        }

        public List<AcctgTrans> mergeAcctgTrans(){
            return getAcctgTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTrans().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AcctgTransEntry> getAcctgTransEntry(){
            return getRelationValues(ctx, p1, "acctg_trans_entry", AcctgTransEntry.class);
        }

        public List<AcctgTransEntry> mergeAcctgTransEntry(){
            return getAcctgTransEntry().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTransEntry().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Agreement> getFromAgreement(){
            return getRelationValues(ctx, p1, "from_agreement", Agreement.class);
        }

        public List<Agreement> mergeFromAgreement(){
            return getFromAgreement().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromAgreement().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Agreement> getToAgreement(){
            return getRelationValues(ctx, p1, "to_agreement", Agreement.class);
        }

        public List<Agreement> mergeToAgreement(){
            return getToAgreement().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToAgreement().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<BillingAccountRole> getBillingAccountRole(){
            return getRelationValues(ctx, p1, "billing_account_role", BillingAccountRole.class);
        }

        public List<BillingAccountRole> mergeBillingAccountRole(){
            return getBillingAccountRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelBillingAccountRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CarrierShipmentBoxType> getCarrierShipmentBoxType(){
            return getRelationValues(ctx, p1, "carrier_shipment_box_type", CarrierShipmentBoxType.class);
        }

        public List<CarrierShipmentBoxType> mergeCarrierShipmentBoxType(){
            return getCarrierShipmentBoxType().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCarrierShipmentBoxType().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CarrierShipmentMethod> getCarrierShipmentMethod(){
            return getRelationValues(ctx, p1, "carrier_shipment_method", CarrierShipmentMethod.class);
        }

        public List<CarrierShipmentMethod> mergeCarrierShipmentMethod(){
            return getCarrierShipmentMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCarrierShipmentMethod().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CommunicationEvent> getToCommunicationEvent(){
            return getRelationValues(ctx, p1, "to_communication_event", CommunicationEvent.class);
        }

        public List<CommunicationEvent> mergeToCommunicationEvent(){
            return getToCommunicationEvent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToCommunicationEvent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CommunicationEvent> getFromCommunicationEvent(){
            return getRelationValues(ctx, p1, "from_communication_event", CommunicationEvent.class);
        }

        public List<CommunicationEvent> mergeFromCommunicationEvent(){
            return getFromCommunicationEvent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromCommunicationEvent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CommunicationEventRole> getCommunicationEventRole(){
            return getRelationValues(ctx, p1, "communication_event_role", CommunicationEventRole.class);
        }

        public List<CommunicationEventRole> mergeCommunicationEventRole(){
            return getCommunicationEventRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCommunicationEventRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContentRole> getContentRole(){
            return getRelationValues(ctx, p1, "content_role", ContentRole.class);
        }

        public List<ContentRole> mergeContentRole(){
            return getContentRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelContentRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustRequest> getFromCustRequest(){
            return getRelationValues(ctx, p1, "from_cust_request", CustRequest.class);
        }

        public List<CustRequest> mergeFromCustRequest(){
            return getFromCustRequest().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromCustRequest().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustRequestType> getCustRequestType(){
            return getRelationValues(ctx, p1, "cust_request_type", CustRequestType.class);
        }

        public List<CustRequestType> mergeCustRequestType(){
            return getCustRequestType().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCustRequestType().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Facility> getOwnerFacility(){
            return getRelationValues(ctx, p1, "owner_facility", Facility.class);
        }

        public List<Facility> mergeOwnerFacility(){
            return getOwnerFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOwnerFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccount> getOrganizationFinAccount(){
            return getRelationValues(ctx, p1, "organization_fin_account", FinAccount.class);
        }

        public List<FinAccount> mergeOrganizationFinAccount(){
            return getOrganizationFinAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrganizationFinAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccount> getOwnerFinAccount(){
            return getRelationValues(ctx, p1, "owner_fin_account", FinAccount.class);
        }

        public List<FinAccount> mergeOwnerFinAccount(){
            return getOwnerFinAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOwnerFinAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountRole> getFinAccountRole(){
            return getRelationValues(ctx, p1, "fin_account_role", FinAccountRole.class);
        }

        public List<FinAccountRole> mergeFinAccountRole(){
            return getFinAccountRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountTrans> getFinAccountTrans(){
            return getRelationValues(ctx, p1, "fin_account_trans", FinAccountTrans.class);
        }

        public List<FinAccountTrans> mergeFinAccountTrans(){
            return getFinAccountTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountTrans().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountTrans> getPerformedByFinAccountTrans(){
            return getRelationValues(ctx, p1, "performed_by_fin_account_trans", FinAccountTrans.class);
        }

        public List<FinAccountTrans> mergePerformedByFinAccountTrans(){
            return getPerformedByFinAccountTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPerformedByFinAccountTrans().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getFixedAsset(){
            return getRelationValues(ctx, p1, "fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeFixedAsset(){
            return getFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAssetRegistration> getGovAgencyFixedAssetRegistration(){
            return getRelationValues(ctx, p1, "gov_agency_fixed_asset_registration", FixedAssetRegistration.class);
        }

        public List<FixedAssetRegistration> mergeGovAgencyFixedAssetRegistration(){
            return getGovAgencyFixedAssetRegistration().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelGovAgencyFixedAssetRegistration().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<GlAccountTypeDefault> getOrganizationGlAccountTypeDefault(){
            return getRelationValues(ctx, p1, "organization_gl_account_type_default", GlAccountTypeDefault.class);
        }

        public List<GlAccountTypeDefault> mergeOrganizationGlAccountTypeDefault(){
            return getOrganizationGlAccountTypeDefault().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrganizationGlAccountTypeDefault().add(c))
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
         
        public List<InventoryItem> getOwnerInventoryItem(){
            return getRelationValues(ctx, p1, "owner_inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeOwnerInventoryItem(){
            return getOwnerInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOwnerInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Invoice> getFromInvoice(){
            return getRelationValues(ctx, p1, "from_invoice", Invoice.class);
        }

        public List<Invoice> mergeFromInvoice(){
            return getFromInvoice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromInvoice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Invoice> getInvoice(){
            return getRelationValues(ctx, p1, "invoice", Invoice.class);
        }

        public List<Invoice> mergeInvoice(){
            return getInvoice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceItem> getTaxAuthorityInvoiceItem(){
            return getRelationValues(ctx, p1, "tax_authority_invoice_item", InvoiceItem.class);
        }

        public List<InvoiceItem> mergeTaxAuthorityInvoiceItem(){
            return getTaxAuthorityInvoiceItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthorityInvoiceItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceItem> getOverrideOrgInvoiceItem(){
            return getRelationValues(ctx, p1, "override_org_invoice_item", InvoiceItem.class);
        }

        public List<InvoiceItem> mergeOverrideOrgInvoiceItem(){
            return getOverrideOrgInvoiceItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOverrideOrgInvoiceItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceItemTypeGlAccount> getOrganizationInvoiceItemTypeGlAccount(){
            return getRelationValues(ctx, p1, "organization_invoice_item_type_gl_account", InvoiceItemTypeGlAccount.class);
        }

        public List<InvoiceItemTypeGlAccount> mergeOrganizationInvoiceItemTypeGlAccount(){
            return getOrganizationInvoiceItemTypeGlAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrganizationInvoiceItemTypeGlAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceRole> getInvoiceRole(){
            return getRelationValues(ctx, p1, "invoice_role", InvoiceRole.class);
        }

        public List<InvoiceRole> mergeInvoiceRole(){
            return getInvoiceRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoiceRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroup> getSupplierOrderItemShipGroup(){
            return getRelationValues(ctx, p1, "supplier_order_item_ship_group", OrderItemShipGroup.class);
        }

        public List<OrderItemShipGroup> mergeSupplierOrderItemShipGroup(){
            return getSupplierOrderItemShipGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSupplierOrderItemShipGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroup> getVendorOrderItemShipGroup(){
            return getRelationValues(ctx, p1, "vendor_order_item_ship_group", OrderItemShipGroup.class);
        }

        public List<OrderItemShipGroup> mergeVendorOrderItemShipGroup(){
            return getVendorOrderItemShipGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelVendorOrderItemShipGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroup> getCarrierOrderItemShipGroup(){
            return getRelationValues(ctx, p1, "carrier_order_item_ship_group", OrderItemShipGroup.class);
        }

        public List<OrderItemShipGroup> mergeCarrierOrderItemShipGroup(){
            return getCarrierOrderItemShipGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCarrierOrderItemShipGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderRole> getOrderRole(){
            return getRelationValues(ctx, p1, "order_role", OrderRole.class);
        }

        public List<OrderRole> mergeOrderRole(){
            return getOrderRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyAcctgPreference> getPartyAcctgPreference(){
            return getRelationValues(ctx, p1, "party_acctg_preference", PartyAcctgPreference.class);
        }

        public List<PartyAcctgPreference> mergePartyAcctgPreference(){
            return getPartyAcctgPreference().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyAcctgPreference().add(c))
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
         
        public List<PartyGeoPoint> getPartyGeoPoint(){
            return getRelationValues(ctx, p1, "party_geo_point", PartyGeoPoint.class);
        }

        public List<PartyGeoPoint> mergePartyGeoPoint(){
            return getPartyGeoPoint().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyGeoPoint().add(c))
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
         
        public List<PartyIdentification> getPartyIdentification(){
            return getRelationValues(ctx, p1, "party_identification", PartyIdentification.class);
        }

        public List<PartyIdentification> mergePartyIdentification(){
            return getPartyIdentification().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyIdentification().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyRate> getPartyRate(){
            return getRelationValues(ctx, p1, "party_rate", PartyRate.class);
        }

        public List<PartyRate> mergePartyRate(){
            return getPartyRate().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyRate().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyRelationship> getFromPartyRelationship(){
            return getRelationValues(ctx, p1, "from_party_relationship", PartyRelationship.class);
        }

        public List<PartyRelationship> mergeFromPartyRelationship(){
            return getFromPartyRelationship().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromPartyRelationship().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyRelationship> getToPartyRelationship(){
            return getRelationValues(ctx, p1, "to_party_relationship", PartyRelationship.class);
        }

        public List<PartyRelationship> mergeToPartyRelationship(){
            return getToPartyRelationship().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToPartyRelationship().add(c))
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
         
        public List<PartyStatus> getPartyStatus(){
            return getRelationValues(ctx, p1, "party_status", PartyStatus.class);
        }

        public List<PartyStatus> mergePartyStatus(){
            return getPartyStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyTaxAuthInfo> getPartyTaxAuthInfo(){
            return getRelationValues(ctx, p1, "party_tax_auth_info", PartyTaxAuthInfo.class);
        }

        public List<PartyTaxAuthInfo> mergePartyTaxAuthInfo(){
            return getPartyTaxAuthInfo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyTaxAuthInfo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Payment> getFromPayment(){
            return getRelationValues(ctx, p1, "from_payment", Payment.class);
        }

        public List<Payment> mergeFromPayment(){
            return getFromPayment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromPayment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Payment> getToPayment(){
            return getRelationValues(ctx, p1, "to_payment", Payment.class);
        }

        public List<Payment> mergeToPayment(){
            return getToPayment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToPayment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PaymentGlAccountTypeMap> getPaymentGlAccountTypeMap(){
            return getRelationValues(ctx, p1, "payment_gl_account_type_map", PaymentGlAccountTypeMap.class);
        }

        public List<PaymentGlAccountTypeMap> mergePaymentGlAccountTypeMap(){
            return getPaymentGlAccountTypeMap().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPaymentGlAccountTypeMap().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PaymentMethod> getPaymentMethod(){
            return getRelationValues(ctx, p1, "payment_method", PaymentMethod.class);
        }

        public List<PaymentMethod> mergePaymentMethod(){
            return getPaymentMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPaymentMethod().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PaymentMethodTypeGlAccount> getOrganizationPaymentMethodTypeGlAccount(){
            return getRelationValues(ctx, p1, "organization_payment_method_type_gl_account", PaymentMethodTypeGlAccount.class);
        }

        public List<PaymentMethodTypeGlAccount> mergeOrganizationPaymentMethodTypeGlAccount(){
            return getOrganizationPaymentMethodTypeGlAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrganizationPaymentMethodTypeGlAccount().add(c))
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
         
        public List<ProductCategoryRole> getProductCategoryRole(){
            return getRelationValues(ctx, p1, "product_category_role", ProductCategoryRole.class);
        }

        public List<ProductCategoryRole> mergeProductCategoryRole(){
            return getProductCategoryRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getTaxAuthorityProductPrice(){
            return getRelationValues(ctx, p1, "tax_authority_product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeTaxAuthorityProductPrice(){
            return getTaxAuthorityProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthorityProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromo> getProductPromo(){
            return getRelationValues(ctx, p1, "product_promo", ProductPromo.class);
        }

        public List<ProductPromo> mergeProductPromo(){
            return getProductPromo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPromo().add(c))
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
         
        public List<ProductStoreRole> getProductStoreRole(){
            return getRelationValues(ctx, p1, "product_store_role", ProductStoreRole.class);
        }

        public List<ProductStoreRole> mergeProductStoreRole(){
            return getProductStoreRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreShipmentMeth> getProductStoreShipmentMeth(){
            return getRelationValues(ctx, p1, "product_store_shipment_meth", ProductStoreShipmentMeth.class);
        }

        public List<ProductStoreShipmentMeth> mergeProductStoreShipmentMeth(){
            return getProductStoreShipmentMeth().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreShipmentMeth().add(c))
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
         
        public List<QuoteRole> getQuoteRole(){
            return getRelationValues(ctx, p1, "quote_role", QuoteRole.class);
        }

        public List<QuoteRole> mergeQuoteRole(){
            return getQuoteRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuoteRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<RateAmount> getRateAmount(){
            return getRelationValues(ctx, p1, "rate_amount", RateAmount.class);
        }

        public List<RateAmount> mergeRateAmount(){
            return getRateAmount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelRateAmount().add(c))
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
         
        public List<ShipmentCostEstimate> getShipmentCostEstimate(){
            return getRelationValues(ctx, p1, "shipment_cost_estimate", ShipmentCostEstimate.class);
        }

        public List<ShipmentCostEstimate> mergeShipmentCostEstimate(){
            return getShipmentCostEstimate().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentCostEstimate().add(c))
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
         
        public List<SupplierProduct> getSupplierProduct(){
            return getRelationValues(ctx, p1, "supplier_product", SupplierProduct.class);
        }

        public List<SupplierProduct> mergeSupplierProduct(){
            return getSupplierProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSupplierProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<SupplierProductFeature> getSupplierProductFeature(){
            return getRelationValues(ctx, p1, "supplier_product_feature", SupplierProductFeature.class);
        }

        public List<SupplierProductFeature> mergeSupplierProductFeature(){
            return getSupplierProductFeature().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSupplierProductFeature().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TaxAuthority> getTaxAuthTaxAuthority(){
            return getRelationValues(ctx, p1, "tax_auth_tax_authority", TaxAuthority.class);
        }

        public List<TaxAuthority> mergeTaxAuthTaxAuthority(){
            return getTaxAuthTaxAuthority().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthTaxAuthority().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TaxAuthorityGlAccount> getOrganizationTaxAuthorityGlAccount(){
            return getRelationValues(ctx, p1, "organization_tax_authority_gl_account", TaxAuthorityGlAccount.class);
        }

        public List<TaxAuthorityGlAccount> mergeOrganizationTaxAuthorityGlAccount(){
            return getOrganizationTaxAuthorityGlAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrganizationTaxAuthorityGlAccount().add(c))
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
         
        public List<WorkEffortPartyAssignment> getWorkEffortPartyAssignment(){
            return getRelationValues(ctx, p1, "work_effort_party_assignment", WorkEffortPartyAssignment.class);
        }

        public List<WorkEffortPartyAssignment> mergeWorkEffortPartyAssignment(){
            return getWorkEffortPartyAssignment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffortPartyAssignment().add(c))
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
        PartyData p = PartyData.newBuilder()
                .setPartyId(key)
                .build();
        Party rec = findOne(ctx, p, Party.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, Party rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String CREATED_BY_USER_LOGIN="created_by_user_login";
         
    public static final String LAST_MODIFIED_BY_USER_LOGIN="last_modified_by_user_login";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String ACCTG_TRANS_ENTRY="acctg_trans_entry";
         
    public static final String FROM_AGREEMENT="from_agreement";
         
    public static final String TO_AGREEMENT="to_agreement";
         
    public static final String BILLING_ACCOUNT_ROLE="billing_account_role";
         
    public static final String CARRIER_SHIPMENT_BOX_TYPE="carrier_shipment_box_type";
         
    public static final String CARRIER_SHIPMENT_METHOD="carrier_shipment_method";
         
    public static final String TO_COMMUNICATION_EVENT="to_communication_event";
         
    public static final String FROM_COMMUNICATION_EVENT="from_communication_event";
         
    public static final String COMMUNICATION_EVENT_ROLE="communication_event_role";
         
    public static final String CONTENT_ROLE="content_role";
         
    public static final String FROM_CUST_REQUEST="from_cust_request";
         
    public static final String CUST_REQUEST_TYPE="cust_request_type";
         
    public static final String OWNER_FACILITY="owner_facility";
         
    public static final String ORGANIZATION_FIN_ACCOUNT="organization_fin_account";
         
    public static final String OWNER_FIN_ACCOUNT="owner_fin_account";
         
    public static final String FIN_ACCOUNT_ROLE="fin_account_role";
         
    public static final String FIN_ACCOUNT_TRANS="fin_account_trans";
         
    public static final String PERFORMED_BY_FIN_ACCOUNT_TRANS="performed_by_fin_account_trans";
         
    public static final String FIXED_ASSET="fixed_asset";
         
    public static final String GOV_AGENCY_FIXED_ASSET_REGISTRATION="gov_agency_fixed_asset_registration";
         
    public static final String ORGANIZATION_GL_ACCOUNT_TYPE_DEFAULT="organization_gl_account_type_default";
         
    public static final String INVENTORY_ITEM="inventory_item";
         
    public static final String OWNER_INVENTORY_ITEM="owner_inventory_item";
         
    public static final String FROM_INVOICE="from_invoice";
         
    public static final String INVOICE="invoice";
         
    public static final String TAX_AUTHORITY_INVOICE_ITEM="tax_authority_invoice_item";
         
    public static final String OVERRIDE_ORG_INVOICE_ITEM="override_org_invoice_item";
         
    public static final String ORGANIZATION_INVOICE_ITEM_TYPE_GL_ACCOUNT="organization_invoice_item_type_gl_account";
         
    public static final String INVOICE_ROLE="invoice_role";
         
    public static final String SUPPLIER_ORDER_ITEM_SHIP_GROUP="supplier_order_item_ship_group";
         
    public static final String VENDOR_ORDER_ITEM_SHIP_GROUP="vendor_order_item_ship_group";
         
    public static final String CARRIER_ORDER_ITEM_SHIP_GROUP="carrier_order_item_ship_group";
         
    public static final String ORDER_ROLE="order_role";
         
    public static final String PARTY_ACCTG_PREFERENCE="party_acctg_preference";
         
    public static final String PARTY_CONTACT_MECH="party_contact_mech";
         
    public static final String PARTY_CONTACT_MECH_PURPOSE="party_contact_mech_purpose";
         
    public static final String PARTY_GEO_POINT="party_geo_point";
         
    public static final String PARTY_GROUP="party_group";
         
    public static final String PARTY_IDENTIFICATION="party_identification";
         
    public static final String PARTY_RATE="party_rate";
         
    public static final String FROM_PARTY_RELATIONSHIP="from_party_relationship";
         
    public static final String TO_PARTY_RELATIONSHIP="to_party_relationship";
         
    public static final String PARTY_ROLE="party_role";
         
    public static final String PARTY_STATUS="party_status";
         
    public static final String PARTY_TAX_AUTH_INFO="party_tax_auth_info";
         
    public static final String FROM_PAYMENT="from_payment";
         
    public static final String TO_PAYMENT="to_payment";
         
    public static final String PAYMENT_GL_ACCOUNT_TYPE_MAP="payment_gl_account_type_map";
         
    public static final String PAYMENT_METHOD="payment_method";
         
    public static final String ORGANIZATION_PAYMENT_METHOD_TYPE_GL_ACCOUNT="organization_payment_method_type_gl_account";
         
    public static final String PERSON="person";
         
    public static final String PRODUCT_CATEGORY_ROLE="product_category_role";
         
    public static final String TAX_AUTHORITY_PRODUCT_PRICE="tax_authority_product_price";
         
    public static final String PRODUCT_PROMO="product_promo";
         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String PRODUCT_STORE_ROLE="product_store_role";
         
    public static final String PRODUCT_STORE_SHIPMENT_METH="product_store_shipment_meth";
         
    public static final String QUOTE="quote";
         
    public static final String QUOTE_ROLE="quote_role";
         
    public static final String RATE_AMOUNT="rate_amount";
         
    public static final String TO_SHIPMENT="to_shipment";
         
    public static final String FROM_SHIPMENT="from_shipment";
         
    public static final String SHIPMENT_COST_ESTIMATE="shipment_cost_estimate";
         
    public static final String CARRIER_SHIPMENT_ROUTE_SEGMENT="carrier_shipment_route_segment";
         
    public static final String SUPPLIER_PRODUCT="supplier_product";
         
    public static final String SUPPLIER_PRODUCT_FEATURE="supplier_product_feature";
         
    public static final String TAX_AUTH_TAX_AUTHORITY="tax_auth_tax_authority";
         
    public static final String ORGANIZATION_TAX_AUTHORITY_GL_ACCOUNT="organization_tax_authority_gl_account";
         
    public static final String USER_LOGIN="user_login";
         
    public static final String WORK_EFFORT_PARTY_ASSIGNMENT="work_effort_party_assignment";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryPartyRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            PartyData p = PartyData.newBuilder()
                    .setPartyId(key)
                    .build();
            List<PartyData.Builder> ds = find(ctx, p, Party.class).stream()
                    .map(e -> {
                        PartyData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
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
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans_entry to head entity                        
                        if(relationsDemand.contains("acctg_trans_entry")) {
                            getRelationValues(ctx, p1, "acctg_trans_entry",
                                            AcctgTransEntry.class)
                                    .forEach(el -> pb.addAcctgTransEntry(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_agreement to head entity                        
                        if(relationsDemand.contains("from_agreement")) {
                            getRelationValues(ctx, p1, "from_agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addFromAgreement(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_agreement to head entity                        
                        if(relationsDemand.contains("to_agreement")) {
                            getRelationValues(ctx, p1, "to_agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addToAgreement(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set billing_account_role to head entity                        
                        if(relationsDemand.contains("billing_account_role")) {
                            getRelationValues(ctx, p1, "billing_account_role",
                                            BillingAccountRole.class)
                                    .forEach(el -> pb.addBillingAccountRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_box_type to head entity                        
                        if(relationsDemand.contains("carrier_shipment_box_type")) {
                            getRelationValues(ctx, p1, "carrier_shipment_box_type",
                                            CarrierShipmentBoxType.class)
                                    .forEach(el -> pb.addCarrierShipmentBoxType(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_method to head entity                        
                        if(relationsDemand.contains("carrier_shipment_method")) {
                            getRelationValues(ctx, p1, "carrier_shipment_method",
                                            CarrierShipmentMethod.class)
                                    .forEach(el -> pb.addCarrierShipmentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_communication_event to head entity                        
                        if(relationsDemand.contains("to_communication_event")) {
                            getRelationValues(ctx, p1, "to_communication_event",
                                            CommunicationEvent.class)
                                    .forEach(el -> pb.addToCommunicationEvent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_communication_event to head entity                        
                        if(relationsDemand.contains("from_communication_event")) {
                            getRelationValues(ctx, p1, "from_communication_event",
                                            CommunicationEvent.class)
                                    .forEach(el -> pb.addFromCommunicationEvent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set communication_event_role to head entity                        
                        if(relationsDemand.contains("communication_event_role")) {
                            getRelationValues(ctx, p1, "communication_event_role",
                                            CommunicationEventRole.class)
                                    .forEach(el -> pb.addCommunicationEventRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set content_role to head entity                        
                        if(relationsDemand.contains("content_role")) {
                            getRelationValues(ctx, p1, "content_role",
                                            ContentRole.class)
                                    .forEach(el -> pb.addContentRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_cust_request to head entity                        
                        if(relationsDemand.contains("from_cust_request")) {
                            getRelationValues(ctx, p1, "from_cust_request",
                                            CustRequest.class)
                                    .forEach(el -> pb.addFromCustRequest(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set cust_request_type to head entity                        
                        if(relationsDemand.contains("cust_request_type")) {
                            getRelationValues(ctx, p1, "cust_request_type",
                                            CustRequestType.class)
                                    .forEach(el -> pb.addCustRequestType(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set owner_facility to head entity                        
                        if(relationsDemand.contains("owner_facility")) {
                            getRelationValues(ctx, p1, "owner_facility",
                                            Facility.class)
                                    .forEach(el -> pb.addOwnerFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set organization_fin_account to head entity                        
                        if(relationsDemand.contains("organization_fin_account")) {
                            getRelationValues(ctx, p1, "organization_fin_account",
                                            FinAccount.class)
                                    .forEach(el -> pb.addOrganizationFinAccount(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set owner_fin_account to head entity                        
                        if(relationsDemand.contains("owner_fin_account")) {
                            getRelationValues(ctx, p1, "owner_fin_account",
                                            FinAccount.class)
                                    .forEach(el -> pb.addOwnerFinAccount(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fin_account_role to head entity                        
                        if(relationsDemand.contains("fin_account_role")) {
                            getRelationValues(ctx, p1, "fin_account_role",
                                            FinAccountRole.class)
                                    .forEach(el -> pb.addFinAccountRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_trans to head entity                        
                        if(relationsDemand.contains("fin_account_trans")) {
                            getRelationValues(ctx, p1, "fin_account_trans",
                                            FinAccountTrans.class)
                                    .forEach(el -> pb.addFinAccountTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set performed_by_fin_account_trans to head entity                        
                        if(relationsDemand.contains("performed_by_fin_account_trans")) {
                            getRelationValues(ctx, p1, "performed_by_fin_account_trans",
                                            FinAccountTrans.class)
                                    .forEach(el -> pb.addPerformedByFinAccountTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset to head entity                        
                        if(relationsDemand.contains("fixed_asset")) {
                            getRelationValues(ctx, p1, "fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set gov_agency_fixed_asset_registration to head entity                        
                        if(relationsDemand.contains("gov_agency_fixed_asset_registration")) {
                            getRelationValues(ctx, p1, "gov_agency_fixed_asset_registration",
                                            FixedAssetRegistration.class)
                                    .forEach(el -> pb.addGovAgencyFixedAssetRegistration(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set organization_gl_account_type_default to head entity                        
                        if(relationsDemand.contains("organization_gl_account_type_default")) {
                            getRelationValues(ctx, p1, "organization_gl_account_type_default",
                                            GlAccountTypeDefault.class)
                                    .forEach(el -> pb.addOrganizationGlAccountTypeDefault(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item to head entity                        
                        if(relationsDemand.contains("inventory_item")) {
                            getRelationValues(ctx, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set owner_inventory_item to head entity                        
                        if(relationsDemand.contains("owner_inventory_item")) {
                            getRelationValues(ctx, p1, "owner_inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addOwnerInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_invoice to head entity                        
                        if(relationsDemand.contains("from_invoice")) {
                            getRelationValues(ctx, p1, "from_invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.addFromInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set invoice to head entity                        
                        if(relationsDemand.contains("invoice")) {
                            getRelationValues(ctx, p1, "invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.addInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_invoice_item to head entity                        
                        if(relationsDemand.contains("tax_authority_invoice_item")) {
                            getRelationValues(ctx, p1, "tax_authority_invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addTaxAuthorityInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set override_org_invoice_item to head entity                        
                        if(relationsDemand.contains("override_org_invoice_item")) {
                            getRelationValues(ctx, p1, "override_org_invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addOverrideOrgInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set organization_invoice_item_type_gl_account to head entity                        
                        if(relationsDemand.contains("organization_invoice_item_type_gl_account")) {
                            getRelationValues(ctx, p1, "organization_invoice_item_type_gl_account",
                                            InvoiceItemTypeGlAccount.class)
                                    .forEach(el -> pb.addOrganizationInvoiceItemTypeGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_role to head entity                        
                        if(relationsDemand.contains("invoice_role")) {
                            getRelationValues(ctx, p1, "invoice_role",
                                            InvoiceRole.class)
                                    .forEach(el -> pb.addInvoiceRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("supplier_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "supplier_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addSupplierOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set vendor_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("vendor_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "vendor_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addVendorOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("carrier_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "carrier_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addCarrierOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_role to head entity                        
                        if(relationsDemand.contains("order_role")) {
                            getRelationValues(ctx, p1, "order_role",
                                            OrderRole.class)
                                    .forEach(el -> pb.addOrderRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_acctg_preference to head entity                        
                        if(relationsDemand.contains("party_acctg_preference")) {
                            getRelationValues(ctx, p1, "party_acctg_preference",
                                            PartyAcctgPreference.class)
                                    .forEach(el -> pb.setPartyAcctgPreference(
                                             el.toDataBuilder().build()));
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
                                               
                        // add/set party_geo_point to head entity                        
                        if(relationsDemand.contains("party_geo_point")) {
                            getRelationValues(ctx, p1, "party_geo_point",
                                            PartyGeoPoint.class)
                                    .forEach(el -> pb.addPartyGeoPoint(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_group to head entity                        
                        if(relationsDemand.contains("party_group")) {
                            getRelationValues(ctx, p1, "party_group",
                                            PartyGroup.class)
                                    .forEach(el -> pb.setPartyGroup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party_identification to head entity                        
                        if(relationsDemand.contains("party_identification")) {
                            getRelationValues(ctx, p1, "party_identification",
                                            PartyIdentification.class)
                                    .forEach(el -> pb.addPartyIdentification(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_rate to head entity                        
                        if(relationsDemand.contains("party_rate")) {
                            getRelationValues(ctx, p1, "party_rate",
                                            PartyRate.class)
                                    .forEach(el -> pb.addPartyRate(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_party_relationship to head entity                        
                        if(relationsDemand.contains("from_party_relationship")) {
                            getRelationValues(ctx, p1, "from_party_relationship",
                                            PartyRelationship.class)
                                    .forEach(el -> pb.addFromPartyRelationship(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_party_relationship to head entity                        
                        if(relationsDemand.contains("to_party_relationship")) {
                            getRelationValues(ctx, p1, "to_party_relationship",
                                            PartyRelationship.class)
                                    .forEach(el -> pb.addToPartyRelationship(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_role to head entity                        
                        if(relationsDemand.contains("party_role")) {
                            getRelationValues(ctx, p1, "party_role",
                                            PartyRole.class)
                                    .forEach(el -> pb.addPartyRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_status to head entity                        
                        if(relationsDemand.contains("party_status")) {
                            getRelationValues(ctx, p1, "party_status",
                                            PartyStatus.class)
                                    .forEach(el -> pb.addPartyStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party_tax_auth_info to head entity                        
                        if(relationsDemand.contains("party_tax_auth_info")) {
                            getRelationValues(ctx, p1, "party_tax_auth_info",
                                            PartyTaxAuthInfo.class)
                                    .forEach(el -> pb.addPartyTaxAuthInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_payment to head entity                        
                        if(relationsDemand.contains("from_payment")) {
                            getRelationValues(ctx, p1, "from_payment",
                                            Payment.class)
                                    .forEach(el -> pb.addFromPayment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set to_payment to head entity                        
                        if(relationsDemand.contains("to_payment")) {
                            getRelationValues(ctx, p1, "to_payment",
                                            Payment.class)
                                    .forEach(el -> pb.addToPayment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set payment_gl_account_type_map to head entity                        
                        if(relationsDemand.contains("payment_gl_account_type_map")) {
                            getRelationValues(ctx, p1, "payment_gl_account_type_map",
                                            PaymentGlAccountTypeMap.class)
                                    .forEach(el -> pb.addPaymentGlAccountTypeMap(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_method to head entity                        
                        if(relationsDemand.contains("payment_method")) {
                            getRelationValues(ctx, p1, "payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.addPaymentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set organization_payment_method_type_gl_account to head entity                        
                        if(relationsDemand.contains("organization_payment_method_type_gl_account")) {
                            getRelationValues(ctx, p1, "organization_payment_method_type_gl_account",
                                            PaymentMethodTypeGlAccount.class)
                                    .forEach(el -> pb.addOrganizationPaymentMethodTypeGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set person to head entity                        
                        if(relationsDemand.contains("person")) {
                            getRelationValues(ctx, p1, "person",
                                            Person.class)
                                    .forEach(el -> pb.setPerson(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_category_role to head entity                        
                        if(relationsDemand.contains("product_category_role")) {
                            getRelationValues(ctx, p1, "product_category_role",
                                            ProductCategoryRole.class)
                                    .forEach(el -> pb.addProductCategoryRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tax_authority_product_price to head entity                        
                        if(relationsDemand.contains("tax_authority_product_price")) {
                            getRelationValues(ctx, p1, "tax_authority_product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addTaxAuthorityProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_promo to head entity                        
                        if(relationsDemand.contains("product_promo")) {
                            getRelationValues(ctx, p1, "product_promo",
                                            ProductPromo.class)
                                    .forEach(el -> pb.addProductPromo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.addProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_role to head entity                        
                        if(relationsDemand.contains("product_store_role")) {
                            getRelationValues(ctx, p1, "product_store_role",
                                            ProductStoreRole.class)
                                    .forEach(el -> pb.addProductStoreRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_shipment_meth to head entity                        
                        if(relationsDemand.contains("product_store_shipment_meth")) {
                            getRelationValues(ctx, p1, "product_store_shipment_meth",
                                            ProductStoreShipmentMeth.class)
                                    .forEach(el -> pb.addProductStoreShipmentMeth(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote to head entity                        
                        if(relationsDemand.contains("quote")) {
                            getRelationValues(ctx, p1, "quote",
                                            Quote.class)
                                    .forEach(el -> pb.addQuote(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set quote_role to head entity                        
                        if(relationsDemand.contains("quote_role")) {
                            getRelationValues(ctx, p1, "quote_role",
                                            QuoteRole.class)
                                    .forEach(el -> pb.addQuoteRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set rate_amount to head entity                        
                        if(relationsDemand.contains("rate_amount")) {
                            getRelationValues(ctx, p1, "rate_amount",
                                            RateAmount.class)
                                    .forEach(el -> pb.addRateAmount(
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
                                               
                        // add/set shipment_cost_estimate to head entity                        
                        if(relationsDemand.contains("shipment_cost_estimate")) {
                            getRelationValues(ctx, p1, "shipment_cost_estimate",
                                            ShipmentCostEstimate.class)
                                    .forEach(el -> pb.addShipmentCostEstimate(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_route_segment to head entity                        
                        if(relationsDemand.contains("carrier_shipment_route_segment")) {
                            getRelationValues(ctx, p1, "carrier_shipment_route_segment",
                                            ShipmentRouteSegment.class)
                                    .forEach(el -> pb.addCarrierShipmentRouteSegment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_product to head entity                        
                        if(relationsDemand.contains("supplier_product")) {
                            getRelationValues(ctx, p1, "supplier_product",
                                            SupplierProduct.class)
                                    .forEach(el -> pb.addSupplierProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_product_feature to head entity                        
                        if(relationsDemand.contains("supplier_product_feature")) {
                            getRelationValues(ctx, p1, "supplier_product_feature",
                                            SupplierProductFeature.class)
                                    .forEach(el -> pb.addSupplierProductFeature(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tax_auth_tax_authority to head entity                        
                        if(relationsDemand.contains("tax_auth_tax_authority")) {
                            getRelationValues(ctx, p1, "tax_auth_tax_authority",
                                            TaxAuthority.class)
                                    .forEach(el -> pb.addTaxAuthTaxAuthority(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set organization_tax_authority_gl_account to head entity                        
                        if(relationsDemand.contains("organization_tax_authority_gl_account")) {
                            getRelationValues(ctx, p1, "organization_tax_authority_gl_account",
                                            TaxAuthorityGlAccount.class)
                                    .forEach(el -> pb.addOrganizationTaxAuthorityGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set user_login to head entity                        
                        if(relationsDemand.contains("user_login")) {
                            getRelationValues(ctx, p1, "user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.addUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set work_effort_party_assignment to head entity                        
                        if(relationsDemand.contains("work_effort_party_assignment")) {
                            getRelationValues(ctx, p1, "work_effort_party_assignment",
                                            WorkEffortPartyAssignment.class)
                                    .forEach(el -> pb.addWorkEffortPartyAssignment(
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


    
    public Party.PartyBuilder seed(){
        return Party.builder()
                .partyId(sequence.nextStringId());
    }
}

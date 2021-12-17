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

import com.bluecc.hubs.stub.ShipmentData;

public class ShipmentDelegator extends AbstractProcs implements IChainQuery<Shipment>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(Shipment.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from shipment")
        List<Shipment> listShipment();
        @SqlQuery("select * from shipment where shipment_id=:id")
        Shipment getShipment(@Bind("id") String id);

        @SqlQuery("select count(*) from shipment")
        int countShipment();

        // for relations
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "esweo")
        default Map<String, Shipment> chainEstimatedShipWorkEffort(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainEstimatedShipWorkEffort(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "esweo")
        default Map<String, Shipment> chainEstimatedShipWorkEffort(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ESTIMATED_SHIP_WORK_EFFORT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("esweo_work_effort_id", String.class) != null) {
                            p.getRelEstimatedShipWorkEffort()
                                    .add(rr.getRow(WorkEffort.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "eaweo")
        default Map<String, Shipment> chainEstimatedArrivalWorkEffort(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainEstimatedArrivalWorkEffort(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "eaweo")
        default Map<String, Shipment> chainEstimatedArrivalWorkEffort(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ESTIMATED_ARRIVAL_WORK_EFFORT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("eaweo_work_effort_id", String.class) != null) {
                            p.getRelEstimatedArrivalWorkEffort()
                                    .add(rr.getRow(WorkEffort.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Facility.class, prefix = "ofzo")
        default Map<String, Shipment> chainOriginFacility(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainOriginFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Facility.class, prefix = "ofzo")
        default Map<String, Shipment> chainOriginFacility(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORIGIN_FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("ofzo_facility_id", String.class) != null) {
                            p.getRelOriginFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Facility.class, prefix = "dfo")
        default Map<String, Shipment> chainDestinationFacility(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainDestinationFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Facility.class, prefix = "dfo")
        default Map<String, Shipment> chainDestinationFacility(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DESTINATION_FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("dfo_facility_id", String.class) != null) {
                            p.getRelDestinationFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "ocmo")
        default Map<String, Shipment> chainOriginContactMech(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainOriginContactMech(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "ocmo")
        default Map<String, Shipment> chainOriginContactMech(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORIGIN_CONTACT_MECH);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("ocmo_contact_mech_id", String.class) != null) {
                            p.getRelOriginContactMech()
                                    .add(rr.getRow(ContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "dcmo")
        default Map<String, Shipment> chainDestContactMech(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainDestContactMech(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "dcmo")
        default Map<String, Shipment> chainDestContactMech(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DEST_CONTACT_MECH);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("dcmo_contact_mech_id", String.class) != null) {
                            p.getRelDestContactMech()
                                    .add(rr.getRow(ContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "opao")
        default Map<String, Shipment> chainOriginPostalAddress(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainOriginPostalAddress(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "opao")
        default Map<String, Shipment> chainOriginPostalAddress(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORIGIN_POSTAL_ADDRESS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("opao_contact_mech_id", String.class) != null) {
                            p.getRelOriginPostalAddress()
                                    .add(rr.getRow(PostalAddress.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = TelecomNumber.class, prefix = "otno")
        default Map<String, Shipment> chainOriginTelecomNumber(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainOriginTelecomNumber(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = TelecomNumber.class, prefix = "otno")
        default Map<String, Shipment> chainOriginTelecomNumber(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORIGIN_TELECOM_NUMBER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("otno_contact_mech_id", String.class) != null) {
                            p.getRelOriginTelecomNumber()
                                    .add(rr.getRow(TelecomNumber.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "dpao")
        default Map<String, Shipment> chainDestinationPostalAddress(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainDestinationPostalAddress(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "dpao")
        default Map<String, Shipment> chainDestinationPostalAddress(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DESTINATION_POSTAL_ADDRESS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("dpao_contact_mech_id", String.class) != null) {
                            p.getRelDestinationPostalAddress()
                                    .add(rr.getRow(PostalAddress.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = TelecomNumber.class, prefix = "dtno")
        default Map<String, Shipment> chainDestinationTelecomNumber(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainDestinationTelecomNumber(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = TelecomNumber.class, prefix = "dtno")
        default Map<String, Shipment> chainDestinationTelecomNumber(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DESTINATION_TELECOM_NUMBER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("dtno_contact_mech_id", String.class) != null) {
                            p.getRelDestinationTelecomNumber()
                                    .add(rr.getRow(TelecomNumber.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "poho")
        default Map<String, Shipment> chainPrimaryOrderHeader(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainPrimaryOrderHeader(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "poho")
        default Map<String, Shipment> chainPrimaryOrderHeader(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_ORDER_HEADER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("poho_order_id", String.class) != null) {
                            p.getRelPrimaryOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "poisgo")
        default Map<String, Shipment> chainPrimaryOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainPrimaryOrderItemShipGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "poisgo")
        default Map<String, Shipment> chainPrimaryOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_ORDER_ITEM_SHIP_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("poisgo_order_id", String.class) != null) {
                            p.getRelPrimaryOrderItemShipGroup()
                                    .add(rr.getRow(OrderItemShipGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Party.class, prefix = "tpo")
        default Map<String, Shipment> chainToParty(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainToParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Party.class, prefix = "tpo")
        default Map<String, Shipment> chainToParty(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("tpo_party_id", String.class) != null) {
                            p.getRelToParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Person.class, prefix = "tpo")
        default Map<String, Shipment> chainToPerson(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainToPerson(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Person.class, prefix = "tpo")
        default Map<String, Shipment> chainToPerson(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PERSON);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("tpo_party_id", String.class) != null) {
                            p.getRelToPerson()
                                    .add(rr.getRow(Person.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "tpgo")
        default Map<String, Shipment> chainToPartyGroup(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainToPartyGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "tpgo")
        default Map<String, Shipment> chainToPartyGroup(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("tpgo_party_id", String.class) != null) {
                            p.getRelToPartyGroup()
                                    .add(rr.getRow(PartyGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Party.class, prefix = "fpo")
        default Map<String, Shipment> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainFromParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Party.class, prefix = "fpo")
        default Map<String, Shipment> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("fpo_party_id", String.class) != null) {
                            p.getRelFromParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Person.class, prefix = "fpo")
        default Map<String, Shipment> chainFromPerson(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainFromPerson(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Person.class, prefix = "fpo")
        default Map<String, Shipment> chainFromPerson(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PERSON);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("fpo_party_id", String.class) != null) {
                            p.getRelFromPerson()
                                    .add(rr.getRow(Person.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "fpgo")
        default Map<String, Shipment> chainFromPartyGroup(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainFromPartyGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "fpgo")
        default Map<String, Shipment> chainFromPartyGroup(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PARTY_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("fpgo_party_id", String.class) != null) {
                            p.getRelFromPartyGroup()
                                    .add(rr.getRow(PartyGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Shipment> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Shipment> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("atm_shipment_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, Shipment> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainItemIssuance(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, Shipment> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ITEM_ISSUANCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("iim_shipment_id", String.class) != null) {
                            p.getRelItemIssuance()
                                    .add(rr.getRow(ItemIssuance.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentItem.class, prefix = "sim")
        default Map<String, Shipment> chainShipmentItem(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentItem.class, prefix = "sim")
        default Map<String, Shipment> chainShipmentItem(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("sim_shipment_id", String.class) != null) {
                            p.getRelShipmentItem()
                                    .add(rr.getRow(ShipmentItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sibm")
        default Map<String, Shipment> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sibm")
        default Map<String, Shipment> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_ITEM_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("sibm_shipment_id", String.class) != null) {
                            p.getRelShipmentItemBilling()
                                    .add(rr.getRow(ShipmentItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentPackage.class, prefix = "spm")
        default Map<String, Shipment> chainShipmentPackage(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentPackage(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentPackage.class, prefix = "spm")
        default Map<String, Shipment> chainShipmentPackage(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_PACKAGE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("spm_shipment_id", String.class) != null) {
                            p.getRelShipmentPackage()
                                    .add(rr.getRow(ShipmentPackage.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentPackageContent.class, prefix = "spcm")
        default Map<String, Shipment> chainShipmentPackageContent(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentPackageContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentPackageContent.class, prefix = "spcm")
        default Map<String, Shipment> chainShipmentPackageContent(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_PACKAGE_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("spcm_shipment_id", String.class) != null) {
                            p.getRelShipmentPackageContent()
                                    .add(rr.getRow(ShipmentPackageContent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentPackageRouteSeg.class, prefix = "sprsm")
        default Map<String, Shipment> chainShipmentPackageRouteSeg(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentPackageRouteSeg(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentPackageRouteSeg.class, prefix = "sprsm")
        default Map<String, Shipment> chainShipmentPackageRouteSeg(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_PACKAGE_ROUTE_SEG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("sprsm_shipment_id", String.class) != null) {
                            p.getRelShipmentPackageRouteSeg()
                                    .add(rr.getRow(ShipmentPackageRouteSeg.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, Shipment> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, Shipment> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("srm_shipment_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "srsm")
        default Map<String, Shipment> chainShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentRouteSegment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentRouteSegment.class, prefix = "srsm")
        default Map<String, Shipment> chainShipmentRouteSegment(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_ROUTE_SEGMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("srsm_shipment_id", String.class) != null) {
                            p.getRelShipmentRouteSegment()
                                    .add(rr.getRow(ShipmentRouteSegment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentStatus.class, prefix = "ssm")
        default Map<String, Shipment> chainShipmentStatus(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainShipmentStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = ShipmentStatus.class, prefix = "ssm")
        default Map<String, Shipment> chainShipmentStatus(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("ssm_shipment_id", String.class) != null) {
                            p.getRelShipmentStatus()
                                    .add(rr.getRow(ShipmentStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Shipment> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Shipment.class, prefix = "sh")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Shipment> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Shipment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Shipment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Shipment p = map.computeIfAbsent(rr.getColumn("sh_shipment_id", String.class),
                                id -> rr.getRow(Shipment.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, Shipment>> estimatedShipWorkEffort(Dao dao, boolean succ) {
        return e -> dao.chainEstimatedShipWorkEffort(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> estimatedShipWorkEffort(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainEstimatedShipWorkEffort(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> estimatedArrivalWorkEffort(Dao dao, boolean succ) {
        return e -> dao.chainEstimatedArrivalWorkEffort(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> estimatedArrivalWorkEffort(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainEstimatedArrivalWorkEffort(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> originFacility(Dao dao, boolean succ) {
        return e -> dao.chainOriginFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> originFacility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOriginFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> destinationFacility(Dao dao, boolean succ) {
        return e -> dao.chainDestinationFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> destinationFacility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainDestinationFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> originContactMech(Dao dao, boolean succ) {
        return e -> dao.chainOriginContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> originContactMech(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOriginContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> destContactMech(Dao dao, boolean succ) {
        return e -> dao.chainDestContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> destContactMech(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainDestContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> originPostalAddress(Dao dao, boolean succ) {
        return e -> dao.chainOriginPostalAddress(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> originPostalAddress(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOriginPostalAddress(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> originTelecomNumber(Dao dao, boolean succ) {
        return e -> dao.chainOriginTelecomNumber(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> originTelecomNumber(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOriginTelecomNumber(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> destinationPostalAddress(Dao dao, boolean succ) {
        return e -> dao.chainDestinationPostalAddress(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> destinationPostalAddress(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainDestinationPostalAddress(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> destinationTelecomNumber(Dao dao, boolean succ) {
        return e -> dao.chainDestinationTelecomNumber(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> destinationTelecomNumber(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainDestinationTelecomNumber(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> primaryOrderHeader(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> primaryOrderHeader(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> primaryOrderItemShipGroup(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryOrderItemShipGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> primaryOrderItemShipGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryOrderItemShipGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> toParty(Dao dao, boolean succ) {
        return e -> dao.chainToParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> toParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> toPerson(Dao dao, boolean succ) {
        return e -> dao.chainToPerson(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> toPerson(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToPerson(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> toPartyGroup(Dao dao, boolean succ) {
        return e -> dao.chainToPartyGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> toPartyGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToPartyGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> fromParty(Dao dao, boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> fromParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> fromPerson(Dao dao, boolean succ) {
        return e -> dao.chainFromPerson(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> fromPerson(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromPerson(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> fromPartyGroup(Dao dao, boolean succ) {
        return e -> dao.chainFromPartyGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> fromPartyGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromPartyGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> acctgTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> itemIssuance(Dao dao, boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> itemIssuance(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentItem(Dao dao, boolean succ) {
        return e -> dao.chainShipmentItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentPackage(Dao dao, boolean succ) {
        return e -> dao.chainShipmentPackage(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentPackage(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentPackage(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentPackageContent(Dao dao, boolean succ) {
        return e -> dao.chainShipmentPackageContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentPackageContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentPackageContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentPackageRouteSeg(Dao dao, boolean succ) {
        return e -> dao.chainShipmentPackageRouteSeg(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentPackageRouteSeg(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentPackageRouteSeg(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentRouteSegment(Dao dao, boolean succ) {
        return e -> dao.chainShipmentRouteSegment(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentRouteSegment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentRouteSegment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> shipmentStatus(Dao dao, boolean succ) {
        return e -> dao.chainShipmentStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> shipmentStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Shipment>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, Shipment>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, Shipment> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, Shipment> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, Shipment> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, Shipment>> chain = tenant(dao, false);
         
        if (incls.contains(ESTIMATED_SHIP_WORK_EFFORT)) {
            chain = chain.andThen(estimatedShipWorkEffort(dao, true));
        }
         
        if (incls.contains(ESTIMATED_ARRIVAL_WORK_EFFORT)) {
            chain = chain.andThen(estimatedArrivalWorkEffort(dao, true));
        }
         
        if (incls.contains(ORIGIN_FACILITY)) {
            chain = chain.andThen(originFacility(dao, true));
        }
         
        if (incls.contains(DESTINATION_FACILITY)) {
            chain = chain.andThen(destinationFacility(dao, true));
        }
         
        if (incls.contains(ORIGIN_CONTACT_MECH)) {
            chain = chain.andThen(originContactMech(dao, true));
        }
         
        if (incls.contains(DEST_CONTACT_MECH)) {
            chain = chain.andThen(destContactMech(dao, true));
        }
         
        if (incls.contains(ORIGIN_POSTAL_ADDRESS)) {
            chain = chain.andThen(originPostalAddress(dao, true));
        }
         
        if (incls.contains(ORIGIN_TELECOM_NUMBER)) {
            chain = chain.andThen(originTelecomNumber(dao, true));
        }
         
        if (incls.contains(DESTINATION_POSTAL_ADDRESS)) {
            chain = chain.andThen(destinationPostalAddress(dao, true));
        }
         
        if (incls.contains(DESTINATION_TELECOM_NUMBER)) {
            chain = chain.andThen(destinationTelecomNumber(dao, true));
        }
         
        if (incls.contains(PRIMARY_ORDER_HEADER)) {
            chain = chain.andThen(primaryOrderHeader(dao, true));
        }
         
        if (incls.contains(PRIMARY_ORDER_ITEM_SHIP_GROUP)) {
            chain = chain.andThen(primaryOrderItemShipGroup(dao, true));
        }
         
        if (incls.contains(TO_PARTY)) {
            chain = chain.andThen(toParty(dao, true));
        }
         
        if (incls.contains(TO_PERSON)) {
            chain = chain.andThen(toPerson(dao, true));
        }
         
        if (incls.contains(TO_PARTY_GROUP)) {
            chain = chain.andThen(toPartyGroup(dao, true));
        }
         
        if (incls.contains(FROM_PARTY)) {
            chain = chain.andThen(fromParty(dao, true));
        }
         
        if (incls.contains(FROM_PERSON)) {
            chain = chain.andThen(fromPerson(dao, true));
        }
         
        if (incls.contains(FROM_PARTY_GROUP)) {
            chain = chain.andThen(fromPartyGroup(dao, true));
        }
         
        if (incls.contains(ACCTG_TRANS)) {
            chain = chain.andThen(acctgTrans(dao, true));
        }
         
        if (incls.contains(ITEM_ISSUANCE)) {
            chain = chain.andThen(itemIssuance(dao, true));
        }
         
        if (incls.contains(SHIPMENT_ITEM)) {
            chain = chain.andThen(shipmentItem(dao, true));
        }
         
        if (incls.contains(SHIPMENT_ITEM_BILLING)) {
            chain = chain.andThen(shipmentItemBilling(dao, true));
        }
         
        if (incls.contains(SHIPMENT_PACKAGE)) {
            chain = chain.andThen(shipmentPackage(dao, true));
        }
         
        if (incls.contains(SHIPMENT_PACKAGE_CONTENT)) {
            chain = chain.andThen(shipmentPackageContent(dao, true));
        }
         
        if (incls.contains(SHIPMENT_PACKAGE_ROUTE_SEG)) {
            chain = chain.andThen(shipmentPackageRouteSeg(dao, true));
        }
         
        if (incls.contains(SHIPMENT_RECEIPT)) {
            chain = chain.andThen(shipmentReceipt(dao, true));
        }
         
        if (incls.contains(SHIPMENT_ROUTE_SEGMENT)) {
            chain = chain.andThen(shipmentRouteSegment(dao, true));
        }
         
        if (incls.contains(SHIPMENT_STATUS)) {
            chain = chain.andThen(shipmentStatus(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ShipmentData> responseObserver) {
        Map<String, Shipment> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            ShipmentData.Builder shipmentData = data.toHeadBuilder();
             
            data.getRelEstimatedShipWorkEffort().forEach(e -> 
                shipmentData.setEstimatedShipWorkEffort(e.toHeadBuilder())); 
            data.getRelEstimatedArrivalWorkEffort().forEach(e -> 
                shipmentData.setEstimatedArrivalWorkEffort(e.toHeadBuilder())); 
            data.getRelOriginFacility().forEach(e -> 
                shipmentData.setOriginFacility(e.toDataBuilder())); 
            data.getRelDestinationFacility().forEach(e -> 
                shipmentData.setDestinationFacility(e.toDataBuilder())); 
            data.getRelOriginContactMech().forEach(e -> 
                shipmentData.setOriginContactMech(e.toDataBuilder())); 
            data.getRelDestContactMech().forEach(e -> 
                shipmentData.setDestContactMech(e.toDataBuilder())); 
            data.getRelOriginPostalAddress().forEach(e -> 
                shipmentData.setOriginPostalAddress(e.toDataBuilder())); 
            data.getRelOriginTelecomNumber().forEach(e -> 
                shipmentData.setOriginTelecomNumber(e.toDataBuilder())); 
            data.getRelDestinationPostalAddress().forEach(e -> 
                shipmentData.setDestinationPostalAddress(e.toDataBuilder())); 
            data.getRelDestinationTelecomNumber().forEach(e -> 
                shipmentData.setDestinationTelecomNumber(e.toDataBuilder())); 
            data.getRelPrimaryOrderHeader().forEach(e -> 
                shipmentData.setPrimaryOrderHeader(e.toHeadBuilder())); 
            data.getRelPrimaryOrderItemShipGroup().forEach(e -> 
                shipmentData.setPrimaryOrderItemShipGroup(e.toDataBuilder())); 
            data.getRelToParty().forEach(e -> 
                shipmentData.setToParty(e.toHeadBuilder())); 
            data.getRelToPerson().forEach(e -> 
                shipmentData.setToPerson(e.toHeadBuilder())); 
            data.getRelToPartyGroup().forEach(e -> 
                shipmentData.setToPartyGroup(e.toHeadBuilder())); 
            data.getRelFromParty().forEach(e -> 
                shipmentData.setFromParty(e.toHeadBuilder())); 
            data.getRelFromPerson().forEach(e -> 
                shipmentData.setFromPerson(e.toHeadBuilder())); 
            data.getRelFromPartyGroup().forEach(e -> 
                shipmentData.setFromPartyGroup(e.toHeadBuilder())); 
            data.getRelAcctgTrans().forEach(e -> 
                shipmentData.addAcctgTrans(e.toDataBuilder())); 
            data.getRelItemIssuance().forEach(e -> 
                shipmentData.addItemIssuance(e.toDataBuilder())); 
            data.getRelShipmentItem().forEach(e -> 
                shipmentData.addShipmentItem(e.toDataBuilder())); 
            data.getRelShipmentItemBilling().forEach(e -> 
                shipmentData.addShipmentItemBilling(e.toDataBuilder())); 
            data.getRelShipmentPackage().forEach(e -> 
                shipmentData.addShipmentPackage(e.toDataBuilder())); 
            data.getRelShipmentPackageContent().forEach(e -> 
                shipmentData.addShipmentPackageContent(e.toDataBuilder())); 
            data.getRelShipmentPackageRouteSeg().forEach(e -> 
                shipmentData.addShipmentPackageRouteSeg(e.toDataBuilder())); 
            data.getRelShipmentReceipt().forEach(e -> 
                shipmentData.addShipmentReceipt(e.toDataBuilder())); 
            data.getRelShipmentRouteSegment().forEach(e -> 
                shipmentData.addShipmentRouteSegment(e.toDataBuilder())); 
            data.getRelShipmentStatus().forEach(e -> 
                shipmentData.addShipmentStatus(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                shipmentData.setTenant(e.toDataBuilder()));
            return shipmentData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public Shipment get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getShipment(id);
    }

    public List<Shipment> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listShipment();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countShipment();
    }


    public void store(Shipment shipment){
        store(shipment, true);
    }

    public void store(Shipment shipment, boolean genId){
        process(c ->{
            if(genId){
                shipment.setShipmentId(sequence.nextStringId());
            }
            storeOrUpdate(c, shipment.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "Shipment", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Shipment rec;
        final Message p1;
        Shipment persistObject;

        Agent(IProc.ProcContext ctx, Shipment rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Shipment getRecord(){
            return rec;
        }

        public Shipment merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<WorkEffort> getEstimatedShipWorkEffort(){
            return getRelationValues(ctx, p1, "estimated_ship_work_effort", WorkEffort.class);
        }

        public List<WorkEffort> mergeEstimatedShipWorkEffort(){
            return getEstimatedShipWorkEffort().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEstimatedShipWorkEffort().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffort> getEstimatedArrivalWorkEffort(){
            return getRelationValues(ctx, p1, "estimated_arrival_work_effort", WorkEffort.class);
        }

        public List<WorkEffort> mergeEstimatedArrivalWorkEffort(){
            return getEstimatedArrivalWorkEffort().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEstimatedArrivalWorkEffort().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Facility> getOriginFacility(){
            return getRelationValues(ctx, p1, "origin_facility", Facility.class);
        }

        public List<Facility> mergeOriginFacility(){
            return getOriginFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOriginFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Facility> getDestinationFacility(){
            return getRelationValues(ctx, p1, "destination_facility", Facility.class);
        }

        public List<Facility> mergeDestinationFacility(){
            return getDestinationFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDestinationFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContactMech> getOriginContactMech(){
            return getRelationValues(ctx, p1, "origin_contact_mech", ContactMech.class);
        }

        public List<ContactMech> mergeOriginContactMech(){
            return getOriginContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOriginContactMech().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContactMech> getDestContactMech(){
            return getRelationValues(ctx, p1, "dest_contact_mech", ContactMech.class);
        }

        public List<ContactMech> mergeDestContactMech(){
            return getDestContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDestContactMech().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PostalAddress> getOriginPostalAddress(){
            return getRelationValues(ctx, p1, "origin_postal_address", PostalAddress.class);
        }

        public List<PostalAddress> mergeOriginPostalAddress(){
            return getOriginPostalAddress().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOriginPostalAddress().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TelecomNumber> getOriginTelecomNumber(){
            return getRelationValues(ctx, p1, "origin_telecom_number", TelecomNumber.class);
        }

        public List<TelecomNumber> mergeOriginTelecomNumber(){
            return getOriginTelecomNumber().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOriginTelecomNumber().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PostalAddress> getDestinationPostalAddress(){
            return getRelationValues(ctx, p1, "destination_postal_address", PostalAddress.class);
        }

        public List<PostalAddress> mergeDestinationPostalAddress(){
            return getDestinationPostalAddress().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDestinationPostalAddress().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TelecomNumber> getDestinationTelecomNumber(){
            return getRelationValues(ctx, p1, "destination_telecom_number", TelecomNumber.class);
        }

        public List<TelecomNumber> mergeDestinationTelecomNumber(){
            return getDestinationTelecomNumber().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDestinationTelecomNumber().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderHeader> getPrimaryOrderHeader(){
            return getRelationValues(ctx, p1, "primary_order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergePrimaryOrderHeader(){
            return getPrimaryOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroup> getPrimaryOrderItemShipGroup(){
            return getRelationValues(ctx, p1, "primary_order_item_ship_group", OrderItemShipGroup.class);
        }

        public List<OrderItemShipGroup> mergePrimaryOrderItemShipGroup(){
            return getPrimaryOrderItemShipGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryOrderItemShipGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getToParty(){
            return getRelationValues(ctx, p1, "to_party", Party.class);
        }

        public List<Party> mergeToParty(){
            return getToParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Person> getToPerson(){
            return getRelationValues(ctx, p1, "to_person", Person.class);
        }

        public List<Person> mergeToPerson(){
            return getToPerson().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToPerson().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyGroup> getToPartyGroup(){
            return getRelationValues(ctx, p1, "to_party_group", PartyGroup.class);
        }

        public List<PartyGroup> mergeToPartyGroup(){
            return getToPartyGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToPartyGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getFromParty(){
            return getRelationValues(ctx, p1, "from_party", Party.class);
        }

        public List<Party> mergeFromParty(){
            return getFromParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Person> getFromPerson(){
            return getRelationValues(ctx, p1, "from_person", Person.class);
        }

        public List<Person> mergeFromPerson(){
            return getFromPerson().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromPerson().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyGroup> getFromPartyGroup(){
            return getRelationValues(ctx, p1, "from_party_group", PartyGroup.class);
        }

        public List<PartyGroup> mergeFromPartyGroup(){
            return getFromPartyGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromPartyGroup().add(c))
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
         
        public List<ItemIssuance> getItemIssuance(){
            return getRelationValues(ctx, p1, "item_issuance", ItemIssuance.class);
        }

        public List<ItemIssuance> mergeItemIssuance(){
            return getItemIssuance().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelItemIssuance().add(c))
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
         
        public List<ShipmentItemBilling> getShipmentItemBilling(){
            return getRelationValues(ctx, p1, "shipment_item_billing", ShipmentItemBilling.class);
        }

        public List<ShipmentItemBilling> mergeShipmentItemBilling(){
            return getShipmentItemBilling().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentItemBilling().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentPackage> getShipmentPackage(){
            return getRelationValues(ctx, p1, "shipment_package", ShipmentPackage.class);
        }

        public List<ShipmentPackage> mergeShipmentPackage(){
            return getShipmentPackage().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentPackage().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentPackageContent> getShipmentPackageContent(){
            return getRelationValues(ctx, p1, "shipment_package_content", ShipmentPackageContent.class);
        }

        public List<ShipmentPackageContent> mergeShipmentPackageContent(){
            return getShipmentPackageContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentPackageContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentPackageRouteSeg> getShipmentPackageRouteSeg(){
            return getRelationValues(ctx, p1, "shipment_package_route_seg", ShipmentPackageRouteSeg.class);
        }

        public List<ShipmentPackageRouteSeg> mergeShipmentPackageRouteSeg(){
            return getShipmentPackageRouteSeg().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentPackageRouteSeg().add(c))
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
         
        public List<ShipmentRouteSegment> getShipmentRouteSegment(){
            return getRelationValues(ctx, p1, "shipment_route_segment", ShipmentRouteSegment.class);
        }

        public List<ShipmentRouteSegment> mergeShipmentRouteSegment(){
            return getShipmentRouteSegment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentRouteSegment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentStatus> getShipmentStatus(){
            return getRelationValues(ctx, p1, "shipment_status", ShipmentStatus.class);
        }

        public List<ShipmentStatus> mergeShipmentStatus(){
            return getShipmentStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentStatus().add(c))
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
        ShipmentData p = ShipmentData.newBuilder()
                .setShipmentId(key)
                .build();
        Shipment rec = findOne(ctx, p, Shipment.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, Shipment rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String ESTIMATED_SHIP_WORK_EFFORT="estimated_ship_work_effort";
         
    public static final String ESTIMATED_ARRIVAL_WORK_EFFORT="estimated_arrival_work_effort";
         
    public static final String ORIGIN_FACILITY="origin_facility";
         
    public static final String DESTINATION_FACILITY="destination_facility";
         
    public static final String ORIGIN_CONTACT_MECH="origin_contact_mech";
         
    public static final String DEST_CONTACT_MECH="dest_contact_mech";
         
    public static final String ORIGIN_POSTAL_ADDRESS="origin_postal_address";
         
    public static final String ORIGIN_TELECOM_NUMBER="origin_telecom_number";
         
    public static final String DESTINATION_POSTAL_ADDRESS="destination_postal_address";
         
    public static final String DESTINATION_TELECOM_NUMBER="destination_telecom_number";
         
    public static final String PRIMARY_ORDER_HEADER="primary_order_header";
         
    public static final String PRIMARY_ORDER_ITEM_SHIP_GROUP="primary_order_item_ship_group";
         
    public static final String TO_PARTY="to_party";
         
    public static final String TO_PERSON="to_person";
         
    public static final String TO_PARTY_GROUP="to_party_group";
         
    public static final String FROM_PARTY="from_party";
         
    public static final String FROM_PERSON="from_person";
         
    public static final String FROM_PARTY_GROUP="from_party_group";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String SHIPMENT_ITEM="shipment_item";
         
    public static final String SHIPMENT_ITEM_BILLING="shipment_item_billing";
         
    public static final String SHIPMENT_PACKAGE="shipment_package";
         
    public static final String SHIPMENT_PACKAGE_CONTENT="shipment_package_content";
         
    public static final String SHIPMENT_PACKAGE_ROUTE_SEG="shipment_package_route_seg";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String SHIPMENT_ROUTE_SEGMENT="shipment_route_segment";
         
    public static final String SHIPMENT_STATUS="shipment_status";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryShipmentRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ShipmentData p = ShipmentData.newBuilder()
                    .setShipmentId(key)
                    .build();
            List<ShipmentData.Builder> ds = find(ctx, p, Shipment.class).stream()
                    .map(e -> {
                        ShipmentData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set estimated_ship_work_effort to head entity                        
                        if(relationsDemand.contains("estimated_ship_work_effort")) {
                            getRelationValues(ctx, p1, "estimated_ship_work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.setEstimatedShipWorkEffort(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set estimated_arrival_work_effort to head entity                        
                        if(relationsDemand.contains("estimated_arrival_work_effort")) {
                            getRelationValues(ctx, p1, "estimated_arrival_work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.setEstimatedArrivalWorkEffort(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set origin_facility to head entity                        
                        if(relationsDemand.contains("origin_facility")) {
                            getRelationValues(ctx, p1, "origin_facility",
                                            Facility.class)
                                    .forEach(el -> pb.setOriginFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set destination_facility to head entity                        
                        if(relationsDemand.contains("destination_facility")) {
                            getRelationValues(ctx, p1, "destination_facility",
                                            Facility.class)
                                    .forEach(el -> pb.setDestinationFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set origin_contact_mech to head entity                        
                        if(relationsDemand.contains("origin_contact_mech")) {
                            getRelationValues(ctx, p1, "origin_contact_mech",
                                            ContactMech.class)
                                    .forEach(el -> pb.setOriginContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set dest_contact_mech to head entity                        
                        if(relationsDemand.contains("dest_contact_mech")) {
                            getRelationValues(ctx, p1, "dest_contact_mech",
                                            ContactMech.class)
                                    .forEach(el -> pb.setDestContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set origin_postal_address to head entity                        
                        if(relationsDemand.contains("origin_postal_address")) {
                            getRelationValues(ctx, p1, "origin_postal_address",
                                            PostalAddress.class)
                                    .forEach(el -> pb.setOriginPostalAddress(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set origin_telecom_number to head entity                        
                        if(relationsDemand.contains("origin_telecom_number")) {
                            getRelationValues(ctx, p1, "origin_telecom_number",
                                            TelecomNumber.class)
                                    .forEach(el -> pb.setOriginTelecomNumber(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set destination_postal_address to head entity                        
                        if(relationsDemand.contains("destination_postal_address")) {
                            getRelationValues(ctx, p1, "destination_postal_address",
                                            PostalAddress.class)
                                    .forEach(el -> pb.setDestinationPostalAddress(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set destination_telecom_number to head entity                        
                        if(relationsDemand.contains("destination_telecom_number")) {
                            getRelationValues(ctx, p1, "destination_telecom_number",
                                            TelecomNumber.class)
                                    .forEach(el -> pb.setDestinationTelecomNumber(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set primary_order_header to head entity                        
                        if(relationsDemand.contains("primary_order_header")) {
                            getRelationValues(ctx, p1, "primary_order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.setPrimaryOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set primary_order_item_ship_group to head entity                        
                        if(relationsDemand.contains("primary_order_item_ship_group")) {
                            getRelationValues(ctx, p1, "primary_order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.setPrimaryOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_party to head entity                        
                        if(relationsDemand.contains("to_party")) {
                            getRelationValues(ctx, p1, "to_party",
                                            Party.class)
                                    .forEach(el -> pb.setToParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set to_person to head entity                        
                        if(relationsDemand.contains("to_person")) {
                            getRelationValues(ctx, p1, "to_person",
                                            Person.class)
                                    .forEach(el -> pb.setToPerson(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set to_party_group to head entity                        
                        if(relationsDemand.contains("to_party_group")) {
                            getRelationValues(ctx, p1, "to_party_group",
                                            PartyGroup.class)
                                    .forEach(el -> pb.setToPartyGroup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_party to head entity                        
                        if(relationsDemand.contains("from_party")) {
                            getRelationValues(ctx, p1, "from_party",
                                            Party.class)
                                    .forEach(el -> pb.setFromParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_person to head entity                        
                        if(relationsDemand.contains("from_person")) {
                            getRelationValues(ctx, p1, "from_person",
                                            Person.class)
                                    .forEach(el -> pb.setFromPerson(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_party_group to head entity                        
                        if(relationsDemand.contains("from_party_group")) {
                            getRelationValues(ctx, p1, "from_party_group",
                                            PartyGroup.class)
                                    .forEach(el -> pb.setFromPartyGroup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set item_issuance to head entity                        
                        if(relationsDemand.contains("item_issuance")) {
                            getRelationValues(ctx, p1, "item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_item to head entity                        
                        if(relationsDemand.contains("shipment_item")) {
                            getRelationValues(ctx, p1, "shipment_item",
                                            ShipmentItem.class)
                                    .forEach(el -> pb.addShipmentItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_item_billing to head entity                        
                        if(relationsDemand.contains("shipment_item_billing")) {
                            getRelationValues(ctx, p1, "shipment_item_billing",
                                            ShipmentItemBilling.class)
                                    .forEach(el -> pb.addShipmentItemBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_package to head entity                        
                        if(relationsDemand.contains("shipment_package")) {
                            getRelationValues(ctx, p1, "shipment_package",
                                            ShipmentPackage.class)
                                    .forEach(el -> pb.addShipmentPackage(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_package_content to head entity                        
                        if(relationsDemand.contains("shipment_package_content")) {
                            getRelationValues(ctx, p1, "shipment_package_content",
                                            ShipmentPackageContent.class)
                                    .forEach(el -> pb.addShipmentPackageContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_package_route_seg to head entity                        
                        if(relationsDemand.contains("shipment_package_route_seg")) {
                            getRelationValues(ctx, p1, "shipment_package_route_seg",
                                            ShipmentPackageRouteSeg.class)
                                    .forEach(el -> pb.addShipmentPackageRouteSeg(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_route_segment to head entity                        
                        if(relationsDemand.contains("shipment_route_segment")) {
                            getRelationValues(ctx, p1, "shipment_route_segment",
                                            ShipmentRouteSegment.class)
                                    .forEach(el -> pb.addShipmentRouteSegment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_status to head entity                        
                        if(relationsDemand.contains("shipment_status")) {
                            getRelationValues(ctx, p1, "shipment_status",
                                            ShipmentStatus.class)
                                    .forEach(el -> pb.addShipmentStatus(
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


    
    public Shipment.ShipmentBuilder seed(){
        return Shipment.builder()
                .shipmentId(sequence.nextStringId());
    }
}

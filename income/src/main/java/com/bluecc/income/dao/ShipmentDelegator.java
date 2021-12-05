package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.ShipmentData;

public class ShipmentDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Shipment.class)
    public interface ShipmentDao {
        @SqlQuery("select * from shipment")
        List<Shipment> listShipment();
        @SqlQuery("select * from shipment where shipment_id=:id")
        Shipment getShipment(@Bind("id") String id);

        @SqlQuery("select count(*) from shipment")
        int countShipment();
    }

         
    public static final String ESTIMATED_SHIP_WORK_EFFORT="estimated_ship_work_effort";
         
    public static final String ESTIMATED_ARRIVAL_WORK_EFFORT="estimated_arrival_work_effort";
         
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
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set estimated_arrival_work_effort to head entity                        
                        if(relationsDemand.contains("estimated_arrival_work_effort")) {
                            getRelationValues(ctx, p1, "estimated_arrival_work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.setEstimatedArrivalWorkEffort(
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
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}

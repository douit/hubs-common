package com.bluecc.income.dao;

import com.bluecc.hubs.stub.*;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.*;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PersonDelegatorTest extends AbstractStoreProcTest {
    @Inject PersonDelegator persons;

    @Before
    public void setUp() throws Exception {
        setupEntities("Person");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PersonFlatData flatData= PersonFlatData.newBuilder()
                    .setPartyId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, persons.create(ctx, flatData));
            assertEquals(1, persons.update(ctx, flatData));
            assertEquals(1, persons.find(ctx, flatData).size());
            assertEquals(1, persons.findById(ctx, flatData).size());
            assertEquals(1, persons.delete(ctx, flatData));
            assertEquals(0, persons.find(ctx, flatData).size());
        });
    }

    @Test
    public void testQueryDemands() {
        String key="admin";
        Set<String> relationsDemand= Sets.newHashSet("party_contact_mech");
        process(c -> {
            PersonData p = PersonData.newBuilder()
                    .setPartyId(key)
                    .build();
            List<PersonData> ds = genericProcs.find(c, p, Person.class).stream()
                    .map(e -> {
                        PersonData.Builder pb = e.toHeadBuilder();


                        // add/set party to head entity
                        // if(relationsDemand.contains("party")) {
                        //     genericProcs.getRelationValues(c, p, "party",
                        //                     Party.class)
                        //             .forEach(el -> pb.setParty(
                        //                     (PartyData) el.toData()));
                        // }

                        // add/set party_contact_mech to head entity
                        if(relationsDemand.contains("party_contact_mech")) {
                            genericProcs.getRelationValues(c, p, "party_contact_mech",
                                            PartyContactMech.class)
                                    .forEach(el -> pb.addPartyContactMech(
                                            (PartyContactMechData) el.toData()));
                        }

                        // add/set party_contact_mech_purpose to head entity
                        if(relationsDemand.contains("party_contact_mech_purpose")) {
                            genericProcs.getRelationValues(c, p, "party_contact_mech_purpose",
                                            PartyContactMechPurpose.class)
                                    .forEach(el -> pb.addPartyContactMechPurpose(
                                            (PartyContactMechPurposeData) el.toData()));
                        }

                        // add/set product_store_role to head entity
                        if(relationsDemand.contains("product_store_role")) {
                            genericProcs.getRelationValues(c, p, "product_store_role",
                                            ProductStoreRole.class)
                                    .forEach(el -> pb.addProductStoreRole(
                                            (ProductStoreRoleData) el.toData()));
                        }

                        // add/set to_shipment to head entity
                        if(relationsDemand.contains("to_shipment")) {
                            genericProcs.getRelationValues(c, p, "to_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addToShipment(
                                            (ShipmentData) el.toData()));
                        }

                        // add/set from_shipment to head entity
                        if(relationsDemand.contains("from_shipment")) {
                            genericProcs.getRelationValues(c, p, "from_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addFromShipment(
                                            (ShipmentData) el.toData()));
                        }

                        // add/set carrier_shipment_route_segment to head entity
                        if(relationsDemand.contains("carrier_shipment_route_segment")) {
                            genericProcs.getRelationValues(c, p, "carrier_shipment_route_segment",
                                            ShipmentRouteSegment.class)
                                    .forEach(el -> pb.addCarrierShipmentRouteSegment(
                                            (ShipmentRouteSegmentData) el.toData()));
                        }

                        // add/set user_login to head entity
                        if(relationsDemand.contains("user_login")) {
                            genericProcs.getRelationValues(c, p, "user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.addUserLogin(
                                            (UserLoginData) el.toData()));
                        }


                        return pb.build();
                    }).collect(Collectors.toList());

            ds.forEach(e -> System.out.println(e));
        });


    }
}

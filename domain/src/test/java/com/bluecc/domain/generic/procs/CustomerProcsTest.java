package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.PartyRoleRepository;
import com.bluecc.domain.generic.procs.CustomerProcs.CustomerParams;
import com.bluecc.domain.sql.model.*;
import com.bluecc.domain.util.JdbcHelper;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static com.bluecc.domain.util.JsonUtil.pretty;
import static org.junit.Assert.*;

public class CustomerProcsTest extends AbstractProcsTest{
    @Inject
    CustomerProcs customerProcs;
    @Inject
    PartyRoleRepository partyRoleRepository;

    Faker faker = new Faker(new Locale("zh-CN"));
    @Before
    public void setUp() throws Exception {
        // OrderItemPriceInfo
        jdbcHelper.truncate("party", "person",
                "user_login", "party_role", "party_status",
                "geo_point", "party_geo_point");
    }

    @Test
    public void saveCustomer() {
        CustomerParams params=CustomerParams.builder()
                .party(custParty())
                .person(custPerson())
                .userLogin(new UserLogin())
                .partyRoles(custRoles())
                .partyStatus(custStatus())
                .geoPoint(geoPoint())
                .partyGeoPoint(custGeoPoint())
                .build();
        Long id=customerProcs.saveCustomer(params);
        System.out.println(id);

        assertEquals(2L, partyRoleRepository.count());

        CustomerProcs.Customer customer=customerProcs.findCustomer(id);
        pretty(customer);
    }

    private GeoPoint geoPoint() {
        GeoPoint geoPoint=new GeoPoint();
        geoPoint.setDataSourceId("GEOPT_GOOGLE");
        geoPoint.setLatitude("40.297264");
        geoPoint.setLongitude("-111.696625");
        geoPoint.setElevation(randDecimal(1000, 4770));
        geoPoint.setElevationUomId("LEN_ft");
        geoPoint.setInformation("A testing GeoPoint for contactMechId=9015 (DemoCustomer)");
        return geoPoint;
    }

    private PartyGeoPoint custGeoPoint() {
        PartyGeoPoint geoPoint=new PartyGeoPoint();
        geoPoint.setFromDate(DateTime.now());
        return geoPoint;
    }

    private PartyStatus custStatus() {
        PartyStatus partyStatus=new PartyStatus();
        partyStatus.setStatusId("PARTY_ENABLED");
        partyStatus.setStatusDate(DateTime.now());
        return partyStatus;
    }

    private Collection<? extends PartyRole> custRoles() {
        List<PartyRole> roles= Lists.newArrayList();

        PartyRole role=new PartyRole();
        role.setRoleTypeId("CUSTOMER");
        roles.add(role);

        role=new PartyRole();
        role.setRoleTypeId("BILL_TO_CUSTOMER");
        roles.add(role);
        return roles;
    }

    private Person custPerson() {
        Person person=new Person();
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());

        return person;
    }

    private Party custParty() {
        Party party=new Party();
        party.setPartyTypeId("PERSON");
        party.setStatusId("PARTY_ENABLED");
        party.setPreferredCurrencyUomId("EUR");
        return party;
    }
}
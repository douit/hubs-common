package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.procs.CustomerProcs.CustomerParams;
import com.bluecc.domain.sql.model.Party;
import com.bluecc.domain.sql.model.Person;
import com.bluecc.domain.sql.model.UserLogin;
import com.bluecc.domain.util.JdbcHelper;
import com.github.javafaker.Faker;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class CustomerProcsTest extends AbstractProcsTest{
    @Inject
    JdbcHelper jdbcHelper;
    @Inject
    CustomerProcs customerProcs;
    Faker faker = new Faker(new Locale("zh-CN"));
    @Before
    public void setUp() throws Exception {
        // OrderItemPriceInfo
        jdbcHelper.truncate("party", "person", "user_login");
    }

    @Test
    public void saveCustomer() {
        CustomerParams params=CustomerParams.builder()
                .party(custParty())
                .person(custPerson())
                .userLogin(new UserLogin())
                .build();
        Long id=customerProcs.saveCustomer(params);
        System.out.println(id);
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
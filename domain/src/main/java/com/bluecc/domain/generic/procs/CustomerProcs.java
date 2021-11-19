package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.PartyRepository;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.sql.model.*;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.QBean;
import com.querydsl.sql.dml.SQLInsertClause;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import static com.querydsl.core.types.Projections.bean;

import static com.bluecc.domain.sql.model.QGeoPoint.geoPoint;
import static com.bluecc.domain.sql.model.QParty.party;
import static com.bluecc.domain.sql.model.QPartyGeoPoint.partyGeoPoint;
import static com.bluecc.domain.sql.model.QPartyRole.partyRole;
import static com.bluecc.domain.sql.model.QPartyStatus.partyStatus;
import static com.bluecc.domain.sql.model.QPerson.person;
import static com.bluecc.domain.sql.model.QUserLogin.userLogin;

public class CustomerProcs extends PartyRepository {
    @Data
    @Builder
    public static class CustomerParams {
        Party party;
        Person person;
        UserLogin userLogin;

        @Singular
        List<PartyRole> partyRoles;
        PartyStatus partyStatus;

        GeoPoint geoPoint;
        PartyGeoPoint partyGeoPoint;
    }

    @Data
    public static class Customer {
        Long partyId;
        String lastName;
        String firstName;

        Party party;
        Person person;
        List<PartyRole> partyRoles;
    }

    // detail
    final QBean<PartyRole> partyRoleBean = bean(PartyRole.class, partyRole.all());
    // master and detail
    final QBean<Customer> customerBean = bean(Customer.class,
            person.partyId, person.lastName, person.firstName,  // digest attrs
            bean(Party.class, party.all()).as("party"),
            bean(Person.class, person.all()).as("person"),
            GroupBy.list(partyRoleBean).as("partyRoles")  // detail: partyRoles
    );

    @Transactional
    public Customer findCustomer(Long partyId) {
        List<Customer> rs = selectFrom(person)
                .innerJoin(party).on(person.partyId.eq(party.partyId))
                .leftJoin(partyRole).on(person.partyId.eq(partyRole.partyId))
                .where(person.partyId.eq(partyId))
                .transform(GroupBy.groupBy(person.partyId).list(customerBean));
        return rs.isEmpty() ? null : rs.get(0);
    }

    @Transactional
    public Long saveCustomer(CustomerParams params) {
        Long partyId = save(params.party);

        params.person.setPartyId(partyId);
        insert(person).populate(params.person)
                .executeWithKey(person.partyId);

        params.userLogin.setPartyId(partyId);
        insert(userLogin).populate(params.userLogin)
                .executeWithKey(userLogin.partyId);

        // insert list
        SQLInsertClause insert = insert(partyRole);
        for (PartyRole role : params.partyRoles) {
            role.setPartyId(partyId);
            insert.populate(role).addBatch();
        }
        insert.execute();

        params.partyStatus.setPartyId(partyId);
        insert(partyStatus).populate(params.partyStatus)
                .executeWithKey(partyStatus.partyId);

        // insert combo
        Long geoPointId = insert(geoPoint).populate(params.geoPoint)
                .executeWithKey(geoPoint.geoPointId);

        params.partyGeoPoint.setPartyId(partyId);
        params.partyGeoPoint.setGeoPointId(geoPointId);
        insert(partyGeoPoint).populate(params.partyGeoPoint)
                .executeWithKey(partyGeoPoint.id);

        return partyId;
    }
}



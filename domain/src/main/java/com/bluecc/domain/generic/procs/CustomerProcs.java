package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.PartyRepository;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.sql.model.*;
import com.querydsl.sql.dml.SQLInsertClause;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

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

    }

    @Transactional
    public Long saveCustomer(CustomerParams params) {
        Long partyId = save(params.getParty());

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

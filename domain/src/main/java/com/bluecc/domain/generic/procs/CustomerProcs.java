package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.PartyRepository;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.sql.model.*;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

import static com.bluecc.domain.sql.model.QParty.party;
import static com.bluecc.domain.sql.model.QPerson.person;
import static com.bluecc.domain.sql.model.QUserLogin.userLogin;

public class CustomerProcs extends PartyRepository {
    @Data
    @Builder
    public static class CustomerParams{
        Party party;
        Person person;
        UserLogin userLogin;
        @Singular
        List<PartyRole> partyRoles;
        PartyStatus partyStatus;
        PartyGeoPoint partyGeoPoint;
    }

    @Data
    public static class Customer{

    }

    @Transactional
    public Long saveCustomer(CustomerParams customerParams){
        Long partyId=save(customerParams.getParty());
        customerParams.person.setPartyId(partyId);
        insert(person).populate(customerParams.person)
                .executeWithKey(person.partyId);
        customerParams.userLogin.setPartyId(partyId);
        insert(userLogin).populate(customerParams.userLogin)
                .executeWithKey(userLogin.partyId);
        return partyId;
    }
}

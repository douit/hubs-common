package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QPerson.person;

// Person
public class PersonRepository extends AbstractRepository {
    @Transactional
    public Long save(Person entity) {
        if (entity.getPartyId() != null) {
            update(person).populate(entity).execute();
            return entity.getPartyId();
        }
        return insert(person).populate(entity)
                .executeWithKey(person.partyId);
    }

    @Transactional
    public Person findById(Long id) {
        return selectFrom(person).where(person.partyId.eq(id)).fetchOne();
    }


    @Transactional
    public List<Person> findAll(Predicate expr) {
        return selectFrom(person).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(person).fetchCount();
    }

    @Transactional
    public void delete(Person s) {
        delete(person)
            .where(person.partyId.eq(s.getPartyId()))
            .execute();
    }
}

/*
-- keys: partyId

-- fields --
    
    Long partyId
    String salutation
    String firstName
    String middleName
    String lastName
    String personalTitle
    String suffix
    String nickname
    String firstNameLocal
    String middleNameLocal
    String lastNameLocal
    String otherLocal
    Long memberId
    String gender
    java.sql.Date birthDate
    java.sql.Date deceasedDate
    Double height
    Double weight
    String mothersMaidenName
    String oldMaritalStatus
    Long maritalStatusEnumId
    String socialSecurityNumber
    String passportNumber
    java.sql.Date passportExpireDate
    Double totalYearsWorkExperience
    String comments
    Long employmentStatusEnumId
    Long residenceStatusEnumId
    String occupation
    Long yearsWithEmployer
    Long monthsWithEmployer
    String existingCustomer
    Long cardId

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - EmploymentStatusEnumeration (one, autoRelation: false, keymaps: employmentStatusEnumId -> enumId)
    - ResidenceStatusEnumeration (one, autoRelation: false, keymaps: residenceStatusEnumId -> enumId)
    - MaritalStatusEnumeration (one, autoRelation: false, keymaps: maritalStatusEnumId -> enumId)
    + PartyContactMech (many, autoRelation: true, keymaps: partyId)
    + PartyContactMechPurpose (many, autoRelation: true, keymaps: partyId)
    + ApproverPersonTraining (many, autoRelation: true, keymaps: partyId -> approverId)
    + ProdCatalogRole (many, autoRelation: true, keymaps: partyId)
    + ProductStoreRole (many, autoRelation: true, keymaps: partyId)
    + ToShipment (many, autoRelation: true, keymaps: partyId -> partyIdTo)
    + FromShipment (many, autoRelation: true, keymaps: partyId -> partyIdFrom)
    + CarrierShipmentRouteSegment (many, autoRelation: true, keymaps: partyId -> carrierPartyId)
    + UserLogin (many, autoRelation: true, keymaps: partyId)
    + WebSiteRole (many, autoRelation: true, keymaps: partyId)
*/



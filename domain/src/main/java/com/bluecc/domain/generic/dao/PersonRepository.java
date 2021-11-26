package com.bluecc.domain.generic.dao;

import com.bluecc.domain.util.Sequence;
import com.google.inject.Inject;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;
import org.joda.time.DateTime;

import com.bluecc.domain.sql.model.*;
import com.querydsl.core.types.QBean;
import static com.querydsl.core.types.Projections.bean;

import static com.bluecc.domain.sql.model.QPerson.person;

// Person
public class PersonRepository extends AbstractRepository {
    @Inject Sequence sequence;

    public static final QBean<Person> personBean = bean(Person.class, person.all());

    @Transactional
    public String save(Person entity) {
        if (entity.getPartyId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(person).populate(entity).execute();
            return entity.getPartyId();
        }
        entity.setCreatedStamp(DateTime.now());
        String uid=sequence.nextStringId();
        entity.setPartyId(uid);
        return create(entity);
        // return insert(person).populate(entity)
        //        .executeWithKey(person.partyId);
    }

    @Transactional
    public String create(Person entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(person).populate(entity)
                .executeWithKey(person.partyId);
        return entity.getPartyId();
    }

    @Transactional
    public Person findById(String id) {
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
    
    String partyId
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
    String memberId
    String gender
    java.sql.Date birthDate
    java.sql.Date deceasedDate
    Double height
    Double weight
    String mothersMaidenName
    String oldMaritalStatus
    String maritalStatusEnumId
    String socialSecurityNumber
    String passportNumber
    java.sql.Date passportExpireDate
    Double totalYearsWorkExperience
    String comments
    String employmentStatusEnumId
    String residenceStatusEnumId
    String occupation
    Long yearsWithEmployer
    Long monthsWithEmployer
    String existingCustomer
    String cardId

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



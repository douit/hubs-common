//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.PersonFlatData;

import com.bluecc.hubs.stub.PersonData;
import com.bluecc.income.dao.PersonDelegator;
import static com.bluecc.income.dao.PersonDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PersonData.class,
        symbol = EntityNames.Person)
public class Person implements IEventModel<PersonFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RId 
    String partyId;
    @SerializedName("salutation") 
    String salutation;
    @SerializedName("first_name") 
    String firstName;
    @SerializedName("middle_name") 
    String middleName;
    @SerializedName("last_name") 
    String lastName;
    @SerializedName("personal_title") 
    String personalTitle;
    @SerializedName("suffix") 
    String suffix;
    @SerializedName("nickname") 
    String nickname;
    @SerializedName("first_name_local") 
    String firstNameLocal;
    @SerializedName("middle_name_local") 
    String middleNameLocal;
    @SerializedName("last_name_local") 
    String lastNameLocal;
    @SerializedName("other_local") 
    String otherLocal;
    @SerializedName("member_id") 
    String memberId;
    @SerializedName("gender") 
    Character gender;
    @SerializedName("birth_date") 
    java.time.LocalDate birthDate;
    @SerializedName("deceased_date") 
    java.time.LocalDate deceasedDate;
    @SerializedName("height") 
    Double height;
    @SerializedName("weight") 
    Double weight;
    @SerializedName("mothers_maiden_name") 
    String mothersMaidenName;
    @SerializedName("marital_status_enum_id") 
    String maritalStatusEnumId;
    @SerializedName("social_security_number") 
    String socialSecurityNumber;
    @SerializedName("passport_number") 
    String passportNumber;
    @SerializedName("passport_expire_date") 
    java.time.LocalDate passportExpireDate;
    @SerializedName("total_years_work_experience") 
    Double totalYearsWorkExperience;
    @SerializedName("comments") 
    String comments;
    @SerializedName("employment_status_enum_id") 
    String employmentStatusEnumId;
    @SerializedName("residence_status_enum_id") 
    String residenceStatusEnumId;
    @SerializedName("occupation") 
    String occupation;
    @SerializedName("years_with_employer") 
    Long yearsWithEmployer;
    @SerializedName("months_with_employer") 
    Long monthsWithEmployer;
    @SerializedName("existing_customer") 
    Character existingCustomer;
    @SerializedName("card_id") 
    String cardId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return partyId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PersonFlatData.Builder toDataBuilder() {
        PersonFlatData.Builder builder = PersonFlatData.newBuilder();
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getSalutation() != null) {
            builder.setSalutation(getSalutation());
        }
        if (getFirstName() != null) {
            builder.setFirstName(getFirstName());
        }
        if (getMiddleName() != null) {
            builder.setMiddleName(getMiddleName());
        }
        if (getLastName() != null) {
            builder.setLastName(getLastName());
        }
        if (getPersonalTitle() != null) {
            builder.setPersonalTitle(getPersonalTitle());
        }
        if (getSuffix() != null) {
            builder.setSuffix(getSuffix());
        }
        if (getNickname() != null) {
            builder.setNickname(getNickname());
        }
        if (getFirstNameLocal() != null) {
            builder.setFirstNameLocal(getFirstNameLocal());
        }
        if (getMiddleNameLocal() != null) {
            builder.setMiddleNameLocal(getMiddleNameLocal());
        }
        if (getLastNameLocal() != null) {
            builder.setLastNameLocal(getLastNameLocal());
        }
        if (getOtherLocal() != null) {
            builder.setOtherLocal(getOtherLocal());
        }
        if (getMemberId() != null) {
            builder.setMemberId(getMemberId());
        }
        if (getGender() != null) {
            builder.setGender(getIndicator(getGender()));
        }
        if (getBirthDate() != null) {
            builder.setBirthDate(getDate(getBirthDate()));
        }
        if (getDeceasedDate() != null) {
            builder.setDeceasedDate(getDate(getDeceasedDate()));
        }
        if (getHeight() != null) {
            builder.setHeight(getHeight());
        }
        if (getWeight() != null) {
            builder.setWeight(getWeight());
        }
        if (getMothersMaidenName() != null) {
            builder.setMothersMaidenName(getMothersMaidenName());
        }
        if (getMaritalStatusEnumId() != null) {
            builder.setMaritalStatusEnumId(getMaritalStatusEnumId());
        }
        if (getSocialSecurityNumber() != null) {
            builder.setSocialSecurityNumber(getSocialSecurityNumber());
        }
        if (getPassportNumber() != null) {
            builder.setPassportNumber(getPassportNumber());
        }
        if (getPassportExpireDate() != null) {
            builder.setPassportExpireDate(getDate(getPassportExpireDate()));
        }
        if (getTotalYearsWorkExperience() != null) {
            builder.setTotalYearsWorkExperience(getTotalYearsWorkExperience());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getEmploymentStatusEnumId() != null) {
            builder.setEmploymentStatusEnumId(getEmploymentStatusEnumId());
        }
        if (getResidenceStatusEnumId() != null) {
            builder.setResidenceStatusEnumId(getResidenceStatusEnumId());
        }
        if (getOccupation() != null) {
            builder.setOccupation(getOccupation());
        }
        if (getYearsWithEmployer() != null) {
            builder.setYearsWithEmployer(getYearsWithEmployer());
        }
        if (getMonthsWithEmployer() != null) {
            builder.setMonthsWithEmployer(getMonthsWithEmployer());
        }
        if (getExistingCustomer() != null) {
            builder.setExistingCustomer(getIndicator(getExistingCustomer()));
        }
        if (getCardId() != null) {
            builder.setCardId(getCardId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static Person fromData(PersonFlatData data) {
        return fromPrototype(data).build();
    }

    public static Person.PersonBuilder fromPrototype(PersonFlatData data) {
        return Person.builder()
                .partyId(data.getPartyId())
                .salutation(data.getSalutation())
                .firstName(data.getFirstName())
                .middleName(data.getMiddleName())
                .lastName(data.getLastName())
                .personalTitle(data.getPersonalTitle())
                .suffix(data.getSuffix())
                .nickname(data.getNickname())
                .firstNameLocal(data.getFirstNameLocal())
                .middleNameLocal(data.getMiddleNameLocal())
                .lastNameLocal(data.getLastNameLocal())
                .otherLocal(data.getOtherLocal())
                .memberId(data.getMemberId())
                .gender(getIndicatorChar(data.getGender()))
                .birthDate(getLocalDate(data.getBirthDate()))
                .deceasedDate(getLocalDate(data.getDeceasedDate()))
                .height(data.getHeight())
                .weight(data.getWeight())
                .mothersMaidenName(data.getMothersMaidenName())
                .maritalStatusEnumId(data.getMaritalStatusEnumId())
                .socialSecurityNumber(data.getSocialSecurityNumber())
                .passportNumber(data.getPassportNumber())
                .passportExpireDate(getLocalDate(data.getPassportExpireDate()))
                .totalYearsWorkExperience(data.getTotalYearsWorkExperience())
                .comments(data.getComments())
                .employmentStatusEnumId(data.getEmploymentStatusEnumId())
                .residenceStatusEnumId(data.getResidenceStatusEnumId())
                .occupation(data.getOccupation())
                .yearsWithEmployer(data.getYearsWithEmployer())
                .monthsWithEmployer(data.getMonthsWithEmployer())
                .existingCustomer(getIndicatorChar(data.getExistingCustomer()))
                .cardId(data.getCardId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMech")
    @SerializedName("party_contact_mech") 
    List<PartyContactMech> relPartyContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyContactMechPurpose")
    @SerializedName("party_contact_mech_purpose") 
    List<PartyContactMechPurpose> relPartyContactMechPurpose= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreRole")
    @SerializedName("product_store_role") 
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    @Exclude
    @Singular("addToShipment")
    @SerializedName("to_shipment") 
    List<Shipment> relToShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addFromShipment")
    @SerializedName("from_shipment") 
    List<Shipment> relFromShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addCarrierShipmentRouteSegment")
    @SerializedName("carrier_shipment_route_segment") 
    List<ShipmentRouteSegment> relCarrierShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLogin")
    @SerializedName("user_login") 
    List<UserLogin> relUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARTY, getter(this, Person::getRelParty)); 
        supplierMap.put(PARTY_CONTACT_MECH, getter(this, Person::getRelPartyContactMech)); 
        supplierMap.put(PARTY_CONTACT_MECH_PURPOSE, getter(this, Person::getRelPartyContactMechPurpose)); 
        supplierMap.put(PRODUCT_STORE_ROLE, getter(this, Person::getRelProductStoreRole)); 
        supplierMap.put(TO_SHIPMENT, getter(this, Person::getRelToShipment)); 
        supplierMap.put(FROM_SHIPMENT, getter(this, Person::getRelFromShipment)); 
        supplierMap.put(CARRIER_SHIPMENT_ROUTE_SEGMENT, getter(this, Person::getRelCarrierShipmentRouteSegment)); 
        supplierMap.put(USER_LOGIN, getter(this, Person::getRelUserLogin)); 
        supplierMap.put(TENANT, getter(this, Person::getRelTenant));

        return supplierMap;
    };

    public PersonDelegator.Agent agent(IProc.ProcContext ctx,
                                             PersonDelegator delegator){
        return delegator.getAgent(ctx, this.getPartyId());
    }

    public PersonData.Builder toHeadBuilder() {
        PersonData.Builder builder = PersonData.newBuilder();
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getSalutation() != null) {
            builder.setSalutation(getSalutation());
        }
        if (getFirstName() != null) {
            builder.setFirstName(getFirstName());
        }
        if (getMiddleName() != null) {
            builder.setMiddleName(getMiddleName());
        }
        if (getLastName() != null) {
            builder.setLastName(getLastName());
        }
        if (getPersonalTitle() != null) {
            builder.setPersonalTitle(getPersonalTitle());
        }
        if (getSuffix() != null) {
            builder.setSuffix(getSuffix());
        }
        if (getNickname() != null) {
            builder.setNickname(getNickname());
        }
        if (getFirstNameLocal() != null) {
            builder.setFirstNameLocal(getFirstNameLocal());
        }
        if (getMiddleNameLocal() != null) {
            builder.setMiddleNameLocal(getMiddleNameLocal());
        }
        if (getLastNameLocal() != null) {
            builder.setLastNameLocal(getLastNameLocal());
        }
        if (getOtherLocal() != null) {
            builder.setOtherLocal(getOtherLocal());
        }
        if (getMemberId() != null) {
            builder.setMemberId(getMemberId());
        }
        if (getGender() != null) {
            builder.setGender(getIndicator(getGender()));
        }
        if (getBirthDate() != null) {
            builder.setBirthDate(getDate(getBirthDate()));
        }
        if (getDeceasedDate() != null) {
            builder.setDeceasedDate(getDate(getDeceasedDate()));
        }
        if (getHeight() != null) {
            builder.setHeight(getHeight());
        }
        if (getWeight() != null) {
            builder.setWeight(getWeight());
        }
        if (getMothersMaidenName() != null) {
            builder.setMothersMaidenName(getMothersMaidenName());
        }
        if (getMaritalStatusEnumId() != null) {
            builder.setMaritalStatusEnumId(getMaritalStatusEnumId());
        }
        if (getSocialSecurityNumber() != null) {
            builder.setSocialSecurityNumber(getSocialSecurityNumber());
        }
        if (getPassportNumber() != null) {
            builder.setPassportNumber(getPassportNumber());
        }
        if (getPassportExpireDate() != null) {
            builder.setPassportExpireDate(getDate(getPassportExpireDate()));
        }
        if (getTotalYearsWorkExperience() != null) {
            builder.setTotalYearsWorkExperience(getTotalYearsWorkExperience());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getEmploymentStatusEnumId() != null) {
            builder.setEmploymentStatusEnumId(getEmploymentStatusEnumId());
        }
        if (getResidenceStatusEnumId() != null) {
            builder.setResidenceStatusEnumId(getResidenceStatusEnumId());
        }
        if (getOccupation() != null) {
            builder.setOccupation(getOccupation());
        }
        if (getYearsWithEmployer() != null) {
            builder.setYearsWithEmployer(getYearsWithEmployer());
        }
        if (getMonthsWithEmployer() != null) {
            builder.setMonthsWithEmployer(getMonthsWithEmployer());
        }
        if (getExistingCustomer() != null) {
            builder.setExistingCustomer(getIndicator(getExistingCustomer()));
        }
        if (getCardId() != null) {
            builder.setCardId(getCardId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
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
    Character gender
    java.time.LocalDate birthDate
    java.time.LocalDate deceasedDate
    Double height
    Double weight
    String mothersMaidenName
    String maritalStatusEnumId
    String socialSecurityNumber
    String passportNumber
    java.time.LocalDate passportExpireDate
    Double totalYearsWorkExperience
    String comments
    String employmentStatusEnumId
    String residenceStatusEnumId
    String occupation
    Long yearsWithEmployer
    Long monthsWithEmployer
    Character existingCustomer
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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PersonFlatData;

import com.bluecc.hubs.stub.PersonData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements IEventModel<PersonFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String partyId;
    String salutation;
    String firstName;
    String middleName;
    String lastName;
    String personalTitle;
    String suffix;
    String nickname;
    String firstNameLocal;
    String middleNameLocal;
    String lastNameLocal;
    String otherLocal;
    String memberId;
    Character gender;
    java.time.LocalDate birthDate;
    java.time.LocalDate deceasedDate;
    Double height;
    Double weight;
    String mothersMaidenName;
    String maritalStatusEnumId;
    String socialSecurityNumber;
    String passportNumber;
    java.time.LocalDate passportExpireDate;
    Double totalYearsWorkExperience;
    String comments;
    String employmentStatusEnumId;
    String residenceStatusEnumId;
    String occupation;
    Long yearsWithEmployer;
    Long monthsWithEmployer;
    Character existingCustomer;
    String cardId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PersonFlatData.Builder toDataBuilder() {
        PersonFlatData.Builder builder = PersonFlatData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (salutation != null) {
            builder.setSalutation(salutation);
        }
        if (firstName != null) {
            builder.setFirstName(firstName);
        }
        if (middleName != null) {
            builder.setMiddleName(middleName);
        }
        if (lastName != null) {
            builder.setLastName(lastName);
        }
        if (personalTitle != null) {
            builder.setPersonalTitle(personalTitle);
        }
        if (suffix != null) {
            builder.setSuffix(suffix);
        }
        if (nickname != null) {
            builder.setNickname(nickname);
        }
        if (firstNameLocal != null) {
            builder.setFirstNameLocal(firstNameLocal);
        }
        if (middleNameLocal != null) {
            builder.setMiddleNameLocal(middleNameLocal);
        }
        if (lastNameLocal != null) {
            builder.setLastNameLocal(lastNameLocal);
        }
        if (otherLocal != null) {
            builder.setOtherLocal(otherLocal);
        }
        if (memberId != null) {
            builder.setMemberId(memberId);
        }
        if (gender != null) {
            builder.setGender(getIndicator(gender));
        }
        if (birthDate != null) {
            builder.setBirthDate(getDate(birthDate));
        }
        if (deceasedDate != null) {
            builder.setDeceasedDate(getDate(deceasedDate));
        }
        if (height != null) {
            builder.setHeight(height);
        }
        if (weight != null) {
            builder.setWeight(weight);
        }
        if (mothersMaidenName != null) {
            builder.setMothersMaidenName(mothersMaidenName);
        }
        if (maritalStatusEnumId != null) {
            builder.setMaritalStatusEnumId(maritalStatusEnumId);
        }
        if (socialSecurityNumber != null) {
            builder.setSocialSecurityNumber(socialSecurityNumber);
        }
        if (passportNumber != null) {
            builder.setPassportNumber(passportNumber);
        }
        if (passportExpireDate != null) {
            builder.setPassportExpireDate(getDate(passportExpireDate));
        }
        if (totalYearsWorkExperience != null) {
            builder.setTotalYearsWorkExperience(totalYearsWorkExperience);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (employmentStatusEnumId != null) {
            builder.setEmploymentStatusEnumId(employmentStatusEnumId);
        }
        if (residenceStatusEnumId != null) {
            builder.setResidenceStatusEnumId(residenceStatusEnumId);
        }
        if (occupation != null) {
            builder.setOccupation(occupation);
        }
        if (yearsWithEmployer != null) {
            builder.setYearsWithEmployer(yearsWithEmployer);
        }
        if (monthsWithEmployer != null) {
            builder.setMonthsWithEmployer(monthsWithEmployer);
        }
        if (existingCustomer != null) {
            builder.setExistingCustomer(getIndicator(existingCustomer));
        }
        if (cardId != null) {
            builder.setCardId(cardId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Person fromData(PersonFlatData data) {
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
                
                .build();
    }

        
    public PersonData.Builder toHeadBuilder() {
        PersonData.Builder builder = PersonData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (salutation != null) {
            builder.setSalutation(salutation);
        }
        if (firstName != null) {
            builder.setFirstName(firstName);
        }
        if (middleName != null) {
            builder.setMiddleName(middleName);
        }
        if (lastName != null) {
            builder.setLastName(lastName);
        }
        if (personalTitle != null) {
            builder.setPersonalTitle(personalTitle);
        }
        if (suffix != null) {
            builder.setSuffix(suffix);
        }
        if (nickname != null) {
            builder.setNickname(nickname);
        }
        if (firstNameLocal != null) {
            builder.setFirstNameLocal(firstNameLocal);
        }
        if (middleNameLocal != null) {
            builder.setMiddleNameLocal(middleNameLocal);
        }
        if (lastNameLocal != null) {
            builder.setLastNameLocal(lastNameLocal);
        }
        if (otherLocal != null) {
            builder.setOtherLocal(otherLocal);
        }
        if (memberId != null) {
            builder.setMemberId(memberId);
        }
        if (gender != null) {
            builder.setGender(getIndicator(gender));
        }
        if (birthDate != null) {
            builder.setBirthDate(getDate(birthDate));
        }
        if (deceasedDate != null) {
            builder.setDeceasedDate(getDate(deceasedDate));
        }
        if (height != null) {
            builder.setHeight(height);
        }
        if (weight != null) {
            builder.setWeight(weight);
        }
        if (mothersMaidenName != null) {
            builder.setMothersMaidenName(mothersMaidenName);
        }
        if (maritalStatusEnumId != null) {
            builder.setMaritalStatusEnumId(maritalStatusEnumId);
        }
        if (socialSecurityNumber != null) {
            builder.setSocialSecurityNumber(socialSecurityNumber);
        }
        if (passportNumber != null) {
            builder.setPassportNumber(passportNumber);
        }
        if (passportExpireDate != null) {
            builder.setPassportExpireDate(getDate(passportExpireDate));
        }
        if (totalYearsWorkExperience != null) {
            builder.setTotalYearsWorkExperience(totalYearsWorkExperience);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (employmentStatusEnumId != null) {
            builder.setEmploymentStatusEnumId(employmentStatusEnumId);
        }
        if (residenceStatusEnumId != null) {
            builder.setResidenceStatusEnumId(residenceStatusEnumId);
        }
        if (occupation != null) {
            builder.setOccupation(occupation);
        }
        if (yearsWithEmployer != null) {
            builder.setYearsWithEmployer(yearsWithEmployer);
        }
        if (monthsWithEmployer != null) {
            builder.setMonthsWithEmployer(monthsWithEmployer);
        }
        if (existingCustomer != null) {
            builder.setExistingCustomer(getIndicator(existingCustomer));
        }
        if (cardId != null) {
            builder.setCardId(cardId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}

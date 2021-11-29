package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
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
    Character oldMaritalStatus;
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
    
}

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
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    String invoiceId;
    String invoiceTypeId;
    String partyIdFrom;
    String partyId;
    String roleTypeId;
    String statusId;
    String billingAccountId;
    String contactMechId;
    java.time.LocalDateTime invoiceDate;
    java.time.LocalDateTime dueDate;
    java.time.LocalDateTime paidDate;
    String invoiceMessage;
    String referenceNumber;
    String description;
    String currencyUomId;
    String recurrenceInfoId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    
}

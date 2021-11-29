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
public class OrderHeader implements Serializable {
    private static final long serialVersionUID = 1L;

    String orderId;
    String orderTypeId;
    String orderName;
    String externalId;
    String salesChannelEnumId;
    java.time.LocalDateTime orderDate;
    Character priority;
    java.time.LocalDateTime entryDate;
    java.time.LocalDateTime pickSheetPrintedDate;
    String visitId;
    String statusId;
    String createdBy;
    String firstAttemptOrderId;
    String currencyUom;
    String syncStatusId;
    String billingAccountId;
    String originFacilityId;
    String webSiteId;
    String productStoreId;
    String agreementId;
    String terminalId;
    String transactionId;
    String autoOrderShoppingListId;
    Character needsInventoryIssuance;
    Character isRushOrder;
    String internalCode;
    java.math.BigDecimal remainingSubTotal;
    java.math.BigDecimal grandTotal;
    Character isViewed;
    Character invoicePerShipment;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    
}

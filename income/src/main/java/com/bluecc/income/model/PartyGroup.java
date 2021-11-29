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
public class PartyGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    String partyId;
    String groupName;
    String groupNameLocal;
    String officeSiteName;
    java.math.BigDecimal annualRevenue;
    Long numEmployees;
    String tickerSymbol;
    String comments;
    java.net.URI logoImageUrl;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    
}

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
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    String userLoginId;
    String currentPassword;
    String passwordHint;
    Character isSystem;
    Character enabled;
    Character hasLoggedOut;
    Character requirePasswordChange;
    String lastCurrencyUom;
    String lastLocale;
    String lastTimeZone;
    java.time.LocalDateTime disabledDateTime;
    Long successiveFailedLogins;
    String externalAuthId;
    String userLdapDn;
    String disabledBy;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String partyId;
    
}

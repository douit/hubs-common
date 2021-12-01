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
public class ProdCatalog implements Serializable {
    private static final long serialVersionUID = 1L;

    String prodCatalogId;
    String catalogName;
    Character useQuickAdd;
    java.net.URI styleSheet;
    java.net.URI headerLogo;
    String contentPathPrefix;
    String templatePathPrefix;
    Character viewAllowPermReqd;
    Character purchaseAllowPermReqd;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    
}

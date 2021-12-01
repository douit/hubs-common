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
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    String productCategoryId;
    String productCategoryTypeId;
    String primaryParentCategoryId;
    String categoryName;
    String description;
    String longDescription;
    java.net.URI categoryImageUrl;
    java.net.URI linkOneImageUrl;
    java.net.URI linkTwoImageUrl;
    String detailScreen;
    Character showInSelect;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    
}

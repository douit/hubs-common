package com.bluecc.domain.simplify.dto;

import lombok.Data;
import org.joda.time.LocalDate;

@Data
public class OrderDelivery {

    private String deliveryStatusCode;

    private LocalDate reportedDate;

}


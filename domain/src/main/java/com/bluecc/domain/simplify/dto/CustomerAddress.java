package com.bluecc.domain.simplify.dto;

import lombok.Data;
import org.joda.time.LocalDate;

@Data
public class CustomerAddress {

    private Address address;

    private String addressTypeCode;

    private LocalDate fromDate, toDate;

}


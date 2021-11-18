package com.bluecc.domain.simplify.dto;

import lombok.Data;

@Data
public class Address {

    private Long id;

    private String street, zip, town, state, country;

    private String otherDetails;

}


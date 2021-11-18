package com.bluecc.domain.simplify.dto;

import lombok.Data;

import java.util.Set;

@Data
public class Customer {

    private Long id;

    private Person contactPerson;

    private String name;

    private Set<CustomerAddress> addresses;

}


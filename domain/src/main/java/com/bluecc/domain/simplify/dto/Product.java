package com.bluecc.domain.simplify.dto;

import lombok.Data;

import java.util.Set;

@Data
public class Product {

    private Long id;

    private String name;

    private String otherProductDetails;

    private Double price;

    private Supplier supplier;

    private Set<ProductL10n> localizations;
}


package com.bluecc.domain.simplify.dto;

import lombok.Data;
import org.joda.time.LocalDate;

import java.util.Set;

@Data
public class Order {

    private Long id;

    private CustomerPaymentMethod customerPaymentMethod;

    private LocalDate orderPlacedDate, orderPaidDate;

    private String orderStatus;

    private Double totalOrderPrice;

    private Set<OrderProduct> orderProducts;

}


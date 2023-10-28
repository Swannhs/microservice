package com.swann.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLineItem {
    private String skuCode;
    private Double price;
    private Integer quantity;
}

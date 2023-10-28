package com.swann.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private String orderNumber;
    private List<OrderLineItem> orderLineItems;
}

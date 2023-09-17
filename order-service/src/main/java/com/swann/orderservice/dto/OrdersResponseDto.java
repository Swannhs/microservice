package com.swann.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.swann.orderservice.model.Order}
 */
@Getter
@Setter
public class OrdersResponseDto implements Serializable {
    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItems;
}
package com.swann.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.swann.orderservice.model.Order}
 */
@Getter
@Setter
public class OrderCreateRequestDto implements Serializable {
    List<OrderLineItemsDto> orderLineItems;
}
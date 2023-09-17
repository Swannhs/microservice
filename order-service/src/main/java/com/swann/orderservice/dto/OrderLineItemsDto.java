package com.swann.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.swann.orderservice.model.OrderLineItems}
 */
@Getter
@Setter
public class OrderLineItemsDto implements Serializable {
    String skuCode;
    BigDecimal price;
    Integer quantity;
}
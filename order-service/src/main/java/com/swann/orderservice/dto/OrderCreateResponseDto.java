package com.swann.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.swann.orderservice.model.Order}
 */
@Getter
@Setter
public class OrderCreateResponseDto implements Serializable {
    private List<OrderLineItemsDto> orderLineItems;
}
package com.swann.inventoryservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
@Getter
@Setter
public class InventoryResponseDto implements Serializable {
    private String skuCode;
    private Integer quantity;
}
package com.swann.inventoryservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link com.swann.inventoryservice.model.Inventory}
 */
@Getter
@Setter
public class InventoryCreateRequestDto implements Serializable {
    private String skuCode;
    private Integer quantity;
}
package com.swann.inventoryservice.dto;

import com.swann.inventoryservice.model.Inventory;
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
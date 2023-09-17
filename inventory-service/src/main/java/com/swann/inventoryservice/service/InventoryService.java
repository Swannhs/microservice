package com.swann.inventoryservice.service;

import com.swann.inventoryservice.dto.InventoryCreateRequestDto;
import com.swann.inventoryservice.dto.InventoryResponseDto;

import java.util.List;

public interface InventoryService {
    List<InventoryResponseDto> getAllInventory();
    InventoryResponseDto createInventory(InventoryCreateRequestDto inventoryCreateRequestDto);
}

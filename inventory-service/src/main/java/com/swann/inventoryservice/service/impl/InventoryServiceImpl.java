package com.swann.inventoryservice.service.impl;

import com.swann.inventoryservice.dto.InventoryCreateRequestDto;
import com.swann.inventoryservice.model.Inventory;
import com.swann.inventoryservice.model.InventoryResponseDto;
import com.swann.inventoryservice.repository.InventoryRepository;
import com.swann.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final ModelMapper modelMapper;
    private final InventoryRepository inventoryRepository;

    @Override
    public List<InventoryResponseDto> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        return inventoryList.stream()
                .map(inventory -> modelMapper.map(inventory, InventoryResponseDto.class))
                .toList();
    }

    @Override
    public InventoryResponseDto createInventory(InventoryCreateRequestDto inventoryCreateRequestDto) {
        Inventory inventory = modelMapper.map(inventoryCreateRequestDto, Inventory.class);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return modelMapper.map(savedInventory, InventoryResponseDto.class);
    }
}

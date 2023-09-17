package com.swann.inventoryservice.service;

import com.swann.inventoryservice.dto.InventoryCreateRequestDto;
import com.swann.inventoryservice.dto.InventoryResponseDto;
import com.swann.inventoryservice.model.Inventory;
import com.swann.inventoryservice.repository.InventoryRepository;
import com.swann.inventoryservice.service.impl.InventoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllInventory() {
        Inventory inventory = new Inventory(); // Initialize with test data
        InventoryResponseDto inventoryResponseDto = new InventoryResponseDto(); // Initialize with test data

        when(inventoryRepository.findAll()).thenReturn(Collections.singletonList(inventory));
        when(modelMapper.map(inventory, InventoryResponseDto.class)).thenReturn(inventoryResponseDto);

        List<InventoryResponseDto> result = inventoryService.getAllInventory();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        // Add more assertions to validate the content of the result, if necessary

        verify(inventoryRepository, times(1)).findAll();
        verify(modelMapper, times(1)).map(inventory, InventoryResponseDto.class);
    }

    @Test
    public void testCreateAndGetInventory() {
        InventoryCreateRequestDto requestDto = new InventoryCreateRequestDto();
        requestDto.setSkuCode("12345");
        requestDto.setQuantity(10);

        Inventory inventory = new Inventory(); // Initialize with test data
        inventory.setSkuCode("12345");
        inventory.setQuantity(10);

        InventoryResponseDto responseDto = new InventoryResponseDto();
        responseDto.setSkuCode("12345");
        responseDto.setQuantity(10);

        // Mock the service's interactions
        when(modelMapper.map(requestDto, Inventory.class)).thenReturn(inventory);
        when(inventoryRepository.save(inventory)).thenReturn(inventory); // For simplicity, assuming the saved inventory is same as input
        when(inventoryRepository.findAll()).thenReturn(Collections.singletonList(inventory));
        when(modelMapper.map(inventory, InventoryResponseDto.class)).thenReturn(responseDto);

        // Test the create functionality
        InventoryResponseDto createResult = inventoryService.createInventory(requestDto);
        assertThat(createResult).isNotNull();
        assertThat(createResult.getSkuCode()).isEqualTo("12345");
        assertThat(createResult.getQuantity()).isEqualTo(10);

        // Test the getAll functionality
        List<InventoryResponseDto> getAllResult = inventoryService.getAllInventory();
        assertThat(getAllResult).isNotNull();
        assertThat(getAllResult.size()).isEqualTo(1);
        assertThat(getAllResult.get(0).getSkuCode()).isEqualTo("12345");
        assertThat(getAllResult.get(0).getQuantity()).isEqualTo(10);

        // Verify the mocked interactions
        verify(modelMapper, times(1)).map(requestDto, Inventory.class);
        verify(inventoryRepository, times(1)).save(inventory);
        verify(inventoryRepository, times(1)).findAll();
        verify(modelMapper, times(2)).map(inventory, InventoryResponseDto.class); // Once for create, once for getAll
    }

    // Add more tests as needed
}

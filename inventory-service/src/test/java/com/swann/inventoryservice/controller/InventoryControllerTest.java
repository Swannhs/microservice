package com.swann.inventoryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swann.inventoryservice.dto.InventoryCreateRequestDto;
import com.swann.inventoryservice.dto.InventoryResponseDto;
import com.swann.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InventoryService inventoryService;

    @BeforeEach
    public void setUp() {
        InventoryResponseDto responseDto = new InventoryResponseDto();
        responseDto.setSkuCode("12345");
        responseDto.setQuantity(10);

        when(inventoryService.getAllInventory()).thenReturn(Collections.singletonList(responseDto));
        when(inventoryService.createInventory(any(InventoryCreateRequestDto.class))).thenReturn(responseDto);
    }

    @Test
    public void testGetAllInventory() throws Exception {
        mockMvc.perform(get("/api/inventory")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].skuCode").value("12345"))
                .andExpect(jsonPath("$[0].quantity").value(10));
    }

    @Test
    public void testCreateInventory() throws Exception {
        InventoryCreateRequestDto requestDto = new InventoryCreateRequestDto();
        requestDto.setSkuCode("12345");
        requestDto.setQuantity(10);

        mockMvc.perform(post("/api/inventory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.skuCode").value("12345"))
                .andExpect(jsonPath("$.quantity").value(10));
    }
}
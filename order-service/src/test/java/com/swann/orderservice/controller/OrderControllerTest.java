package com.swann.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swann.orderservice.dto.OrderCreateRequestDto;
import com.swann.orderservice.dto.OrderCreateResponseDto;
import com.swann.orderservice.dto.OrderLineItemsDto;
import com.swann.orderservice.dto.OrdersResponseDto;
import com.swann.orderservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testGetAllOrders() throws Exception {
        OrdersResponseDto responseDto = new OrdersResponseDto();
        when(orderService.getAllOrders()).thenReturn(Collections.singletonList(responseDto));

        mockMvc.perform(get("/api/order"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateOrder() throws Exception {
        // Given
        OrderCreateRequestDto requestDto = new OrderCreateRequestDto();
        OrderLineItemsDto orderLineItemDto = new OrderLineItemsDto();
        orderLineItemDto.setSkuCode("12345");
        orderLineItemDto.setPrice(BigDecimal.valueOf(12));
        orderLineItemDto.setQuantity(10);
        requestDto.setOrderLineItems(Collections.singletonList(orderLineItemDto));

        OrderCreateResponseDto responseDto = new OrderCreateResponseDto();
        responseDto.setOrderNumber("c80bb992-1f84-4c24-8355-8dbb389936e6");
        // Initialize the list of orderLineItems in responseDto

        when(orderService.createOrder(requestDto)).thenReturn(responseDto);

        // When & Then
        mockMvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated());
    }
}
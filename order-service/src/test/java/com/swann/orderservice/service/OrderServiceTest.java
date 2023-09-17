package com.swann.orderservice.service;

import com.swann.orderservice.dto.OrderCreateRequestDto;
import com.swann.orderservice.dto.OrderCreateResponseDto;
import com.swann.orderservice.dto.OrderLineItemsDto;
import com.swann.orderservice.dto.OrdersResponseDto;
import com.swann.orderservice.model.Order;
import com.swann.orderservice.repository.OrderRepository;
import com.swann.orderservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOrders() {
        Order order = new Order(); // Set fields as required
        OrdersResponseDto response = new OrdersResponseDto(); // Set fields as required

        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));
        when(modelMapper.map(order, OrdersResponseDto.class)).thenReturn(response);

        List<OrdersResponseDto> orders = orderService.getAllOrders();
        assertThat(orders).hasSize(1);
        // Add more assertions as needed

        verify(orderRepository).findAll();
        verify(modelMapper).map(order, OrdersResponseDto.class);
    }

    @Test
    public void testCreateOrder() {
        // Order line item for request
        OrderLineItemsDto lineItemDto = new OrderLineItemsDto();
        lineItemDto.setSkuCode("SKU123");
        lineItemDto.setPrice(BigDecimal.valueOf(100.00));
        lineItemDto.setQuantity(2);

        // Request
        OrderCreateRequestDto request = new OrderCreateRequestDto();
        request.setOrderLineItems(Collections.singletonList(lineItemDto));

        // Order before save
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        // ... set other fields as required ...

        // Order after save (typically with an ID assigned by the database)
        Order savedOrder = new Order();
        savedOrder.setId(1L);
        savedOrder.setOrderNumber(order.getOrderNumber());
        // ... set other fields similar to 'order' ...

        // Response
        OrderCreateResponseDto response = new OrderCreateResponseDto();
        response.setOrderNumber(savedOrder.getOrderNumber());
        // ... set other fields as required ...

        when(modelMapper.map(request, Order.class)).thenReturn(order);
        when(orderRepository.save(order)).thenReturn(savedOrder);
        when(modelMapper.map(savedOrder, OrderCreateResponseDto.class)).thenReturn(response);

        OrderCreateResponseDto result = orderService.createOrder(request);
        assertThat(result).isNotNull();
        assertThat(result.getOrderNumber()).isEqualTo(response.getOrderNumber());
        // Add more assertions as needed

        verify(modelMapper).map(request, Order.class);
        verify(orderRepository).save(order);
        verify(modelMapper).map(savedOrder, OrderCreateResponseDto.class);
    }
}

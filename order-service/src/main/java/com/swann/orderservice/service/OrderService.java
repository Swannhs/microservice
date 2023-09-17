package com.swann.orderservice.service;

import com.swann.orderservice.dto.OrderCreateRequestDto;
import com.swann.orderservice.dto.OrderCreateResponseDto;
import com.swann.orderservice.dto.OrdersResponseDto;

import java.util.List;

public interface OrderService {
    List<OrdersResponseDto> getAllOrders();
    OrderCreateResponseDto createOrder(OrderCreateRequestDto orderCreateRequestDto);
}

package com.swann.orderservice.service.impl;

import com.swann.orderservice.dto.OrderCreateRequestDto;
import com.swann.orderservice.dto.OrderCreateResponseDto;
import com.swann.orderservice.dto.OrdersResponseDto;
import com.swann.orderservice.model.Order;
import com.swann.orderservice.repository.OrderRepository;
import com.swann.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;

    @Override
    public List<OrdersResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrdersResponseDto.class)).toList();
    }

    @Override
    public OrderCreateResponseDto createOrder(OrderCreateRequestDto orderCreateRequestDto) {
        Order order = modelMapper.map(orderCreateRequestDto, Order.class);
        order.setOrderNumber(UUID.randomUUID().toString());
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderCreateResponseDto.class);
    }
}

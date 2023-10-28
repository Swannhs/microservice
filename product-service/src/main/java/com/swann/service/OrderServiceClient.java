package com.swann.service;

import com.swann.response.OrderResponse;

import java.util.List;

public interface OrderServiceClient {
    List<OrderResponse> getAllOrders();
}

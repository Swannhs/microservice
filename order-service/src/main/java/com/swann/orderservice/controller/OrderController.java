package com.swann.orderservice.controller;

import com.swann.orderservice.dto.OrderCreateRequestDto;
import com.swann.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Tag(name = "Order", description = "Order API")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Get all orders")
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create order")
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateRequestDto orderCreateRequestDto) {
        return new ResponseEntity<>(orderService.createOrder(orderCreateRequestDto), HttpStatus.CREATED);
    }
}
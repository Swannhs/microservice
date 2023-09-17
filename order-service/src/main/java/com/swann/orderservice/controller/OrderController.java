package com.swann.orderservice.controller;

import com.swann.orderservice.dto.OrderCreateRequestDto;
import com.swann.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateRequestDto orderCreateRequestDto) {
        return new ResponseEntity<>(orderService.createOrder(orderCreateRequestDto), HttpStatus.CREATED);
    }
}

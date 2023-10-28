package com.swann.service.impl;

import com.swann.response.OrderResponse;
import com.swann.service.OrderServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceClientImpl implements OrderServiceClient {
    private final WebClient.Builder webClientBuilder;

    @Override
    public List<OrderResponse> getAllOrders() {
        WebClient webClient = webClientBuilder.build();

        Flux<OrderResponse> orderResponseFlux = webClient.get()
                .uri("/api/order")
                .retrieve()
                .bodyToFlux(OrderResponse.class);

        return orderResponseFlux.collectList().block();
    }
}

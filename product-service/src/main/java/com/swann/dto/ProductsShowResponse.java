package com.swann.dto;

import com.swann.response.OrderResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsShowResponse {
    private String id;
    private String name;
    private String description;
    private Double price;
    List<OrderResponse> orders;
}

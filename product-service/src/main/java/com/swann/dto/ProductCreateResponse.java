package com.swann.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateResponse {
    private String id;
    private String name;
    private String description;
    private Double price;
}

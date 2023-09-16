package com.swann.service;

import com.swann.dto.ProductCreateRequest;
import com.swann.dto.ProductCreateResponse;
import com.swann.dto.ProductsShowResponse;

import java.util.List;

public interface ProductService {
    ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest);

    List<ProductsShowResponse> getAllProducts();
}

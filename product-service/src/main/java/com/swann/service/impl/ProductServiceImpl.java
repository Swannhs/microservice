package com.swann.service.impl;

import com.swann.dto.ProductCreateRequest;
import com.swann.dto.ProductCreateResponse;
import com.swann.dto.ProductsShowResponse;
import com.swann.model.Product;
import com.swann.repository.ProductRepository;
import com.swann.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Override
    public List<ProductsShowResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductsShowResponse.class)).toList();
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest) {
        Product product = productRepository.save(modelMapper.map(productCreateRequest, Product.class));
        return modelMapper.map(product, ProductCreateResponse.class);
    }
}

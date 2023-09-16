package com.swann.service;

import com.swann.dto.ProductCreateRequest;
import com.swann.dto.ProductCreateResponse;
import com.swann.dto.ProductsShowResponse;
import com.swann.model.Product;
import com.swann.repository.ProductRepository;
import com.swann.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private ProductServiceImpl productService; // Use the implementation, not the interface

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Mocking
        Product product = new Product("1", "Test Product", "Description", 100.0);
        ProductsShowResponse response = new ProductsShowResponse();
        response.setId("1");
        response.setName("Test Product");
        response.setDescription("Description");
        response.setPrice(100.0);

        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        when(modelMapper.map(product, ProductsShowResponse.class)).thenReturn(response);

        // Testing
        List<ProductsShowResponse> products = productService.getAllProducts();
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Test Product");

        // Verify interactions
        verify(productRepository).findAll();
        verify(modelMapper).map(product, ProductsShowResponse.class);
    }

    @Test
    public void testCreateProduct() {
        // Mocking
        ProductCreateRequest request = new ProductCreateRequest();
        request.setName("Test Product");
        request.setDescription("Description");
        request.setPrice(100.0);

        Product product = new Product("1", "Test Product", "Description", 100.0);
        ProductCreateResponse response = new ProductCreateResponse();
        response.setId("1");
        response.setName("Test Product");

        when(modelMapper.map(request, Product.class)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(modelMapper.map(product, ProductCreateResponse.class)).thenReturn(response);

        // Testing
        ProductCreateResponse result = productService.createProduct(request);
        assertThat(result.getId()).isEqualTo("1");
        assertThat(result.getName()).isEqualTo("Test Product");

        // Verify interactions
        verify(modelMapper).map(request, Product.class);
        verify(productRepository).save(product);
        verify(modelMapper).map(product, ProductCreateResponse.class);
    }

    // Add more tests for other service methods as needed.
}

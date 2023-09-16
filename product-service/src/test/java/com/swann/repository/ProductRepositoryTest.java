package com.swann.repository;

import com.swann.configuration.TestcontainersConfig;
import com.swann.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Testcontainers
public class ProductRepositoryTest extends TestcontainersConfig {
    @Autowired
    private ProductRepository productRepository;
    @BeforeEach
    public void setup() {
        productRepository.deleteAll();
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product(null, "Test Product", "Description", 100.0);
        Product savedProduct = productRepository.save(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("Test Product");
    }

    // Add more tests for other repository methods as needed.
}

package com.swann.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swann.dto.ProductCreateRequest;
import com.swann.dto.ProductCreateResponse;
import com.swann.dto.ProductsShowResponse;
import com.swann.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
        ProductsShowResponse response = new ProductsShowResponse();
        response.setId("1");
        response.setName("Test Product");
        response.setDescription("Description");
        response.setPrice(100.0);

        when(productService.getAllProducts()).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/api/product"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'1', 'name':'Test Product', 'description':'Description', 'price':100.0}]"));
    }

    @Test
    public void testCreateProduct() throws Exception {
        ProductCreateRequest request = new ProductCreateRequest();
        request.setName("Pen");
        request.setDescription("this is content");
        request.setPrice(10.0);

        // Assuming that the service returns a response with an ID and the same name, description, and price
        ProductCreateResponse response = new ProductCreateResponse();
        response.setId("650618ace1af7707a5531fc0"); // This ID will be ignored in the comparison
        response.setName("Pen");
        response.setDescription("this is content");
        response.setPrice(10.0);

        when(productService.createProduct(request)).thenReturn(response);

        mockMvc.perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
//                .andExpect(content().json("{\"name\":\"Pen\", \"description\":\"this is content\", \"price\":10.0}"))
//                .andExpect(jsonPath("$.id").exists()); //TODO: Will implement later
    }

    // Add more tests for other controller endpoints as needed.
}

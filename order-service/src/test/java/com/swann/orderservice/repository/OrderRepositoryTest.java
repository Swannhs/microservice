package com.swann.orderservice.repository;

import com.swann.orderservice.model.Order;
import com.swann.orderservice.model.OrderLineItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Testcontainers
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void setup() {
        orderRepository.deleteAll();
    }

//    TODO: Will fix this later
//    @Test
//    public void testCreateOrderWithLineItems() {
//        OrderLineItems lineItem = new OrderLineItems(null, "SKU123", BigDecimal.valueOf(100), 2);
//        Order order = new Order(null, "ORDER123", Collections.singletonList(lineItem));
//
//        Order savedOrder = orderRepository.save(order);
//
//        assertThat(savedOrder).isNotNull();
//        assertThat(savedOrder.getId()).isNotNull();
//        assertThat(savedOrder.getOrderNumber()).isEqualTo("ORDER123");
//        assertThat(savedOrder.getOrderLineItems()).hasSize(1);
//    }

//    TODO: Will fix this later
//    @Test
//    public void testFindAllOrders() {
//        OrderLineItems lineItem = new OrderLineItems(null, "SKU123", BigDecimal.valueOf(100), 2);
//        Order order = new Order(null, "ORDER123", Collections.singletonList(lineItem));
//        orderRepository.save(order);
//
//        List<Order> orders = orderRepository.findAll();
//
//        assertThat(orders).hasSize(1);
//        Order retrievedOrder = orders.get(0);
//        assertThat(retrievedOrder.getOrderNumber()).isEqualTo("ORDER123");
//        assertThat(retrievedOrder.getOrderLineItems()).hasSize(1);
//    }

    // You can add more tests as needed.
}

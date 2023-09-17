package com.swann.inventoryservice.repository;

import com.swann.inventoryservice.model.Inventory;
import com.swann.inventoryservice.configuration.TestcontainersConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfig.class)
public class InventoryRepositoryTest {

    @Autowired
    private InventoryRepository inventoryRepository;

    @BeforeEach
    public void setup() {
        inventoryRepository.deleteAll();
    }

//    @Test
//    public void testSaveAndFindInventory() {
//        Inventory inventory = new Inventory();
//        inventory.setSkuCode("SKU123");
//        inventory.setQuantity(10);
//
//        // Save
//        Inventory savedInventory = inventoryRepository.save(inventory);
//        assertThat(savedInventory).isNotNull();
//        assertThat(savedInventory.getId()).isNotNull();
//
//        // Find by ID
//        Optional<Inventory> foundInventory = inventoryRepository.findById(savedInventory.getId());
//        assertThat(foundInventory).isPresent();
//        assertThat(foundInventory.get().getSkuCode()).isEqualTo("SKU123");
//        assertThat(foundInventory.get().getQuantity()).isEqualTo(10);
//    }

    // Add more tests as needed
}

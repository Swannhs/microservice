package com.swann.inventoryservice.controller;

import com.swann.inventoryservice.dto.InventoryCreateRequestDto;
import com.swann.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<?> getAllInventory() {
        return new ResponseEntity<>(inventoryService.getAllInventory(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createInventory(@RequestBody InventoryCreateRequestDto inventoryCreateRequestDto) {
        return new ResponseEntity<>(inventoryService.createInventory(inventoryCreateRequestDto), HttpStatus.CREATED);
    }
}

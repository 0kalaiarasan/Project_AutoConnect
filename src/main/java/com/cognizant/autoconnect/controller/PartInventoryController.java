package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.PartInventory;
import com.cognizant.autoconnect.service.PartInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/part-inventory")
@RequiredArgsConstructor
public class PartInventoryController {

    private final PartInventoryService inventoryService;

    @PostMapping
    public ResponseEntity<PartInventory> addInventory(@RequestBody PartInventory inventory) {
        return new ResponseEntity<>(inventoryService.addInventory(inventory), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartInventory> getInventoryById(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryService.getInventoryById(id));
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<PartInventory>> getInventoryByLocation(@PathVariable Long locationId) {
        return ResponseEntity.ok(inventoryService.getInventoryByLocation(locationId));
    }

    @GetMapping
    public ResponseEntity<List<PartInventory>> getAllInventory() {
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartInventory> updateInventory(@PathVariable Long id, @RequestBody PartInventory inventory) {
        return ResponseEntity.ok(inventoryService.updateInventory(id, inventory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
}

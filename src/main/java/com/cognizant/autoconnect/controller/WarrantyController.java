package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Warranty;
import com.cognizant.autoconnect.service.WarrantyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranties")
@RequiredArgsConstructor
public class WarrantyController {

    private final WarrantyService warrantyService;

    @PostMapping
    public ResponseEntity<Warranty> createWarranty(@RequestBody Warranty warranty) {
        return new ResponseEntity<>(warrantyService.createWarranty(warranty), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warranty> getWarrantyById(@PathVariable Long id) {
        return ResponseEntity.ok(warrantyService.getWarrantyById(id));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Warranty>> getWarrantiesByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(warrantyService.getWarrantiesByVehicle(vehicleId));
    }

    @GetMapping
    public ResponseEntity<List<Warranty>> getAllWarranties() {
        return ResponseEntity.ok(warrantyService.getAllWarranties());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warranty> updateWarranty(@PathVariable Long id, @RequestBody Warranty warranty) {
        return ResponseEntity.ok(warrantyService.updateWarranty(id, warranty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarranty(@PathVariable Long id) {
        warrantyService.deleteWarranty(id);
        return ResponseEntity.noContent().build();
    }
}

package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.WarrantyClaim;
import com.cognizant.autoconnect.service.WarrantyClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty-claims")
@RequiredArgsConstructor
public class WarrantyClaimController {

    private final WarrantyClaimService claimService;

    @PostMapping
    public ResponseEntity<WarrantyClaim> createClaim(@RequestBody WarrantyClaim claim) {
        return new ResponseEntity<>(claimService.createClaim(claim), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaim> getClaimById(@PathVariable Long id) {
        return ResponseEntity.ok(claimService.getClaimById(id));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<WarrantyClaim>> getClaimsByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(claimService.getClaimsByVehicle(vehicleId));
    }

    @GetMapping("/woid/{woid}")
    public ResponseEntity<List<WarrantyClaim>> getClaimsByWorkOrder(@PathVariable Long woid) {
        return ResponseEntity.ok(claimService.getClaimsByWorkOrder(woid));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaim>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarrantyClaim> updateClaim(@PathVariable Long id, @RequestBody WarrantyClaim claim) {
        return ResponseEntity.ok(claimService.updateClaim(id, claim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}

package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Commission;
import com.cognizant.autoconnect.service.CommissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commissions")
@RequiredArgsConstructor
public class CommissionController {

    private final CommissionService commissionService;

    @PostMapping
    public ResponseEntity<Commission> createCommission(@RequestBody Commission commission) {
        return new ResponseEntity<>(commissionService.createCommission(commission), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commission> getCommissionById(@PathVariable Long id) {
        return ResponseEntity.ok(commissionService.getCommissionById(id));
    }

    @GetMapping("/salesperson/{salespersonId}")
    public ResponseEntity<List<Commission>> getCommissionsBySalesperson(@PathVariable Long salespersonId) {
        return ResponseEntity.ok(commissionService.getCommissionsBySalesperson(salespersonId));
    }

    @GetMapping
    public ResponseEntity<List<Commission>> getAllCommissions() {
        return ResponseEntity.ok(commissionService.getAllCommissions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commission> updateCommission(@PathVariable Long id, @RequestBody Commission commission) {
        return ResponseEntity.ok(commissionService.updateCommission(id, commission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommission(@PathVariable Long id) {
        commissionService.deleteCommission(id);
        return ResponseEntity.noContent().build();
    }
}

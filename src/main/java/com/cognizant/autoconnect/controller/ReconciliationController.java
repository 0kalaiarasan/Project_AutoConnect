package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Reconciliation;
import com.cognizant.autoconnect.service.ReconciliationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reconciliations")
@RequiredArgsConstructor
public class ReconciliationController {

    private final ReconciliationService reconciliationService;

    @PostMapping
    public ResponseEntity<Reconciliation> createReconciliation(@RequestBody Reconciliation reconciliation) {
        return new ResponseEntity<>(reconciliationService.createReconciliation(reconciliation), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reconciliation> getReconciliationById(@PathVariable Long id) {
        return ResponseEntity.ok(reconciliationService.getReconciliationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Reconciliation>> getAllReconciliations() {
        return ResponseEntity.ok(reconciliationService.getAllReconciliations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reconciliation> updateReconciliation(@PathVariable Long id, @RequestBody Reconciliation reconciliation) {
        return ResponseEntity.ok(reconciliationService.updateReconciliation(id, reconciliation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReconciliation(@PathVariable Long id) {
        reconciliationService.deleteReconciliation(id);
        return ResponseEntity.noContent().build();
    }
}

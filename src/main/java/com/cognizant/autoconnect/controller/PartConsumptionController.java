package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.PartConsumption;
import com.cognizant.autoconnect.service.PartConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/part-consumption")
@RequiredArgsConstructor
public class PartConsumptionController {

    private final PartConsumptionService consumptionService;

    @PostMapping
    public ResponseEntity<PartConsumption> createConsumption(@RequestBody PartConsumption consumption) {
        return new ResponseEntity<>(consumptionService.createConsumption(consumption), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartConsumption> getConsumptionById(@PathVariable Long id) {
        return ResponseEntity.ok(consumptionService.getConsumptionById(id));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<PartConsumption>> getConsumptionByJob(@PathVariable Long jobId) {
        return ResponseEntity.ok(consumptionService.getConsumptionByJobId(jobId));
    }

    @GetMapping
    public ResponseEntity<List<PartConsumption>> getAllConsumptions() {
        return ResponseEntity.ok(consumptionService.getAllConsumptions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartConsumption> updateConsumption(@PathVariable Long id, @RequestBody PartConsumption consumption) {
        return ResponseEntity.ok(consumptionService.updateConsumption(id, consumption));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumption(@PathVariable Long id) {
        consumptionService.deleteConsumption(id);
        return ResponseEntity.noContent().build();
    }
}

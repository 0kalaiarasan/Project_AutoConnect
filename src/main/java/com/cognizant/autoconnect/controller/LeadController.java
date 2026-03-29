package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Lead;
import com.cognizant.autoconnect.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        return new ResponseEntity<>(leadService.createLead(lead), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.getLeadById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Lead>> getLeadsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(leadService.getLeadsByCustomerId(customerId));
    }

    @GetMapping("/assigned/{userId}")
    public ResponseEntity<List<Lead>> getLeadsByAssignedUser(@PathVariable Long userId) {
        return ResponseEntity.ok(leadService.getLeadsByAssignedUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @RequestBody Lead lead) {
        return ResponseEntity.ok(leadService.updateLead(id, lead));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}

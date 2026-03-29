package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.AuditPackage;
import com.cognizant.autoconnect.service.AuditPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-packages")
@RequiredArgsConstructor
public class AuditPackageController {

    private final AuditPackageService packageService;

    @PostMapping
    public ResponseEntity<AuditPackage> createAuditPackage(@RequestBody AuditPackage auditPackage) {
        return new ResponseEntity<>(packageService.createAuditPackage(auditPackage), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditPackage> getAuditPackageById(@PathVariable Long id) {
        return ResponseEntity.ok(packageService.getAuditPackageById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuditPackage>> getAllPackages() {
        return ResponseEntity.ok(packageService.getAllPackages());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditPackage> updateAuditPackage(@PathVariable Long id, @RequestBody AuditPackage auditPackage) {
        return ResponseEntity.ok(packageService.updateAuditPackage(id, auditPackage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditPackage(@PathVariable Long id) {
        packageService.deleteAuditPackage(id);
        return ResponseEntity.noContent().build();
    }
}

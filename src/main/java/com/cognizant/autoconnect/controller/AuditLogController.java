package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.AuditLog;
import com.cognizant.autoconnect.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogService auditLogService;

    @PostMapping
    public ResponseEntity<AuditLog> createAuditLog(@RequestBody AuditLog auditLog) {
        return new ResponseEntity<>(auditLogService.createAuditLog(auditLog), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLog>> getAuditLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(auditLogService.getAuditLogsByUserId(userId));
    }

    @GetMapping("/resource/{resourceType}/{resourceId}")
    public ResponseEntity<List<AuditLog>> getAuditLogsByResource(
            @PathVariable String resourceType, 
            @PathVariable Long resourceId) {
        return ResponseEntity.ok(auditLogService.getAuditLogsByResource(resourceType, resourceId));
    }

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
        return ResponseEntity.ok(auditLogService.getAllAuditLogs());
    }
}

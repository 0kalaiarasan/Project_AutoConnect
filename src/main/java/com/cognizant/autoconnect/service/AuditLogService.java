package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.AuditLog;
import com.cognizant.autoconnect.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLog createAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    public List<AuditLog> getAuditLogsByUserId(Long userId) {
        return auditLogRepository.findByUserId(userId);
    }

    public List<AuditLog> getAuditLogsByResource(String resourceType, Long resourceId) {
        return auditLogRepository.findByResourceTypeAndResourceId(resourceType, resourceId);
    }
    
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }
}

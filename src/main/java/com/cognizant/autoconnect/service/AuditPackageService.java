package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.AuditPackage;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.AuditPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditPackageService {

    private final AuditPackageRepository auditPackageRepository;

    public AuditPackage createAuditPackage(AuditPackage auditPackage) {
        return auditPackageRepository.save(auditPackage);
    }

    public AuditPackage getAuditPackageById(Long id) {
        return auditPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Audit Package not found with id: " + id));
    }

    public List<AuditPackage> getPackagesByPeriod(LocalDate start, LocalDate end) {
        return auditPackageRepository.findByPeriodStartBetween(start, end);
    }

    public List<AuditPackage> getAllPackages() {
        return auditPackageRepository.findAll();
    }

    public AuditPackage updateAuditPackage(Long id, AuditPackage packageDetails) {
        AuditPackage auditPackage = getAuditPackageById(id);
        auditPackage.setPeriodStart(packageDetails.getPeriodStart());
        auditPackage.setPeriodEnd(packageDetails.getPeriodEnd());
        auditPackage.setContentsJson(packageDetails.getContentsJson());
        auditPackage.setPackageUri(packageDetails.getPackageUri());
        return auditPackageRepository.save(auditPackage);
    }

    public void deleteAuditPackage(Long id) {
        AuditPackage auditPackage = getAuditPackageById(id);
        auditPackageRepository.delete(auditPackage);
    }
}

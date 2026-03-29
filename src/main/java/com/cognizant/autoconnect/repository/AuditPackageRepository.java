package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.AuditPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuditPackageRepository extends JpaRepository<AuditPackage, Long> {
    List<AuditPackage> findByPeriodStartBetween(LocalDate start, LocalDate end);
}

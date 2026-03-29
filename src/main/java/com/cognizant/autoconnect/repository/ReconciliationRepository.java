package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Reconciliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface ReconciliationRepository extends JpaRepository<Reconciliation, Long> {
    List<Reconciliation> findByPeriodStartBetween(LocalDate start, LocalDate end);
    List<Reconciliation> findByStatus(String status);
}

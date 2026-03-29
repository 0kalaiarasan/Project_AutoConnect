package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface KpiRepository extends JpaRepository<KPI, Long> {
    Optional<KPI> findByName(String name);
    List<KPI> findByReportingPeriod(String reportingPeriod);
}

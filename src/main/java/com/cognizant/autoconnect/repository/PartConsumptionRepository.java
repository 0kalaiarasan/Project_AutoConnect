package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.PartConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartConsumptionRepository extends JpaRepository<PartConsumption, Long> {
    List<PartConsumption> findByJobId(Long jobId);
    List<PartConsumption> findByPartId(Long partId);
}

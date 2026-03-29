package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findByCustomerId(Long customerId);
    List<Lead> findByAssignedToFk(Long assignedToFk);
    List<Lead> findByStatus(String status);
}

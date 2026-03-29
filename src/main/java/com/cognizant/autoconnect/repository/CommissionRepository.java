package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {
    List<Commission> findBySalesPersonFk(Long salesPersonFk);
    List<Commission> findByStatus(String status);
}

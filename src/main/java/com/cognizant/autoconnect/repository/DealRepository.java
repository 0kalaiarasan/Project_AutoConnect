package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
    List<Deal> findBySalesPersonFk(Long salesPersonFk);
    List<Deal> findByStatus(String status);
}

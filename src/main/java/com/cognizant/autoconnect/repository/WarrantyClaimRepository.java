package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.WarrantyClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarrantyClaimRepository extends JpaRepository<WarrantyClaim, Long> {
    List<WarrantyClaim> findByVehicleId(Long vehicleId);
    List<WarrantyClaim> findByWoid(Long woid);
    List<WarrantyClaim> findByStatus(String status);
}

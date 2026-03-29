package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    List<Warranty> findByVehicleId(Long vehicleId);
    List<Warranty> findByStatus(String status);
}

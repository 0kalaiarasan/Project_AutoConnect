package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByVin(String vin);
    Optional<Vehicle> findByStockNumber(String stockNumber);
    List<Vehicle> findByMakeAndModel(String make, String model);
    List<Vehicle> findByStatus(String status);
}

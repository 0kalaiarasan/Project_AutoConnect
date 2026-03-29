package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.PartInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PartInventoryRepository extends JpaRepository<PartInventory, Long> {
    Optional<PartInventory> findByPartIdAndLocationId(Long partId, Long locationId);
    List<PartInventory> findByLocationId(Long locationId);
}

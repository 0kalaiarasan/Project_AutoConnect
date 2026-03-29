package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.PartOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartOrderRepository extends JpaRepository<PartOrder, Long> {
    List<PartOrder> findByVendorId(Long vendorId);
    List<PartOrder> findByStatus(String status);
}

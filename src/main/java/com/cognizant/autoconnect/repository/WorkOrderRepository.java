package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    List<WorkOrder> findByAppId(Long appId);
    List<WorkOrder> findByAdvisorId(Long advisorId);
    List<WorkOrder> findByVehicleId(Long vehicleId);
    List<WorkOrder> findByAssignedTechnicianFk(Long assignedTechnicianFk);
}

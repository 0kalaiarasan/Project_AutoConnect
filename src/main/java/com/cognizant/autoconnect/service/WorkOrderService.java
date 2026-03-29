package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.WorkOrder;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrder createWorkOrder(WorkOrder workOrder) {
        return workOrderRepository.save(workOrder);
    }

    public WorkOrder getWorkOrderById(Long id) {
        return workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work Order not found with id: " + id));
    }

    public List<WorkOrder> getWorkOrdersByAppId(Long appId) {
        return workOrderRepository.findByAppId(appId);
    }

    public List<WorkOrder> getWorkOrdersByAdvisor(Long advisorId) {
        return workOrderRepository.findByAdvisorId(advisorId);
    }

    public List<WorkOrder> getWorkOrdersByVehicle(Long vehicleId) {
        return workOrderRepository.findByVehicleId(vehicleId);
    }

    public List<WorkOrder> getWorkOrdersByTechnician(Long technicianId) {
        return workOrderRepository.findByAssignedTechnicianFk(technicianId);
    }

    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAll();
    }

    public WorkOrder updateWorkOrder(Long id, WorkOrder workOrderDetails) {
        WorkOrder workOrder = getWorkOrderById(id);
        workOrder.setAppId(workOrderDetails.getAppId());
        workOrder.setAdvisorId(workOrderDetails.getAdvisorId());
        workOrder.setVehicleId(workOrderDetails.getVehicleId());
        workOrder.setReportedIssuesJson(workOrderDetails.getReportedIssuesJson());
        workOrder.setEstimatedHours(workOrderDetails.getEstimatedHours());
        workOrder.setAssignedTechnicianFk(workOrderDetails.getAssignedTechnicianFk());
        workOrder.setPartsRequiredJson(workOrderDetails.getPartsRequiredJson());
        workOrder.setStatus(workOrderDetails.getStatus());
        return workOrderRepository.save(workOrder);
    }

    public void deleteWorkOrder(Long id) {
        WorkOrder workOrder = getWorkOrderById(id);
        workOrderRepository.delete(workOrder);
    }
}

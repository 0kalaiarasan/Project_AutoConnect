package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.WorkOrder;
import com.cognizant.autoconnect.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    @PostMapping
    public ResponseEntity<WorkOrder> createWorkOrder(@RequestBody WorkOrder workOrder) {
        return new ResponseEntity<>(workOrderService.createWorkOrder(workOrder), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> getWorkOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(workOrderService.getWorkOrderById(id));
    }

    @GetMapping("/app/{appId}")
    public ResponseEntity<List<WorkOrder>> getWorkOrdersByAppId(@PathVariable Long appId) {
        return ResponseEntity.ok(workOrderService.getWorkOrdersByAppId(appId));
    }

    @GetMapping("/technician/{technicianId}")
    public ResponseEntity<List<WorkOrder>> getWorkOrdersByTechnician(@PathVariable Long technicianId) {
        return ResponseEntity.ok(workOrderService.getWorkOrdersByTechnician(technicianId));
    }

    @GetMapping
    public ResponseEntity<List<WorkOrder>> getAllWorkOrders() {
        return ResponseEntity.ok(workOrderService.getAllWorkOrders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrder> updateWorkOrder(@PathVariable Long id, @RequestBody WorkOrder workOrder) {
        return ResponseEntity.ok(workOrderService.updateWorkOrder(id, workOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkOrder(@PathVariable Long id) {
        workOrderService.deleteWorkOrder(id);
        return ResponseEntity.noContent().build();
    }
}

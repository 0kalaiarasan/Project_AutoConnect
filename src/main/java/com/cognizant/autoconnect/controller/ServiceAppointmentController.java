package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.ServiceAppointment;
import com.cognizant.autoconnect.service.ServiceAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class ServiceAppointmentController {

    private final ServiceAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ServiceAppointment> createAppointment(@RequestBody ServiceAppointment appointment) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceAppointment> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ServiceAppointment>> getAppointmentsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByCustomer(customerId));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<ServiceAppointment>> getAppointmentsByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByVehicle(vehicleId));
    }

    @GetMapping
    public ResponseEntity<List<ServiceAppointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceAppointment> updateAppointment(@PathVariable Long id, @RequestBody ServiceAppointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}

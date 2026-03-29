package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.ServiceAppointment;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.ServiceAppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceAppointmentService {

    private final ServiceAppointmentRepository serviceAppointmentRepository;

    public ServiceAppointment createAppointment(ServiceAppointment appointment) {
        return serviceAppointmentRepository.save(appointment);
    }

    public ServiceAppointment getAppointmentById(Long id) {
        return serviceAppointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service Appointment not found with id: " + id));
    }

    public List<ServiceAppointment> getAppointmentsByCustomer(Long customerId) {
        return serviceAppointmentRepository.findByCustomerId(customerId);
    }

    public List<ServiceAppointment> getAppointmentsByVehicle(Long vehicleId) {
        return serviceAppointmentRepository.findByVehicleId(vehicleId);
    }

    public List<ServiceAppointment> getAppointmentsByAdvisor(Long advisorId) {
        return serviceAppointmentRepository.findByAdvisorId(advisorId);
    }

    public List<ServiceAppointment> getAppointmentsBetween(LocalDateTime start, LocalDateTime end) {
        return serviceAppointmentRepository.findByScheduledAtBetween(start, end);
    }

    public List<ServiceAppointment> getAllAppointments() {
        return serviceAppointmentRepository.findAll();
    }

    public ServiceAppointment updateAppointment(Long id, ServiceAppointment appointmentDetails) {
        ServiceAppointment appointment = getAppointmentById(id);
        appointment.setCustomerId(appointmentDetails.getCustomerId());
        appointment.setVehicleId(appointmentDetails.getVehicleId());
        appointment.setAdvisorId(appointmentDetails.getAdvisorId());
        appointment.setScheduledAt(appointmentDetails.getScheduledAt());
        appointment.setDurationMinutes(appointmentDetails.getDurationMinutes());
        appointment.setServiceType(appointmentDetails.getServiceType());
        appointment.setStatus(appointmentDetails.getStatus());
        return serviceAppointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        ServiceAppointment appointment = getAppointmentById(id);
        serviceAppointmentRepository.delete(appointment);
    }
}

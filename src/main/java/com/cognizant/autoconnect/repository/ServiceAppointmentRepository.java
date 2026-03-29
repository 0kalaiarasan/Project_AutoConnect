package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.ServiceAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long> {
    List<ServiceAppointment> findByCustomerId(Long customerId);
    List<ServiceAppointment> findByVehicleId(Long vehicleId);
    List<ServiceAppointment> findByAdvisorId(Long advisorId);
    List<ServiceAppointment> findByScheduledAtBetween(LocalDateTime start, LocalDateTime end);
}

package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Vehicle;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));
    }

    public Vehicle getVehicleByVin(String vin) {
        return vehicleRepository.findByVin(vin)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with VIN: " + vin));
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setVin(vehicleDetails.getVin());
        vehicle.setStockNumber(vehicleDetails.getStockNumber());
        vehicle.setMake(vehicleDetails.getMake());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setTrim(vehicleDetails.getTrim());
        vehicle.setColor(vehicleDetails.getColor());
        vehicle.setMileage(vehicleDetails.getMileage());
        vehicle.setCondition(vehicleDetails.getCondition());
        vehicle.setLocationId(vehicleDetails.getLocationId());
        vehicle.setStatus(vehicleDetails.getStatus());
        vehicle.setBasePrice(vehicleDetails.getBasePrice());
        vehicle.setMsrp(vehicleDetails.getMsrp());
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.delete(vehicle);
    }
}

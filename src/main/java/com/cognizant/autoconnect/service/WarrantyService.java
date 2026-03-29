package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Warranty;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.WarrantyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyService {

    private final WarrantyRepository warrantyRepository;

    public Warranty createWarranty(Warranty warranty) {
        return warrantyRepository.save(warranty);
    }

    public Warranty getWarrantyById(Long id) {
        return warrantyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found with id: " + id));
    }

    public List<Warranty> getWarrantiesByVehicle(Long vehicleId) {
        return warrantyRepository.findByVehicleId(vehicleId);
    }

    public List<Warranty> getAllWarranties() {
        return warrantyRepository.findAll();
    }

    public Warranty updateWarranty(Long id, Warranty warrantyDetails) {
        Warranty warranty = getWarrantyById(id);
        warranty.setVehicleId(warrantyDetails.getVehicleId());
        warranty.setPolicyCode(warrantyDetails.getPolicyCode());
        warranty.setCoverageJson(warrantyDetails.getCoverageJson());
        warranty.setStartAt(warrantyDetails.getStartAt());
        warranty.setEndAt(warrantyDetails.getEndAt());
        warranty.setStatus(warrantyDetails.getStatus());
        return warrantyRepository.save(warranty);
    }

    public void deleteWarranty(Long id) {
        Warranty warranty = getWarrantyById(id);
        warrantyRepository.delete(warranty);
    }
}

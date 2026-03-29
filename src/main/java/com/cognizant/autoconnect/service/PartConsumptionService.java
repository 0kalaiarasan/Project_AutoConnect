package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.PartConsumption;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.PartConsumptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartConsumptionService {

    private final PartConsumptionRepository consumptionRepository;

    public PartConsumption createConsumption(PartConsumption consumption) {
        return consumptionRepository.save(consumption);
    }

    public PartConsumption getConsumptionById(Long id) {
        return consumptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part Consumption not found with id: " + id));
    }

    public List<PartConsumption> getConsumptionByJobId(Long jobId) {
        return consumptionRepository.findByJobId(jobId);
    }

    public List<PartConsumption> getConsumptionByPartId(Long partId) {
        return consumptionRepository.findByPartId(partId);
    }

    public List<PartConsumption> getAllConsumptions() {
        return consumptionRepository.findAll();
    }

    public PartConsumption updateConsumption(Long id, PartConsumption consumptionDetails) {
        PartConsumption consumption = getConsumptionById(id);
        consumption.setJobId(consumptionDetails.getJobId());
        consumption.setPartId(consumptionDetails.getPartId());
        consumption.setQuantity(consumptionDetails.getQuantity());
        consumption.setConsumedByFk(consumptionDetails.getConsumedByFk());
        consumption.setLotBatch(consumptionDetails.getLotBatch());
        return consumptionRepository.save(consumption);
    }

    public void deleteConsumption(Long id) {
        PartConsumption consumption = getConsumptionById(id);
        consumptionRepository.delete(consumption);
    }
}

package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Part;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    public Part createPart(Part part) {
        return partRepository.save(part);
    }

    public Part getPartById(Long id) {
        return partRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part not found with id: " + id));
    }

    public Part getPartByNumber(String partNumber) {
        return partRepository.findByPartNumber(partNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Part not found with number: " + partNumber));
    }

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Part updatePart(Long id, Part partDetails) {
        Part part = getPartById(id);
        part.setPartNumber(partDetails.getPartNumber());
        part.setDescription(partDetails.getDescription());
        part.setManufacturer(partDetails.getManufacturer());
        part.setUnitOfMeasure(partDetails.getUnitOfMeasure());
        part.setCost(partDetails.getCost());
        part.setRetailPrice(partDetails.getRetailPrice());
        part.setStatus(partDetails.getStatus());
        return partRepository.save(part);
    }

    public void deletePart(Long id) {
        Part part = getPartById(id);
        partRepository.delete(part);
    }
}

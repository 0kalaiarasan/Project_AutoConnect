package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.WarrantyClaim;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.WarrantyClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyClaimService {

    private final WarrantyClaimRepository claimRepository;

    public WarrantyClaim createClaim(WarrantyClaim claim) {
        return claimRepository.save(claim);
    }

    public WarrantyClaim getClaimById(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty Claim not found with id: " + id));
    }

    public List<WarrantyClaim> getClaimsByVehicle(Long vehicleId) {
        return claimRepository.findByVehicleId(vehicleId);
    }

    public List<WarrantyClaim> getClaimsByWorkOrder(Long woid) {
        return claimRepository.findByWoid(woid);
    }

    public List<WarrantyClaim> getAllClaims() {
        return claimRepository.findAll();
    }

    public WarrantyClaim updateClaim(Long id, WarrantyClaim claimDetails) {
        WarrantyClaim claim = getClaimById(id);
        claim.setWoid(claimDetails.getWoid());
        claim.setVehicleId(claimDetails.getVehicleId());
        claim.setCustomerId(claimDetails.getCustomerId());
        claim.setClaimAmount(claimDetails.getClaimAmount());
        claim.setSubmittedToOemAt(claimDetails.getSubmittedToOemAt());
        claim.setResponseJson(claimDetails.getResponseJson());
        claim.setStatus(claimDetails.getStatus());
        return claimRepository.save(claim);
    }

    public void deleteClaim(Long id) {
        WarrantyClaim claim = getClaimById(id);
        claimRepository.delete(claim);
    }
}

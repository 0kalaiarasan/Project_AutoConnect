package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Commission;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.CommissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommissionService {

    private final CommissionRepository commissionRepository;

    public Commission createCommission(Commission commission) {
        return commissionRepository.save(commission);
    }

    public Commission getCommissionById(Long id) {
        return commissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commission not found with id: " + id));
    }

    public List<Commission> getCommissionsBySalesperson(Long salespersonId) {
        return commissionRepository.findBySalesPersonFk(salespersonId);
    }

    public List<Commission> getAllCommissions() {
        return commissionRepository.findAll();
    }

    public Commission updateCommission(Long id, Commission commissionDetails) {
        Commission commission = getCommissionById(id);
        commission.setDealId(commissionDetails.getDealId());
        commission.setSalesPersonFk(commissionDetails.getSalesPersonFk());
        commission.setCommissionAmount(commissionDetails.getCommissionAmount());
        commission.setCalculatedAt(commissionDetails.getCalculatedAt());
        commission.setPaidAt(commissionDetails.getPaidAt());
        commission.setStatus(commissionDetails.getStatus());
        return commissionRepository.save(commission);
    }

    public void deleteCommission(Long id) {
        Commission commission = getCommissionById(id);
        commissionRepository.delete(commission);
    }
}

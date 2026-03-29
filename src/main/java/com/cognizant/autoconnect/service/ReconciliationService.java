package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Reconciliation;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.ReconciliationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReconciliationService {

    private final ReconciliationRepository reconciliationRepository;

    public Reconciliation createReconciliation(Reconciliation reconciliation) {
        return reconciliationRepository.save(reconciliation);
    }

    public Reconciliation getReconciliationById(Long id) {
        return reconciliationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reconciliation not found with id: " + id));
    }

    public List<Reconciliation> getReconciliationsByPeriod(LocalDate start, LocalDate end) {
        return reconciliationRepository.findByPeriodStartBetween(start, end);
    }

    public List<Reconciliation> getAllReconciliations() {
        return reconciliationRepository.findAll();
    }

    public Reconciliation updateReconciliation(Long id, Reconciliation reconDetails) {
        Reconciliation recon = getReconciliationById(id);
        recon.setPeriodStart(reconDetails.getPeriodStart());
        recon.setPeriodEnd(reconDetails.getPeriodEnd());
        recon.setSalesSummaryJson(reconDetails.getSalesSummaryJson());
        recon.setPaymentsSummaryJson(reconDetails.getPaymentsSummaryJson());
        recon.setDiscrepanciesJson(reconDetails.getDiscrepanciesJson());
        recon.setStatus(reconDetails.getStatus());
        return reconciliationRepository.save(recon);
    }

    public void deleteReconciliation(Long id) {
        Reconciliation recon = getReconciliationById(id);
        reconciliationRepository.delete(recon);
    }
}

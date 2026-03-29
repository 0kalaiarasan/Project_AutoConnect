package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Lead;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;

    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lead not found with id: " + id));
    }

    public List<Lead> getLeadsByCustomerId(Long customerId) {
        return leadRepository.findByCustomerId(customerId);
    }
    
    public List<Lead> getLeadsByAssignedUser(Long userId) {
        return leadRepository.findByAssignedToFk(userId);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead updateLead(Long id, Lead leadDetails) {
        Lead lead = getLeadById(id);
        lead.setSource(leadDetails.getSource());
        lead.setInterestedModel(leadDetails.getInterestedModel());
        lead.setStatus(leadDetails.getStatus());
        lead.setAssignedToFk(leadDetails.getAssignedToFk());
        lead.setNotes(leadDetails.getNotes());
        return leadRepository.save(lead);
    }

    public void deleteLead(Long id) {
        Lead lead = getLeadById(id);
        leadRepository.delete(lead);
    }
}

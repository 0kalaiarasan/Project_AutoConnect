package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.JobCard;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.JobCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobCardService {

    private final JobCardRepository jobCardRepository;

    public JobCard createJobCard(JobCard jobCard) {
        return jobCardRepository.save(jobCard);
    }

    public JobCard getJobCardById(Long id) {
        return jobCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Card not found with id: " + id));
    }

    public JobCard getJobCardByWoid(Long woid) {
        return jobCardRepository.findByWoid(woid)
                .orElseThrow(() -> new ResourceNotFoundException("Job Card not found with Work Order ID: " + woid));
    }

    public List<JobCard> getJobCardsByTechnician(Long technicianId) {
        return jobCardRepository.findByTechnicianId(technicianId);
    }

    public List<JobCard> getJobCardsByStatus(String status) {
        return jobCardRepository.findByStatus(status);
    }

    public List<JobCard> getAllJobCards() {
        return jobCardRepository.findAll();
    }

    public JobCard updateJobCard(Long id, JobCard jobCardDetails) {
        JobCard jobCard = getJobCardById(id);
        jobCard.setWoid(jobCardDetails.getWoid());
        jobCard.setTechnicianId(jobCardDetails.getTechnicianId());
        jobCard.setStartAt(jobCardDetails.getStartAt());
        jobCard.setEndAt(jobCardDetails.getEndAt());
        jobCard.setFindingsJson(jobCardDetails.getFindingsJson());
        jobCard.setActionsJson(jobCardDetails.getActionsJson());
        jobCard.setPhotosUriJson(jobCardDetails.getPhotosUriJson());
        jobCard.setSignedOffByFk(jobCardDetails.getSignedOffByFk());
        jobCard.setSignedOffAt(jobCardDetails.getSignedOffAt());
        jobCard.setStatus(jobCardDetails.getStatus());
        return jobCardRepository.save(jobCard);
    }

    public void deleteJobCard(Long id) {
        JobCard jobCard = getJobCardById(id);
        jobCardRepository.delete(jobCard);
    }
}

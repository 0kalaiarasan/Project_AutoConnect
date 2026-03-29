package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Recall;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.RecallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecallService {

    private final RecallRepository recallRepository;

    public Recall createRecall(Recall recall) {
        return recallRepository.save(recall);
    }

    public Recall getRecallById(Long id) {
        return recallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recall not found with id: " + id));
    }

    public Recall getRecallByNumber(String recallNumber) {
        return recallRepository.findByRecallNumber(recallNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Recall not found with number: " + recallNumber));
    }

    public List<Recall> getAllRecalls() {
        return recallRepository.findAll();
    }

    public Recall updateRecall(Long id, Recall recallDetails) {
        Recall recall = getRecallById(id);
        recall.setRecallNumber(recallDetails.getRecallNumber());
        recall.setAffectedModelsJson(recallDetails.getAffectedModelsJson());
        recall.setRemedyDetails(recallDetails.getRemedyDetails());
        recall.setStatus(recallDetails.getStatus());
        return recallRepository.save(recall);
    }

    public void deleteRecall(Long id) {
        Recall recall = getRecallById(id);
        recallRepository.delete(recall);
    }
}

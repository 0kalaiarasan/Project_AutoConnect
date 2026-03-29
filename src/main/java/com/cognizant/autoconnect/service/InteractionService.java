package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Interaction;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.InteractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractionService {

    private final InteractionRepository interactionRepository;

    public Interaction createInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    public Interaction getInteractionById(Long id) {
        return interactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interaction not found with id: " + id));
    }

    public List<Interaction> getInteractionsByCustomerId(Long customerId) {
        return interactionRepository.findByCustomerId(customerId);
    }

    public List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }
    
    public void deleteInteraction(Long id) {
        Interaction interaction = getInteractionById(id);
        interactionRepository.delete(interaction);
    }
}

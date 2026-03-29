package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Interaction;
import com.cognizant.autoconnect.service.InteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
@RequiredArgsConstructor
public class InteractionController {

    private final InteractionService interactionService;

    @PostMapping
    public ResponseEntity<Interaction> createInteraction(@RequestBody Interaction interaction) {
        return new ResponseEntity<>(interactionService.createInteraction(interaction), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interaction> getInteractionById(@PathVariable Long id) {
        return ResponseEntity.ok(interactionService.getInteractionById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Interaction>> getInteractionsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(interactionService.getInteractionsByCustomerId(customerId));
    }

    @GetMapping
    public ResponseEntity<List<Interaction>> getAllInteractions() {
        return ResponseEntity.ok(interactionService.getAllInteractions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
        return ResponseEntity.noContent().build();
    }
}

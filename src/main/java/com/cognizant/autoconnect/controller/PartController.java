package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Part;
import com.cognizant.autoconnect.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        return new ResponseEntity<>(partService.createPart(part), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
        return ResponseEntity.ok(partService.getPartById(id));
    }

    @GetMapping("/number/{partNumber}")
    public ResponseEntity<Part> getPartByNumber(@PathVariable String partNumber) {
        return ResponseEntity.ok(partService.getPartByNumber(partNumber));
    }

    @GetMapping
    public ResponseEntity<List<Part>> getAllParts() {
        return ResponseEntity.ok(partService.getAllParts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @RequestBody Part part) {
        return ResponseEntity.ok(partService.updatePart(id, part));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart(@PathVariable Long id) {
        partService.deletePart(id);
        return ResponseEntity.noContent().build();
    }
}

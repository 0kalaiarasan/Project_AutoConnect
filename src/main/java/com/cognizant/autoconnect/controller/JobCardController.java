package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.JobCard;
import com.cognizant.autoconnect.service.JobCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-cards")
@RequiredArgsConstructor
public class JobCardController {

    private final JobCardService jobCardService;

    @PostMapping
    public ResponseEntity<JobCard> createJobCard(@RequestBody JobCard jobCard) {
        return new ResponseEntity<>(jobCardService.createJobCard(jobCard), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobCard> getJobCardById(@PathVariable Long id) {
        return ResponseEntity.ok(jobCardService.getJobCardById(id));
    }

    @GetMapping("/woid/{woid}")
    public ResponseEntity<JobCard> getJobCardByWoid(@PathVariable Long woid) {
        return ResponseEntity.ok(jobCardService.getJobCardByWoid(woid));
    }

    @GetMapping("/technician/{technicianId}")
    public ResponseEntity<List<JobCard>> getJobCardsByTechnician(@PathVariable Long technicianId) {
        return ResponseEntity.ok(jobCardService.getJobCardsByTechnician(technicianId));
    }

    @GetMapping
    public ResponseEntity<List<JobCard>> getAllJobCards() {
        return ResponseEntity.ok(jobCardService.getAllJobCards());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobCard> updateJobCard(@PathVariable Long id, @RequestBody JobCard jobCard) {
        return ResponseEntity.ok(jobCardService.updateJobCard(id, jobCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobCard(@PathVariable Long id) {
        jobCardService.deleteJobCard(id);
        return ResponseEntity.noContent().build();
    }
}

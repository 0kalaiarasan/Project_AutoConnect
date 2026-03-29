package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Recall;
import com.cognizant.autoconnect.service.RecallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recalls")
@RequiredArgsConstructor
public class RecallController {

    private final RecallService recallService;

    @PostMapping
    public ResponseEntity<Recall> createRecall(@RequestBody Recall recall) {
        return new ResponseEntity<>(recallService.createRecall(recall), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recall> getRecallById(@PathVariable Long id) {
        return ResponseEntity.ok(recallService.getRecallById(id));
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<Recall> getRecallByNumber(@PathVariable String number) {
        return ResponseEntity.ok(recallService.getRecallByNumber(number));
    }

    @GetMapping
    public ResponseEntity<List<Recall>> getAllRecalls() {
        return ResponseEntity.ok(recallService.getAllRecalls());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recall> updateRecall(@PathVariable Long id, @RequestBody Recall recall) {
        return ResponseEntity.ok(recallService.updateRecall(id, recall));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecall(@PathVariable Long id) {
        recallService.deleteRecall(id);
        return ResponseEntity.noContent().build();
    }
}

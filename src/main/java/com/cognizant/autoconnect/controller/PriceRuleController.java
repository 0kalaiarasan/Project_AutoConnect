package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.PriceRule;
import com.cognizant.autoconnect.service.PriceRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricerules")
@RequiredArgsConstructor
public class PriceRuleController {

    private final PriceRuleService priceRuleService;

    @PostMapping
    public ResponseEntity<PriceRule> createPriceRule(@RequestBody PriceRule priceRule) {
        return new ResponseEntity<>(priceRuleService.createPriceRule(priceRule), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceRule> getPriceRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(priceRuleService.getPriceRuleById(id));
    }

    @GetMapping
    public ResponseEntity<List<PriceRule>> getAllPriceRules() {
        return ResponseEntity.ok(priceRuleService.getAllPriceRules());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceRule> updatePriceRule(@PathVariable Long id, @RequestBody PriceRule priceRule) {
        return ResponseEntity.ok(priceRuleService.updatePriceRule(id, priceRule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceRule(@PathVariable Long id) {
        priceRuleService.deletePriceRule(id);
        return ResponseEntity.noContent().build();
    }
}

package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.PriceRule;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.PriceRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceRuleService {

    private final PriceRuleRepository priceRuleRepository;

    public PriceRule createPriceRule(PriceRule priceRule) {
        return priceRuleRepository.save(priceRule);
    }

    public PriceRule getPriceRuleById(Long id) {
        return priceRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PriceRule not found with id: " + id));
    }

    public List<PriceRule> getAllPriceRules() {
        return priceRuleRepository.findAll();
    }

    public PriceRule updatePriceRule(Long id, PriceRule priceRuleDetails) {
        PriceRule priceRule = getPriceRuleById(id);
        priceRule.setName(priceRuleDetails.getName());
        priceRule.setConditionsJson(priceRuleDetails.getConditionsJson());
        priceRule.setAdjustmentExpressionJson(priceRuleDetails.getAdjustmentExpressionJson());
        priceRule.setEffectiveFrom(priceRuleDetails.getEffectiveFrom());
        priceRule.setEffectiveTo(priceRuleDetails.getEffectiveTo());
        priceRule.setPriority(priceRuleDetails.getPriority());
        priceRule.setStatus(priceRuleDetails.getStatus());
        return priceRuleRepository.save(priceRule);
    }

    public void deletePriceRule(Long id) {
        PriceRule priceRule = getPriceRuleById(id);
        priceRuleRepository.delete(priceRule);
    }
}

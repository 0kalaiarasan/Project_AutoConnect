package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Promotion;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Promotion not found with id: " + id));
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion updatePromotion(Long id, Promotion promotionDetails) {
        Promotion promotion = getPromotionById(id);
        promotion.setCode(promotionDetails.getCode());
        promotion.setName(promotionDetails.getName());
        promotion.setType(promotionDetails.getType());
        promotion.setConditionsJson(promotionDetails.getConditionsJson());
        promotion.setActionsJson(promotionDetails.getActionsJson());
        promotion.setStartAt(promotionDetails.getStartAt());
        promotion.setEndAt(promotionDetails.getEndAt());
        promotion.setUsageLimit(promotionDetails.getUsageLimit());
        promotion.setStatus(promotionDetails.getStatus());
        return promotionRepository.save(promotion);
    }

    public void deletePromotion(Long id) {
        Promotion promotion = getPromotionById(id);
        promotionRepository.delete(promotion);
    }
}

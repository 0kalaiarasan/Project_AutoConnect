package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Deal;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealService {

    private final DealRepository dealRepository;

    public Deal createDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    public Deal getDealById(Long id) {
        return dealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deal not found with id: " + id));
    }

    public List<Deal> getDealsBySalesperson(Long salespersonId) {
        return dealRepository.findBySalesPersonFk(salespersonId);
    }

    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    public Deal updateDeal(Long id, Deal dealDetails) {
        Deal deal = getDealById(id);
        deal.setQuoteId(dealDetails.getQuoteId());
        deal.setSalesPersonFk(dealDetails.getSalesPersonFk());
        deal.setFinanceOfferJson(dealDetails.getFinanceOfferJson());
        deal.setApprovedByFk(dealDetails.getApprovedByFk());
        deal.setApprovedAt(dealDetails.getApprovedAt());
        deal.setDealDocumentsUriJson(dealDetails.getDealDocumentsUriJson());
        deal.setStatus(dealDetails.getStatus());
        return dealRepository.save(deal);
    }

    public void deleteDeal(Long id) {
        Deal deal = getDealById(id);
        dealRepository.delete(deal);
    }
}

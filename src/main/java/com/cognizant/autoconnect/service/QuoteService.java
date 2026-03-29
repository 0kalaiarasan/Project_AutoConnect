package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Quote;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + id));
    }

    public List<Quote> getQuotesByCustomerId(Long customerId) {
        return quoteRepository.findByCustomerId(customerId);
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote updateQuote(Long id, Quote quoteDetails) {
        Quote quote = getQuoteById(id);
        quote.setVehicleId(quoteDetails.getVehicleId());
        quote.setTradeInDetailsJson(quoteDetails.getTradeInDetailsJson());
        quote.setOptionsJson(quoteDetails.getOptionsJson());
        quote.setTaxesJson(quoteDetails.getTaxesJson());
        quote.setFeesJson(quoteDetails.getFeesJson());
        quote.setTotalPrice(quoteDetails.getTotalPrice());
        quote.setExpiresAt(quoteDetails.getExpiresAt());
        quote.setStatus(quoteDetails.getStatus());
        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        Quote quote = getQuoteById(id);
        quoteRepository.delete(quote);
    }
}

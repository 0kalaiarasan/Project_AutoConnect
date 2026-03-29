package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.Quote;
import com.cognizant.autoconnect.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        return new ResponseEntity<>(quoteService.createQuote(quote), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        return ResponseEntity.ok(quoteService.getQuoteById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Quote>> getQuotesByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(quoteService.getQuotesByCustomerId(customerId));
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return ResponseEntity.ok(quoteService.getAllQuotes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @RequestBody Quote quote) {
        return ResponseEntity.ok(quoteService.updateQuote(id, quote));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }
}

package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByCustomerId(Long customerId);
    List<Quote> findByStatus(String status);
}

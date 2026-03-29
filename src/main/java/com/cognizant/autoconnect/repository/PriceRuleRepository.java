package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.PriceRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRuleRepository extends JpaRepository<PriceRule, Long> {
    List<PriceRule> findByStatusOrderByPriorityDesc(String status);
}

package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceRuleId;

    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String conditionsJson;
    
    @Column(columnDefinition = "TEXT")
    private String adjustmentExpressionJson;
    
    private LocalDateTime effectiveFrom;
    
    private LocalDateTime effectiveTo;
    
    private Integer priority;
    
    private String status;
}

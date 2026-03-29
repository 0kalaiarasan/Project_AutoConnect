package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reconciliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reconId;

    private LocalDate periodStart;
    
    private LocalDate periodEnd;
    
    @Column(columnDefinition = "TEXT")
    private String salesSummaryJson;
    
    @Column(columnDefinition = "TEXT")
    private String paymentsSummaryJson;
    
    @Column(columnDefinition = "TEXT")
    private String discrepanciesJson;
    
    private LocalDateTime reconciledAt;
    
    private String status;
    
    @PrePersist
    public void prePersist() {
        if(reconciledAt == null) {
            reconciledAt = LocalDateTime.now();
        }
    }
}

package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private Long customerId;
    
    // Can be QuoteID, AppID, WOID depending on what's being billed
    private Long relatedEntityId; 
    
    @Column(columnDefinition = "TEXT")
    private String lineItemsJson;
    
    private BigDecimal subtotal;
    
    private BigDecimal taxes;
    
    @Column(columnDefinition = "TEXT")
    private String discountsJson;
    
    private BigDecimal totalAmount;
    
    private LocalDateTime issuedAt;
    
    private LocalDate dueDate;
    
    private String status;
    
    private String invoiceUri;
    
    @PrePersist
    public void prePersist() {
        if(issuedAt == null) {
            issuedAt = LocalDateTime.now();
        }
    }
}

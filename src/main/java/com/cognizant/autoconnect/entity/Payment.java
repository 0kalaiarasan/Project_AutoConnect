package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long invoiceId;
    
    private Long customerId;
    
    private BigDecimal amount;
    
    private String method; // Credit Card, Cash, Bank Transfer
    
    private String transactionRef;
    
    private LocalDateTime paidAt;
    
    private String status;
    
    @PrePersist
    public void prePersist() {
        if(paidAt == null) {
            paidAt = LocalDateTime.now();
        }
    }
}

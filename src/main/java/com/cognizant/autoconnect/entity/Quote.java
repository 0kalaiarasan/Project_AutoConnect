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
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteId;

    private Long customerId;
    
    private Long vehicleId;
    
    @Column(columnDefinition = "TEXT")
    private String tradeInDetailsJson;
    
    @Column(columnDefinition = "TEXT")
    private String optionsJson;
    
    @Column(columnDefinition = "TEXT")
    private String taxesJson;
    
    @Column(columnDefinition = "TEXT")
    private String feesJson;
    
    private BigDecimal totalPrice;
    
    private LocalDateTime expiresAt;
    
    private Long createdByFk;
    
    private String status;
}

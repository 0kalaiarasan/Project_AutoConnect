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
public class WarrantyClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private Long woid;
    
    private Long vehicleId;
    
    private Long customerId;
    
    private BigDecimal claimAmount;
    
    private LocalDateTime submittedToOemAt;
    
    @Column(columnDefinition = "TEXT")
    private String responseJson;
    
    private String status;
}

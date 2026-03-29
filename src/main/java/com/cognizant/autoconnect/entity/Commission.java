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
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionId;

    private Long dealId;
    
    private Long salesPersonFk;
    
    private BigDecimal commissionAmount;
    
    private LocalDateTime calculatedAt;
    
    private LocalDateTime paidAt;
    
    private String status;
}

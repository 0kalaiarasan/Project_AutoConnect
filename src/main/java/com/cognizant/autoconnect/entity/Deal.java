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
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    private Long quoteId;
    
    private Long salesPersonFk;
    
    @Column(columnDefinition = "TEXT")
    private String financeOfferJson;
    
    private Long approvedByFk;
    
    private LocalDateTime approvedAt;
    
    @Column(columnDefinition = "TEXT")
    private String dealDocumentsUriJson;
    
    private String status;
}

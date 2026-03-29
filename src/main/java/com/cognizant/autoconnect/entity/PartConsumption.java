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
public class PartConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumptionId;

    private Long jobId;
    
    private Long partId;
    
    private Integer quantity;
    
    private LocalDateTime consumedAt;
    
    private Long consumedByFk;
    
    private String lotBatch;
    
    @PrePersist
    public void prePersist() {
        if(consumedAt == null) {
            consumedAt = LocalDateTime.now();
        }
    }
}

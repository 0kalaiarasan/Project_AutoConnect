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
public class PartInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invId;

    private Long partId;
    
    private Long locationId;
    
    private Integer quantityOnHand;
    
    private Integer quantityReserved;
    
    private Integer reorderPoint;
    
    private LocalDateTime lastUpdatedAt;
    
    @PrePersist
    public void prePersist() {
        if(lastUpdatedAt == null) {
            lastUpdatedAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdatedAt = LocalDateTime.now();
    }
}

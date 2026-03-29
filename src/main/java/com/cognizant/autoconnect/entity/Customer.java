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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private Long userId;
    
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String contactInfoJson;
    
    private Long preferredDealerId;
    
    @Column(columnDefinition = "TEXT")
    private String vehicleOwnershipJson;
    
    private String loyaltyTier;
    
    private String status;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    public void prePersist() {
        if(createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}

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
public class PartOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partOrderId;

    private Long vendorId;
    
    @Column(columnDefinition = "TEXT")
    private String itemsJson;
    
    private LocalDateTime issuedAt;
    
    private LocalDateTime expectedAt;
    
    private LocalDateTime receivedAt;
    
    private String status;
    
    @PrePersist
    public void prePersist() {
        if(issuedAt == null) {
            issuedAt = LocalDateTime.now();
        }
    }
}

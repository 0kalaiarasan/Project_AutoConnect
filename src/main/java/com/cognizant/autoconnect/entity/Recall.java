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
public class Recall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recallId;

    @Column(unique = true)
    private String recallNumber;
    
    @Column(columnDefinition = "TEXT")
    private String affectedModelsJson;
    
    private LocalDateTime issuedAt;
    
    @Column(columnDefinition = "TEXT")
    private String remedyDetails;
    
    private String status;
    
    @PrePersist
    public void prePersist() {
        if(issuedAt == null) {
            issuedAt = LocalDateTime.now();
        }
    }
}

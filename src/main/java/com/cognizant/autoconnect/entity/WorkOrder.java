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
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long woid;

    private Long appId;
    
    private Long advisorId;
    
    private Long vehicleId;
    
    @Column(columnDefinition = "TEXT")
    private String reportedIssuesJson;
    
    private Double estimatedHours;
    
    private Long assignedTechnicianFk;
    
    @Column(columnDefinition = "TEXT")
    private String partsRequiredJson;
    
    private String status;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    public void prePersist() {
        if(createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}

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
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warrantyId;

    private Long vehicleId;
    
    private String policyCode;
    
    @Column(columnDefinition = "TEXT")
    private String coverageJson;
    
    private LocalDateTime startAt;
    
    private LocalDateTime endAt;
    
    private String status;
}

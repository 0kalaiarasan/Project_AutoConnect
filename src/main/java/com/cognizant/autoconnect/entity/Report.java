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
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    // Sales/Service/Parts/Finance
    private String scope; 
    
    @Column(columnDefinition = "TEXT")
    private String parametersJson;
    
    @Column(columnDefinition = "TEXT")
    private String metricsJson;
    
    private Long generatedByFk;
    
    private LocalDateTime generatedAt;
    
    private String reportUri;
    
    @PrePersist
    public void prePersist() {
        if(generatedAt == null) {
            generatedAt = LocalDateTime.now();
        }
    }
}

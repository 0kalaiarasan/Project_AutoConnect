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
public class JobCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private Long woid;
    
    private Long technicianId;
    
    private LocalDateTime startAt;
    
    private LocalDateTime endAt;
    
    @Column(columnDefinition = "TEXT")
    private String findingsJson;
    
    @Column(columnDefinition = "TEXT")
    private String actionsJson;
    
    @Column(columnDefinition = "TEXT")
    private String photosUriJson;
    
    private Long signedOffByFk;
    
    private LocalDateTime signedOffAt;
    
    private String status;
}

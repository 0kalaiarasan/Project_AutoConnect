package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    private LocalDate periodStart;
    
    private LocalDate periodEnd;
    
    @Column(columnDefinition = "TEXT")
    private String contentsJson;
    
    private LocalDateTime generatedAt;
    
    private String packageUri;
    
    @PrePersist
    public void prePersist() {
        if(generatedAt == null) {
            generatedAt = LocalDateTime.now();
        }
    }
}

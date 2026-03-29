package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kpiId;

    @Column(unique = true)
    private String name;
    
    private String definition;
    
    private Double targetValue;
    
    private Double currentValue;
    
    private String reportingPeriod; // e.g., Monthly, Quarterly
}

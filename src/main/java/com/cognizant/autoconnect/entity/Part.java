package com.cognizant.autoconnect.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @Column(unique = true)
    private String partNumber;
    
    private String description;
    
    private String manufacturer;
    
    private String unitOfMeasure;
    
    private BigDecimal cost;
    
    private BigDecimal retailPrice;
    
    private String status;
}

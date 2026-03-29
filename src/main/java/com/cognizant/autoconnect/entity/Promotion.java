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
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promoId;

    @Column(unique = true)
    private String code;
    
    private String name;
    
    private String type;
    
    @Column(columnDefinition = "TEXT")
    private String conditionsJson;
    
    @Column(columnDefinition = "TEXT")
    private String actionsJson;
    
    private LocalDateTime startAt;
    
    private LocalDateTime endAt;
    
    private Integer usageLimit;
    
    private String status;
}

package com.cognizant.autoconnect.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(unique = true)
    private String vin;

    private String stockNumber;

    private String make;

    private String model;

    @Column(name = "model_year")
    private Integer year;

    private String trim;

    private String color;

    private Integer mileage;

    // New/Used
    @Column(name = "vehicle_condition")
    private String condition;

    private Long locationId;

    private String status;

    private BigDecimal basePrice;

    private BigDecimal msrp;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}

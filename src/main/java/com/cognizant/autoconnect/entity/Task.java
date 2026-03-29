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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private Long assignedToFk;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private LocalDateTime dueDate;
    
    private String priority;
    
    private String status; // Pending, In Progress, Completed
    
    private Long relatedEntityId; // e.g., Deal ID, Lead ID, WOID
    
    private String relatedEntityType;
}

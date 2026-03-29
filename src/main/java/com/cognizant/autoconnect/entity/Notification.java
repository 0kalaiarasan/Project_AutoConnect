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
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private Long recipientId; // User ID or Customer ID
    
    private String type; // Email, SMS, In-App
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    private LocalDateTime sentAt;
    
    private Boolean isRead;
    
    @PrePersist
    public void prePersist() {
        if(sentAt == null) {
            sentAt = LocalDateTime.now();
        }
        if(isRead == null) {
            isRead = false;
        }
    }
}

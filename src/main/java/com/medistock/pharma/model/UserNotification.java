package com.medistock.pharma.model;

import lombok.*;
        import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserNotification {

    @Id
    private String id;

    private String message;

    private boolean read;
}
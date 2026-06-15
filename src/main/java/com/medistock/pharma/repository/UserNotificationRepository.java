package com.medistock.pharma.repository;

import com.medistock.pharma.model.UserNotification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserNotificationRepository
        extends MongoRepository<UserNotification, String> {
}
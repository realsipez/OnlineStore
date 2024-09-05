package me.sina.notification.service;

import me.sina.notification.dto.NotificationRequest;
import me.sina.notification.model.Notification;
import me.sina.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(new Notification("Product", notificationRequest.getMessage(), LocalDateTime.now()));
    }
}
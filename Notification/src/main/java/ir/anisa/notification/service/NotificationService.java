package ir.anisa.notification.service;

import ir.anisa.notification.dto.NotificationDTO;

public interface NotificationService {
    void sendNotification(NotificationDTO notificationDTO);
}

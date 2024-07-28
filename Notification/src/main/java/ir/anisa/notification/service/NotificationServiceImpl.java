package ir.anisa.notification.service;

import ir.anisa.notification.dto.NotificationDTO;
import ir.anisa.notification.model.Notification;
import ir.anisa.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        notificationRepository.save(new Notification("Product", notificationDTO.getMessage(), LocalDateTime.now()));
    }
}

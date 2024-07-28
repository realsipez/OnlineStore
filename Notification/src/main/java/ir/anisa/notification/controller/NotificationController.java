package ir.anisa.notification.controller;

import ir.anisa.notification.dto.NotificationDTO;
import ir.anisa.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification/")
public class NotificationController {


    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping("/send")
    public void sendNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.sendNotification(notificationDTO);
    }
}

package ir.anisa.client.notification;

import ir.anisa.client.common.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTIFICATION")
public interface NotificationClient {

    @PostMapping(Constants.NOTIFICATION_SEND_API_URL)
    void sendNotification(@RequestBody NotificationDTO notificationDTO);
}

package me.sina.client.notification;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("NOTIFICATION")
public interface NotificationClient {
}

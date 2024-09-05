package me.sina.notification.messaging.consumer.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import me.sina.notification.dto.NotificationRequest;
import me.sina.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {


    private final NotificationService notificationService;

    @Autowired
    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consume(NotificationRequest notificationRequest) {
        log.warn("====>Consumed  {} from Queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}

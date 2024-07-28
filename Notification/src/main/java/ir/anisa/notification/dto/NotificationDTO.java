package ir.anisa.notification.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NotificationDTO implements Serializable {
    private String message;
}

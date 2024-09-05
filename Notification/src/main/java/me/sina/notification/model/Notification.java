package me.sina.notification.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;
    @NonNull
    private String sender;
    @NonNull
    private String message;
    @NonNull
    private LocalDateTime sendAt;
}

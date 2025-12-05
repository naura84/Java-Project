package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class MessageEntity {
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private String subject;
    private String body;
    private LocalDateTime sentAt;
    private LocalDateTime readAt;
    private String attachments; // JSON
}

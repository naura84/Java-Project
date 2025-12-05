package models;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Notification {
    private Integer id;
    private Integer userId;
    private String title;
    private String message;
    private String link;
    private Boolean isRead;
    private LocalDateTime createdAt;
}

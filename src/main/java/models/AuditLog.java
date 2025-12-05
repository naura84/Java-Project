package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AuditLog {
    private Long id;
    private Integer userId;
    private String action;
    private String entity;
    private String entityId;
    private String description;
    private String ipAddress;
    private String userAgent;
    private LocalDateTime createdAt;
}

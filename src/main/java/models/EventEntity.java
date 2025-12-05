package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class EventEntity {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private String location;
    private String audience; // JSON
    private Integer createdBy;
    private LocalDateTime createdAt;
}

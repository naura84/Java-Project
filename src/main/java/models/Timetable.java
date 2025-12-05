package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Timetable {
    private Integer id;
    private String ownerType;
    private Integer ownerId;
    private Integer termId;
    private String schedule; // JSON
    private java.time.LocalDateTime updatedAt;
}

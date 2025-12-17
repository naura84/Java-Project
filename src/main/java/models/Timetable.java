package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "timetables")
@Getter
@Setter
@NoArgsConstructor
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ownerType;
    private Integer ownerId;
    private Integer termId;
    private String schedule; // JSON
    private java.time.LocalDateTime updatedAt;
}

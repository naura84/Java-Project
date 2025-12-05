package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CourseOffering {
    private Integer id;
    private Integer courseId;
    private Integer termId;
    private Integer instructorId;
    private Integer classId;
    private Integer roomId;
    private String schedule; // JSON as String
    private Integer maxCapacity;
    private Integer enrolledCount;
    private String status;
    private LocalDateTime createdAt;
}

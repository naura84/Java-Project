package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Attendance {
    private Integer id;
    private Integer studentId;
    private Integer courseOfferingId;
    private LocalDate date;
    private String status;
    private Integer recordedBy;
    private LocalDateTime recordedAt;
    private String notes;
}

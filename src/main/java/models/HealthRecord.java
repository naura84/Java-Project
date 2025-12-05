package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class HealthRecord {
    private Integer id;
    private Integer userId;
    private String bloodType;
    private String allergies;
    private String chronicConditions;
    private String medications;
    private String emergencyInstructions;
    private LocalDateTime lastUpdate;
}

package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class MedicalVisit {
    private Integer id;
    private Integer userId;
    private LocalDateTime visitDate;
    private String reason;
    private String diagnosis;
    private String treatment;
    private Boolean referred;
    private String notes;
}

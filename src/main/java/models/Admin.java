package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String title;
    private String officeLocation;
    private String permissions; // JSON as String
    private LocalDateTime createdAt;
}

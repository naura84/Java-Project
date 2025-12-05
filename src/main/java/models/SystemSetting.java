package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class SystemSetting {
    private String key;
    private String value;
    private String description;
    private LocalDateTime updatedAt;
}

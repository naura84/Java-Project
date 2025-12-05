package models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {
    private Integer id;
    private String code;
    private String label;
    private String description;
}

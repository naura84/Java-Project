package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Role {
    private Integer id;
    private String code;
    private String label;
    private String description;
}

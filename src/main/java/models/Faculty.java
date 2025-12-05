package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Faculty {
    private Integer id;
    private String code;
    private String name;
    private String description;
}

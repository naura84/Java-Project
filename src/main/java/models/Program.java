package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Program {
    private Integer id;
    private Integer departmentId;
    private String code;
    private String name;
    private String level;
    private Integer durationSemesters;
    private String description;
}

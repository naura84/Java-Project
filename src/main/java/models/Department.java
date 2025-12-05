package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Department {
    private Integer id;
    private Integer facultyId;
    private String code;
    private String name;
    private Integer headId;
}

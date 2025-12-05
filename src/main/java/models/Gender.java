package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Gender {
    private Integer id;
    private String code;
    private String label;
}

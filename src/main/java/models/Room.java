package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Room {
    private Integer id;
    private Integer buildingId;
    private String code;
    private String name;
    private Integer capacity;
    private String type;
}

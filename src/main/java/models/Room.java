package models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Room {
    private Integer id;
    private Integer buildingId;
    private String code;
    private String name;
    private Integer capacity;
    private String type;
}

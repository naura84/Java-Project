package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class TransportRoute {
    private Integer id;
    private String name;
    private String stops; // JSON
    private Boolean active;
}

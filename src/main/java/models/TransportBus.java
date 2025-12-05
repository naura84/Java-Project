package models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class TransportBus {
    private Integer id;
    private String plateNumber;
    private String driverName;
    private Integer capacity;
    private String routeDescription;
}

package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transport_buses")
@Getter
@Setter
@NoArgsConstructor
public class TransportBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plateNumber;
    private String driverName;
    private Integer capacity;
    private String routeDescription;
}

package models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String officeLocation;
    private String permissions; // JSON as String
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User user;
}

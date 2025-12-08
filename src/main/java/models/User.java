package models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private String passwordResetToken;
    private LocalDateTime passwordResetExpires;

    @OneToMany(mappedBy = "user")
    private List<UserProfile> profiles;
    @jakarta.persistence.Transient
    private String sessionId;
}
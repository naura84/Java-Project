package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private Integer roleId;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private String passwordResetToken;
    private LocalDateTime passwordResetExpires;
}
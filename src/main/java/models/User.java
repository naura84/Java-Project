package models;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
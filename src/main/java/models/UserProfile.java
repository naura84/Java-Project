package models;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {
    @Id
    private Integer userId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preferredName;
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;
    private LocalDate birthDate;
    private String placeOfBirth;
    private String photoPath;
    private String addressFull;
    private String city;
    private String postalCode;
    private String country;
    private String phoneMobile;
    private String phoneHome;
    private String emergencyContactName;
    private String emergencyContactRelation;
    private String emergencyContactPhone;
    private String timezone;
    private String languagePref;
}

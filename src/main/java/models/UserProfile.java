package models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class UserProfile {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preferredName;
    private Integer genderId;
    private Integer nationalityId;
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

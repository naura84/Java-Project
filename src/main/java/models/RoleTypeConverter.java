package models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class RoleTypeConverter implements AttributeConverter<RoleType, String> {

    @Override
    public String convertToDatabaseColumn(RoleType attribute) {
        if (attribute == null) return null;
        // store the enum name (ADMIN, STUDENT, TEACHER)
        return attribute.name();
    }

    @Override
    public RoleType convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String v = dbData.trim();
        // Accept common synonyms and legacy values
        switch (v.toUpperCase()) {
            case "PROF":
            case "PROFESSOR":
            case "TEACHER":
                return RoleType.TEACHER;
            case "ADMIN":
            case "ADMINISTRATOR":
                return RoleType.ADMIN;
            case "STUDENT":
            case "ETUDIANT":
            case "ELEVE":
                return RoleType.STUDENT;
            default:
                // try enum name
                try {
                    return RoleType.valueOf(v.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    // try code mapping (like 'admin','teacher')
                    return RoleType.fromCode(v);
                }
        }
    }
}

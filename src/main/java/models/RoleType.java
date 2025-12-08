package models;

public enum RoleType {
    ADMIN("admin"),
    STUDENT("student"),
    TEACHER("teacher");

    private final String code;

    RoleType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static RoleType fromCode(String c) {
        if (c == null) return null;
        String lc = c.trim().toLowerCase();
        for (RoleType r : values()) if (r.code.equals(lc)) return r;
        return null;
    }
}

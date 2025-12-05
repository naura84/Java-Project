package models;

public class Program {
    private Integer id;
    private Integer departmentId;
    private String code;
    private String name;
    private String level;
    private Integer durationSemesters;
    private String description;

    public Program() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getDepartmentId() { return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }

    public void setLevel(String level) { this.level = level; }

    public Integer getDurationSemesters() { return durationSemesters; }

    public void setDurationSemesters(Integer durationSemesters) { this.durationSemesters = durationSemesters; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}

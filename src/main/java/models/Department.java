package models;

public class Department {
    private Integer id;
    private Integer facultyId;
    private String code;
    private String name;
    private Integer headId;

    public Department() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getFacultyId() { return facultyId; }

    public void setFacultyId(Integer facultyId) { this.facultyId = facultyId; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getHeadId() { return headId; }

    public void setHeadId(Integer headId) { this.headId = headId; }
}

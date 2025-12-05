package models;

public class Gender {
    private Integer id;
    private String code;
    private String label;

    public Gender() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getLabel() { return label; }

    public void setLabel(String label) { this.label = label; }

    @Override
    public String toString() { return "Gender{"+"id="+id+", code='"+code+'\''+"}"; }
}

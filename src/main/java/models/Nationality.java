package models;

public class Nationality {
    private Integer id;
    private String code;
    private String name;

    public Nationality() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return "Nationality{"+"id="+id+", name='"+name+'\''+"}"; }
}

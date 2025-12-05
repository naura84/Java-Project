package models;

import java.time.LocalDateTime;

public class Admin {
    private Integer id;
    private String title;
    private String officeLocation;
    private String permissions; // JSON as String
    private LocalDateTime createdAt;

    public Admin() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getOfficeLocation() { return officeLocation; }

    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }

    public String getPermissions() { return permissions; }

    public void setPermissions(String permissions) { this.permissions = permissions; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() { return "Admin{"+"id="+id+", title='"+title+'\''+"}"; }
}

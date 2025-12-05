package models;

public class Timetable {
    private Integer id;
    private String ownerType;
    private Integer ownerId;
    private Integer termId;
    private String schedule; // JSON
    private java.time.LocalDateTime updatedAt;

    public Timetable() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getOwnerType() { return ownerType; }

    public void setOwnerType(String ownerType) { this.ownerType = ownerType; }

    public Integer getOwnerId() { return ownerId; }

    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }

    public Integer getTermId() { return termId; }

    public void setTermId(Integer termId) { this.termId = termId; }

    public String getSchedule() { return schedule; }

    public void setSchedule(String schedule) { this.schedule = schedule; }

    public java.time.LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(java.time.LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {
    private Integer id;
    private Integer studentId;
    private Integer courseOfferingId;
    private LocalDate date;
    private String status;
    private Integer recordedBy;
    private LocalDateTime recordedAt;
    private String notes;

    public Attendance() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getCourseOfferingId() { return courseOfferingId; }

    public void setCourseOfferingId(Integer courseOfferingId) { this.courseOfferingId = courseOfferingId; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Integer getRecordedBy() { return recordedBy; }

    public void setRecordedBy(Integer recordedBy) { this.recordedBy = recordedBy; }

    public LocalDateTime getRecordedAt() { return recordedAt; }

    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}

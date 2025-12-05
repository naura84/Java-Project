package models;

import java.time.LocalDateTime;

public class CourseOffering {
    private Integer id;
    private Integer courseId;
    private Integer termId;
    private Integer instructorId;
    private Integer classId;
    private Integer roomId;
    private String schedule; // JSON as String
    private Integer maxCapacity;
    private Integer enrolledCount;
    private String status;
    private LocalDateTime createdAt;

    public CourseOffering() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getCourseId() { return courseId; }

    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public Integer getTermId() { return termId; }

    public void setTermId(Integer termId) { this.termId = termId; }

    public Integer getInstructorId() { return instructorId; }

    public void setInstructorId(Integer instructorId) { this.instructorId = instructorId; }

    public Integer getClassId() { return classId; }

    public void setClassId(Integer classId) { this.classId = classId; }

    public Integer getRoomId() { return roomId; }

    public void setRoomId(Integer roomId) { this.roomId = roomId; }

    public String getSchedule() { return schedule; }

    public void setSchedule(String schedule) { this.schedule = schedule; }

    public Integer getMaxCapacity() { return maxCapacity; }

    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; }

    public Integer getEnrolledCount() { return enrolledCount; }

    public void setEnrolledCount(Integer enrolledCount) { this.enrolledCount = enrolledCount; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

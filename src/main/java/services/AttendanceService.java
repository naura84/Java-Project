package services;

import dao.GenericDAO;
import models.Attendance;

import java.util.List;

public class AttendanceService extends BaseService<Attendance, Integer> {

    public AttendanceService(GenericDAO<Attendance, Integer> dao) {
        super(dao);
    }

    public Attendance recordAttendance(Attendance at) {
        return save(at);
    }

    public Attendance justifyAbsence(Integer attendanceId, String reason) {
        Attendance at = find(attendanceId);
        if (at == null) throw new IllegalArgumentException("Attendance not found");
        at.setNotes(reason);
        return update(at);
    }

    public List<Attendance> attendanceStatsForStudent(Integer studentId) {
        String jpql = "SELECT a FROM Attendance a WHERE a.student.id = :sid";
        return dao.findWithQuery(jpql, java.util.Map.of("sid", studentId));
    }
}

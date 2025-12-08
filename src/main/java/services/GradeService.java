package services;

import dao.GenericDAO;
import models.Assessment;
import models.Grade;
import models.Course;

import java.math.BigDecimal;
import java.util.List;

public class GradeService extends BaseService<Grade, Integer> {

    private final GenericDAO<Grade, Integer> gradeDao;

    public GradeService(GenericDAO<Grade, Integer> dao) {
        super(dao);
        this.gradeDao = dao;
    }

    public Grade addGrade(Grade g) {
        return save(g);
    }

    public double calculateAverage(Integer studentId, Integer courseId) {
        String jpql = "SELECT g FROM Grade g WHERE g.student.id = :sid AND g.assessment.courseOffering.course.id = :cid";
        List<Grade> list = gradeDao.findWithQuery(jpql, java.util.Map.of("sid", studentId, "cid", courseId));
        if (list == null || list.isEmpty()) return 0.0;
        double sum = 0.0;
        int count = 0;
        for (Grade g : list) {
            BigDecimal sc = g.getScore();
            if (sc != null) {
                sum += sc.doubleValue();
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;
    }

    public double calculateGPA(Integer studentId) {
        String jpql = "SELECT g FROM Grade g WHERE g.student.id = :sid";
        List<Grade> list = gradeDao.findWithQuery(jpql, java.util.Map.of("sid", studentId));
        if (list == null || list.isEmpty()) return 0.0;
        double totalPoints = 0.0;
        int totalCredits = 0;
        for (Grade g : list) {
            BigDecimal sc = g.getScore();
            Assessment a = g.getAssessment();
            if (sc == null || a == null || a.getCourseOffering() == null || a.getCourseOffering().getCourse() == null) continue;
            Course course = a.getCourseOffering().getCourse();
            int credits = course.getCredits() != null ? course.getCredits().intValue() : 1;
            double gradePoint = mapScoreToPoint(sc);
            totalPoints += gradePoint * credits;
            totalCredits += credits;
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    private double mapScoreToPoint(BigDecimal score) {
        double s = score.doubleValue();
        if (s >= 90) return 4.0;
        if (s >= 80) return 3.0;
        if (s >= 70) return 2.0;
        if (s >= 60) return 1.0;
        return 0.0;
    }
}

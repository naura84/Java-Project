package services;

import dao.GenericDAO;
import models.CourseOffering;
import models.Enrollment;
import models.Etudiant;

import java.util.List;

public class EnrollmentService extends BaseService<Enrollment, Integer> {

    private final GenericDAO<CourseOffering, Integer> courseOfferingDao = new GenericDAO<>(CourseOffering.class);
    private final GenericDAO<Etudiant, Integer> studentDao = new GenericDAO<>(Etudiant.class);

    public EnrollmentService(GenericDAO<Enrollment, Integer> dao) {
        super(dao);
    }

    public Enrollment enrollStudent(Integer studentId, Integer courseOfferingId) {
        CourseOffering co = courseOfferingDao.find(courseOfferingId);
        Etudiant s = studentDao.find(studentId);
        if (co == null || s == null) throw new IllegalArgumentException("Invalid ids");
        Enrollment en = new Enrollment();
        en.setStudent(s);
        en.setCourseOffering(co);
        return save(en);
    }

    public List<Enrollment> listEnrollmentsForStudent(Integer studentId) {
        String jpql = "SELECT e FROM Enrollment e WHERE e.student.id = :sid";
        return dao.findWithQuery(jpql, java.util.Map.of("sid", studentId));
    }
}

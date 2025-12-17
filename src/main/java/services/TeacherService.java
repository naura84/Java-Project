package services;

import dao.GenericDAO;
import models.Course;
import models.CourseOffering;
import models.Enseignant;

import java.util.List;

/**
 * Teacher-related operations: assign to courses, update professional info, schedule retrieval.
 */
public class TeacherService extends BaseService<Enseignant, Integer> {

    private final GenericDAO<CourseOffering, Integer> offeringDao = new GenericDAO<>(CourseOffering.class);
    private final GenericDAO<Course, Integer> courseDao = new GenericDAO<>(Course.class);

    public TeacherService(GenericDAO<Enseignant, Integer> dao) {
        super(dao);
    }

    public CourseOffering assignToCourse(Integer teacherId, Integer courseId) {
        Course c = courseDao.find(courseId);
        if (c == null) throw new IllegalArgumentException("Course not found: " + courseId);
        CourseOffering co = new CourseOffering();
        co.setCourse(c);
        co.setInstructor(find(teacherId));
        // Persist using offering DAO
        return offeringDao.save(co);
    }

    public Enseignant updateProfessionalInfo(Enseignant t) {
        return update(t);
    }

    public List<CourseOffering> getTeachingSchedule(Integer teacherId) {
        String jpql = "SELECT o FROM CourseOffering o WHERE o.instructor.id = :tid ORDER BY o.id DESC";
        return offeringDao.findWithQuery(jpql, java.util.Map.of("tid", teacherId));
    }
}

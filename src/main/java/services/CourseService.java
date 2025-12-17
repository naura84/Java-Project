package services;

import dao.GenericDAO;
import models.Course;
import models.CourseOffering;
import models.Enseignant;

import java.util.List;

public class CourseService extends BaseService<Course, Integer> {

    private final GenericDAO<CourseOffering, Integer> offeringDao = new GenericDAO<>(CourseOffering.class);
    private final GenericDAO<Enseignant, Integer> teacherDao = new GenericDAO<>(Enseignant.class);

    public CourseService(GenericDAO<Course, Integer> dao) {
        super(dao);
    }

    public Course createCourse(Course c) {
        return save(c);
    }

    public CourseOffering createClass(Integer courseId, String className) {
        Course c = find(courseId);
        if (c == null) throw new IllegalArgumentException("Course not found: " + courseId);
        CourseOffering co = new CourseOffering();
        co.setCourse(c);
        // CourseOffering doesn't have a 'name' field; use schedule/status as placeholder
        co.setSchedule(className);
        return offeringDao.save(co);
    }

    public CourseOffering addTeacherToCourse(Integer courseOfferingId, Integer teacherId) {
        CourseOffering co = offeringDao.find(courseOfferingId);
        Enseignant t = teacherDao.find(teacherId);
        if (co == null || t == null) throw new IllegalArgumentException("Invalid ids");
        co.setInstructor(t);
        return offeringDao.update(co);
    }

    public void setVolumeHours(Integer courseId, Integer hours) {
        Course c = find(courseId);
        if (c == null) throw new IllegalArgumentException("Course not found: " + courseId);
        c.setCoefficient(hours);
        update(c);
    }

    public List<CourseOffering> listOfferings(Integer courseId) {
        String jpql = "SELECT o FROM CourseOffering o WHERE o.course.id = :cid";
        return offeringDao.findWithQuery(jpql, java.util.Map.of("cid", courseId));
    }

    /**
     * List latest course offerings across all courses, ordered by id desc (most recent first).
     * @param max maximum number of offerings to return
     */
    public java.util.List<CourseOffering> listLatestOfferings(int max) {
        String jpql = "SELECT o FROM CourseOffering o ORDER BY o.id DESC";
        return offeringDao.findWithQuery(jpql, null, max);
    }
}


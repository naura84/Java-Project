package services;

import dao.GenericDAO;
import models.Course;

/**
 * Example service for `Course` demonstrating how to use `GenericDAO`.
 * If you prefer DI, create and inject `GenericDAO<Course, Integer>` instead of `new`ing it.
 */
public class CourseService extends BaseService<Course, Integer> {

    public CourseService() {
        super(new GenericDAO<>(Course.class));
    }

    // Add course-specific business methods here. Examples:
    public java.util.List<Course> findByDepartmentId(Integer deptId) {
        String jpql = "SELECT c FROM Course c WHERE c.department.id = :deptId";
        return dao.findWithQuery(jpql, java.util.Map.of("deptId", deptId));
    }
}

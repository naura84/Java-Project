package services;

import dao.GenericDAO;
import models.Etudiant;
import models.SchoolClass;
import java.util.List;

/**
 * Student-related operations: create, update, assign to class, status management.
 */
public class StudentService extends BaseService<Etudiant, Integer> {

    private final GenericDAO<SchoolClass, Integer> classDao = new GenericDAO<>(SchoolClass.class);

    public StudentService(GenericDAO<Etudiant, Integer> dao) {
        super(dao);
    }

    public Etudiant createStudent(Etudiant s) {
        return save(s);
    }

    public Etudiant updateStudent(Etudiant s) {
        return update(s);
    }

    public Etudiant assignToClass(Etudiant student, Integer classId) {
        SchoolClass sc = classDao.find(classId);
        if (sc == null) throw new IllegalArgumentException("Class not found: " + classId);
        student.setCurrentLevel(sc.getName());
        return update(student);
    }

    public Etudiant getStudentRecord(Integer id) {
        return find(id);
    }

    public Etudiant changeStatus(Etudiant student, String status) {
        student.setStatus(status);
        return update(student);
    }

    public List<Etudiant> getAllStudents() {
        return findAll();
    }
}

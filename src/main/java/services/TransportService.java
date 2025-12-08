package services;

import dao.GenericDAO;
import models.TransportBus;
import models.TransportRoute;
import models.Etudiant;

import java.util.List;

public class TransportService extends BaseService<TransportRoute, Integer> {

    private final GenericDAO<TransportBus, Integer> busDao = new GenericDAO<>(TransportBus.class);
    private final GenericDAO<Etudiant, Integer> studentDao = new GenericDAO<>(Etudiant.class);

    public TransportService(GenericDAO<TransportRoute, Integer> dao) {
        super(dao);
    }

    public TransportBus createBus(TransportBus b) {
        return busDao.save(b);
    }

    public TransportRoute createRoute(TransportRoute r) {
        return save(r);
    }

    public TransportRoute registerStudentToRoute(Integer studentId, Integer routeId) {
        Etudiant s = studentDao.find(studentId);
        TransportRoute r = find(routeId);
        if (s == null || r == null) throw new IllegalArgumentException("Invalid ids");
        // The model currently has no student collection on TransportRoute.
        // To register students to routes add an association on the model
        // (e.g. List<Etudiant> students) or create a TransportRegistration entity.
        throw new UnsupportedOperationException("Transport student registration not implemented; update model to include student association or add registration entity");
    }

    public List<TransportRoute> listRoutes() {
        return findAll();
    }
}

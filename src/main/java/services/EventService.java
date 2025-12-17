package services;

import dao.GenericDAO;
import models.EventEntity;

import java.util.List;

public class EventService extends BaseService<EventEntity, Integer> {

    public EventService(GenericDAO<EventEntity, Integer> dao) {
        super(dao);
    }

    public EventEntity scheduleEvent(EventEntity e) {
        EventEntity saved = save(e);
        // Optionally trigger notifications
        return saved;
    }

    public List<EventEntity> listUpcoming() {
        String jpql = "SELECT ev FROM EventEntity ev WHERE ev.startDatetime >= CURRENT_TIMESTAMP ORDER BY ev.startDatetime ASC";
        return dao.findWithQuery(jpql, null);
    }

    public java.util.List<EventEntity> listUpcoming(int max) {
        String jpql = "SELECT ev FROM EventEntity ev WHERE ev.startDatetime >= CURRENT_TIMESTAMP ORDER BY ev.startDatetime ASC";
        return dao.findWithQuery(jpql, null, max);
    }
}

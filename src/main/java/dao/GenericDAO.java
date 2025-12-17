package dao;

import config.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Generic JPA DAO providing basic CRUD operations for any entity type.
 *
 * Example:
 *   GenericDAO<Course, Integer> courseDao = new GenericDAO<>(Course.class);
 *   courseDao.save(course);
 */
public class GenericDAO<T, ID> {

    protected final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T find(ID id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public List<T> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String ql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            TypedQuery<T> q = em.createQuery(ql, entityClass);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public T save(T entity) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public T update(T entity) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T merged = em.merge(entity);
            em.getTransaction().commit();
            return merged;
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public void delete(T entity) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T managed = entity;
            if (!em.contains(entity)) {
                managed = em.merge(entity);
            }
            em.remove(managed);
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public boolean deleteById(ID id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T found = em.find(entityClass, id);
            if (found == null) {
                em.getTransaction().commit();
                return false;
            }
            em.remove(found);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public boolean existsById(ID id) {
        return find(id) != null;
    }

    public long count() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String ql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e";
            Query q = em.createQuery(ql);
            return ((Number) q.getSingleResult()).longValue();
        } finally {
            em.close();
        }
    }

    public List<T> findWithQuery(String jpql, Map<String, Object> params) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<T> q = em.createQuery(jpql, entityClass);
            if (params != null) {
                params.forEach(q::setParameter);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Execute JPQL and return results with an optional maximum number of results.
     */
    public List<T> findWithQuery(String jpql, Map<String, Object> params, int maxResults) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<T> q = em.createQuery(jpql, entityClass);
            if (params != null) {
                params.forEach(q::setParameter);
            }
            if (maxResults > 0) q.setMaxResults(maxResults);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}

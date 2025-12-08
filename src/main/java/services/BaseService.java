package services;

import dao.GenericDAO;


public class BaseService<T, ID> {

    protected final GenericDAO<T, ID> dao;

    public BaseService(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    public T find(ID id) {
        return dao.find(id);
    }

    public java.util.List<T> findAll() {
        return dao.findAll();
    }

    public T save(T entity) {
        return dao.save(entity);
    }

    public T update(T entity) {
        return dao.update(entity);
    }

    public void delete(T entity) {
        dao.delete(entity);
    }

    public boolean deleteById(ID id) {
        return dao.deleteById(id);
    }

    public boolean existsById(ID id) {
        return dao.existsById(id);
    }

    public long count() {
        return dao.count();
    }
}

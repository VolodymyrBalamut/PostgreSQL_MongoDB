package DAO;

import java.util.List;

public interface IDAO<T> {
    List<T> findAll();
    List<T> findById(int id);
    List<T> findByName(String name);
    boolean insert(T obj);
    boolean update(T obj);
    boolean delete(T obj);
}

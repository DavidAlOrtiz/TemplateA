package mx.dva.ortiz.jsf.repository;

import java.util.List;

public interface IGenericRepository<T> {
    List<T> getAll();
    T getById(Long id);
    void save(T t);
    void eliminar(Long id);
}

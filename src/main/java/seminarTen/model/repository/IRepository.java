package seminarTen.model.repository;

import seminarTen.exceptions.ProductAddException;

import java.util.List;
/**
 * универсальный интерфейс репозитория для взаимодействия с данными
  */
public interface IRepository<E> {
    E getById(int id);
    List<E> getAll();
    void add(E e) throws ProductAddException;
    void delete(int id);
}

package io.dumasoft.library.models.dao;

import java.util.List;

public interface IBookDao<T> {
    public List<T> findAll();

    public void save(T item);

    public T findOne(Long id);

    public void delete(Long id);
}

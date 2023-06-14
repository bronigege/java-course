package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IAuthorDao extends CrudRepository<Author, Long>, PagingAndSortingRepository<Author, Long> {
    /*public List<T> findAll();

    public void save(T item);

    public T findOne(Long id);

    public void delete(Long id);*/
}

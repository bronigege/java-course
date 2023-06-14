package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBookDao extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {

}

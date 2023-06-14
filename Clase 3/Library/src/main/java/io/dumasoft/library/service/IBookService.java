package io.dumasoft.library.service;

import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    public List<Book> findAll();
    public void save(Book book);
    public Book findOne(Long id);
    public void delete(Long id);

    public Page<Book> findAll(Pageable pageable);
}

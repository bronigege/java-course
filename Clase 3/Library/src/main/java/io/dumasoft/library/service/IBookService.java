package io.dumasoft.library.service;

import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> findAll();
    public void save(Book book);
    public Book findOne(Long id);
    public void delete(Long id);
}

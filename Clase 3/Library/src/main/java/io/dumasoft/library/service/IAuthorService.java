package io.dumasoft.library.service;

import io.dumasoft.library.models.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAuthorService {
    public List<Author> findAll();
    public void save(Author author);
    public Author findOne(Long id);
    public void delete(Long id);

    public Page<Author> findAll(Pageable pageable);
}

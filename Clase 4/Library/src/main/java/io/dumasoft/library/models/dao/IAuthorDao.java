package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAuthorDao extends PagingAndSortingRepository<Author, Long>, CrudRepository<Author, Long> {
}

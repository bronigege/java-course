package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Editorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEditorialDao extends PagingAndSortingRepository<Editorial, Long>, CrudRepository<Editorial, Long> {
}

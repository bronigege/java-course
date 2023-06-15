package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.Format;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFormatDao extends PagingAndSortingRepository<Format, Long>, CrudRepository<Format, Long> {
}

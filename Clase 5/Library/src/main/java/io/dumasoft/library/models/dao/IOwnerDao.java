package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface IOwnerDao extends CrudRepository<Owner, Long> {
}

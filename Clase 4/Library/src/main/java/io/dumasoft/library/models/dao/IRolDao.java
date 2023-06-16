package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.admin.Role;
import io.dumasoft.library.models.entity.admin.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRolDao extends CrudRepository<Role, Long> {

}

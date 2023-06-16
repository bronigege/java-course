package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Format;
import io.dumasoft.library.models.entity.admin.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserDao extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
    public User findByUsername(String username);
}

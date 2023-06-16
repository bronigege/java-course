package io.dumasoft.library.service.admin;

import io.dumasoft.library.models.entity.admin.Role;
import io.dumasoft.library.models.entity.admin.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRolService {
    public List<Role> findAll();

    public void save(Role role);

    public Role findOne(Long id);

    public void delete(Long id);
}

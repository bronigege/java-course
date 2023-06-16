package io.dumasoft.library.service.admin;

import io.dumasoft.library.models.dao.IRolDao;
import io.dumasoft.library.models.entity.admin.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {
    private IRolDao rolDao;

    public RolServiceImpl(IRolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) rolDao.findAll();
    }

    @Override
    public void save(Role role) {
        rolDao.save(role);
    }

    @Override
    public Role findOne(Long id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        rolDao.findById(id);
    }
}

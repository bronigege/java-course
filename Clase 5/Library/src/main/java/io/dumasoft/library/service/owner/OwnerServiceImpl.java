package io.dumasoft.library.service.owner;

import io.dumasoft.library.models.dao.IFormatDao;
import io.dumasoft.library.models.dao.IOwnerDao;
import io.dumasoft.library.models.entity.Format;
import io.dumasoft.library.models.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements IOwnerService {
    private final IOwnerDao ownerDao;

    @Autowired
    public OwnerServiceImpl(IOwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        return (List<Owner>) ownerDao.findAll();
    }

    @Override
    @Transactional
    public void save(Owner owner) {
        ownerDao.save(owner);
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findOne(Long id) {
        return ownerDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ownerDao.deleteById(id);
    }
}

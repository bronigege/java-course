package io.dumasoft.library.service.editorial;

import io.dumasoft.library.models.dao.IEditorialDao;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.models.entity.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditorialServiceImpl implements IEditorialService {
    private final IEditorialDao editorialDao;

    @Autowired
    public EditorialServiceImpl(IEditorialDao editorialDao) {
        this.editorialDao = editorialDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Editorial> findAll() {
        return (List<Editorial>) editorialDao.findAll();
    }

    @Override
    @Transactional
    public void save(Editorial editorial) {
        editorialDao.save(editorial);
    }

    @Override
    @Transactional(readOnly = true)
    public Editorial findOne(Long id) {
        return editorialDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        editorialDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Editorial> findAll(Pageable pageable) {
        return editorialDao.findAll(pageable);
    }
}

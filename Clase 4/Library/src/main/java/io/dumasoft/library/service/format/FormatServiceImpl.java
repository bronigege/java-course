package io.dumasoft.library.service.format;

import io.dumasoft.library.models.dao.IEditorialDao;
import io.dumasoft.library.models.dao.IFormatDao;
import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormatServiceImpl implements IFormatService {
    private final IFormatDao formatDao;

    @Autowired
    public FormatServiceImpl(IFormatDao formatDao) {
        this.formatDao = formatDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Format> findAll() {
        return (List<Format>) formatDao.findAll();
    }

    @Override
    @Transactional
    public void save(Format format) {
        formatDao.save(format);
    }

    @Override
    @Transactional(readOnly = true)
    public Format findOne(Long id) {
        return formatDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        formatDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Format> findAll(Pageable pageable) {
        return formatDao.findAll(pageable);
    }
}

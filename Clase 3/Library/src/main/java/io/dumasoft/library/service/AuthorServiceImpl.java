package io.dumasoft.library.service;

import io.dumasoft.library.models.dao.IAuthorDao;
import io.dumasoft.library.models.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    private final IAuthorDao<Author> authorDao;

    public AuthorServiceImpl(IAuthorDao<Author> authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Author author) {
        authorDao.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Author findOne(Long id) {
        return authorDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        authorDao.delete(id);
    }
}

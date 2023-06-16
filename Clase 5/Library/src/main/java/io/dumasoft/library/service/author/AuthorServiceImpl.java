package io.dumasoft.library.service.author;

import io.dumasoft.library.models.dao.IAuthorDao;
import io.dumasoft.library.models.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    private final IAuthorDao authorDao;

    @Autowired
    public AuthorServiceImpl(IAuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return (List<Author>) authorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Author book) {
        authorDao.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Author findOne(Long id) {
        return authorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        authorDao.deleteById(id);
    }

    @Override
    @Transactional
    public Page<Author> findAll(Pageable pageable) {
        return authorDao.findAll(pageable);
    }
}

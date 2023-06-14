package io.dumasoft.library.service;

import io.dumasoft.library.models.dao.IBookDao;
import io.dumasoft.library.models.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    private final IBookDao<Book> bookDao;

    public BookServiceImpl(IBookDao<Book> bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findOne(Long id) {
        return bookDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookDao.delete(id);
    }
}

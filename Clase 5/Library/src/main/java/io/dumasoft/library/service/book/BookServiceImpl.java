package io.dumasoft.library.service.book;

import io.dumasoft.library.models.dao.IBookDao;
import io.dumasoft.library.models.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    private final IBookDao bookDao;

    @Autowired
    public BookServiceImpl(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findOne(Long id) {
        return bookDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Book> findAll(Pageable pageable) {
        return bookDao.findAll(pageable);
    }
}

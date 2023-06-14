package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDaoImpl implements IBookDao<Book> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return entityManager.createQuery("FROM Book ").getResultList();
    }

    @Override
    @Transactional
    public void save(Book item) {
        entityManager.persist(item);
    }

    @Override
    public Book findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

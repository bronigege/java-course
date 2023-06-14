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
    public List<Book> findAll() {
        return entityManager.createQuery("FROM Book ").getResultList();
    }

    @Override
    public void save(Book item) {
        if (item.getId() != null && item.getId() > 0) {
            entityManager.merge(item);
        } else {
            entityManager.persist(item);
        }
    }

    @Override
    public Book findOne(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void delete(Long id) {
        Book book = findOne(id);
        entityManager.remove(book);
    }
}

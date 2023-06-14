package io.dumasoft.library.models.dao;

import io.dumasoft.library.models.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDaoImpl implements IAuthorDao<Author> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return entityManager.createQuery("FROM Author ").getResultList();
    }

    @Override
    @Transactional
    public void save(Author item) {
        if (item.getId() != null && item.getId() > 0) {
            entityManager.merge(item);
        } else {
            entityManager.persist(item);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Author findOne(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void delete(Long id) {

    }
}

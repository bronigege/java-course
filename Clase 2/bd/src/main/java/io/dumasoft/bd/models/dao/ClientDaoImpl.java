package io.dumasoft.bd.models.dao;

import io.dumasoft.bd.models.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements IPersonalDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("FROM Client").getResultList();
    }
}

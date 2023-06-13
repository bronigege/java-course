package io.dumasoft.bd.models.dao;

import io.dumasoft.bd.models.entity.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImpl implements IPersonalDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Profesor> findAll() {
        return entityManager.createQuery("FROM Profesor ").getResultList();
    }
}

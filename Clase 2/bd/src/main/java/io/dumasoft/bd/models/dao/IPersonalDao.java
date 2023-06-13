package io.dumasoft.bd.models.dao;

import io.dumasoft.bd.models.entity.Client;

import java.util.List;

public interface IPersonalDao<T> {
    public List<T> findAll();
}

package com.mars.edu.web.locallibs.model;

import com.mars.edu.web.locallibs.base.BaseRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 6:33
 * use for: 数据源持有者
 * 应用于service封装
 */
public class DataSourceHandler<T, ID extends Serializable> {
    private EntityManager entityManager;
    private BaseRepository<T,ID> repository;
    private T newEntity;

    public DataSourceHandler() {
    }

    public DataSourceHandler(EntityManager entityManager, BaseRepository<T, ID> repository, T newEntity) {
        this.entityManager = entityManager;
        this.repository = repository;
        this.newEntity = newEntity;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BaseRepository<T, ID> getRepository() {
        return repository;
    }

    public void setRepository(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T getNewEntity() {
        return newEntity;
    }

    public void setNewEntity(T newEntity) {
        this.newEntity = newEntity;
    }
}

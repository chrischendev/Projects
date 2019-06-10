package com.mars.edu.web.locallibs.base;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.*;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 22:16
 * use for:
 */
@Transactional
public interface BaseService<T, ID extends Serializable, R extends BaseRepository<T, ID>> {
    R getRepository();

    EntityManager getEntityManager();

    //增加
    default boolean add(T entity) {
        if (null == entity) {
            throw new NullPointerException("entity is null");
        }
        getRepository().saveAndFlush(entity);
        return true;
    }

    //批量添加 集合
    default boolean addBatch(Iterable<T> entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        Iterator<T> iterator = entities.iterator();
        EntityManager entityManager = getEntityManager();
        while (iterator.hasNext()) {
            T entity = iterator.next();
            entityManager.merge(entity);
        }
        entityManager.flush();
        entityManager.clear();
        return true;
    }

    //批量添加 数组
    default boolean addBatch(T... entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        return addBatch(Arrays.asList(entities));
    }

    //创建一个空的实体对象
    T createEntity();

    //给实体类添加id
    T addId(T entity, ID id);

    //删除 按照ID删除 删除没办法确定主键 所以可以删除对象
    default boolean delete(ID id) {
        if (null == id) {
            throw new NullPointerException("id is null");
        }
        getRepository().deleteById(id);
        return true;
    }

    //批量删除 按照ID
    default boolean deleteAllById(Iterable<ID> ids) {
        if (null == ids) {
            throw new NullPointerException("ids is null");
        }
        List<T> entityList = new ArrayList<>();
        Iterator<ID> iterator = ids.iterator();
        while (iterator.hasNext()) {
            ID id = iterator.next();
            T entity = createEntity();
            addId(entity, id);
            entityList.add(entity);
        }
        deleteAll(entityList);
        return true;
    }

    //批量删除 按照ID
    default boolean deleteAllById(ID... ids) {
        if (null == ids) {
            throw new NullPointerException("ids is null");
        }
        return deleteAllById(Arrays.asList(ids));
    }

    //删除对象
    default boolean delete(T entity) {
        if (null == entity) {
            throw new NullPointerException("entity is null");
        }
        getRepository().delete(entity);
        return true;
    }

    //批量删除对象 集合
    default boolean deleteAll(Iterable<T> entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        getRepository().deleteAll(entities);
        return true;
    }

    //批量删除对象 数组
    default boolean deleteAll(T... entities) {
        deleteAll(Arrays.asList(entities));
        return true;
    }

    //检查是否有id
    boolean existId(T entity);

    //批量检查是否有id
    default boolean existIdBatch(Iterable<T> entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        Iterator<T> iterator = entities.iterator();
        while (iterator.hasNext()) {
            T entity = iterator.next();
            if (!existId(entity)) {
                return false;
            }
        }
        return true;
    }

    //修改 其实就是add 必须带有id先进行id检查
    default boolean update(T entity) {
        if (null == entity) {
            throw new NullPointerException("entity is null");
        }
        if (!existId(entity)) {
            throw new NullPointerException("id is null ");
        }
        getRepository().saveAndFlush(entity);
        return true;
    }

    //批量修改
    default boolean updateAll(Iterable<T> entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        if (!existIdBatch(entities)) {
            throw new NullPointerException("some id is null ");
        }
        addBatch(entities);
        return true;
    }

    //批量修改
    default boolean updateAll(T... entities) {
        return updateAll(Arrays.asList(entities));
    }

    //查询
    default T findById(ID id) {
        if (null == id) {
            return null;
        }
        Optional<T> optional = getRepository().findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    //查询所有
    default List<T> findAll() {
        return getRepository().findAll();
    }
}

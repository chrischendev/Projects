package com.mars.edu.web.locallibs.base;

import com.mars.edu.web.locallibs.model.DataSourceHandler;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 22:16
 * use for: 基本业务处理
 *
 * @author chris
 */
@Transactional
public interface BaseService<T, ID extends Serializable> {
    /**
     * 获取数据源持有者
     *
     * @return
     */
    DataSourceHandler<T, ID> getDataSourceHandler();

    /**
     * 增加
     *
     * @param entity
     * @return
     */
    default boolean add(T entity) {
        if (null == entity) {
            throw new NullPointerException("entity is null");
        }
        getDataSourceHandler().getRepository().saveAndFlush(entity);
        return true;
    }

    /**
     * 批量添加 集合
     * 暂时有问题
     *
     * @param entities
     * @return
     */
    default boolean addBatch(Iterable<T> entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        Iterator<T> iterator = entities.iterator();
        EntityManager entityManager = getDataSourceHandler().getEntityManager();
        while (iterator.hasNext()) {
            T entity = iterator.next();
            entityManager.merge(entity);
        }
        entityManager.flush();
        entityManager.clear();
        return true;
    }
    /**
     * 批量添加 数组
     *
     * @param entities
     * @return
     */
    default boolean addBatch(T... entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        return addBatch(Arrays.asList(entities));
    }

    /**
     * 创建一个空的实体对象
     * @return
     */
    //T createEntity();

    /**
     * 给实体类添加id
     *
     * @param entity
     * @param id
     * @return
     */
    default T addId(T entity, ID id) {
        Class<?> entityClass = entity.getClass();
        try {
            Field idField = entityClass.getField("id");
            idField.setAccessible(true);
            idField.set(entity, id);
            idField.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * 删除 按照ID删除
     * 删除没办法确定主键 所以可以删除对象
     *
     * @param id
     * @return
     */
    default boolean delete(ID id) {
        if (null == id) {
            throw new NullPointerException("id is null");
        }
        getDataSourceHandler().getRepository().deleteById(id);
        return true;
    }

    /**
     * 批量删除 按照ID
     *
     * @param ids
     * @return
     */
    default boolean deleteAllById(Iterable<ID> ids) {
        if (null == ids) {
            throw new NullPointerException("ids is null");
        }
        List<T> entityList = new ArrayList<>();
        Iterator<ID> iterator = ids.iterator();
        while (iterator.hasNext()) {
            ID id = iterator.next();
            T entity = getDataSourceHandler().getNewEntity();
            addId(entity, id);
            entityList.add(entity);
        }
        deleteAll(entityList);
        return true;
    }

    /**
     * 批量删除 按照ID
     *
     * @param ids
     * @return
     */
    default boolean deleteAllById(ID... ids) {
        if (null == ids) {
            throw new NullPointerException("ids is null");
        }
        return deleteAllById(Arrays.asList(ids));
    }

    /**
     * 删除对象
     *
     * @param entity
     * @return
     */
    default boolean delete(T entity) {
        if (null == entity) {
            throw new NullPointerException("entity is null");
        }
        getDataSourceHandler().getRepository().delete(entity);
        return true;
    }

    /**
     * 批量删除对象 集合
     *
     * @param entities
     * @return
     */
    default boolean deleteAll(Iterable<T> entities) {
        if (null == entities) {
            throw new NullPointerException("entities is null");
        }
        getDataSourceHandler().getRepository().deleteAll(entities);
        return true;
    }

    /**
     * 批量删除对象 数组
     *
     * @param entities
     * @return
     */
    default boolean deleteAll(T... entities) {
        deleteAll(Arrays.asList(entities));
        return true;
    }

    /**
     * 检查是否有id
     *
     * @param entity
     * @return
     */
    boolean existId(T entity);

    /**
     * 批量检查是否有id
     *
     * @param entities
     * @return
     */
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

    /**
     * 修改 其实就是add 必须带有id先进行id检查
     *
     * @param entity
     * @return
     */
    default boolean update(T entity) {
        if (null == entity) {
            throw new NullPointerException("entity is null");
        }
        if (!existId(entity)) {
            throw new NullPointerException("id is null ");
        }
        getDataSourceHandler().getRepository().saveAndFlush(entity);
        return true;
    }

    /**
     * 批量修改
     *
     * @param entities
     * @return
     */
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

    /**
     * 批量修改
     *
     * @param entities
     * @return
     */
    default boolean updateAll(T... entities) {
        return updateAll(Arrays.asList(entities));
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    default T findById(ID id) {
        if (null == id) {
            return null;
        }
        Optional<T> optional = getDataSourceHandler().getRepository().findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    default List<T> findAll() {
        return getDataSourceHandler().getRepository().findAll();
    }
}

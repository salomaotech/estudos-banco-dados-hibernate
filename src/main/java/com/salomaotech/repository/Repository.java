package com.salomaotech.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class Repository<T> {

    private final JpaUtil jpaUtil;

    public Repository(JpaUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    public void save(T obj) {

        EntityManager manager = jpaUtil.entityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {

            manager.persist(obj);

        } catch (Exception ex) {

        }

        tx.commit();
        manager.close();

    }

    public T update(T obj) {

        EntityManager manager = jpaUtil.entityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {

            obj = manager.merge(obj);

        } catch (Exception ex) {

        }

        tx.commit();
        manager.close();

        return obj;

    }

    public void delete(Long id, Class<T> classe) {

        EntityManager manager = jpaUtil.entityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {

            T entity = manager.find(classe, id);

            if (entity != null) {
                manager.remove(entity);
            }

        } catch (Exception ex) {

        }

        tx.commit();
        manager.close();

    }

    public T findById(Long id, Class<T> classe) {

        T obj = null;
        EntityManager manager = jpaUtil.entityManager();

        try {

            obj = manager.find(classe, id);

        } catch (Exception ex) {

        }

        manager.close();
        return obj;

    }

    public List<T> findAll(Class<T> classe) {

        List<T> results = new ArrayList();
        EntityManager manager = jpaUtil.entityManager();

        try {

            Query query = manager.createQuery("select obj from " + classe.getName() + " obj ");
            results = query.getResultList();

        } catch (Exception ex) {

        }

        manager.close();
        return results;

    }
}

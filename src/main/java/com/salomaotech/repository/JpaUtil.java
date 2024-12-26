package com.salomaotech.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory factory;

    static {

        factory = Persistence.createEntityManagerFactory("Conexao");

    }

    public EntityManager entityManager() {

        return factory.createEntityManager();

    }

    public void close() {

        factory.close();

    }

}

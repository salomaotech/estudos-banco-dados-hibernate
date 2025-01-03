package com.salomaotech.services;

import com.salomaotech.repository.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 * Aqui ficam alguns exemplos de operações em lote utilizando JPQL
 *
 * @author Salomão Silva
 */
public class OperacoesLote {

    private final JpaUtil jpaUtil;

    public OperacoesLote(JpaUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    public void atualizarEmailsClientes() {

        EntityManager manager = jpaUtil.entityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Query query = manager.createQuery("update Cliente set nome = 'Amanda Silva' where email like :email");
        query.setParameter("email", "%@email.com");
        int linhas = query.executeUpdate();

        System.out.println("Linhas alteradas: " + linhas);

        tx.commit();
        manager.close();

    }

}

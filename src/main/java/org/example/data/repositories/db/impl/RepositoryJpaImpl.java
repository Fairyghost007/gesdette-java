package org.example.data.repositories.db.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.data.core.config.repository.Repository;

public class RepositoryJpaImpl<T> implements Repository<T> {

    protected EntityManager em;
    private Class<T> entityClass;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GESDETTE");

    public RepositoryJpaImpl(Class<T> entityClass) {
        this.em = emf.createEntityManager();
        this.entityClass = entityClass;
    }

    @Override
    public void insert(T objet) {
        em.getTransaction().begin();
        em.persist(objet);
        em.getTransaction().commit();
    }

    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean update(T objet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public List<T> selectAll() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(jpql, entityClass).getResultList();
    }

    @Override
    public T selectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}

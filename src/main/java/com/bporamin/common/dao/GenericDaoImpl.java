package com.bporamin.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Fang on 3/2/2017.
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E, I extends Serializable> implements GenericDao<E, I> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class clazz;

    protected GenericDaoImpl() {
        clazz = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // API
    @Override
    @Transactional(readOnly = true)
    public E findById(final I id) {
        return (E) getSession().get(clazz, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return getSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    @Transactional
    public void save(final E entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public E update(final E entity) {
        return (E) getSession().merge(entity);
    }

    @Override
    @Transactional
    public void delete(final E entity) {
        getSession().delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(final I id) {
        final E entity = findById(id);
        delete(entity);
    }

}

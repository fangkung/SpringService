package com.bporamin.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fang on 3/2/2017.
 */
public interface GenericDao<E, I extends Serializable> {

    public E findById(I id);

    public List<E> findAll();

    public void save(E entity);

    public E update(E entity);

    public void delete(E entity);

    public void deleteById(I id);

}

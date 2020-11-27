package com.dyl.service.base;

import java.util.List;

public interface BaseService<T> {

    public T findById(Integer id);

    public void deleteById(Integer id);

    public List<T> findAll();

    public void insert(T entity);
}

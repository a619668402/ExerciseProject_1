package com.dyl.service.base;

import java.util.List;

public interface BaseService<T> {

    public T findById(Integer id);

    public Integer deleteById(Integer id);

    public List<T> findAll();

    public Integer insert(T entity);
}

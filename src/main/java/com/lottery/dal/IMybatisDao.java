package com.lottery.dal;

/**
 * dao基础接口
 * User: ryanshi@tcl.com
 * Date: 2016-05-30
 * Time: 14:13
 */
public interface IMybatisDao<T extends IMybatisEntity> {

    public long save(T entity);

    public boolean update(T entity);

    public boolean delete(T entity);

    public T get(long id);
}

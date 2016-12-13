package com.lottery.commons.service.mybatisservice;

import com.lottery.dal.IMybatisEntity;
import com.sun.istack.internal.Nullable;

import javax.annotation.Nonnegative;

/**
 * 实体类数据服务封闭
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-17
 * Time: 14:39
 */
public interface IMybatisDataService<T extends IMybatisEntity> {

    /**
     * save
     * @param entity
     * @return
     */
    public T add(@Nullable T entity);

    /**
     * update
     * @param entity
     * @return
     */
    public boolean update(@Nullable T entity);

    /**
     * delete
     * @param entity
     * @return
     */
    public boolean delete(@Nullable T entity);

    /**
     * get
     * @param id
     * @return
     */
    public T get(@Nonnegative Long id);

}

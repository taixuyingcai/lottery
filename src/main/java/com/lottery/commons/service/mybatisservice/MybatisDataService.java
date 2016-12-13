package com.lottery.commons.service.mybatisservice;

import com.lottery.dal.IMybatisDao;
import com.lottery.dal.IMybatisEntity;

/**
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-09
 * Time: 17:42
 */
public abstract class MybatisDataService<T extends IMybatisEntity> {

    protected abstract IMybatisDao<T> getDao();

    /**
     * 添加
     * @param t
     * @return
     */
    public T add(T t) {
        getDao().save(t);
        if (t != null && t.getId() > 0) {
            return t;
        }
        return null;
    }

    public T get(Long id) {
        T t = getDao().get(id);
        if (t != null && t.getId() > 0) {
            return t;
        }
        return null;
    }

    public boolean delete(T t) {
        boolean flag = getDao().delete(t);
        if (flag) {
            return true;
        }
        return false;
    }

    public boolean update(T t) {
        boolean flag = getDao().update(t);
        if (flag) return true;
        return false;
    }

}

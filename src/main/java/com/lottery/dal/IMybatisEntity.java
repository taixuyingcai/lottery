package com.lottery.dal;

import java.io.Serializable;

/**
 * 所有实体类的基类，都要有一个id字段
 * User: ryanshi@tcl.com
 * Date: 2016-05-30
 * Time: 13:57
 */
public abstract class IMybatisEntity implements Serializable{

    protected long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

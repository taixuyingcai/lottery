package com.lottery.dal;

import com.sun.tools.corba.se.idl.constExpr.Times;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 所有实体类的基类，都要有一个id字段
 * User: ryanshi@tcl.com
 * Date: 2016-05-30
 * Time: 13:57
 */
public abstract class IMybatisEntity implements Serializable{

    protected long id;
    protected Timestamp createTime;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }
}

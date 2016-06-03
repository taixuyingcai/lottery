package com.lottery.dal;

import java.sql.Timestamp;

/**
 * 伪删除实体类
 * User: ryanshi@tcl.com
 * Date: 2016-05-30
 * Time: 14:03
 */
public abstract class IMybatisPseudoEntity extends IMybatisEntity{

    protected Timestamp updateTime;
    protected int isDel;

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}

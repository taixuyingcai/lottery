package com.lottery.model.bill;

import com.lottery.dal.IMybatisEntity;
import com.sun.tools.corba.se.idl.constExpr.Times;

import java.sql.Timestamp;

/**
 * 发票实体类
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 11:00
 */
public class Bill extends IMybatisEntity{

    private String name;

    private String title;

    private String type;

    private int count;

    private int cost;

    private int status;

    private Timestamp updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int state) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}

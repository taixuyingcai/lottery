package com.lottery.model.admin;

import com.lottery.dal.IMybatisPseudoEntity;

import java.sql.Timestamp;

/**
 * User: ryanshi@tcl.com
 * Date: 2016-05-30
 * Time: 13:47
 */
public class Admin extends IMybatisPseudoEntity {

    private String uid;
    private String name;
    private int roleType;
    private Timestamp createTime;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}

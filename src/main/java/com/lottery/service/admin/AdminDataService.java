package com.lottery.service.admin;

import com.google.inject.Inject;
import com.lottery.model.admin.Admin;

import java.util.List;

/**
 * User: ryanshi@tcl.com
 * Date: 2016-05-31
 * Time: 17:21
 */
public class AdminDataService implements IAdminDataService{

    @Inject
    private IAdminDao dao;

    @Override
    public int getCount(String uid, String name) {
        return dao.getCount(uid, name);
    }

    @Override
    public List<Admin> getList(String uid, String name, int indexFrom, int pageSize) {
        return dao.getForGrid(uid, name, indexFrom, pageSize);
    }
}

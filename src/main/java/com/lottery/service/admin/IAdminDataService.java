package com.lottery.service.admin;

import com.lottery.model.admin.Admin;

import java.util.List;

/**
 * admin dataservice
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-07
 * Time: 13:58
 */
public interface IAdminDataService {

    public int getCount(String uid, String name);

    public List<Admin> getList(String uid, String name, int indexFrom, int pageSize);
}

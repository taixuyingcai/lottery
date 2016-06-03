package com.lottery.service.admin;

import com.lottery.dal.IMybatisDao;
import com.lottery.model.admin.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: ryanshi@tcl.com
 * Date: 2016-05-31
 * Time: 17:00
 */
public interface IAdminDao extends IMybatisDao<Admin> {

    /**
     * 查询数量
     * @param uid
     * @param name
     * @return
     */
    public int getCount(@Param("uid")String uid, @Param("name")String name);

    /**
     * 查询列表
     * @param uid
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    public List<Admin> getForGrid(@Param("uid")String uid, @Param("name")String name, @Param("page")int page,
                                  @Param("pageSize")int pageSize);

    public Admin getById(@Param("id")long id);
}

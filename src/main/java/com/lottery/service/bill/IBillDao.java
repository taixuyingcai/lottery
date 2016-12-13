package com.lottery.service.bill;

import com.lottery.dal.IMybatisDao;
import com.lottery.model.bill.Bill;
import org.apache.ibatis.annotations.Param;

import java.security.PublicKey;
import java.util.List;

/**
 * 发票dao
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 11:10
 */
public interface IBillDao extends IMybatisDao<Bill> {

    public int getCount(@Param("name")String name);

    public List<Bill> getList(@Param("name")String name, @Param("pageIndex")int pageIndex, @Param("pageSize")
    int pageSize);
}

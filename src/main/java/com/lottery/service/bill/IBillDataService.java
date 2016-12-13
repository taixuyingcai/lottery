package com.lottery.service.bill;

import com.lottery.commons.service.mybatisservice.IMybatisDataService;
import com.lottery.model.bill.Bill;

import java.util.List;

/**
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 15:51
 */
public interface IBillDataService extends IMybatisDataService<Bill> {

    /**
     * 查询总数量
     * @param name
     * @return
     */
    public int getCount(String name);

    /**
     * 分页查询列表
     * @param name
     * @param indexFrom
     * @param pageSize
     * @return
     */
    public List<Bill> getList(String name, int indexFrom, int pageSize);
}

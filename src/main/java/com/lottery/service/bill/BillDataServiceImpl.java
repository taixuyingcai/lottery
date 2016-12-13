package com.lottery.service.bill;

import com.google.inject.Inject;
import com.lottery.commons.service.mybatisservice.MybatisDataService;
import com.lottery.dal.IMybatisDao;
import com.lottery.model.bill.Bill;

import java.util.List;

/**
 * 发票data服务
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 11:20
 */
public class BillDataServiceImpl extends MybatisDataService<Bill> implements IBillDataService {

    @Inject
    private IBillDao dao;

    @Override
    public int getCount(String name) {
        return dao.getCount(name);
    }

    public List<Bill> getList(String name, int indexFrom, int pageSize){
        List<Bill> list = dao.getList(name, indexFrom, pageSize);
        return list;
    }

    @Override
    protected IMybatisDao<Bill> getDao() {
        return dao;
    }
}

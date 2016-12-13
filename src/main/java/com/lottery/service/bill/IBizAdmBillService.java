package com.lottery.service.bill;

import com.lottery.model.UtilModel.Page;
import com.lottery.model.UtilModel.ServiceResponse;
import com.lottery.model.bill.Bill;

/**
 * 业务逻辑服务
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-19
 * Time: 14:27
 */
public interface IBizAdmBillService {

    public ServiceResponse<Bill> get(Long id);

    public ServiceResponse<Bill> add(Bill bill);

    public ServiceResponse modify(Bill bill);

    public ServiceResponse<Page<Bill>> getList(String name, int indexFrom, int pageSize);
}

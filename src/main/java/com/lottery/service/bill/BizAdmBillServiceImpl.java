package com.lottery.service.bill;

import com.google.inject.Inject;
import com.lottery.commons.constants.ErrorKey;
import com.lottery.model.UtilModel.Page;
import com.lottery.model.UtilModel.ServiceResponse;
import com.lottery.model.bill.Bill;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-19
 * Time: 14:50
 */
public class BizAdmBillServiceImpl implements IBizAdmBillService {

    @Inject
    private IBillDataService billDataService;

    @Override
    public ServiceResponse<Bill> get(Long id) {
        if (id == null || id <= 0) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_ARG);
        }
        Bill bill = billDataService.get(id);
        if (bill == null) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_DB_NOEXSIT);
        }
        return new ServiceResponse<Bill>(bill);
    }

    @Override
    public ServiceResponse<Bill> add(Bill bill) {
        if (bill == null) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_ARG);
        }
        Bill billDb = billDataService.add(bill);
        if (billDb == null) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_DAL);
        }
        return new ServiceResponse<Bill>(billDb);
    }

    @Override
    public ServiceResponse modify(Bill bill) {
        if (bill == null || bill.getId() <= 0) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_ARG);
        }
        Long id = bill.getId();
        Bill billDb = billDataService.get(id);
        if (billDb == null) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_DB_NOEXSIT);
        }
        billDb.setName(bill.getName());
        billDb.setTitle(bill.getTitle());
        billDb.setCount(bill.getCount());
        billDb.setCost(bill.getCost());
        billDb.setStatus(bill.getStatus());
        billDb.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Boolean flag = billDataService.update(billDb);
        if (!flag) {
            return ServiceResponse.genFailResponse(ErrorKey.ERROR_DAL);
        }
        return ServiceResponse.genSuccResponseWithoutData();
    }

    @Override
    public ServiceResponse<Page<Bill>> getList(String name, int pageIndex, int pageSize) {
        Page page = new Page(pageIndex, pageSize);
        int count = billDataService.getCount(name);
        page.setTotal(count);
        if (count == 0) {
            return new ServiceResponse<Page<Bill>>(page);
        }
        List<Bill> bills = billDataService.getList(name, page.getFromIndex(), pageSize);
        page.setItems(bills);
        return new ServiceResponse<Page<Bill>>(page);
    }
}

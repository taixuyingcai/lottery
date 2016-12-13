package com.lottery.controller.bill;

import com.lottery.Util.JsonUtil;
import com.lottery.Util.ResponseUtil;
import com.lottery.model.UtilModel.Page;
import com.lottery.model.UtilModel.ServiceResponse;
import com.lottery.model.bill.Bill;
import com.lottery.service.bill.IBizAdmBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * controller
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 10:59
 */
@Controller
@RequestMapping("/adm/bill/*")
public class BillController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    @Inject
    private IBizAdmBillService bizAdmBillService;

    @RequestMapping(value = "/billList", method = RequestMethod.GET)
    public ModelAndView toBillList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("/bill/billList");
        } catch (Exception e) {
            LOGGER.error("controller error e = ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/billGrid", method = RequestMethod.POST)
    public ModelAndView billGrid(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            String name = ServletRequestUtils.getStringParameter(request, "name");
            int indexFrom = ServletRequestUtils.getIntParameter(request, "page");
            int pageSize = ServletRequestUtils.getIntParameter(request, "rp");
            ServiceResponse<Page<Bill>> bills = bizAdmBillService.getList(name, indexFrom, pageSize);
            ResponseUtil.genJsonResult(modelAndView, JsonUtil.objToJson(bills), true, "");
        } catch (Exception e) {
            LOGGER.error("controller error e = ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/toAddBill", method = RequestMethod.GET)
    public ModelAndView toAddBill(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("/bill/addBill");
        } catch (Exception e) {
            LOGGER.error("controller error e = ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/doAddBill", method = RequestMethod.POST)
    public ModelAndView doAddBill(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            String name = ServletRequestUtils.getStringParameter(request, "name");
            String title = ServletRequestUtils.getStringParameter(request, "title");
            int cost = ServletRequestUtils.getIntParameter(request, "cost", 10000);
            int count = ServletRequestUtils.getIntParameter(request, "count", 1);
            Bill bill = new Bill();
            bill.setName(name);
            bill.setCost(cost);
            bill.setTitle(title);
            bill.setCount(count);
            bill.setStatus(1);
            bill.setType("");
            bill.setCreateTime(new Timestamp(System.currentTimeMillis()));
            ServiceResponse<Bill> serviceResponse = bizAdmBillService.add(bill);
            if (!serviceResponse.isSuccess()) {
                ResponseUtil.handleException(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/bill/billList");
        } catch (Exception e) {
            LOGGER.error("controller error e = ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/toModifyBill", method = RequestMethod.GET)
    public ModelAndView toModifyBill(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Long id = ServletRequestUtils.getLongParameter(request, "id");
            if (id == null || id <= 0) {
                ResponseUtil.handleException(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("/bill/updateBill");
            ServiceResponse<Bill> serviceResponse = bizAdmBillService.get(id);
            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("bill", serviceResponse.getResponseData());
            }
        } catch (Exception e) {
            LOGGER.error("controller error e = ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/doModifyBill", method = RequestMethod.POST)
    public ModelAndView doModifyBill(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Long id = ServletRequestUtils.getLongParameter(request, "id");
            String name = ServletRequestUtils.getStringParameter(request, "name");
            String title = ServletRequestUtils.getStringParameter(request, "title");
            int cost = ServletRequestUtils.getIntParameter(request, "cost", 10000);
            int count = ServletRequestUtils.getIntParameter(request, "count", 1);
            Bill bill = new Bill();
            bill.setId(id);
            bill.setName(name);
            bill.setCost(cost);
            bill.setTitle(title);
            bill.setCount(count);
            ServiceResponse serviceResponse = bizAdmBillService.modify(bill);
            if (!serviceResponse.isSuccess()) {
                modelAndView.addObject("errorTip", "修改失败");
                modelAndView.addObject("bill", bill);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/bill/billList");
        } catch (Exception e) {
            LOGGER.error("controller error e = ", e);
        }
        return modelAndView;
    }
}

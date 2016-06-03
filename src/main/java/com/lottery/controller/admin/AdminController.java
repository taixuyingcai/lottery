package com.lottery.controller.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.lottery.model.admin.Admin;
import com.lottery.model.common.FlexigridData;
import com.lottery.service.admin.IAdminDao;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: ryanshi@tcl.com
 * Date: 2016-05-31
 * Time: 17:15
 */
@Controller
@RequestMapping("/adm/admin/*")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private IAdminDao adminDao;

    @RequestMapping(value = "/toGrid", method = RequestMethod.GET)
    public ModelAndView jumpToGrid(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("/admin/adminList");
            return modelAndView;
        } catch (Exception e) {
            LOGGER.error("controller exception.", e);
            // TODO 跳转到错误提示页面
            return modelAndView;
        }
    }

    @RequestMapping(value = "/adminGrid", method = RequestMethod.POST)
    public ModelAndView getAdmin(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("controller getAdmin......");
        ModelAndView modelAndView = new ModelAndView();
        try {
            String uid = ServletRequestUtils.getStringParameter(request, "uid", "");
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            int page = ServletRequestUtils.getIntParameter(request, "page", 0);
            int pageSize = ServletRequestUtils.getIntParameter(request, "rp", 10);
            int count = adminDao.getCount(uid, name);
            int index = (page - 1) * pageSize;
            List<Admin> admins = adminDao.getForGrid(uid, name, index, pageSize);
            FlexigridData<Admin> data = new FlexigridData<>(count, page, admins);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String obj = gson.toJson(data);
            JSONObject dataJsonObject = new JSONObject(obj);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("data", dataJsonObject);
            jsonObject.put("result", true);
            modelAndView.addObject("resultData", jsonObject);
            modelAndView.setViewName("/commons/resultdata");
        } catch (Exception e) {
            LOGGER.error("controller exception .", e);
        }
        return modelAndView;
    }
}

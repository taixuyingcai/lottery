package com.lottery.Util;

import com.lottery.model.UtilModel.Page;
import com.lottery.model.common.FlexigridData;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * 返回结果工具类
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-30
 * Time: 17:24
 */
public class ResponseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

    public static final String RESPONSE_KEY_RESULT = "result";

    public static final String RESPONSE_KEY_DATA = "data";

    public static final String RESPONSE_KEY_MSG = "msg";

    /**
     * 将分页数据转成json形式的string
     * @param page
     * @param <T>
     * @return
     */
    public static <T> String ajaxGridResponse(Page<T> page) {
        if (page == null) {
            throw new NullPointerException();
        }
        FlexigridData<T> data = new FlexigridData<>();
        data.setPage(page.getPageIndex());
        data.setTotal(page.getTotal());
        data.setRows(page.getItems());
        return JsonUtil.objToJson(data);
    }

    public static void genJsonResult(ModelAndView modelAndView, String data, boolean resultFlag, String msg) {
        modelAndView.setViewName("/commons/resultdata");
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONObject result = new JSONObject();
            result.put(RESPONSE_KEY_DATA, jsonObject);
            result.put(RESPONSE_KEY_RESULT, resultFlag);
            result.put(RESPONSE_KEY_MSG, msg);
            modelAndView.addObject("resultData", result);
        } catch (Exception e) {
            LOGGER.error("genJsonResult error!. e = ", e);
        }
    }

    /**
     * 失败处理：
     *
     * @param modelAndView
     */
    public static void handleException(ModelAndView modelAndView) {
        modelAndView.setViewName("systemErr");
    }
}

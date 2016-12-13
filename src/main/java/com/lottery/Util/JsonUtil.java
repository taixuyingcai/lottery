package com.lottery.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON工具类
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-30
 * Time: 17:23
 */
public class JsonUtil {

    public static <T> String objToJson(T o) {
        return getInstance().toJson(o);
    }

    private static Gson getInstance() {
        return SingletonHolder.instance;
    }

    private static final class SingletonHolder {
        private static final Gson instance;
        static {
            instance = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        }
    }
}

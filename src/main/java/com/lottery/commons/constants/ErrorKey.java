package com.lottery.commons.constants;

/**
 * 错误码
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-19
 * Time: 15:09
 */
public final class ErrorKey {

    public ErrorKey() {

    }

    // 基本错误
    public static final int ERROR = 1;

    // 参数错误
    public static final int ERROR_ARG = 2;

    // 异常
    public static final int ERROR_EXCEPTION = 3;

    // 数据库错误
    public static final int ERROR_DAL = 4;

    // 数据不存在
    public static final int ERROR_DB_NOEXSIT = 5;
}

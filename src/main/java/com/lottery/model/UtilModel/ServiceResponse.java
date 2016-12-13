package com.lottery.model.UtilModel;

/**
 * 响应实体封装
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-19
 * Time: 14:28
 */
public class ServiceResponse<T> {

    /**
     * 返回结果是否成功
     */
    private final boolean success;

    /**
     * 错误码
     */
    private final int errorKey;

    /**
     * 返回数据集
     */
    private final T responseData;

    public ServiceResponse(boolean success, int errorKey, T responseData) {
        this.success = success;
        this.errorKey = errorKey;
        this.responseData = responseData;
    }

    public ServiceResponse(T responseData) {
        this.success = true;
        this.errorKey = 0;
        this.responseData = responseData;
    }


    public int getErrorKey() {
        return errorKey;
    }

    public T getResponseData() {
        return responseData;
    }

    public boolean isSuccess() {
        return success;
    }

    /**
     * 构建错误返回
     * @param errorKey
     * @return
     */
    public static <T> ServiceResponse<T> genFailResponse(int errorKey) {
        return new ServiceResponse<T>(false, errorKey, null);
    }

    /**
     * 构建正确返回
     * @return
     */
    public static <T> ServiceResponse<T> genSuccResponseWithoutData() {
        return new ServiceResponse<T>(true, 0, null);
    }
}

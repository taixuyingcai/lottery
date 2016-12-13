package com.lottery.model.UtilModel;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分页实体类
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-30
 * Time: 17:28
 */
public class Page<T> {

    /**
     * 总记录数
     */
    private int total;

    /**
     * 当前页码
     */
    private int pageIndex;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 最大页码数
     */
    private int maxPageSize;
    /**
     * 数据
     */
    private List<T> items;

    public Page(int pageIndex, int pageSize) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
    }

    public Page(int pageIndex, int pageSize, int total) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
        setTotal(total);
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex < 1 ? 1 : pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1 ? 1 : pageSize;
    }

    public void setTotal(int total) {
        this.total = total < 0 ? 0 : total;
        maxPageSize = total / pageSize == 0 ? total / pageSize :  total / pageSize + 1;
        if (maxPageSize <= 0) {
            maxPageSize = 1;
        }
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public int getFromIndex() {
        return ( getPageIndex() - 1) * pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}

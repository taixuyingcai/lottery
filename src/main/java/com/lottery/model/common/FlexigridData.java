package com.lottery.model.common;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.List;

/**
 * User: ryanshi@tcl.com
 * Date: 2016-06-01
 * Time: 13:57
 */
public class FlexigridData<T> {

    private int total;

    private int page;

    private List<T> rows = Lists.newArrayList();

    public FlexigridData() {

    }

    public FlexigridData(int total, int page) {
        this.total = total;
        this.page = page;
    }

    public  FlexigridData(int total, int page, List<T> rows) {
        this.total = total;
        this.page = page;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return String.format("[total: %s, page: %s, rows.size: %s]", total, page, (rows == null ? "null" : rows.size()));
    }
}

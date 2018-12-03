package com.jd.springmvcbase.utils;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {
    private Long recordsTotal = 0L;

    private List<T> data = new ArrayList<T>();

    private Integer pageIndex = 0;

    private Integer pageSize = 10;

    public PageResult(){

    }

    public PageResult(Integer pageIndex, Integer pageSize){
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public PageResult(Long recordsTotal, Integer pageIndex, Integer pageSize, List<T> data){
        this.recordsTotal = recordsTotal;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.data = data;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

package com.example.paging.api;

public class PageCondition {

    private int pageSize;
    private int pageNo;

    public PageCondition(final int pageNo, final int pageSize) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

}
